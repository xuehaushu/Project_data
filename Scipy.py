import numpy
from time import perf_counter as perf_counter
floats = numpy.loadtxt('floats-10M-lines.txt')
print(floats[-3:])
floats *= .5
print(floats[-3:])
t0 = pc(); floats /= 3; pc() - t0
numpy.save('floats-10M',floats)
floats2 = numpy.load('floats-19M.npy','r+')
floats2 *= 6
print(floats2[-3:])

