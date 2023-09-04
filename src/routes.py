from flask import Flask, request, redirect
import json

from controllers.shortener_controller import ShortenerUrlController as shortController

app = Flask(__name__)

@app.route('/')
def index():
    return "API para encurtamento de url"

@app.route('/links')
def links():
    return shortController().getLinks()

@app.route('/<code>')
def redirect(code):
    shortController.getUrlByCode(code)

@app.route('/shortener', methods=['POST', ])
def shortenerUrl():
    raw_data = request.data.decode('utf-8')
    json_data = json.loads(raw_data)
    urlShortened = shortController.shortener(json_data["url"])
    return urlShortened
    



