from flask import Flask, request, redirect
import json

from controllers.encurt_controller import EncurtUrlController

app = Flask(__name__)

@app.route('/')
def index():
    return "API para encurtamento de url"

@app.route('/receive', methods=['POST', ])
def receiveUrl():
    pass

@app.route('/code')
def returnUrlEncurted():
    return str(EncurtUrlController.encurt(0))