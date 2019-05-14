from random import randint
from itertools import chain
chinese = [randint(60,100) for _ in range(40)]
math = [randint(60,100) for _ in range(40)]
english = [randint(60,100) for _ in range(40)]
for i in range(len(math)):
	print(chinese[i] + math[i] + english[i])

#print(zip([1,2,3,4]('a','b','c','d'))
#print(zip([1,2,3,4]('a','b','c','d')[7,8,9,10]))
print("#"*50)
total = []
for c,m,e in zip(chinese,math,english):
	total.append(c + m + e)
for i in total:
	print(i)
e1 = [randint(60,100) for _ in range(40)]
e2 = [randint(60,100) for _ in range(42)]
e3 = [randint(60,100) for _ in range(42)]
e4 = [randint(60,100) for _ in range(39)]
count = 0
for x in chain(e1,e2,e3,e4):
	if x >= 90:
		count += 1
print(count)



