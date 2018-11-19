Help it with Fork and Pull Request!

# Common

## jQuery
### Basic IF
```javascript
If ($('#some_field').prop('checked') {
		Alert("something");
	} else {
	    Alert("else");
}
```

### To show complete Object/Variable properties
```javascript
console.log($(ajaxObj));
```

### JSON to String
_Jquery.stringify()_
```javascript
JSON.stringify(javascriptObject)
```

### Ajax
#### To setup every Ajax requisiton on the file to allow Cross Domain and Credentials
```javascript
$.ajaxSetup({
      //dataSrc: '',
      crossDomain: true,
      xhrFields: {
      withCredentials: true
      }
});
```

