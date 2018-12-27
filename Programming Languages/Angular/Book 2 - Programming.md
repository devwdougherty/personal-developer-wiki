

# Data Structure

## FormGroup

**Import**
```typescript
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
```

**HTML Declaration**
<form [formGroup]="newAssetForm" role="form">
</form>

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
