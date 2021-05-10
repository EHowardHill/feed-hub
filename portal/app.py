from flask import Flask, render_template, request, send_file, jsonify, session

# Flask application defaults
app = Flask(__name__, template_folder='templates')
app.secret_key = "welcome to the cheese house"          # Arbitrary, can be any string
app.config['SESSION_TYPE'] = 'filesystem'

# Home bit
@app.route('/')
@app.route('/home', methods=["GET", "POST"])
def home():
    return render_template(
        'landing.html'
    )