Help it with Fork and Pull Request!

# Instalation and Update 

## Upgrading your Fedora Version

Allow your update Fedora removing/ignoring the problematic repositories 

**--allowerasing **
```
$ sudo dnf system-upgrade download --refresh --allowerasing --releasever=29 
```
 
Try to update with a Debug Data File to solve problems 

**--debugsolver **
```
$ sudo dnf system-upgrade download --refresh --debugsolver --releasever=29 
```
 
Fedora version 
```
$ cat /etc/fedora-release 
```
 

 

 

 
