# Book 1 - Javascript

## Javascript DOM HTML

### Input text
*Change value:*
```html/javascript
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
*Change value:*
```html/javascript
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
