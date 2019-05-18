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

### Methods, Functions and Format
#### Basic Complexity
**split():** Split a string into a list where each word is a list item.

#### Medium Complexity
**encode()**: Encode the string with pattern UTF-8 python.

**hexdigest()**: From hashlib library, turns the string to a string with only hexadecimal values.

#### Small Complexity

**.replace("w", "d")**

**stringWord[n], stringWord[-n], stringWord[n:], stringWord[:n], stringWord[n:n], stringWord * n**

**Python 3 String formatting**
```python
test = "Willian"
print(f"hello his name is {test}")**

print('This is my ten-character, two-decimal number:%10.2f' %13.579)
print('This is my ten-character, two-decimal number:{0:10.2f}'.format(13.579))

print('This is my ten-character, two-decimal number:%.2f' %13.579)

num = 23.45678
print(f"My 10 character, four decimal number is:{num:{10}.{6}}")

my_string = "Dougherty"
my_string += " Do Nascimento Barbosa"
```

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

# Libs
## Strings
* [Textwrap](https://docs.python.org/2/library/textwrap.html)

# Q&A
**Python Flask Framework - Why I would need?** Easily map endpoints to Python functions.
