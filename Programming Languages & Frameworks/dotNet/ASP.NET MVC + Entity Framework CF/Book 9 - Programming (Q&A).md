Help it with Fork and Pull Request!

# Q & A

## General 
```c#
public virtual ICollection<Enrollment> Enrollments { get; set; }
```
**Q:** Virtual?

**A:**


```c#
public SchoolContext() : base("SchoolContext")
```
**Q:** Inheritance with base?

**A:**


```c#
protected override void OnModelCreating(DbModelBuilder modelBuilder)
```
**Q:** Protected override void?

**A:**



## OPERATORS
**Q:** ?? Operator
```c#
Int y = x ?? - 1. 
```
**A:** Returns the left-hand operand if the operand is not null; otherwiese returns the right hand operand
Set y to the value of x if x is NOT null; otherwise, if x == null, set y to -1.

Int? string?

**Q:** Why ? After data type?

**A:** The question mark indicates that the property is nullable.


public Grade? Grade { get; set; }

**Q:** ? After a enum in declaration?

**A:** The question mark after the Grade type declaration indicates that the Grade property is nullable. About nullable: https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/nullable-types/using-nullable-types


**Q:** => Operator

**A:**: Using as lambda operator. Lambda expressions: embedded expressions used because are more flexible than anonymous methods. (Generally LINQ queries). => separate input variables (left side of lambda body). Applies the logic (right side) and input the result on the variable before operator (left side).Example: int shortestWordLength = words.Min(w => w.Length);  //w have a result of this logic.


## PROGRAM RUNNING
**Q:** The application is return a error about Constructor Parameterless?

**A:** Check if your repository is on AppStart/UnityConfig and UnityConfig is called on Global file.


## DATABASE
**Q:** Concurrence Problem within a database table (Add / Update state conflict) - Update Event

**A:** Add ValidateOnSaveEnabled on the Update method.Example: 

```c#
public void Update(Operator op)
{
      db.Configuration.ValidateOnSaveEnabled = false;
      db.Set<Operator>().AddOrUpdate(op);
      db.SaveChanges();
      db.Configuration.ValidateOnSaveEnabled = true;
}
```
