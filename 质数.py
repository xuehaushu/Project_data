#!/user/bin/python3


#质数判断
def SelectNum(num):
	fals = 0 #用于判断质数
	if num > 1:
		for i in range(2,num):
			if(num % i) == 0:
				fals = 1
				print(num,"不是质数")
				print(i,"乘以",num//i,"是",num)
				break
		if fals == 0:
			print(num,"是质数")
	else:
		print(num,"不是质数")
num = int(input("请输入一个数字:"))
SelectNum(num)
