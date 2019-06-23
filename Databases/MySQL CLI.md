
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

MySql Workbench doesn't connect with root user ('Access denied for user 'root'@'localhost')

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
