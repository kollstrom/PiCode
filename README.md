# PiCode

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
