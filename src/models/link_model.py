class Link:
    def __init__(self, url, code):
        self.setUrl(url)
        self.setCode(code)
    
    def getUrl(self):
        return self.__url
    
    def getCode(self):
        return self.__code
    
    def setUrl(self, url):
        self.__url = url
    
    def setCode(self, code):
        self.__code = code