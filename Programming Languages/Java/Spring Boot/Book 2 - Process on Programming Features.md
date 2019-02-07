Help it with Fork and Pull Request!

# Database Relations

## To Build a Relationship OneToMany – ManytoOne

**Inside first Entity/Model class:**
```java
/* Store.class */
@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Certificate.class)
private List<Product> productList = new ArrayList<>();

// CascadeType.ALL -> Every operation will be replicated on this relationship.
// fetch = FetchType.LAZY -> Only data that is directly requested.
```
+ +Get & Set methods

**Inside second Entity/Model class:**
```java
/* Product.class */
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "company_id", nullable = false)
private Store store;

```
+ +Get & Set methods

## To Build a Relationship OneToOne – OneToOne

_Be careful with infinite loop class appoint to another recursively, to deal with that:_
[Jackson – Bidirectional Relationships](https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion)

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
# JSON
## Implementing a custom JSON deserializer (Jackson)
_In this example, our custom deserializer method works removing blank spaces inside JSON body fields._
e.g:
```java
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Custom Json component to handle blank spaces at the end and at the start of strings on deserialization process.
 *
 */
@JsonComponent
public class CustomJsonDeserializer extends JsonDeserializer<String> {

    /**
     * Method that can be called to ask implementation to deserialize JSON content into the value type this serializer handles.
     *
     * @param p Base class that defines public API for reading JSON content.
     * @param ctxt Context for the process of deserialization a single root-level value.
     * @return A json string value trimmed.
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        return p.hasToken(JsonToken.VALUE_STRING) ? p.getText().trim() : null;
    }
}
```

# Q&A
