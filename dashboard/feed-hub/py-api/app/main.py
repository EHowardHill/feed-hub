from flask import Flask, request
from flask_sqlalchemy import SQLAlchemy
import json, pprint

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:Shebang01#!@db:3306/db'
#app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:Shebang01#!@localhost:3307/db'
db = SQLAlchemy(app)

class Login(db.Model):
    __tablename__ = 'login'
    id = db.Column(db.Integer, primary_key = True)
    username = db.Column(db.String(45))
    password = db.Column(db.String(45))

class Feed(db.Model):
    __tablename__ = 'feed'
    id = db.Column(db.Integer, primary_key = True)
    name = db.Column(db.String(45))
    price = db.Column(db.Numeric)

class Unit(db.Model):
    __tablename__ = 'unit'
    id = db.Column(db.Integer, primary_key = True)
    id_user = db.Column(db.Integer)
    location = db.Column(db.String(45))

class Stock(db.Model):
    __tablename__ = 'stock'
    id = db.Column(db.Integer, primary_key = True)
    id_unit = db.Column(db.Integer)
    id_feed = db.Column(db.Integer)
    quantity = db.Column(db.Integer)

@app.route('/')
def hello_world():
    return 'Hello, World!'

@app.route('/feed', methods=['POST'])
def feed():
    records = []
    if 'user' in request.form:
        all_units = db.session.query(Unit).filter_by(id_user=request['user']).all()
    else:
        all_units = db.session.query(Unit).all()
    for units in all_units:
        unit = {
            'location':units.location,
            'items': []
        }
        for rec in db.session.query(Stock).filter_by(id_unit=units.id).all():
            feed = db.session.query(Feed).filter_by(id=rec.id_feed).first()
            unit['items'].append({
                'id': feed.id,
                'name': feed.name,
                'price': feed.price,
                'quantity': rec.quantity
            })
        records.append(unit)
    return json.dumps(records)

@app.route('/login', methods=['POST'])
def login():
    f = db.session.query(Login).filter_by(username=request.form['username']).first()
    
    if f == None:
        return "dne"
    else:
        if request.form['password'] == f.password:
            return "pass"
        else:
            return "fail"

if __name__ == "__main__":
    # Only for debugging while developing
    app.run(host="0.0.0.0", debug=True, port=80)