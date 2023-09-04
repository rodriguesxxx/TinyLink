from database.mysql import MysqlDb


class LinkRepository:

    def __init__(self):
        self.mysqlDb = MysqlDb()
        self.cursor = self.mysqlDb.cursor


    def save(self, link):
        # try:
            # query = f"INSERT INTO links (url, code) VALUES('{link.getUrl()}', '{link.getCode()}')"
            query = f"INSERT INTO links (url, code) VALUES('{link.getUrl()}', {link.getCode()})"

            self.cursor.execute(query)
            # return True
        
        # except Exception:
        #     return False
        
    def findAll(self):
        try:
            query = "SELECT * FROM links"
            self.cursor.execute(query)
            return self.cursor.fetchall()
        
        except BaseException:
            return False
        
    def findByCode(self, code):
        try:
            query = f"SELECT url FROM links WHERE code={code}"
            self.cursor.execute(query)
            return self.cursor.fetchone()
        
        except BaseException:
            return False
        