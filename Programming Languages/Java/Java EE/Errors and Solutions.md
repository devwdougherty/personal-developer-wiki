Help it with Fork and Pull Request!

# Errors and Solutions Java

**Error:** Could not determine type for: com.example.demo.model.Produto, at table: item, for columns: [org.hibernate.mapping.Column(produto)]

**Solution:** Possibly is missing a relationship definition among entities, e.g. @ManyToOne or @OneToMany


**Error:** org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Infinite recursion (StackOverflowError)

**Solution:** External Source: https://pt.stackoverflow.com/questions/242288/infinite-recursion-stackoverflowerror-erro-ao-listar-produtos-com-categorias


**Error:** unhandled exception type ParseException

**Solution:** You need add a 
```java
try { } catch (java.text.ParseException e) { }
```
on your method call. Similar cases could be resolved using the same approach.
