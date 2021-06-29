# LINUX - FUNDAMENTALS

1. Kernel 
2. Apps and GUI. 

GNOME / KDE

# Linux Terminal Operations

## Linux Environment

### Get the Sources (Repositories) List:
```
cat /etc/apt/sources.list 
```

### Your IP Address
```
$ hostname -I
```

### Original Locations
**Linux Headers:** /usr/src

### Recomended Locations
**To install software:** /opt/

### User and Privileges Management

**Log as root**
```
$ sudo su
```
**Transfer the ownership of a session to any other user**
```
$ su nameuser
```

## Web Server and Network

### Setup
- [Initial Server Setup with Ubuntu 18.04](https://www.digitalocean.com/community/tutorials/initial-server-setup-with-ubuntu-18-04)

_Key words: Root, ssh connection, basic firewall_

- [How To Install the Apache Web Server on Ubuntu 18.04](https://www.digitalocean.com/community/tutorials/how-to-install-the-apache-web-server-on-ubuntu-18-04)

_Key words: Web server, apache_

- [UFW Essentials: Common Firewall Rules and Commands](https://www.digitalocean.com/community/tutorials/ufw-essentials-common-firewall-rules-and-commands)

_Key words: Linux firewall_

### Managing the Apache Process
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

## Handling Packages

### Installed
```
$ apt list --installed
```

### Locate Directory
```
$ dpkg -L your-package
```

### To unzip and install a TARGZ
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

### Handle DEB packages:
**Install:**
```
sudo dpkg -i linux-headers-4.13.0-36-generic_4.13.0-36.40_16.04.1_amd64.deb
```
**Remove:**
```
sudo dpkg -r linux-headers-4.13.0-36-generic_4.13.0-36.40_16.04.1_amd64.deb
``` 

## File/Directory Explorer

### Move and Copy the unzip package to a root directory 
```
$ sudo mv package_java/ /opt/directory_package_java(You choose) 
$ sudo cp file directory/you/choose 
```

### To change file permissions 
```
$ chmod +x /path/to/yourscript.sh 
```
Explanation: _x (execute) r (read) w (write) - Or 777_
 
### Change the proprietary of the Folder and SubFolders 
```
$ sudo chown -R nameuser:namegroup /directory 
$ ls –l To see the result 
```

### To install a SH package file 
```
$ bash file_package_name 
```
After terms accept and PATH edited automatically go to: $ cd .. and: 
```
$ source .bashrc 
```

### To Run a .sh File 
```
$ ./file-name.sh 
```

### Directory Commands 
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

### Find
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

### DIFF
```
$ diff file1.txt file2.txt
```

## DIRECTORIES OPERATIONS

### Remove Content

Remove directory: `rmdir`

Remove empty directory: `rm -rf`

Remove directory and subdirectories: `rm -r`

### Search Content

We can use grep or fgrep (fastest and only look into strings and words).

Search any line that contains the word in filename: `grep 'word' filename`

Search any words in files: `grep -w "boo" file` / Two different words: `egrep -w "word1|word2" /path/to/file`

Count the number of lines when words has been matched: `grep -c "word" /path/to/file`

Search and list (word-to-search proper word and part of others) any word inside a file: `fgrep 'word-to-search' file.txt`

Search and list (only word california) inside a file: `fgrep -w California address.txt`

Search any word inside a file content: `cat otherfile | grep 'something'`

Perform a case-insensitive search for the word 'bar': `grep -i 'bar' file1`

Look for all files in the current directory and in all of its subdirectories for the word 'httpd': `grep -R 'httpd' .`

Search a file (/etc/passwd) for user boo: `grep boo /etc/passwd`

To run searches recursively use -r parameter and the directory: `grep -r "myword" /etc/`

See more on: [How To Use grep Command In Linux / UNIX With Practical Examples](https://www.cyberciti.biz/faq/howto-use-grep-command-in-linux-unix/)
