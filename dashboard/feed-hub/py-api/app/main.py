from flask import Flask, request
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:Shebang01#!@db:3306/db'
db = SQLAlchemy(app)

class Login(db.Model):
    id = db.Column(db.Integer, primary_key = True)
    username = db.Column(db.String(45))
    password = db.Column(db.String(45))

@app.route('/')
def hello_world():
    return 'Hello, World!'

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