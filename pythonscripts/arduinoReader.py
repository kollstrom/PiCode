# -*- coding: utf-8 -*-
import serial
#  ttyACM1 -> nederst til hoyre på PI-en
ser = serial.Serial('/dev/ttyACM0', 9600)
while 1:
    print(ser.readline())
    
