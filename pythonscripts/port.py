import os
from difflib import Differ

file = open('port.txt', 'w')
before = os.popen('ls /dev/tty*').read()
raw_input('Connect the USB-cable from the Arduino to the Pi - then press ENTER')
after = os.popen('ls /dev/tty*').read()

d = Differ()
diff = d.compare(before, after)
print(diff)