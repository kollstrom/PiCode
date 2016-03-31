import os
from difflib import Differ

# Find and set new port:

file = open('port.txt', 'w')
before = os.popen('ls /dev/tty*').read()
raw_input('Connect the USB-cable from the Arduino to the Pi - then press ENTER')
after = os.popen('ls /dev/tty*').read()

d = Differ()
diff = d.compare(before, after)
plusdiff = "".join(diff)
plus_start_index = plusdiff.find('+')
plus_end_index = plusdiff.rfind('+') + 3
new_port = plusdiff[plus_start_index:plus_end_index].replace('+', '').replace(' ', '').strip('\n')
file.write(new_port)
print("Connecting Arduino to port> " + new_port)
file.close()

# Set CLASSPATH, compile and run:
print("Compiling java classes. This will take a while.")
os.system('export CLASSPATH="/home/pi/PiCode/jars/json-simple-1.1.1.jar:."')
os.system('javac c3pio/*.java')
os.system('java  c3pio/Controller')
