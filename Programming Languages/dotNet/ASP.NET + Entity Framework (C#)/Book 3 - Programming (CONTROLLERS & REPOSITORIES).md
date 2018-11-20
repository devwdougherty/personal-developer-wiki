Help it with Fork and Pull Request!

# Getting Data of Table to Validation or Display

## With Repository and ActionResult

On TableRepository.cs and Interface/ITableRepository.cs (declare the new method) write the public method with the parameter that will receive the value to query database.
e.g.:
```c#
public Operator GetRegistrationNumber(string registrationNumber)
{
    return db.Operators.FirstOrDefault(x => x.RegistrationNumber == registrationNumber);
}
```

On TableController.cs / Action (With the right ViewModel) call the new method that was write on the TableRepository.cs (with the right parameter).
e.g.:
```c#
Operator registrationNumber = repository.GetRegistrationNumber(model.RegistrationNumber);
```

## LINQ

### Select on SelectList
e.g.:
```c#
string nameSelected = vsomIdsSelectList.Where(x => x.Value.Equals(model.VsomId)).First().Text.ToString();
```

### Select on Repository Method
e.g.:
```c#
bool persistedOperatorRegistrationNumber = operatorRepository.GetAll().Where(o => o.RegistrationNumber.Trim().ToLower().Equals(op.RegistrationNumber.Trim().ToLower())).Any();
```

### Select on Repository after Repository predefined method.
e.g.:
```c#
IEnumerable<Camera> cameras = repository.GetAll();
if (!string.IsNullOrEmpty(searchString))
{
      cameras = cameras.Where(s => s.Location.ToLower().Contains(searchString.ToLower()));
}
```
### LINQ Select with Where, Select and Distinct
e.g.:
```c#
return db.Units.Where(u => u.EnterTime > cutoffDate).Select(u => u.ParentSN).Distinct().ToList();
```

### Select on a LINQ SELECT ToList()
```c#
var errors = ModelState.Select(x => x.Value.Errors)
                                                     .Where(y => y.Count > 0)
                                                     .ToList().First();
string errorMsg = errors.ElementAt(0).ErrorMessage.ToString();
//ElementAt(Number of Element) -> It acess a list element to get it properties
```

# Error Messages

## Messages of ModelState (standard method/controller derived of model (TableViewModel))
e.g.:
```c#
public ActionResult Create(OperatorViewModel model)
ModelState.AddModelError("", "There is already a user registered with that registration number.");
```

## Getting Error Messages of ModelState
```c#
var errors = ModelState.Select(x => x.Value.Errors)
                           .Where(y => y.Count > 0)
                           .ToList();
```
