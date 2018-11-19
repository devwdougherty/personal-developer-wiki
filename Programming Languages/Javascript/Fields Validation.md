Help it with Fork and Pull Request!

# Javascript Environment (Set up)

**To use Jquery and Ajax on script directly:**
```javascript
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
```

## Javascript
### Handling Fields and it properties
**Setting a ID**
```javascript
<input type="button" id="myButton">
```
The same approach to: value, class, events, etc. Complete list: https://www.w3schools.com/tags/att_input_type.asp

## jQuery
### Handling Fields and it properties
#### Selectors
**Reference a ID's Field**
id. Ex: 
```javascript
$("#activeCheck")
```
class. Ex: 
```javascript
$(".activeCheck")
```
html element. Ex:
```javascript
:button
```
#### Values
**Getting Value (input fields) and Text (spam fields)**
Ex:
```javascript
console.log($("#StoreId").val());
```
OR
```javascript
console.log($("textDoor").text());
console.log($("textPortaria").html());
```

**Setting value on input field**
Ex:
```javascript
console.log($("#StoreId").val(366));
```

**Using for loop to get 'checked' values on a checkbox list**
Ex:
```javascript
$('#CustomerId input:checked').each(function(){
    var el = $(this),
    currentValue = el.val();

    doorArray.push(currentValue);
});
```
#### Events
**.click**
_Event is on when the element is clicked._
Ex: 
```javascript
$("#activeCheck").click(function () {
	alert("activeCheck clicked");
});
```

**.change()**
Change event determines for Javascript, that something happens on field (So, what the script has to do after button change, will happen).
Ex: 
```javascript
$('#ClienteId').change();
```

#### Field Properties
**.prop('propertie')** and **.removeAttr('attribute')**
Use to handle some propertie/attribute of a input/output field/element.
Ex:
```javascript
$("#activeCheck").click(function () {
    if ($('#activeCheck').prop('checked')) {
        $("#record").removeAttr('disabled');
        $("#play").removeAttr('disabled');
        $("#download").removeAttr('disabled');
        $("#replace").removeAttr('disabled');
        alert("checked");
    } else {
        $("#record").attr('disabled', 'disabled');
        $("#play").attr('disabled', 'disabled');
        $("#download").attr('disabled', 'disabled');
        $("#replace").attr('disabled', 'disabled');
        alert("no checked");
    }
});
```

### jQuery Ajax

**Getting a value from a AjaxObject (List)**
Ex:
```javascript
$("#btnGetPhrases").click(function() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/v1/phrases/1',

        success: function(data) {
            alert("Done!");
            $('#resultPhrases').text("Done!");

            var phraseGetList = data[0].phrase;

            console.log(phraseGetList);        
        },
        error: function() {
            $('#resultPhrases').text("There was an error processing your request. Please try again.");
        }
    });
});
```

