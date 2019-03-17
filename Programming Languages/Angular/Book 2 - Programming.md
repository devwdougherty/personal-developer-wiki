

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

# How To

## How to configure the local of your application properties
_Portuguese_

At your **app.module.ts**:
```typescript
/* Local configuration */
import { LOCALE_ID } from '@angular/core';
import localePt from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';

registerLocaleData(localePt);

providers: [
    {
      provide : LOCALE_ID, useValue: 'pt'
    }
  ],
```
At your **page.html**: (Date and Value examples)
```html
<td class="col-data">{{ venda.dataCadastro | date: 'dd/MM/yyyy' }}</td>
<td class="col-numero">{{ venda.valorTotal | number: '1.2-2' }}</td>
```
# Q & A
**Need Currency Mask?**: Install -> npm install ng2-currency-mask --save
