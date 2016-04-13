import os

os.system('export CLASSPATH="/home/pi/PiCode/jars/json-simple-1.1.1.jar:/home/pi/PiCode/src/"')
os.system('javac /home/pi/PiCode/src/c3pio/*.java')
os.system('java /home/pi/PiCode/src/c3pio/Controller')
