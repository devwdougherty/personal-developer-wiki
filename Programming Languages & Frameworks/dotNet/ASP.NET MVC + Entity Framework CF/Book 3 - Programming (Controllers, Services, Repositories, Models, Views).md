# Book 3 - Programming (Controllers, Services, Repositories, Models, Views)

# View (cshtml)

## How to

### Comment
e.g.:
```c#
@* your code here *@
```

## Relationship between front and back-end

### HTML link to an action/method on back-end controller
e.g.:
```c#
@Html.ActionLink("Back to list", "Index");
/*
1. Your link text
2. Action in the controller
*/
```
**With parameters:**
e.g.:
```c#
@Html.ActionLink("Edit", "Edit", new { id = item.Id })
/*
1. Your link text
2. Action in the controller
3. Parameter
*/
```
