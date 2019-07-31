# Book 1 - Javascript Programming

## Javascript DOM HTML

## Handling Fields and it properties
**Setting a ID**
```javascript
<input type="button" id="myButton">
```
_The same approach to: value, class, events, etc. Complete list: https://www.w3schools.com/tags/att_input_type.asp_

### Input text
**Change value:**
```html
<!DOCTYPE html>
<html>
<body>

<form>
  <div id="will">
    <div>
      <div>
      	  Names: <input type="text" id="myText" value="Willian">
      </div>
    </div>
  </div>
</form>

<button onclick="myFunction()">Try it</button>

<script>
function myFunction() { 
  document.getElementById("myText").value = 'Barbosa';
}
</script>

</body>
</html>

```

### Paragraph
**Change value:**
```html
<!DOCTYPE html>
<html>
<body>

<form>
  <div id="will">
    <div>
      <div>
          <p id='myTest'>Olá</p>
      </div>
    </div>
  </div>
</form>

<button onclick="myFunction()">Try it</button>

<script>
function myFunction() { 
  document.getElementById('myTest').innerHTML = 'Dougherty';
}
</script>

</body>
</html>
```

## Manipulate URL and Event Page
**Reload page:**
```javascript
location.reload()
```
