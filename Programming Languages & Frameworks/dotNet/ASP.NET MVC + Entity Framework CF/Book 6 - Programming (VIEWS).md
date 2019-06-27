Help it with Fork and Pull Request!

**VIEW (cshtml)**

# Comments
```c#
@* here *@
```

# @Html.ActionLink - ACTION/FEATURE/FUNCTION
## Common
e.g.:
```c#
@Html.ActionLink("Home", "Index", "Home")
```
1. Display Name
2. Views/CSHtml Name of MVC Object/Class
3. Folder Name of Views/CSHtml

## Calling HTML.ACTIONLINK with PARAMETER to ACTION.
e.g.:
```c#
@Html.ActionLink("Change Password", "ChangePassword", "User", new { id = User.Identity.GetUserId() }, null))
```
1. Display Name
2. Views/CSHtml Name of MVC Object/Class
3. Folder Name of Views/CSHtml
4. Parameter (accordingly to Action Function) -> new { param (The same name of Action parameter on Controller) . Entity . Identity (ASP.NET -> identifies the Table (as entities)) . Standard Get Funcion with related field

# @Html.IsSeleccted - CLICK EVENT
## Common
e.g.:
```c#
<li class="@Html.IsSelected(actions: "Index,Details,Create,Edit,Delete", controllers: "Workstation")">
```
1. Inside Controller, which Actions are in that will be used?
2. Controller that has the actions.

# @Html.ValidationSummary - DISPLAY GENERAL/ALL MESSAGES FILLED ON FORM
## Common
Example: @Html.ValidationSummary(true, "", new { @class = "text-danger" })

# Adding HTML Attributes for a Field
e.g.: 
```c#
@Html.EditorFor(model => model.ReplaceTraining, new { htmlAttributes = new { @id = "replace" } })
```

# For on table records to display
e.g.:
```c#
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

