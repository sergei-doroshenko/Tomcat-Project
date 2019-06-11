apt-get update
apt-get install openssh-server

mkdir /var/run/sshd
chmod 0755 /var/run/sshd
/usr/sbin/sshd

useradd --create-home --shell /bin/bash --groups sudo username ## includes 'sudo'
passwd username ## Enter a password

apt-get install x11-apps ## X11 demo applications (optional)
ifconfig | awk '/inet addr/{print substr($2,6)}' ## Display IP address (optional)

#Now you can even run graphical applications (if they are installed in the container) using X11 forwarding to the SSH client:
#ssh -X username@IPADDRESS
#xeyes ## run an X11 demo app in the client