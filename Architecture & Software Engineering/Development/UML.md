# Use Case Diagram

## Systems (rectangle)
_e.g.: Website, Software Component, App._

## Actors (dummy)
Someone or something that will use the system. The actors need to be categorical or typed. Not a specific individual or organization. 

_e.g.: Person, organization, another system, external device._

### Types of actors
* Primary - Initiates the use of the system (usually stands in the left of the system)
* Secondary - Reactionary (usually stands in the right of the system)

## Use Cases (shape)
Represents an action or sort of task within the system. Need to start with a verb (action).

_e.g.: Subscribe Site, Input payment method, Choose a car_

## Relationships (lines)
Actors are using the system to achieve a goal.

### Relationship types:
* Association - Basic communication and interaction (solid line)
* Include - Dependency between Base use Case and Included use Case. Base Use Case requires the included to be completed. (dash line towards Included Use Case)
* Extend - When Base Use Case is executed, Extend Use Case could be executed sometimes (with some criteria). (dash line towards Base Use Case)
* Generalization or Inheritance - Specialized Use Cases (Children) with common behavior up to General use Case (Parent) (arrow line).

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Architecture%20&%20&Software%20Engineering/Development/uml-use-case-diagram-example-01.png)
_Example taken from Lucidchart Video (https://youtu.be/zid-MVo7M-E)_