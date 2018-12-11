# 学生的信息系统中数据固定格式为：
#（名字，年龄，性别，邮箱地址，....）
#这个时候使用元组存储可以减少存储空间，访问时索引速度快
student = ('Jim',16,'male','jim8721@gmail.com')
#name
print student[0]

#age
if student[1] >= 18:
	pass

#sex
if student[2] == 'male':
	pass

#方法一
NAME = 0
AGE = 1
SEX = 2
EMAIL = 3
NAME,AGE,SEX,EMAIL = range(4)
#以上两种方式相同，会将变量0123赋给相应变量，通过0123进行访问
#方法二
from collections import namedtuple
Student = namedtuple('Student',['name','age','sex','email'])
#元组创建
s = Student('Jjim',16,'male','Jjim8721@qq.com')
#使用关键字创建
s2 = Student(name='Jjim',age=16,sex='male',email='Jjim8721@qq.com')
#这个时候元组会有属性，可以通过属性的方式访问元组
s.name,s.age,s.male