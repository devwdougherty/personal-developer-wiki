Help it with Fork and Pull Request!

# Linux Architecture 

1. Kernel 
2. Apps and GUI. 

GNOME / KDE

# Linux Environment

## Get the Sources (Repositories) List:
```
cat /etc/apt/sources.list 
```

## Original Locations
**Linux Headers:** /usr/src

## Recomended Locations
**To install software:** /opt/

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

## Terminal General Operations

### Handling Packages

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

#### Handle DEB packages:
**Install:**
```
sudo dpkg -i linux-headers-4.13.0-36-generic_4.13.0-36.40_16.04.1_amd64.deb
```
**Remove:**
```
sudo dpkg -r linux-headers-4.13.0-36-generic_4.13.0-36.40_16.04.1_amd64.deb
``` 

### File Explorer

#### Move and Copy the unzip package to a root directory 
```
$ sudo mv package_java/ /opt/directory_package_java(You choose) 
$ sudo cp file directory/you/choose 
```

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



# File/Directory Explorer

## Find
-type f -> file search

-type d -> directory search

"*" -> all possible characters/words

"." -> hidden file
```
$ find . f -name "*yoursearch*"
$ find ./ -type f -name "myfilename"
$ find ./ -type f -name "myfilename*"
$ find ./ -type f -name ".*"
$ find ./ -type d -name "mydir"
$ find ./ -type d -name "mydir*"
```

## DIFF
```
$ diff file1.txt file2.txt
```

## CRUD DIRECTORY

### Remove
rmdir: remove directory
rm -rf: remove empty directory

### See Content
```
$ grep -r yoursearch
```

## Packages

### Installed
```
$ apt list --installed
```

### Locate Directory
```
$ dpkg -L your-package
```

