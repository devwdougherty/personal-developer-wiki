Help it with Fork and Pull Request!

# Database Relations

## To Build a Relationship OneToMany – ManytoOne between 2 classes

Inside first Entity/model class:
```java
@OneToMany
Private Set<AnotherClass> anotherclass;

```
+ Constructor
+ Get & Set

Inside second entity/model class:
```java
@ManyToOne(targetEntity = FirstClass.class)
Private Set<FirstClass> firstclass;

public Constructor () {
     super();   
}
```
+ Constructor
+ Get & Set

## To Build a Relationship OneToOne – OneToOne between 2 classes

_[be careful with infinite loop class appoint to another recursively:](https://pt.stackoverflow.com/questions/242288/infinite-recursion-stackoverflowerror-erro-ao-listar-produtos-com-categorias)_

# Interface and Implementation

**Example:** DataStorePageable (Your custom class) implements the Pageable (Java) interface:
```java
public class DataStorePageable implements Pageable { 
	// content
}
```

Before use and customize what you want, you need implement the native methods from your interface (In this case: Pageable). 

What is needed to native methods from your interface works? Which variables? You need to put it in your custom class inside a class constructor. Example:
```java
private int page;
private int size;
private String cursor;
 
public DataStorePageable(int page, int size, String cursor) {
     this.page = page;
     this.size = size;
     this.cursor = cursor;
}
```

