#!/bin/bash
# Installations Script für Moodle Auto Login
clear
echo " Prüfe ob auch als Root angemeldet"
echo ""
if [ "$EUID" -ne 0 ];
  then echo "Please run as root"
  exit
fi
echo "Installatios Script für Moodle Auto login"
echo ""
echo ""
read -p 'Benutzername für Moodle anmeldung eingeben:  ' VAR_USER
echo ""
read -p 'Moodle Passwort eingeben:  ' VAR_PW 
echo ""
echo " System wird aktualisiert und notwendige Pakete installiert."


apt-get update && apt-get upgrade -y 
apt-get install  openjdk-11-jre mc -y
mkdir /opt/login
wget https://github.com/mbaumgae81/auto_login_moodle/raw/master/bin/Login.jar -P /opt/login/
echo ""
echo "Erzeuge Scripts"
echo " #!/bin/sh" >> /opt/login/login.sh
echo " #!/bin/sh" >> /opt/login/logout.sh

echo "java -jar /opt/login/Login.jar $VAR_USER $VAR_PW EIN" >> /opt/login/login.sh
echo "java -jar /opt/login/Login.jar $VAR_USER $VAR_PW AUS" >> /opt/login/logout.sh

echo "30 16	* * mon,tue,wed,thu,fri root /opt/login/logout.sh >> /var/log/jaav.log  2>&1" >> /etc/crontab
echo "12 08	* * mon,tue,wed,thu,fri root /opt/login/login.sh >> /var/log/jaav.log  2>&1" >> /etc/crontab
echo ""
echo " Scripte werden ab sofort via Crontab gestartet"
echo " siehe /etc/crontab hier können auch zeitliche änderungen eingetragen werden. "
chmod 644 /opt/login/login.sh
chmod 644 /opt/login/logout.sh



