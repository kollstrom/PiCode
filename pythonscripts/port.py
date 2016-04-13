import os
from difflib import Differ

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
print(new_port)
file.close()