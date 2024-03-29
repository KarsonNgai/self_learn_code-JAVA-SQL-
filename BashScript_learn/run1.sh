#!/usr/bin/expect -f
#v2.2

set timeout -1

spawn git status

expect "On branch main"
expect "Your branch is up to date with 'origin/main'."

expect "nothing to commit, working tree clean"

send -- "the branch is update to date"

spawn git pull

expect eof

spawn code .

expect eof
