from random import randint 

class Encurt:
    
    def __init__(self, url):
        self.url = url

    def encurtUrl(self):
        return self.__generateCode()
   
    def __generateCode(self):
        code = randint(111111, 999999)
        print(code)
        return code
   
    def __validCode(self):
        pass
    