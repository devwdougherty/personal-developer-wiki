Help it with Fork and Pull Request!

# Fields

## Static fields
A static field doesn't need it class instanced to be called or used. They can be accessed directly from class. A static variable maintain the instance/value of your first call.
e.g.:
```c#
public static int ID
```		
_The value of a Static Field is not dependant on a Class Instance. It is shared among all instances and everyone can modify or access it internally._

## Readonly Field
e.g.:
```c#
Public readonly int ID;
```

## Const Field
e.g.:
```c#
Public const int HEIGHT = 180;
```

# Resources
## Time Interval
**TimeSpan type**
e.g: 
```c#
DateTime dateRange = new DateTime(0, 0, 0, 4, 0, 0);
TimeSpan result = DateTime.Now - dateRange;
```
# Data Structure

## Dictionary
e.g:
```c#
Dictionary<string, string> valuesToPatch = new Dictionary<string, string>();
```

## SelectItemList (Model object)
e.g.:
```c#
List<Monitor> monitors //Explanation: Monitor is a Model
var ListUidName = new SelectList(monitors, "MonitorId", "MonitorName");
```

## SecureString
**String to SecureString**
```c#
SecureString theSecureString = new NetworkCredential("", "myPass").SecurePassword;
```
**SecureString to String**
```c#
string theString = new NetworkCredential("", theSecureString).Password;
```

# About Classes

## Static
A static class can not have constructors, as they can not be instantiated, they do not need one.
