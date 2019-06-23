
# Basic commands
```
$ drop database name-database;
$ show databases;
```

**To log root user**
```
$ mysql -u root –p
```

**Exit MySql**
```
Ctrl + D
```

**Check status of service (Ubuntu)**
```
$ sudo service mysql status
```

# Solving Problems

## Uninstall MySQL

**Use apt to uninstall and remove all MySQL packages:**

    $ sudo apt-get remove --purge mysql-server mysql-client mysql-common -y
    $ sudo apt-get autoremove -y
    $ sudo apt-get autoclean

**Remove the MySQL folder:**

    $ rm -rf /etc/mysql

**Delete all MySQL files on your server:**

    $ sudo find / -iname 'mysql*' -exec rm -rf {} \;

## MySQL Workbench doesn't connect with root user ('Access denied for user 'root'@'localhost')

Try:

    $ sudo mysql -u root -p   
or

    $ sudo mysql -u root

    mysql: 
      USE mysql;
      SELECT User, Host, plugin FROM mysql.user;
      UPDATE user SET plugin='mysql_native_password' WHERE User='root';
      FLUSH PRIVILEGES;
      exit;

# About

[A Quick Guide to Using the MySQL APT Repository](https://dev.mysql.com/doc/mysql-apt-repo-quick-guide/en/#repo-qg-apt-replacing)
