import re
def mySplit(s,ds):
	res = [s]
	for d in ds:
		t = []
		map(lambda x:t.extend(x.split(d)), res) 
		res = t
	return res



s = 'ab;cd|efg|hi,jklmn\topq;rst,uvw\txyz'
res = mySplit(s,';,|\t')
for x in res:
	print(x)
print(re.split(r'[,;|\t]',s))