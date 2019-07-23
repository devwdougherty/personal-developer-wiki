# Book 3 - Programming (Model, Repository, Service, Controller, View)

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
