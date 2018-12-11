from types import MappingProxyType
d = {1:'A'}
d_proxy = MappingProxyType(d) #返回一个只读的映射视图
print(d_proxy)
#print(d_proxy[2] = 'x')

d[2] = 'B'
print(d_proxy)
print(d_proxy[2])