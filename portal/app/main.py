import json
from flask import Flask, render_template, request, send_file, jsonify, session
from flask_sqlalchemy import SQLAlchemy

# Flask application defaults
app = Flask(__name__, template_folder='templates')
app.secret_key = "welcome to the cheese house"          # Arbitrary, can be any string
app.config['SESSION_TYPE'] = 'filesystem'
#app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:Shebang01#!@db:3306/db'
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root:Shebang01#!@host.docker.internal:3306/ethanhill'
db = SQLAlchemy(app)

#with open("unit_info.json") as info:
with open("unit_info.json") as info:
    CONFIG = json.loads(info.read())

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

# Home bit
@app.route('/feedtypes')
def home():
    name = db.session.query(Unit).filter_by(id=CONFIG["id"]).first().location
    fl = []
    st = db.session.query(Stock).filter_by(id_unit=CONFIG["id"]).all()
    for s in st:
        sv = db.session.query(Feed).filter_by(id=s.id_feed).first()
        fl.append([sv.name, '$%.2f' % (sv.price / 100), s.quantity, s.id])

    return jsonify({
        'name': name,
        'fl': fl
    })