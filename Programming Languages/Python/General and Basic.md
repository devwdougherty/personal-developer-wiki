Help it with Fork and Pull Request!

# Files

#### Open a file and handle it as of a variable
```python
with open('myfile.txt') as my_new_file:
	contents = my_new_file.read()
```

# Basic Data Type
## Integer
**Integer division**
e.g.:
```python
 a = int(input()) # 4
 b = int(input()) # 3

 print(a//b)
```

## String
**encode()**: Encode the string with pattern UTF-8 python.

**hexdigest()**: From hashlib library, turns the string to a string with only hexadecimal values.

# Functions
Arbitrary number of arguments:
e.g.:
```python
# * args -> tuple
# ** kwargs -> dictionary

def myDoughertyFunction(*args, **kwargs):
	print("blablabla")

myDoughertyFunction(1,5,8,9,first_name='Willian',second_name='Dougherty')
```

# Q&A
**Python Flask Framework - Why I would need?** Easily map endpoints to Python functions.
