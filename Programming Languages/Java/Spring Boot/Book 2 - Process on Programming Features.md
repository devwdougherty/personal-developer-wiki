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

# JPA Operation and Actions

## About EntityManager
EntityManager is a central service that handles the persistence actions on Java.

e.g.:
```java
@PersistenceContext
private EntityManager em;
```

**Explanation:** @PersistenceContext Expresses a dependency on a container-managed EntityManager and its associated persistence context.

_To do custom queries on Spring Boot JPA we need the EntityManager with it context__


## Custom queries

1 - Create a custom repository (Interface)

2 - Create a custom implementation (Class)

3 - Extends your custom interface-repository for the main interface-repository

4 - Declare your custom methods on your interface

5 - Implement your custom methods on your implementation class (Declare and use EntityManager)

6 - Custom queries e.g.:
```java 
public Negotiation getNegotiationWithStatusFinish(String negotiationId) {

	Query q = entityManager.createNativeQuery(
		"SELECT * FROM negotiation WHERE " +
		"(id_negotiation = :negotiationId OR id_negotiation_second = :negotiationId) " +
		"AND (negotiation_status_first = :status OR negotiation_status_second = :status)" , Negotiation.class);
	q.setParameter("negotiationId", negotiationId);
	q.setParameter("status", NegotiationStatus.DONE);

	try {
	    return (Negotiation) q.getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
}
```
