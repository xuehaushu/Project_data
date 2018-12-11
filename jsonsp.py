
#!/usr/bin/python3

import json

#将字典类型转换成jason类型对象
data = {
		'no':1,
        'name':'Runoob',
        'url':'http://www.runoob.com'}

json_str = json.dumps(data)
print("Python原数据:",repr(data))
print("JASON对象:",json_str)
#将json对象转换为字典
data2 = json.loads(json_str)
print("data2['name']",data2['name'])
print("data2['url']",data2['url'])

#数据json的写入和读取
with open('data.json','w') as f:
	json.dump(data,f)
with open('data.json','r') as f:
	data3 = json.load(f)
	print(repr(data3))