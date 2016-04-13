import os

os.system('export CLASSPATH="/home/pi/PiCode/jars/json-simple-1.1.1.jar:/home/pi/PiCode/src/"')
os.system('javac /home/pi/PiCode/src/c3pio/CarSettings.java /home/pi/PiCode/src/c3pio/Controller.java '
          '/home/pi/PiCode/src/c3pio/Simulator.java /home/pi/PiCode/src/c3pio/TCPClient.java'
          '/home/pi/PiCode/src/c3pio/TCPServer.java')
os.system('java -cp /home/pi/PiCode/src/c3pio/ Controller')
