@echo off
set NAME=dailydel
set TIME=20:01:00
set DAY=MON,TUE,WED,THU,FRI
set COMMAND=E:\project1\¡¨Ω””≥…‰≈Ã.bat

%SystemDrive%
cd C:\Windows\Tasks\
if exist %NAME%.job del %NAME%.job

schtasks /create /tn %NAME% /tr "%COMMAND%" /sc weekly /d %DAY% /st %TIME% 