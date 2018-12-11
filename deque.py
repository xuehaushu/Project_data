from collections import deque
dq = deque(range(10),maxlen=10)#maxlen是一个参数，代表这个队列可以容纳的元素量
print(dq)
dq.rotate(3)#旋转操作，会接受一个参数n，当n>0时，会将队列右边的n为移动到队列的左边
print(dq)
dq.rotate(-4)#当n<0时会将最左边的n位元素移动到队列的右边
print(dq)
dq.appendleft(-1)#对元素已满的队列左边头部进行操作，右边的尾部会被删除
print(dq)
dq.extend([11,22,33])
print(dq)#对已满队列尾部添加元素，头部的元素会被挤掉
dq.extendleft([10,20,30,40])
print(dq)#extend(iter)方法会把迭代器器里的元素逐渐添加到双向队列的左边，因此迭代器里的元素会逆序出现在队列里