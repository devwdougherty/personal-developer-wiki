# Programming

## UNDERSTANDING THE SCALA LANGUAGE
See about: https://madusudanan.com/blog/scala-articles-index/

## BASIC CODE
### KEYWORDS
**implicit** - could be applied in functions parameters and functions. Basically: the compiler always will use or call what was defined as 'implicit', addressing itself by the types.

**type** - Use type to do some alias for something more verbose, complex or not clarified:

*Define:*
```scala
	def doSomeThing(f: FunctionSomething)
```
*Compiler interprets:*
```scala
	def doSomeThing(f: (this, that, there, those, these, them)
```
*E.g.:*
```scala
	type CustomerFormat = Value
```
	
### OPERATORS
#### STRING INTERPOLATOR
Inserts arguments between corresponding parts of string context.
```scala
val myName = "Wil"
println(s"My name is $myName")
```

### DATA ACCESS, HANDLE AND LOOP
FOR COMPREHENSIONS
[tbd]

## DATA STRUCTURES

### Optional and Stream

* Both Have the same return types (Stream<R>) but are quite different.

* The map structure tend to execute an additional wrapping internally when it`s called. In more complex cases, this leads to a nested structure. E.g.: <Optional<Optional<String>>,  Stream<Stream<R>>. flatMap works directly avoiding that nested structure.

### Optional in Scala
**Option** -> Abstract class with two children: **Some** and **None**. Is not a type per se.

We can create our own Option Type building the clause and returning Some or None.

_Some -> case class_
_None -> object class_

We can consume **Optional** with pattern matching or getOrElse().

### Map and Flatmap
Functional programming APIs that we use with Optional, Stream and CompletableFuture.

+ flatmap() takes a Function that conceptually wants to consume one value and produce an arbitrary number of values (zero or more).
+ flatMap() applies the concept of "Flattening" (nested collections -> flatten -> one collection with all elements).
+ map() takes a Function and call it for each value in the input stream to produce one result value.

### Match or Map
See About: https://freecontent.manning.com/using-option-in-scala-part-2-map-and-flatmap/

Additionally: We can use the "fold" option.

#### With map: 
+ Use of if clause -> map(ifSome).getOrElse(ifNone)
+ Map will apply the function only if the optional value is present.
+ Map will not apply any function with the optional is None.

### With match: 
+ We can use the pattern matching to identify the result/data structure. Don`t need to use the if/then statements.

Match syntax is more readable with the possible results. A more organized code.

_E.g.:_

**Matching Pattern**
```scala 
def ownerName(car: Car): Option[String] =
	car.owner match {
		case Some(p) => Some(p.name)
		case None => None
```

**Map function**
```scala 
def ownerName(car: car): Option[String] = 
	car.owner.map(p => p.name)
```

**Map on Option
```scala
def map[B](f: A => B): Option[B] =
	this match {
		case Some(a) => Some(f(a))
		case None => None
```
		
See about: https://fares.codes/posts/fold-vs-pattern-matching-and-matching-on-options/

### The Most Idiomatic Way
The most idiomatic way to use an Option instance is to treat it as a collection or monad and use map, flatMap, filter, or foreach.
```scala
val res = value.map(foo).getOrElse(bar)
```

A less-idiomatic way to use Option values is via pattern matching:
```scala 
value match {
	case Some(a) => foo(a)
	case None => bar
}
```

## API with PLAY FRAMEWORK
### ENDPOINTS
Action[AnyContent] = Action - We create a controller method of Action[AnyContent] type and give it a Action value.

*e.g.:*
```scala 
	def getById(itemId: Long): Action[AnyContent] = Action

	def create(): Action[JsValue] = Action.async(controllerComponents.parsers.json)
```


