#coding:utf8
import requests
def getweather(city):
	r = requests.get(u'http://wthrcdn.etouch.cn/weather_mini?city=' + city)
	data = r.json()['data']['forecast'][0]
	return '%s: %s , %s '%(city,data['low'],data['high'])

print(getweather(u'北京'))
print(getweather(u'长春'))
from collections import Iterable,Iterator
class WeatherIterator(Iterator):
	def __init__(self):
