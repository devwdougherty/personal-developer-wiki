# File Explorer

## Find files and directories related to your search

## Files
```
$ sudo find . -name "*yoursearch*"
```

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