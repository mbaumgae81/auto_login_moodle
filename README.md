# auto_login_moodle
Java Programm das mit hilfe des Users und Passwortes gestartet werden kann und sich auf eine Moodle Webseite einloggt. 

Und die Zeiterfassung startet.
Ich habe es getestet auf einem Debian Bullseye minimal installation, während der installation hatte der rechner 1024mb ram und danach auf 512 mb runtergesetzt.

## Installation

Nach der minimal Installation von debian sollte mit folgendem befehl das Installationsscript heruntergeladen werden.

<sup>wget https://raw.githubusercontent.com/mbaumgae81/auto_login_moodle/master/install.sh</sup>

Und anschlißend mit root rechten, das script starten.

<sup>sh ./install.sh</sup>

## Was macht das Installationsscript ?

Das Debian System wird auf den aktuellen stand gebracht und lädt die nötigen Java dateien herunter.
Anschließen wird die Login.jar ins Programmverzeichnis /opt/login heruntergeladen.

Dort werden auch die Login.sh und die Logout.sh mit euren im Scribt eingegebenen Credentials angelegt (falls sich etwas mal ändert).

![opt_ordner](https://user-images.githubusercontent.com/7016905/205121815-e3798539-589c-47cb-8e73-353cd88ad15c.jpg)

![login_out](https://user-images.githubusercontent.com/7016905/205121812-e27d5c6e-10f1-46d6-8189-18100c181ba5.jpg)

Anschließend wird in der crontab noch zwei zeilen zugefügt.
in der Abbildung login 8:30 logout 16:30 Die ausgaben werden nach /var/log/jaav.log geleitet (wo man sehen kann was passiert ist ). 


![crontab](https://user-images.githubusercontent.com/7016905/205121805-962049e5-21c4-40d4-aae2-5f9ae49b0d27.jpg)


