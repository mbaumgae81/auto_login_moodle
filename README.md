# auto_login_moodle
Java Programm das mit hilfe des Users und Passwortes gestartet werden kann und sich auf eine ebseite einloggt. 
Und die Zeiterfassung startet.
Ich habe das ganze auf einem Debian System lauffen.
Dafür habe ich einmal:

<sup>apt update && apt upgrade -y </sup>

<sup>apt install openjdk-11-jre </sup>

Ausgeführt als sudo oder eben root.

unter /opt/login habe ich die fertige .jar reinkopiert und die 2 Shell scripte erstellt
![opt_ordner](https://user-images.githubusercontent.com/7016905/205121815-e3798539-589c-47cb-8e73-353cd88ad15c.jpg)

und die 2 Shell scripte erstellt. Login müssen folgende Parameter übergeben werden.
<sup> Login.jar benutzername@meineemail.de meinPAsswort zustand </sup>
zustand entsprich EIN zum Starten der Zeiterfassung
              und AUS zum Beenden der Zeiterfassung.
![login_out](https://user-images.githubusercontent.com/7016905/205121812-e27d5c6e-10f1-46d6-8189-18100c181ba5.jpg)

Anschließend in der crontab noch die Zeiten und den Script aufruf erstellt. 
in der Abbildung login 8:30 logout 16:30 Die ausgaben werden nach /var/log/jaav.log geleitet. 
Also in dieser datei kann man alles nachsehen was passiert ist.

![crontab](https://user-images.githubusercontent.com/7016905/205121805-962049e5-21c4-40d4-aae2-5f9ae49b0d27.jpg)




So funktioniert es. 
