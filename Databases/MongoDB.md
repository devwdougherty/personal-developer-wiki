# MongoDB

## Installation

### Linux
* [Community Instructions](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/)

### Mac
* [Install MongoDB Community Edition on macOS](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/)

## MongoDB CLI

### Service Actions on Terminal
```shell
$ sudo service mongod start
$ sudo service mongod stop
$ sudo service mongod restart
$ mongo
```

### Verify MongoDB instace details
```shell
$ mongo --eval 'db.runCommand({ connectionStatus: 1 })'
```
