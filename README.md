# PiCode

For å kjøre på Pi-en:
    cd inn i /src
    legg til simplejson-jar-filen i classpath: export CLASSPATH="/home/pi/Documents/json-simple-1.1.1.jar:." //eller tilsvarende sti hvor json-simple er lagret.
    kompiler: javac c3pio/*.java
    kjør: java c3pio/Controller
    
Fin alle porter på pi'en:
    skriv i terminalen til pi'en: ls /dev/tty*

Etter cloning eller pulling av prosjektet må disse stegene gjennomføres.

I .gitignore har vi *.class, ettersom man ikke skal dra med kompilerte filer fra maskin til maskin. 
For å kompilere .java-filene må du:
- Lage en out-mappe under dinFilsti\PiCode
- Legge den til i Project compiler output:
    File > Project Structure > Project:
    Sett Project compiler output til dinFilSti\PiCode\out
    Eksempel: C:\Users\EmilOrvik\Documents\Programmering\pu\PiCode\PiCode\out

- Gjøre tests-packagen om til en test-folder:
    File > Project Structure > Project:
    - Velg tests-mappen og gjør den om til Test-folder
