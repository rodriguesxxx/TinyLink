from service.shortener_service import ShortenerService

class ShortenerUrlController:
    
    @staticmethod
    def shortener(url):
        short =  ShortenerService(url)
        code = short.shortenerUrl()
        urlShortened = f"https://localhost:5000/{code}"
        return urlShortened
   
    @staticmethod
    def getLinks():
        short =  ShortenerService("22")
        return str(short.listLinks())
    
    @staticmethod
    def getUrlByCode(code):
        short =  ShortenerService("22")

        return str(short.getUrlbyCode(code))