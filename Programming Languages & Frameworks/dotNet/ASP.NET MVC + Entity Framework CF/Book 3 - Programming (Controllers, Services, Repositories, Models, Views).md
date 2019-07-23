# Book 3 - Programming (Model, Repository, Service, Controller, View)


# Model (cs)

## Input and Output Validation

### Display Properties
```c#
[DataType(DataType.Password)] // or others
[Display(Name = "Showed in the view")]
```
#### Display Format (decimals, time, date, etc)
e.g.:
```c#
[DataType(DataType.Time)]
[DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:t}")]
public DateTime TrainingTime { get; set; }
```

### Compare fields
```c#
[Compare("NewPassword", ErrorMessage = "The new password and confirmation password do not match.")]
= 5)]
public string ConfirmNewPassword { get; set; }
```

### Maximum and Minimum Lenght to a Input Field
```c#
[StringLength(10, ErrorMessage = "Must be between 5 and 10 characters", MinimumLength = 5)]
```

### String Lenght to a Input Field
```c#
[StringLength(30)]
```

### Range of values to a Input Field
```c#
[Range(1.01, 2, ErrorMessage = "Field should be in range [1.01, 2].")]
```

## REGEX
### Regex to specifies which values are accept in the field.
```c#
[RegularExpression(@"^([1-9]|1[0-9]|20)$", ErrorMessage = "Neighbors should be in range [1, 20] integer.")]
```
_Here accepts: 1 to 9, 10 to 19 and 20._

	^ indicates start of the string. 

	$ indicates end of string. 

	* indicates 0 or more characters.

	+ indicates 1 or more characters.

	0-9, A-Z, a-z indicates that allows that range of symbols/characters.

### Regex with unacceptable symbols
```c#
[RegularExpression(@"^[^/\\() ~!@#$%^&*]*$", ErrorMessage = "Error")]
```

It allows any character except /\\() ~!@#$%^&*

	^ indicates start of the string. 

	$ indicates end of string.

	[ ] Inside indicates what will be filtered. 

	^ inside [ ] indicates what won't be allowed.

### Password input with upper case, lower case, numbers and special characters (no spaces)
```c#
[RegularExpression(@"^((?=.*?[^a-zA-Z0-9]))(?=.*\d)\S{8,30}$", ErrorMessage = "Invalid password. Passwords must be between 8 and 30 characters, must contain upper/lower case letters or numbers and special characters (e.g. Fghj$3456)")]
```

## Remotes 
### Validation input on back-end method
```c#
[Remote("IsIPNumberExists", "Camera", ErrorMessage = "There is already a user registered with that IP Number.", AdditionalFields = "Id")]
```

## Object Relational Mapping Data
### Model Attribute that is not mapped into a database column
```c#
[NotMapped]
public int MyProperty { get; set; }
```

# Controller & Repository (cs)

## How To

### Getting Data to Controller from Database through LINQ
_On TableRepository.cs and Interface/ITableRepository.cs (declare the new method) write the public method with the parameter that will receive the value to query the database._
```c#
public Operator GetByRegistrationNumber(string registrationNumber)
{
    return db.Operators.FirstOrDefault(x => x.RegistrationNumber == registrationNumber);
}
```
_So, on the TableController (inside the right action/endpoint) call the new method from TableRepositoryInterface.cs with the parameter._
```c#
Operator operator = operatorRepository.GetByRegistrationNumber(model.RegistrationNumber);
```

### Transfer data information between a View and a Controller
#### Using Request Form Params (HTML and Javascript)
**HTML View**
```cshtml
@Html.Hidden("optionLogin", "")

<input type="submit" value="Log in with LDAP/AD" class="btn btn-lg btn-primary btn-block" onclick="LoginOption(0)" />
<input type="submit" value="Log in with User and Password" class="btn btn-lg btn-primary btn-block" onclick="LoginOption(1)" />


<script type="text/javascript">
    function LoginOption(optionLoginBtn) {
        var opt = optionLogin;

        optionLogin = optionLoginBtn

        $('#optionLogin').val(optionLogin);
    };
</script>
```

**Controller ActionResult**
```c#
 string optLgn = Request.Form["optionLogin"].ToString();
```

#### Using ActionResult method params (HTML and ViewBag)
**Controller ActionResult View:**
```c#
ViewBag.UserId = userId;
```

**HTML View:**
```cshtml
@Html.Hidden("userId", (string) ViewBag.UserId)
```

**Controller ActionResult:**
```c#
public async Task<ActionResult> ResetPassword(string userId, ResetPasswordViewModel model)
```

## LINQ

### Select on SelectList
```c#
string nameSelected = fruitsIdsSelectList.Where(x => x.Tree.Equals(model.Tree)).First().Text.ToString();
```

### Select on Repository Method
e.g.:
```c#
bool persistedOperatorRegistrationNumber = operatorRepository.GetAll().Where(o => o.RegistrationNumber.Trim().ToLower().Equals(op.RegistrationNumber.Trim().ToLower())).Any();
```

### Select on Repository after Repository predefined method.
e.g.:
```c#
IEnumerable<Computer> computers = computerRepository.GetAll();
if (!string.IsNullOrEmpty(searchString))
{
      computers = computers.Where(s => s.Location.ToLower().Contains(searchString.ToLower()));
}
```

### Select with Where, Select and Distinct
e.g.:
```c#
return db.Units.Where(u => u.EnterTime > cutoffDate).Select(u => u.ParentSN).Distinct().ToList();
```

### Select on a LINQ Select list
e.g.:
```c#
var errors = ModelState.Select(x => x.Value.Errors)
                                                    .Where(y => y.Count > 0)
                                                    .ToList().First();
string errorMsg = errors.ElementAt(0).ErrorMessage.ToString();
/* ElementAt(Number of Element) -> It access a list element to get it properties. */
```

### Select and data update on a List
e.g.:
```c#
collection = collection.Select(c => {c.PropertyToSet = value; return c;}).ToList();
```

# Validation Messages

## Messages of ModelState (standard method/controller derived of model (TableViewModel))
e.g.:
```c#
public ActionResult Create(EnergyViewModel model)
{
	ModelState.AddModelError("", "There is already a energy registered with that name.");
}
```

## Getting Error Messages from system ModelState
e.g.:
```c#
var errors = ModelState.Select(x => x.Value.Errors)
                           .Where(y => y.Count > 0)
                           .ToList();
```

# View (cshtml)

## How to

### Comment
e.g.:
```cshtml
@* your code here *@
```

### Iterate elements
Use:
```cshtml
@for
@foreach
```

### Elements from a for within a table
e.g.:
```cshtml
@for (int i = 0; i < Model.Stores.Count; i++)
{
    @Html.HiddenFor(modelItem => Model.Stores[i].ID)
    <tr>                    
        <td>
            <label class="switch">
                @Html.CheckBoxFor(model => model.Stores[i].CameraisRecording)
                <div class="slider round">
                </div>
            </label>
        </td>
        <td>
            @Html.DisplayFor(modelItem => Model.Stores[i].Name)
        </td>
    </tr>
}
```

## Relationship between front and back-end

### HTML link to an action/method on back-end controller
e.g.:
```cshtml
@Html.ActionLink("Back to list", "Index");
/*
1. Your link text
2. Action in the controller
*/
```
**With parameters:**

e.g.:
```cshtml
@Html.ActionLink("Edit", "Edit", new { id = item.Id })
/*
1. Your link text
2. Action in the controller
3. Parameter
*/
```

### HTML Link Handling CSS Style through Controller Action
_Default: 'active css' class._

e.g.:
```cshtml
<li class="@Html.IsSelected(actions: "Buy", controllers: "Products")">
       @Html.ActionLink("Buy", "Buy", "Products")
</li>
```

### Return to HTML Page messages from ModelState
**Page**

e.g.:
```cshtml
@Html.ValidationSummary(true, "", new { @class = "text-danger" })
```

**Field**

e.g.:
```cshtml
@Html.ValidationMessageFor(model => model.Name, "", new { @class = "text-danger" })
```

## HTML

### Adding HTML Attributes for a Field
e.g.: 
```csthml
@Html.EditorFor(model => model.ReplaceOrder, new { htmlAttributes = new { @id = "replace", onclick = "return false", style = "width:40%" } })
```

# Q&A

**When use the ViewModel?** 

When the project have two or more Entities that interact each other. Example: Users that have roles.

**When use ?? Operator?**

Returns the left-hand operand if the operand is not null; otherwiese returns the right hand operand Set y to the value of x if x is NOT null; otherwise, if x == null, set y to -1.

e.g.:
```c#
Int y = x ?? - 1. 
```

**Why ? After data type? (int?, string? public Grade? Grade)**

The question mark indicates that the property is nullable.

**=> Operator**

Using as lambda operator. Lambda expressions: embedded expressions used because are more flexible than anonymous methods. (Generally LINQ queries). => separate input variables (left side of lambda body). Applies the logic (right side) and input the result on the variable before operator (left side).Example: int shortestWordLength = words.Min(w => w.Length);  
//w have a result of this logic.

**The application is return a error about Constructor Parameterless?**

Check if your repository is on AppStart/UnityConfig and UnityConfig is called on Global file.

**Concurrence problem within a database table (Add / Update state conflict) - Update Event**

Add ValidateOnSaveEnabled on the Update method.

e.g.:
```c#
public void Update(Employee op)
{
      db.Configuration.ValidateOnSaveEnabled = false;
      db.Set<Employee>().AddOrUpdate(op);
      db.SaveChanges();
      db.Configuration.ValidateOnSaveEnabled = true;
}
```

