Help it with Fork and Pull Request!

# Linux Architecture 

1. Kernel 
2. Apps and GUI. 

# Web Server

## Setup
- [Initial Server Setup with Ubuntu 18.04](https://www.digitalocean.com/community/tutorials/initial-server-setup-with-ubuntu-18-04)

_Key words: Root, ssh connection, basic firewall_

- [How To Install the Apache Web Server on Ubuntu 18.04](https://www.digitalocean.com/community/tutorials/how-to-install-the-apache-web-server-on-ubuntu-18-04)

_Key words: Web server, apache_

- [UFW Essentials: Common Firewall Rules and Commands](https://www.digitalocean.com/community/tutorials/ufw-essentials-common-firewall-rules-and-commands)

_Key words: Linux firewall_

## Managing the Apache Process
```
sudo systemctl stop apache2
sudo systemctl start apache2
sudo systemctl restart apache2
```

## Terminal

### Your IP Address
```
$ hostname -I
```

# User and Privileges Management

**Log as root&**
```
$ sudo su
```
**Transfer the ownership of a session to any other user**
```
$ su nameuser
```
