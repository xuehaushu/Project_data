f = open('D:/胡伟个人/Python-instance/testfile.txt')
lines = f.readlines()
print(lines)
f.seek(0)
for line in f:
	print(line)
from itertools import islice
f.seek(0)
islice(f,3,8)#切片获取文本的3到8行内容
for line in islice(f,3,8):
	print(line)

l = [i for i in range(0,20)]
t = iter(l)
for x in islice(t,5,10):
	print(x)
for x in t:#迭代会从上一次的终止位置继续往后迭代，是因为上次迭代的时候指针已经跳转到10的位置
	print(x)