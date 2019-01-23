Help it with Fork and Pull Request!

# Javascript Environment (Set up)

**To use Jquery and Ajax on script directly:**
```javascript
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
```

# Javascript
## Handling Fields and it properties
**Setting a ID**
```javascript
<input type="button" id="myButton">
```
The same approach to: value, class, events, etc. Complete list: https://www.w3schools.com/tags/att_input_type.asp

# jQuery
## Handling Fields and it properties
### Selectors
**Reference a ID's Field**
id. e.g.: 
```javascript
$("#activeCheck")
```
class. e.g.: 
```javascript
$(".activeCheck")
```
html element. e.g.:
```javascript
:button
```
### Values
**Getting Value (input fields) and Text (spam fields)**
e.g.:
```javascript
console.log($("#StoreId").val());
```
OR
```javascript
console.log($("textDoor").text());
console.log($("textPortaria").html());
```

**Setting value on input field**
e.g.:
```javascript
console.log($("#StoreId").val(366));
```

**Using for loop to get 'checked' values on a checkbox list**
e.g.:
```javascript
$('#CustomerId input:checked').each(function(){
    var el = $(this),
    currentValue = el.val();

    doorArray.push(currentValue);
});
```
### Events
**.click**

Event is on when the element is clicked.

e.g.: 
```javascript
$("#activeCheck").click(function () {
	alert("activeCheck clicked");
});
```

**.change()**

Change event determines for Javascript, that something happens on field (So, what the script has to do after button change, will happen).

e.g.: 
```javascript
$('#ClienteId').change();
```

**.bind()**

To handle an event with element
```javascript
$(document).bind('click', function(e){
	var target = $(e.target); 
});
```
_Parameter 1: event type_
_Parameter 2: handler (function that executes each time that event is triggered)._

### Field Properties
**.prop('propertie')** and **.removeAttr('attribute')**

Use to handle some propertie/attribute of a input/output field/element.
e.g.:
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

Handling Javacript variables that received HTML elements.
e.g.:
```javascript
function validateActiveRegister() {
    if ($('#activeCheck').prop('checked')) {
        recordButton.disabled = false;
        playButton.disabled = false;
        downloadButton.disabled = false;
        replaceTraining.prop('disabled', false);
    } else {
        recordButton.disabled = true;
        playButton.disabled = true;
        downloadButton.disabled = true;
        replaceTraining.prop('disabled', true);
        replaceTraining.prop('checked', false);
    }
}

function validateActiveRegisterBool() {
    if ($('#activeCheck').prop('checked')) {
        return true;
    } else {
        return false;
    }
}
```


## jQuery Ajax
Fields
**Getting a value from a AjaxObject (List)**
e.g.:
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

**GET Example**
```javascript
$.ajax({
    type: 'GET',
    url: 'http://localhost:8080/api/v1/phrases/' + numberPhrases,

    success: function(data) {
	alert("Done!");
	$('#resultPhrases').text("200");

	for (var i = 0; i < numberPhrases; i++) {
	    var phraseGetList = data[i].phrase;
	    console.log("Iteraço: " + i + " Frase: " + phraseGetList);
	    $("#phrasesList").append("<p align='center'>" + phraseGetList + "</p>");            
	}
    },
    error: function() {
	$('#resultPhrases').text("There was an error processing your request. Please try again.");
    }
});
```

**Post Example**
```javascript
$.ajax({
    type: 'POST',
Fields    url: 'http://localhost:8080/api/v1/cats',
    data: JSON.stringify(ajaxObj),
    dataType: "json",
    contentType: "application/json;charset=UTF-8",

    success: function(data) {
	alert("Done!");
	$('#result').text("200");
    },
    error: function() {
	$('#result').text("There was an error processing your request. Please try again.");
    }
});
```
