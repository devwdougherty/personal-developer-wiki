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
