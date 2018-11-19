
Help it with Fork and Pull Request!

# Hibernate and JPA

## About FetchType (LAZY and EAGER)
In a database transaction between two tables/entities, LAZY will load just the records that are requested by the program. Instead, EAGER will load all the data related to its transaction (independently, if the system/user will use or not).

## CascadeType
ALL: All cascade operations will be applied to the parent entity’s related entity. All is equivalent to specifying cascade={DETACH, MERGE, PERSIST, REFRESH, REMOVE}

# Data Structures

## General notes
**Vector instead ArrayList:**
	• For applications thread-safe (It's syncronized)
	• Vector double it allocations  when is fully (good when you need to increase your allocation size many times)
	
**LinkedList instead ArrayList:**
	• Better performance on add and remove methods.
	• Worst performance on get and set methods.
	
## MAP<dataType, dataType>

**Initializing a map**
```java
Map<Integer, String> mapTest = Collections.emptyMap();
Map<Integer, String> mapTest = new HashMap<>();
```

**Acessing keys and values in a map**
```java
for (Map.Entry<Integer, List<String>> element : cursorList.entrySet()) {
     Element.getKey();
	Element.getValue();
}
```
**Interactions**
_Elements for_
```java
for(NeedForm needFormIterator : needFormListOpportunity) {
}
```
