#!/usr/bin/python3

import time
import calendar
#获取时间戳，使用time.time()是时间戳
ticks = time.time()
print("当前时间戳为：",ticks)
#获取本地时间，通过localtime()可以将时间戳显示为年月日时分秒
localtime = time.localtime(time.time())
print("本地时间为：",localtime)
#通过time.asctime()对获取的时间进行处理,显示为 星期 月份 日 时间 年份 的便于浏览样式
localtime1 = time.asctime(localtime)
print("本地时间为：",localtime1)

#通过time.strftime()来显示自己需要的格式
#格式2018-03-20 11:45:39
print(time.strftime("%Y-%m-%d %H:%M:%S"),time.localtime)
#格式Sat Mar 28 22:24:24 2018形式
print(time.strftime("%a %b %d %H:%M:%S %Y"),time.localtime)
#将格式字符串为时间戳
a = "Sat Mar 28 22:24:24 2018"
print(time.mktime(time.strptime(a,"%a %b %d %H:%M:%S %Y")))


cal = calendar.month(2018,1)
cal1 = calendar.calendar(2018,w=2,l=1,c=6)
print("以下是2018年1月的日历")
print(cal)
print(cal1)
