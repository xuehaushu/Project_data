#!/usr/bin/python3
import xml.sax

class MovieHandler(xml.sax.ContentHandler):
	def __init__(self):
		self.CurrentData = ""
		self.type = ""
		self.format = ""
		self.year = ""
		self.rating = ""
		self.stars = ""
		self.descripyion = ""

	#元素调用
	def startElement(self,tag,attributes):
		self.CurrentData = tag
		if tag == "movie":
			print("******Movie******")
			title = attributes["title"]
			print("Title:",title)
	#元素结束调用
	def endElement(self,tag):
		if self.CurrentData == "type":
			print("Type:",self.type)
		elif self.CurrentData == "format":
			print("Format:",self.format)
		elif self.CurrentData == "year":
			print("Year:",self.year)
		elif self.CurrentData == "rating":
			print("Rating:",self.rating)
		elif self.CurrentData == "stars":
			print("Stars:",self.stars)
		elif self.CurrentData == "descripyion":
			print("Descripyion:",self.descripyion)
		self.CurrentData = ""

	#读取字符调用
	def characters(self,content):
		if self.CurrentData == "type":
			self.type = content
		elif self.CurrentData == "format":
			self.format = content
		elif self.CurrentData == "year":
			self.year = content
		elif self.CurrentData == "rating":
			self.rating = content
		elif self.CurrentData == "stars":
			self.stars = content
		elif self.CurrentData == "descripyion":
			self.descripyion= content


if(__name__ == "__main__"):
	parser = xml.sax.make_parser() #创建一个XMLReader
	parser.setFeature(xml.sax.handler.feature_namespaces,0) #关闭命名空间
	Handler = MovieHandler() #重写ContextHandler
	parser.setContentHandler(Handler)
	parser.parse("movies.xml")
