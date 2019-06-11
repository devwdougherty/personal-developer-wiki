Help it with Fork and Pull Request!

# Angular Environment

## CLI

### Install and Start app
```
$ npm install
$ ng serve
$ npm start
```

#### To create a new project at terminal
```
$ ng new nome-project
```

#### To create a new component / service / model class
```
$ ng generate component 'nameComponent'
$ ng generate service 'nameService'
$ ng generate class 'nameClass' --type=model
```
_Example: $ ng generate component navbar_

#### Flags
**--spec--false** or **skipTests**: to not create a test file.

**--s**: create without style.

#### Build ways to become Angular build faster
```
$ ng build --source-map=false
$ ng build --watch=true
$ ng build --build-optimizer=false
```

#### To install new package (functions)
```
$ npm install ng2-currency-mask --save
```

# Angular Application

## Router and Routes
See: https://angular.io/guide/router

## Variables and elements Server and Client Side
**You can refer a typescript variable or object on HTML page this way: {{ yourvar_on_ts }} or {{ data.field }}**

**You can get a variable/object value to your field on HTML page with [value] Angular notation.**
e.g.:
```html
<input class="demo" [value]="myObject.lastField">
```

## Events
**On the HTML element, put your event inside ().**
e.g.:
```html
<img width=300 (click)="onLogoClicked()" src="data/img/ok/img.png">
```
