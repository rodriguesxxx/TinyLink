from service.encurt import Encurt

class EncurtUrlController:
    
    @staticmethod
    def encurt(url):
        encurt =  Encurt(url)
        return encurt.encurtUrl()