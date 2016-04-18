    #PiCode

-------------------------------------------------------------------------------------------------------------------------------------
#ARDUINO
-------------------------------------------------------------------------------------------------------------------------------------
Åpne filen "arduino_circuit.html" for oversikt over hvordan Arduino må kobles opp med alkoholsensoren. Komponentene som trengs er:
<ul>
<li>1 stk Alcohol Gas Sensor (MQ3)</li>
<li>1 stk Arduino Uno</li>
<li>1 stk 1k ohm motstand</li>
<li>6 stk tilkoblingsledninger</li>
</ul>

-------------------------------------------------------------------------------------------------------------------------------------
#DEPLOYMENT
-------------------------------------------------------------------------------------------------------------------------------------

For å kjøre på Pi-en må repositoriet klones inn på /home/pi/:
<pre>
    git clone https://github.com/c3pio/PiCode.git
</pre>

For å sette riktig port som Arduinoen kommer inn på, må USB-kabelen til Arduino være frakoblet, men USB-kabelen fra legobilen må være tilkoblet. Kjør Python-skriptet port.py - når programmet prompter deg: koble til USB-kabelen fra Arduinoen og trykk [ENTER]:
<pre>
    python port.py
</pre>

For å kompilere:
<pre>
    cd PiCode/src/
    export CLASSPATH="/home/pi/PiCode/jars/json-simple-1.1.1.jar:." 
    /* Eller tilsvarende sti hvor du har lagret repositoriet. 
    * Simple json er nå lagret i repositoriet så man slipper å laste det ned selv. 
    * Husk ":." på slutten av stien. 
    */
    javac c3pio/*.java
</pre>
For å kjøre:
<pre>
    java c3pio/Controller
</pre>

-------------------------------------------------------------------------------------------------------------------------------------
#UNDER UTVIKLING
--------------------------------------------------------------------------------------------------------------------------------------

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

Kommentarer:
<pre>
    if (condition){
    
        /**
        * Husk mellomrom over kommentarblokk
        *
        *
        */
        
        object.Method();        // Slik kommenterer man enkeltlinjer
    }
</pre>
