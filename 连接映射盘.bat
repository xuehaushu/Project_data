@echo off
echo 开始连接映射盘
net use \\10.180.1.1\d$ "password" /user:"admin" /persistent:yes
echo 连接成功