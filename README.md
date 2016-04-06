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
- Legge til out-mappen i Project compiler output:
    File > Project Structure > Project:
    Sett Project compiler output til dinFilSti\PiCode\out
    Eksempel: C:\Users\EmilOrvik\Documents\Programmering\pu\PiCode\PiCode\out

    - Sett Project language level til 8

    - Velg Project SDK 8

- Under File Project Structure > Project Settings > Modules > Sources: marker src-mappen og trykk "Mark as: Sources"

- Under Modules > Dependencies: legg til json-simple-1.1.1.jar og junit-4.10.jar

- Gjøre tests-packagen om til en test-folder:
    File > Project Structure > Project:
    - Velg tests-mappen og gjør den om til Test-folder
