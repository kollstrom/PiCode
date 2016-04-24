import os
from difflib import Differ

file = open('port.txt', 'w') #  Opens the file that the port-number is stored in
before = os.popen('ls /dev/tty*').read() #  Lists all the ports on the Pi and stores them in a string
raw_input('Connect the USB-cable from the Arduino to the Pi - then press ENTER') #  User-prompt
after = os.popen('ls /dev/tty*').read() #  Lists all the ports on the Pi and stores them in a string

#  Finds the difference between before and after
d = Differ()
diff = d.compare(before, after)
plusdiff = "".join(diff)
plus_start_index = plusdiff.find('+')
plus_end_index = plusdiff.rfind('+') + 3

#  Stores the new port in port.txt
new_port = plusdiff[plus_start_index:plus_end_index].replace('+', '').replace(' ', '').strip('\n')
file.write(new_port)
print(new_port)
file.close()