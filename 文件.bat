@echo off
echo 文件处理测试练习

for /f "skip=3 delims=， tokens=1,2,3,4" %%i in (test1.txt)do echo %%i %%j %%k %%l