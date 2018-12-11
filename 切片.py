#使用列表生成式生成三个列表的列表
board = [['_'] * 3 for i in range(3)]
print(board)
board[1][2] = 'X'
print(board)
   

#三个指向同一对象的引用的列表,当在里面某个元素修改时，错误产生，即对同一个对象连续引用，会造成一旦修改，引用内容会被全部修改。
weird = [['_']*3]*3
print(weird)
weird[1][2] = '0'
print(weird)

row1 = ['_'] * 3
board1 = []
for i in range(3):
	board1.append(row1)#此时追加的同一个对象三次到列表中，和上面同样错误
print(board1)


board2 = []
for i in range(3):
	row2 = ['_'] * 3
	board2.append(row2)
print(board2)



l = [1,2,3]
print(id(l))
l *= 2
print(l)
print(id(l))


t = (1,2,3)
print(id(t))
t *= 2
print(t)
print(id(t))

#从上面的运行结果看出使用*=操作时，可变的的ID没有改变过，而对于不可变的
#元组生成新的对象，解释器会将原对象复制到新对象，然后追加元素，效率很低。



# 一个关于+=的谜题
t = (1,2,[30,40])
print(id(t))
t[2] += [50,60]
print(t)
print(id(t))
猜想运行结果：
1.(1,2，[30,40,50,60])
2.因为tuple不支持元素赋值报错，
3.以上两个都不是
4.1,2都对

# 警示：不要把可变对象放到元组里
#      增量赋值不是一个原子操作，他虽然抛异常，但是还会完成操作
#      查看python字节码，了解代码背后的运行机制

# In [1]: t =(1,2,[30,40])

# In [2]: t
# Out[2]: (1, 2, [30, 40])

# In [3]: id(t)
# Out[3]: 2074336199448

# In [4]: t[2] +=  [50,60]
# ---------------------------------------------------------------------------
# TypeError                                 Traceback (most recent call last)
# <ipython-input-4-fefd2cc391ef> in <module>()
# ----> 1 t[2] +=  [50,60]

# TypeError: 'tuple' object does not support item assignment

# In [5]: t
# Out[5]: (1, 2, [30, 40, 50, 60])

# In [6]: id(t)
# Out[6]: 2074336199448