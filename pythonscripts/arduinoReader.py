# -*- coding: utf-8 -*-
import serial

file = open('port.txt', 'r')
port = file.read().strip('\n')  # Usikker på om .strip('\n') må være med
file.close()

ser = serial.Serial(port, 9600)
while 1:
    print(ser.readline())
