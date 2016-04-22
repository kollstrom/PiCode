# -*- coding: utf-8 -*-

import serial
#  Opens and reads the port-number to the Arduino
file = open('port.txt', 'r')
port = file.read().strip('\n')  # Usikker på om .strip('\n') må være med
file.close()

#  Reads sensor-values that the Arduino is sending
ser = serial.Serial(port, 9600)
while 1:
    print(ser.readline())
    print("69")