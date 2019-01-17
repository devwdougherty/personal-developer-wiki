
Help it with Fork and Pull Request!

# Hibernate and JPA

## About FetchType (LAZY and EAGER)
In a database transaction between two tables/entities, LAZY will load just the records that are requested by the program. Instead, EAGER will load all the data related to its transaction (independently, if the system/user will use or not).

## CascadeType
ALL: All cascade operations will be applied to the parent entity’s related entity. All is equivalent to specifying cascade={DETACH, MERGE, PERSIST, REFRESH, REMOVE}

# Data Structures and It Operations

## General notes
**Vector instead ArrayList:**
	• For applications thread-safe (It's syncronized)
	• Vector double it allocations  when is fully (good when you need to increase your allocation size many times)
	
**LinkedList instead ArrayList:**
	• Better performance on add and remove methods.
	• Worst performance on get and set methods.

## Data interaction ways

### MAP<dataType, dataType>

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

**Sorting a Map manually
```java
if (sortOrder.toUpperCase().equals("ASC")) {

    Collections.sort(requestsList, new Comparator<Request>() {
        public int compare(Request request1, Request request2) {

            int comparatorValue = 0;

            if (request1.getDetails().get("txt-price") != request2.getDetails().get("txt-price")) {

                // Handling double/currency values with local
                Locale pt_ID = new Locale("pt", "BR");
                DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(pt_ID);
                nf.setParseBigDecimal(true);
                BigDecimal value1 = (BigDecimal)nf.parse(request1.getDetails().get("txt-price").get(0), new ParsePosition(0));
                BigDecimal value2 = (BigDecimal)nf.parse(request2.getDetails().get("txt-price").get(0), new ParsePosition(0));

                if (value1.compareTo(value2) == -1) {
                    comparatorValue = 1;
                } else {
                    comparatorValue = -2;
                }
            }

            return comparatorValue;
        }
    });

} else if (sortOrder.toUpperCase().equals("DESC")) {
    requestsList.sort(Comparator.comparing(Request::getSIndex).reversed());
}
```

**Interactions**
_Elements for_
```java
for(NeedForm needFormIterator : needFormListOpportunity) {
}
```
### For each loop

**For each loop on List**

```java
List<String> someList = new ArrayList<String>();
// add "monkey", "donkey", "skeleton key" to someList
for (String item : someList) 
{
   System.out.println(item);
}
```

**For each with Elements**
```java
for (Iterator<String> i = someIterable.iterator(); i.hasNext();) 
{
	String item = i.next();
	System.out.println(item);
}
```

**For each with lambda**
```java
sell.getItemList().forEach(i -> {
            i.setSell(sell);
            i.setProduct(productRepository.findById(i.getProduct().getId()).get());
        });
```

# Quick Tips

**Handle with Optional<T> request? :** Use get() instead handle with not found exception.
	
**Why use stream API? :** It helps in using data in a declarative way (and functional programming style); Good use of multi-core architectures (Parallel processing); Built to be fastest as for-loop.
