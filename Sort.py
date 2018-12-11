fruits = ['grape','raspberry','apple','banana']
print(sorted(fruits))
print(fruits)#使用sorted对fruits进行排序，原列表没有产生变化
print(sorted(fruits,reverse=True))#先对列表排序，然后倒序输出
print(sorted(fruits,key=len))#根据列表中元素的长度进行排序
print(sorted(fruits,key=len,reverse=True))#先按长度排序同一长度的按照字母顺序排序
#以上sorted没有对原列表做修改
fruits.sort()#fruits本身会被改变
print(fruits)