# MongoDB

## Initial Setup

### Linux
* [Community Instructions](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/)
* [How to Install MongoDB on Ubuntu 18.04](https://www.digitalocean.com/community/tutorials/how-to-install-mongodb-on-ubuntu-18-04)

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
or
```shell
$ sudo systemctl status mongod
$ sudo systemctl start mongod 
$ sudo systemctl stop mongod
$ sudo systemctl restart mongod
$ sudo systemctl disable mongodb
$ sudo systemctl enable mongodb
```

### Verify MongoDB instace details
```shell
$ mongo --eval 'db.runCommand({ connectionStatus: 1 })'
```

## MongoDB Operations

### Q&A
*Q: What should I use to llimit the amount of data that MongoDB sends to applications or return only specified fields?*

A: [Include a projection document in your queries](https://docs.mongodb.com/manual/tutorial/project-fields-from-query-results/)
