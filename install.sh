#!/bin/bash


if [ "$EUID" -ne 0 ]
  then echo "Please run as root"
  exit
fi
read -p 'Benutzername für Moodle anmeldung eingeben: ' VAR_USER
read -p 'Moodle Passwort eingeben' VAR_PW 



apt-get update && apt-get upgrade -y 
apt-get install  openjdk-11-jre mc -y
mkdir /opt/login
wget https://github.com/mbaumgae81/auto_login_moodle/raw/master/bin/Login.jar /opt/login/

echo " #!/bin/sh" >> /opt/login/login.sh
echo " #!/bin/sh" >> /opt/login/lout.sh

echo "java -jar /opt/login/login.jar $VAR_USER $VAR_PW EIN" >> /opt/login/login.sh
echo "java -jar /opt/login/login.jar $VAR_USER $VAR_PW AUS" >> /opt/login/logout.sh

echo " 30 16	* * mon,tue,wed,thu,fri root /opt/login/logout.sh >> /var/log/jaav.log  2>&1" >> /opt/login/crontab
echo " 12 08	* * mon,tue,wed,thu,fri root /opt/login/login.sh >> /var/log/jaav.log  2>&1" >> /opt/login/crontab
chmod 644 /opt/login/login.sh
chmod 644 /opt/login/logout.sh



