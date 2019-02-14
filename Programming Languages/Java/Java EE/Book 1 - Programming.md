
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

### String
**Comparing two strings -> equally with Case Sensitive or not**

_.equals & .equalsIgnoreCase_
```java
"blablabla".equals("Blablabla") //Retorna FALSE
"blablabla".equalsIgnoreCase("Blablabla") //Retorna TRUE
```

### Date
**Finding difference in days**
e.g:
```java
long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
```

### List<?> - Unknown Objects
**List with unknow objects**

_In this case, getList will return a String list with unknown properties._
```java
List<?> rawDetails = cloudEntity.getList(detail);
ArrayList valueList = new ArrayList<>();

for (Object valueDetail : rawDetails) {
    valueList.add(StringValue.of(((StringValue) valueDetail).get()));
}
```
**Distinct filter on a List using stream() and predicate. (Duplicate values)**
```java
// List -> List<Door> doorList
List<Door> distinctListDoor = doorList.stream()
                .filter(distinctByKey(o -> o.getDoorMaterialEnum())).collect(Collectors.toList());
		
// Distinct filter method
/**
* Auxiliary method to filter duplicate values in a list.
*
* @param keyExtractor Key parameter to be filtered
* @param <T> T Object
* @return Predicate filter
*/
public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
	Map<Object,Boolean> seen = new ConcurrentHashMap<>();
	return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
}
```


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

**Displaying only the keys:**
```java
 Map<TypeEnum, String> customerInfo;
 
 System.out.println(customerInfo.keySet());
```

**Rename a key:**
```java
 Map<TypeEnum, String> customerInfo;
 
/* Try to remove the element and put it again with the new name. Assuming the keys in your map are String, it could be // achieved that way: */

Object obj = customerInfo.remove("oldKey");
customerInfo.put("newKey", obj);
```


**Sorting a Map manually**
```java
if (sortOrder.toUpperCase().equals("ASC")) {

    Collections.sort(requestsList, new Comparator<Request>() {
        public int compare(Request request1, Request request2) {

            int comparatorValue = 0;

            if (request1.getDetails().get("txt-price") != request2.getDetails().get("txt-price")) {

                // Handling double/currency/bigdecimal values with local
                Locale pt_ID = new Locale("pt", "BR");
                DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(pt_ID);
                nf.setParseBigDecimal(true);
                BigDecimal value1 = (BigDecimal)nf.parse(request1.getDetails().get("txt-price").get(0), new ParsePosition(0));
                BigDecimal value2 = (BigDecimal)nf.parse(request2.getDetails().get("txt-price").get(0), new ParsePosition(0));

		// Special comparators with BigDecimal values. With primite: < > <= >= ==
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

### Files (byte[] format)
**Get the mimeType**
```java
String mimeType = "";

String fileName = "documet-identify.pdf";

mimeType = URLConnection.guessContentTypeFromName(fileName);

// mimeType output: application/pdf
```

# Q&A

**Handle with Optional<T> request? :** Use get() instead handle with not found exception.
	
**Why use stream API? :** It helps in using data in a declarative way (and functional programming style); Good use of multi-core architectures (Parallel processing); Built to be fastest as for-loop.

**Need to compare two dates quickly? :** Use date1.compareTo(date2): If > 0 = Date1 after Date 2; If < 0 = Date1 before Date 2; If == 00 = Date1 equal Date2 
