@echo off
echo ���ɼƻ�����
set name=�ƻ��������
set TIME=20:00:00
set DAY=MON,TUE,WED,THU,FRI
set COMMAND=����ʱ��.bat

%SystemDrive%
cd C:\Windows\Tasks\
if exist %name%.job del %name%.job


schtasks /create /tn %name% /tr %COMMAND% /sc weekly /d %DAY% /st %TIME% 
echo ���Ҫָ���û�ʹ�� /ru