Help it with Fork and Pull Request!

# Django with Virtualenv 

### Create virtual environment and Installing Django app 
##### Inside project folder
```
$ virtualenv venv -p python3.6 
```

##### Activating the environment 
```
$ source venv/bin/ctivate 
```
Or 
```
$ deactivate 
```

##### Installing Django 
```
$ pip install django 
```

### Starting a new Project 
```
$ django-admin startproject myprojectv 
```

##### Run the web server of project 
```
$ python manage.py runserver 
```

### Creating a new App on your Project 

##### A project called 'boards' 
```
$ django-admin startapp boardsdjango-admin startapp boards 
```

##### Open settings.py in project folder and add at INSTALLED_APPS the name of your app. 

### Creating a simple View 

##### Open views.py file inside the app folder and define your view. 

##### Open urls.py file inside the app folder and serve the view created. 
_(Don't forget to import 'views' from 'yourapp')_

### Basic commands 

##### Run your app/project server 
```
$ python manage.py runserver 
```
