#!/usr/bin/expect -f

set timeout -1

spawn git status

spawn git pull

expect eof
