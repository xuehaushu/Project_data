import os



lax_coordinates = (33.9425,-118.408056)
city,year,pop,chg,area =('Tokyo',2003,32450,0.66,8014)
traveler_ids = [('USA','31195855'),('BRA','CE342567'),('ESP','XDA205856')]
for passport in sorted(traveler_ids):#迭代的过程中将passport变量绑到每个元组上
	print('%s/%s'%passport)#%格式运算符可以匹配到元组相应的元素

for country ,_ in traveler_ids:#for循环可以分别提取元组的元素，也叫做拆包，因为第二个元素没用所以使用“_”占位符
	print(country)


#元组拆包
titude,longitude = lax_coordinates#交换两个元素可以使用a,b = b,a
print("*"*100)
print(titude)
print(longitude)
print("*"*100)


print(divmod(20,8))
t = (20,8)
print(divmod(*t))
quotient,remainder = divmod(*t)
print(quotient,remainder)


_,filename = os.path.split('/home/luciano/.ssh/idrsa.pub')#os.path.split()函数会返回以路径和最后一个文件名组成的元组
print(filename)

#当出现多个需要忽略的元素*来处理
a,b,*rest = range(5)
print(a,b,*rest)
print(a,b,rest)
a,*body,c,d = range(5)
print(a,*body,c,d)
print(a,body,c,d)
*head,b,c,d = range(5)
print(*head,b,c,d)
print(head,b,c,d)


