# File Explorer

## Find files and directories related to your search

## Files
```
$ sudo find . -name "*yoursearch*"
```

FIND

find ./ -type f -name "myfilename"
find ./ -type f -name "myfilename*"

Hidden
find ./ -type f -name ".*"

find ./ -type d -name "mydir"
find ./ -type d -name "mydir*"

DIFF

diff file1.txt file2.txt

REMOVE DIRECTORY

rmdir: remove directory
rm -rf: remove empty directory

#### Directories
```
$ sudo find / -name "yoursearch"
```

### File Content
```
$ grep -r yoursearch
```

## Packages
```
$ apt list --installed
```

### Directory installed
```
$ dpkg -L your-package
```

