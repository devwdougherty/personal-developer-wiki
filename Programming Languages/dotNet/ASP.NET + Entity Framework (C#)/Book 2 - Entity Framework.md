Help it with Fork and Pull Request!

# About Entity Framework

## Entity Set and Entity
In Entity Framework terminology, an entity set typically corresponds to a database table, and an entity corresponds to a row in the table.

## About ActionsResult
In ASP.NET MVC Entitty Framework, at patterns ActionsResults with DataBase (like Create, Update, Delete, etc) in CONTROLLER:
Has two instances of Action Result. The first refers to: Loading features/connections to VIEW(cshtml). The second refers to: Loading features/connections to MODEL.

## Problem with Culture (Envolving dots and commas)
Add in WebConfig <system.web> Section: 
```xml
<globalization uiCulture="en-US" culture="en-US" />
```

## About WebConfig
To get some web.config variable:
```c#
ConfigurationManager.AppSettings["variable.name"];
```

# About Database Operation

## Setting all the entities in the context
```c#
public DbSet<Student> Students { get; set; }
```
_DbSet is used when the type of entity is not known at build time._

# About Develop Flow

## Developing a new Feature (Model, View, Controller)
1. ViewModel
  Edit/add your class/feature in ViewModel (Model Folder)
  First at: UserViewModel class (IN CASE OF INSERT FEATURE), EditUserViewModel class (IN CASE OF UPDATE FEATURE), LoginViewModel class 	(IN CASE OF EDIT LOGIN)
  Secont at: RecoveryPasswordViewModel class (your class)
2. Model
  Edit/add the class inside Model Folder (exactly the same of a part in ViewModel).
3. View
  Edit/add a HTML page inside View Page.
4. Index
  Edit the Page to contemplate the new feature
4. Controller
  First: Add a Standard ActionResult as "Create", "Edit". Which should I Use/edit?
  Second: Add/edit the ActionResult Feature and ActionResultViewModel
	
## Developing a new Feature (Model, View, Controller) with New Table
You new feature will interact directly with another? (Example: Users have Roles, Operators have Functions)
**IF YES:** Start on ViewModel.cs

**IF NO:** Create a new Table-EntityMode

**Step 1:**
On Model Page:
	• Build a public class
	• Set the fields with itself properties
	• Set the constructor of class
	• Set a constructor with the same variable sin parameter to initialize the var that have been set
	• Set a public class: 'Table-EntityViewModel'

**Step 2:**
On Table-EntityRepository.cs
	• ... TODO

**Step 3:**
On DBContext.cs: (In case your Table-Entity is a complete MVC, not just to assist another Table-Entity).
	• On the public interface Context class: Declare the DbSet of your new Entity-Table with get/set.
	• On the public Context class: Declare the DbSet of your new Entity-Table with get/set.
	• If you Table-Entity have a Unique Key (in addition ID), set IsUnique(true) property on modelBuilder.Entity in OnModelCreating method

Step 4:
On DBInitializer.cs:
	• ... T0D0

# About Field Validation
TODO

## Record already exists validation (REMOTE, JSON, MODEL AND CONTROLLER)
TODO

# About Security
TODO

## Password Recovery
TODO

## Change Password
TODO

# About Database Relations
TODO

## Killing repositories after use to doesn't crash the SQL Server.
TODO

## About Model relationship with Database on Add/Update application page
TODO

## About Scaffolding

### About Scaffolding Bugs at VS

• You must drop your database before scaffolding.
• At your ProjectClassDatabaseInitializer (Generally on Services Folder) change the Initializer Method to: DropCreateDatabaseAlways
• If your database is not initializing with your application and it is triggering error on scaffolding do that: At Global class of your project, instantiate your ContextClass:
```c#
try { var db = new ClassContext() } catch (Exception ex) { Console.Out.WriteLine (ex.Message) }
```

### Doing a Scaffolding

Step 1: Create your model
Step 2: At VS Project -> Add a new scaffolder item
Step 3: Choose 'MVC 5 Controller with views, using Entity Framework'
Step 4: Select the model
Step 5: Select the context
Step 6: Select the standard layout (Generally at Shared Folder)
Step 7: Rename the name to: YourEntityController

### Hiding a Field of Scaffold

At class properties, add that attribute:
```c#
[ScaffoldColumn(false)] 
```
or
```c#
[Display(AutoGenerateField=false)]
```





