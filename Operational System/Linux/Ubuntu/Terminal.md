Help it with Fork and Pull Request!

# Explorer and Files 

### To unzip and install a TAR GZ 
```
$ tar -xvzf package_java.targz 
```
_Explanation:_

**f:** this must be the last flag of the command, and the tar file must be immediately after. It tells tar the name and path of the compressed file. 

**z:** tells tar to decompress the archive using gzip 

**x:** tar can collect files or extract them. x does the latter. 

**v:** makes tar talk a lot. Verbose output shows you all the files being extracted. 


### Move and Copy the unzip package to a root directory 
```
$ sudo mv package_java/ /opt/directory_package_java(You choose) 
$ sudo cp file directory/you/choose 
```

- /opt/ - _To install software_

### To change permissions 
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
$ pwd currently directory 

$ ls 

$ ls -la just the new files 

$ ls -lh file with it permissions 

$ cp copy 

$ mv move/rename 

$ rm remove
```

### To return to Home Directory 
```
$ cd ~ 
```
 
# ENVIRONMENT 

## Configure Environment Variables 

The file that we have to edit is .bashrc on Home Directory 
```
$ cd ~ (It will redirect to your home/user directory) 

$ vi .bashrc (VI editor) || $ sudo nano (Nano editor) 
```

Go to the final part 

Insert the variable of your package 

ON VI
```

$: i (to insert a line) 

$ export JAVA_HOME=/opt/jdk 

$ export PATH=$JAVA_HOME/bin:$PATH 

$ Ctrl + C - To stop insert 

$ :w 

$ :q 

$ source .bashrc 

$ java -version 

```

**Explanation:**

/opt - Location of your installed applications 
/bin - Where the executable files are in 
/etc - ? 

_What I'm doing? - We defined the Application and PATH Environmental Variables _

 
## VI Editor 

$ vi 

### To Navigate on the editor 
Page up / Page down 

### To Insert/Edit/Write/Quit/Comment/To Digit something 
```
$ i -> insert 

$ e -> edit 

$ q -> quit 

$ w -> write 

$ # -> commentary 

$ ESC + :  -> to VI command line 

$ a -> 
```

## To Save/Communicate to SO that file has changed 
```
$ source 'file or it extension' 
```

## Kill Servers on a Port 
```
$ sudo kill $(sudo lsof -t -i:8080) 
```
 
# Ubuntu Install and Update

## To update SO and it Packages 
```
$ sudo apt-get update -y 

$ sudo apt-get upgrade –y 
```
 
# Development Problems on Ubuntu

### JAVA PROBLEM: Fatal Error SIGSEGV 

**About:** https://stackoverflow.com/questions/6448163/a-fatal-error-has-been-detected-by-the-java-runtime-environment-sigsegv-libjvm 
 
In your home directory ( cd ~ /home/youuser) at .bashrc add: 
```
$ export LD_BIND_NOW=1 
```

Source your bashrc and restart the OS. 
