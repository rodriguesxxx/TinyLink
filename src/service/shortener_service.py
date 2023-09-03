from random import randint
from repository.link_repository import LinkRepository

class ShortenerService:
    
    def __init__(self, url):
        self.url = url

    def shortenerUrl(self):
        return self.__generateCode()
   
    def __generateCode(self):
        code = randint(111111, 999999)
        return code
   
    def __validCode(self):
        pass
    