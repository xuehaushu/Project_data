from collections import namedtuple
City = namedtuple('City','name country population coordinates')
tokyo = City('Tokyo','JP',36.933,(35.689722,139.691667))
print(tokyo)
print(tokyo.population)
print(tokyo.coordinates)
print(tokyo[1])
print(City._fields)#_fields包含这个类所有的字段名称的元组
LatLong = namedtuple('LatLong','lat long')
delhi_data = ('Delhi NCR','IN',21.935,LatLong(28.613889,77.208889))
delhi = City._make(delhi_data)#_make()接受一个可迭代对象生成这个类的实例，作用相当于City(*delhi_data)
print(delhi._asdict())#_asdict()把具名元组以collections.OrderedDict的形式返回
for key,value in delhi._asdict().items():
	print(key+':',value)
