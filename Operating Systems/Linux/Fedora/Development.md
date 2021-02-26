Help it with Fork and Pull Request!

# PostgreSQL

## Setup and Running
The postgresql server is turned off and disabled by default. You can enable its start during the boot using following command:
```
$ sudo systemctl enable postgresql
```

You can start the postgresql server only when necessary as follows.
```
$ sudo systemctl start postgresql
```
## Basic LSB actions (start, stop, restart, try-restart, reload, force-reload, status)

**Status**
```
$ service postgresql status
```


See more: https://fedoraproject.org/wiki/PostgreSQL

## Installing pgAdmin and pgAdminDesktop

- [Installing pgAdmin4 3.X on RHEL / CentOS 7 and Fedora 27](https://people.planetpostgresql.org/devrim/index.php?/archives/96-Installing-pgAdmin4-3.X-on-RHEL-CentOS-7-and-Fedora-27.html)