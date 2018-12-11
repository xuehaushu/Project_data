@echo off


for /f "delims=" %%i in (ip.txt) do (
echo %%i
echo f| xcopy.exe /y  源目录   拷贝目录（当前日期%date:~,4%%date:~5,2%%date:~8,2%）
)
