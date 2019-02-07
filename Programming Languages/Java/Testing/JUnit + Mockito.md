Help it with Fork and Pull Request!

# JUnit Notes 
The class that will be tested shoud have @Test notation and be public. 

# Basic JUnit Commands 

**@Test**
e.g.:  
```java
@Test 
public void testClientProductSum() { 
```

**stub(blablablbal).ToReturn(blabla)**
e.g.:
```java
stub(productDO.getAllProducts(anyInt())).toReturn(products);  
```

**assertEquals**
e.g.:
```java
assertEquals(expectedAmount.getCurrency(), actualAmount.getCurrency()); 
```

**verify(entity/mock).EntityMockMethod(blablbalba, balblaba)**
e.g.: 
```java
verify(productDO).insertProduct(1, screenProducts.get(0)); 
```

# JUnit Notations 

### A unit test that expected a exception return 
```java
@Test(expected = Exception.class) // or your customExceptionClass 
```

# Basic Mockito 
## Annotations 
**@RunWith(MockitoJUnitRunner.class)**

**@Mock** – Mock a service, repository or controller. 

**@Mock(name="somename")** - Use a name parameter when you need to use more than one mock for the same service, repository or controller. 

_Obs: your object must have the same name._

**@InjectMocks** – It uses the previous defined @Mock to inject dependencies where is needed (E.g: controller class). 

**@Spy** - This will allow the program to call all the normal methods of the object while still tracking every interaction; 

## Class Mocking 

### How-to: Standard/Proprietary Class 
e.g.: 
```java
IncompleteKey incompleteKey = mock(IncompleteKey.class); 
```
**Obs:** A standard/proprietary class mocked, is firstly just the "structure", without it methods and functionalities. To solve this, the developer needs to mock all the methods that need.   

e.g.: 
```java
Principal mockPrincipal = Mockito.mock(Principal.class); 

when(mockPrincipal.getName()).thenReturn(usersMocked.get(0).getLogin()); 
```
Here we need 'getName' method, not just the Principal class. 

## Testing Exceptions 
e.g.: 
```java
when(sportService.getPlayerById(any(Long.class))).thenThrow(EntityNotFoundException.class); 

ResponseEntity<Sport> result = spoprtController.getPlayerById(any(Long.class)); 

assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND); 
```

# How to

## How to Setup a Unit Test to run with Mockito Mock (Controllers, Services, Repositories) instead the real methods 

_Example: Mocking a service class:_
```java
ScanService mockService = Mockito.mock(ScanService.class); 
```

**At setUp method (on unit test class):**
```java
scanController = new ScanController(scanRepository, mockService); 
```
_Explanation: This controller use this service class (that will be mocked)._

**At unit test method:**
```java
when(mockService.deleteRabbitQueue(any(String.class))).thenReturn(error); 
```
_Explanation: With this approach, the unit test will test only the desired method (ignoring the rest)_
 

## How to do a Partial Mock with Mockito 

**First Option:** Use thenCallRealMethod() at your method that you don't want a mock. 

**Second Option:** Use a Spy() at your class. 

## How to get a private method to test 
```java
Class<SellService> sellServiceClass = SellService.class; 

Method checkIsAvailable = sellServiceClass .getDeclaredMethod("checkIsAvailable ", Sell.class, Sell.class); 

checkIsAvailable .setAccessible(true); 

assertThat(checkIsAvailable .invoke(sellService, persistedSell, updateSell)).isEqualTo(true); 
```
