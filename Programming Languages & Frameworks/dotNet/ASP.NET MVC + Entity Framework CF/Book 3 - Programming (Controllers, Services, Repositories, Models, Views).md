# Book 3 - Programming (Model, Repository, Service, Controller, View)


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
```c#
var errors = ModelState.Select(x => x.Value.Errors)
                                                    .Where(y => y.Count > 0)
                                                    .ToList().First();
string errorMsg = errors.ElementAt(0).ErrorMessage.ToString();
/* ElementAt(Number of Element) -> It access a list element to get it properties. */
```

### Select and data update on a List
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
