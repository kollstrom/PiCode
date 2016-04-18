import os

os.system('export CLASSPATH="/home/pi/PiCode/jars/json-simple-1.1.1.jar:."')
os.system('javac c3pio/*.java')
os.system('java  c3pio/Controller')
