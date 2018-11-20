Help it with Fork and Pull Request!

# ViewModel
**When use the ViewModel?**

When the project have two or more Entities that interact each other. Example: Users that have roles.

# VALIDATION

## Maximum and Minimum Lenght to a Input Field
```c#
[StringLength(10, ErrorMessage = "Must be between 5 and 10 characters", MinimumLength = 5)]
```

## String Lenght to a Input Field
```c#
[StringLength(30)]
```

## Range of values to a Input Field
```c#
[Range(1.01, 2, ErrorMessage = "Field should be in range [1.01, 2].")]
```

## Regular Expression to specifies which values are accept in the field.
```c#
[RegularExpression(@"^([1-9]|1[0-9]|20)$", ErrorMessage = "Neighbors should be in range [1, 20] integer.")]
```
Here accepts: 1 to 9, 10 to 19 and 20.

**^** indicates start of the string. 

**$** indicates end of string. 

**0-9, A-Z, a-z** indicates 0 or more character. + indicates 1 or more character.

```c#
[RegularExpression(@"^[^/\\() ~!@#$%^&*]*$", ErrorMessage = "Error")]
```
It allows any character except /\\() ~!@#$%^&*

**^** indicates start of the string. 

**$** indicates end of string.

**[ ]** Inside indicates what will be filtered. 

**^** inside [ ] indicates what won't be allowed.

## Remote with Adittional Fields to validation functions
```c#
[Remote("IsIPNumberExists", "Camera", ErrorMessage = "There is already a user registered with that IP Number.", AdditionalFields = "Id")]
```

## Model Attribute that is not mapped into a database column
```c#
[NotMapped]
public int MyProperty { get; set; }
```
