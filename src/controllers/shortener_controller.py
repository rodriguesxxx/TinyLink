from service.shortener_service import Shortener

class ShortenerUrlController:
    
    @staticmethod
    def shortener(url):
        short =  Shortener(url)
        return short.shortenerUrl()