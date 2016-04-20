const int analogInPin = A0;  // Analog input pin that the MQ-3 Breathalyzer is connected to
int sensorValue = 0;        // value read from the sensor

void setup() {
  // initialize serial communications at 9600 bps:
  Serial.begin(9600); 
  pinMode(ledPin, OUTPUT);      // sets the digital pin as output
}

void loop() {
  // read the analog in value:
  sensorValue = analogRead(analogInPin);            

  // print the results to the serial monitor:
  Serial.print(",");                       
  Serial.println(sensorValue);     

  // wait 10 milliseconds before the next loop
  // for the analog-to-digital converter to settle
  // after the last reading:
  delay(10);                     
}

