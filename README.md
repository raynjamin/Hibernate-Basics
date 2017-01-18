## Fork [this](https://github.com/raynjamin/Hibernate-Basics) repo

![screenshot](http://i.imgur.com/zXqdsXK.gif)

## Description

Use Hibernate to store microblog messages in PostgreSQL. Add editing functionality as well.

## Requirements

* In PostgreSQL, create a database for a "MicroblogSpring" project, called `microblog`
* Add the necessary lines to `application.properties`
* Create the `Message` class, mark it as a Hibernate entity and make it stores an `int id` with the proper annotations so it is treated as an id and is automatically generated
* Create an interface that extends `CrudRepository<Message, Integer>`
* In your controller, add the repository with `@Autowired` and use it instead of the `ArrayList<Message>`
* Add a way to edit messages and use the repository to update the object

## HARD MODE
* Create an additional "User" entity
* Make messages belong to individual users.
* Disallow a user from editing a message that does not belong to them.
