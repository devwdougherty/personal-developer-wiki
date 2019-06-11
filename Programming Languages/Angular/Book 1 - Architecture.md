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
