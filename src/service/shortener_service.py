from random import randint
from repository.link_repository import LinkRepository
from models.link_model import Link

class ShortenerService:
    
    def __init__(self, url):
        self.url = url
        self.linkRepository = LinkRepository()

    def listLinks(self):
        return self.linkRepository.findAll()
    
    def shortenerUrl(self):
         code = self.__generateCode()
         link = Link(self.url, code)
         print(self.linkRepository.save(link))
        # try:
        #     code = self.__generateCode()
        #     link = Link(self.url, code)
        #     print(self.linkRepository.save(link))
        #     return code
        
        # except BaseException:
        #     return False
        
    def __generateCode(self):

        code = randint(111111, 999999)
        if(self.__validCode(code)):
            return code
        
        return self.__generateCode()
        
   
    def __validCode(self, code):

        if( not self.linkRepository.findByCode(code) ):
            return True
        
        return False
    