import smtplib
import socket
fromaddr = 'mikkel.raspberry@gmail.com'
toaddr = 'mikkel.svagard@gmail.com'
username = fromaddr
password = 'RaspberryPi'

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.connect(("gmail.com",80))
yourIP = (s.getsockname()[0])
s.close()
text = "Current IP: " + str(yourIP)
print text


msg = "\r\n".join([
  "Fom: " + fromaddr,
  "To: " + toaddr,
  "Subject: " + text,
  "",
  ""
  ])


server = smtplib.SMTP('smtp.gmail.com:587')
server.ehlo()
server.starttls()
server.login(username,password)
server.sendmail(fromaddr, toaddr, msg)
server.quit()
print "message sent"
