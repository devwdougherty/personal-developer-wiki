Help it with Fork and Pull Request!

# Explorer and Files 
nothing.
 
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
/bin - Where the execchoosenutable files are in 
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

## Connectins 

### Kill Servers on a Port 
```
$ sudo kill $(sudo lsof -t -i:8080) 
```

### Check Listening Ports
```
$ sudo netstat -plnt
```
 
# Ubuntu Show, Install, Update and Delete

## List your installed packages
```
$ dpkg --list
```

## Locate folders and files on terminal:
```
$ locate your_folder_or_file
```

## To update SO and it Packages 
```
$ sudo apt-get update -y 

$ sudo apt-get upgrade –y 
```

## To delete programs and package using APT commands
```
$ sudo apt-get remove package_name
```
or
```
$ sudo apt-get purge package_name
```
**Clean the mess:*
```
$ sudo apt-get autoremove
```

 
# Development Problems on Ubuntu

### JAVA PROBLEM: Fatal Error SIGSEGV 

**About:** https://stackoverflow.com/questions/6448163/a-fatal-error-has-been-detected-by-the-java-runtime-environment-sigsegv-libjvm 
 
In your home directory ( cd ~ /home/youuser) at .bashrc add: 
```
$ export LD_BIND_NOW=1 
```

Source your bashrc and restart the OS. 
