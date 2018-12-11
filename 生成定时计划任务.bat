@echo off
echo 生成计划任务
set name=计划任务测试
set TIME=20:00:00
set DAY=MON,TUE,WED,THU,FRI
set COMMAND=日期时间.bat

%SystemDrive%
cd C:\Windows\Tasks\
if exist %name%.job del %name%.job


schtasks /create /tn %name% /tr %COMMAND% /sc weekly /d %DAY% /st %TIME% 
echo 如果要指定用户使用 /ru