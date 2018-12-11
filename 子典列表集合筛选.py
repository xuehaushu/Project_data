from random import randint
import timeit
data = [randint(-10,10) for i in range(10)]  #在2.7中使用xrange(),而到了python3中使用的是range
print(data)
print(filter(lambda x: x >= 0,data))
print([x for x in data if x >= 0])   #通过时间对比可以发现列表生成式比使用filter函数运算速度快



#字典解析
dic = {x:randint(60,100) for x in range(1,21)}
print(dic)
print({x:y for x,y in dic.items() if y > 90})#在Python2中字典项使用iteritems(),而在python3中使用items()



#集合解析
s = set(data)
print(s)
print({x for x in s if x % 3 == 0})