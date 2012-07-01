#!/usr/bin/env sh
PLAYERID="c7993e40"
ROLLBACK_BT_ID=4

while true; do
  if [ ! -f previous ] ; then echo "-999999" > previous; fi

  previous=$(cat previous)
  current=$(curl http://xs.develogical.com:3000/players/$PLAYERID/score 2> /dev/null)

  if [ "$current" -lt "$previous" ] ; then
    echo "PROBLEM: previous: $previous, current: $current"
    echo "rolling back"
    curl "http://sztupi:abcde@buxton.develogical.com:8111/httpAuth/action.html?add2Queue=bt$ROLLBACK_BT_ID"
  else
    echo "OK: previous: $previous, current: $current"
  fi

  echo $current > previous
  sleep 1
done
