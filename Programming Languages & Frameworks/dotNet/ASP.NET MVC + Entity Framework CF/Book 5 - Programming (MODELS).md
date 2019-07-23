Help it with Fork and Pull Request!

**Model .cs**

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

## Display Format (decimals, time, date, etc)
e.g.:
```c#
[DataType(DataType.Time)]
[DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:t}")]
public DateTime TrainingTime { get; set; }
```

## REGEX - Regular Expression
### Regular Expression to specifies which values are accept in the field.
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

### Password input with upper case, lower case, numbers and special characters (no spaces)
```c#
[RegularExpression(@"^((?=.*?[^a-zA-Z0-9]))(?=.*\d)\S{8,30}$", ErrorMessage = "Invalid password. Passwords must be between 8 and 30 characters, could contain: upper case (A-Z), lower case (a-z), number (0-9) and special character (e.g. !@#$%^&*)")]
```

## Remote with Adittional Fields to validation functions
```c#
[Remote("IsIPNumberExists", "Camera", ErrorMessage = "There is already a user registered with that IP Number.", AdditionalFields = "Id")]
```

## Model Attribute that is not mapped into a database column
```c#
[NotMapped]
public int MyProperty { get; set; }
```
