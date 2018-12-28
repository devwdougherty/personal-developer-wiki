

# Data Structure

## FormGroup

**Import**
```typescript
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
```

**HTML Declaration**
```html
<form [formGroup]="newCustomerForm" role="form">
</form>
```

**In typescript class:**
```typescript
newCustomerForm: FormGroup;
```

**Get values**
```typescript
this.customerFormData.id = this.newCustomerForm.getRawValue().id;
```

**Set values**

_All FormGroup values_
```typescript
this.myFormGroup.setValue({
  formControlName1: myValue1, 
  formControlName2: myValue2
});
```
_Some FormGroup values_
```typescript
this.myFormGroup.patchValue({
  formControlName1: myValue1, 
  // formControlName2: myValue2 (can be omitted)
});
```
# Field Validation

## Regex Expression
e.g:
```typescript
var regexp = new RegExp('^\d{6}-\d{2}-\d{6}-\d{1}$');

if (!regexp.test(yourField)) {
  console.log("Error!");
}
```

