Help it with Fork and Pull Request!

# Linux Architecture 

1. Kernel 
2. Apps and GUI. 

# Linux Envirnonment

## Configure Environment Variables


# Web Server and Network

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
sudo systemctl status apache2
sudo systemctl reload apache2
sudo systemctl disable apache2
sudo systemctl enable apache2
```
_disable: By default, Apache is configured to start automatically when the server boots. If this is not what you want, disable this behavior_

## Terminal

### File Explorer

#### Directory Structure

- /opt/ - _To install software_

#### To unzip and install a TARGZ
```
$ tar -xvzf package_java.targz 
```
_Optional:_ You can put the directory that has chosen for application directly at end of decompress line
e.g: $ tar -xvzf package_java.targz **/opt/**

_Explanation:_

**f:** this must be the last flag of the command, and the tar file must be immediately after. It tells tar the name and path of the compressed file. 

**z:** tells tar to decompress the archive using gzip 

**x:** tar can collect files or extract them. x does the latter. 

**v:** makes tar talk a lot. Verbose output shows you all the files being extracted. 

#### Move and Copy the unzip package to a root directory 
```
$ sudo mv package_java/ /opt/directory_package_java(You choose) 
$ sudo cp file directory/you/choose 

#### To change file permissions 
```
$ chmod +x /path/to/yourscript.sh 
```
Explanation: _x (execute) r (read) w (write) - Or 777_
 

#### Change the proprietary of the Folder and SubFolders 
```
$ sudo chown -R nameuser:namegroup /directory 
$ ls –l To see the result 
```

#### To install a SH package file 
```
$ bash file_package_name 
```
After terms accept and PATH edited automatically go to: $ cd .. and: 
```
$ source .bashrc 
```

#### To Run a .sh File 
```
$ ./file-name.sh 
```

#### Directory Commands 
```
$ pwd //currently directory 

$ ls 

$ ls -la //just the new files 

$ ls -lh //file with it permissions 

$ cp //copy 

$ mv //move/rename 

$ rm //remove

$ cd ~ //return to home
```




### Your IP Address
```
$ hostname -I
```

# User and Privileges Management

**Log as root**
```
$ sudo su
```
**Transfer the ownership of a session to any other user**
```
$ su nameuser
```
