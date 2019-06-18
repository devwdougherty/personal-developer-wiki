Help it with Fork and Pull Request!

# MODEL

To use **[Remote]**
```c#
using System.Web.Mvc;
```

# CONTROLLER

To use **MethodBase**
```c#
using System.Reflection;
```
e.g.:
```c#
private static readonly ILog log = LogManager.GetLogger(MethodBase.GetCurrentMethod().DeclaringType);
```
