# Language Definitions

## Features

- SEAMLESS JAVA INTEROP

Scala runs on the JVM.

- TYPE INFERENCE

No need to define variable type (use var/val) and the program can infers the result types of the functions automatically.

- CONCURRENCY & DISTRIBUTION

Asynchronous programming: Futures and Promises can process data at same time (data-parallel). Non-blocking programming, the main program thread runs in the meantime.

- TRAITS: FLEXIBLY COMBINE INTERFACE & BEHAVIOR

```scala
Class - Trait (extends from Class) -> Class (extends from Class (with Traits))

class ClassA extends ClassB with TraitA with TraitB
```

- PATTERN MATCHING

Pattern Matching - Switch on the structure of your data
-> Case classes could be used to represent strutural data types (implicity -> toString(), equals() and hashCode()) and could be deconstructed with pattern matching.

- HIGH-ORDER FUNCTIONS

Functions: First-class objects that are value. Compose them type safety and with a concise syntax.

See about: https://www.scala-lang.org/



