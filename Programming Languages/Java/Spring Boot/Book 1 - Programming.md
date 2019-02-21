Help it with Fork and Pull Request!

# Java Spring Annotations

## About @RestController and @RequestMapping
When a class is flagged as a @RestController, meaning it's ready for use by Spring MVC to handle web requests. @RequestMapping maps / to the index() method. When invoked from a browser or using curl on the command line, the method returns pure text. That's because @RestController combines @Controller and @ResponseBody, two annotations that results in web requests returning data rather than a view.

## About @ApiModelPropertie
Use @Api notation to put comments on a java controller/entity on Swagger.
For controller, e.g:
```java
@Api(value="storeentity", description="Entity that has the Store register attributes")
```

## About @Valid
It validate a model after binding user input to it. Used: On controllers class.

## About Fields Notations
### @Lob
Use @Lob to store on entity Blob values.

### @JsonIgnoreProperties
Use @JsonIgnoreProperties to hidde some properties of JSON. It could be used both to getters (display) and setters (insert).
e.g.:
```java
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Test {
```

### @JsonProperty
Use @JsonIgnoreProperties to hidde some properties of JSON directly on a field. It could be used both to WRITE or READ the field.
e.g.:
```java
@JsonProperty(access = JsonProperty.Access.READ_ONLY)
private Store store;
```

### @Temporal
Use @Temporal to refers to Date/Calendar field, it works to determine the type of datetime.
```java
@Temporal(TemporalType.DATE)
@Temporal(TemporalType.TIME)
@Temporal(TemporalType.TIMESTAMP)
```

## To making JAR file executable
- [Maven Shade Plugin](https://maven.apache.org/plugins/maven-shade-plugin/)
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <version>2.1</version>
      <executions>
        <execution>
          <phase>package</phase>
          <goals>
            <goal>shade</goal>
          </goals>
          <configuration>
            <transformers>
              <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                <mainClass>hello.HelloWorld</mainClass>
              </transformer>
            </transformers>
          </configuration>
        </execution>
      </executions>
</plugin>
```
# Errors and Solutions

## Beans Dependencies Cycle

e.g.:
```java
Problem: The dependencies of some of the beans in the application context form a cycle

┌─────┐
|  purchaseService defined in file [/home/user/Documents/git/store-online/target/store-online-1.0.0/WEB-INF/classes/br/com/usr/store/services/PurchaseService.class]
↑     ↓
|  negotiationService defined in file [/home/user/Documents/git/store-online/target/store-online-1.0.0/WEB-INF/classes/br/com/usr/store/services/services/NegotiationService.class]
└─────┘
```
### About:
- [Beans Dependency Resolution](http://docs.spr@ApiModel(value = "Negotiation", description = "Class of entity responsible for representing the transactions of a negotiation.")ing.io/spring/docs/4.3.10.RELEASE/spring-framework-reference/htmlsingle/#beans-dependency-resolution)
- [Beans Setter Injection](https://docs.spring.io/spring/docs/4.3.10.RELEASE/spring-framework-reference/htmlsingle/#beans-setter-injection) _(Solution)_
- [2.2. Setter Injection](https://www.baeldung.com/spring-annotations-resource-inject-autowire) _(Solution)_
- [Spring @Lazy annotation](https://www.baeldung.com/spring-lazy-annotation) _(Solution)_

**Solutions**

##### Using SI

Use SI (Setter Injection) instead Dependency Injection: Declare, build a set method with @Resource annotation
Use @Resource
```java
private PurchaseService purchaseService;

@Resource(name="purchaseService")
public void setPurchaseService(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
}
```
_Explanation: @Resource annotation forces Spring initialize the class service with it dependecy. Don't forget that your @Resource component is still a @Service class._

##### Using @Lazy
Use @Autowired and @Lazy together in your service/component dependency:
```java
/**
 * Use of BCrypt encoder autowired.
 *
 * @author Willian Barbosa
 */
@Autowired
@Lazy
private PasswordEncoder passwordEncoder;
```
