In this tutorial, we will learn about how to use Hibernate Many-To-Many Bidirectional mapping using annotation based configuration.

In Many-To-Many association, an extra table is used (known as Joined table) whose primary key is the combination of primary key of both the associated tables.In other words there is a foreign key association between the joined table and the associated tables.

A many-to-many association always uses an intermediate join table to store the association that joins two entities. The join table is defined using the @JoinTable JPA annotation.

The many-to-many association can be either unidirectional or bidirectional.

 In unidirectional association, only source entity has a relationship field that refers to the target entities. We can navigate this type of association from one side.

In bidirectional association, each entity (i.e. source and target) has a relationship field that refers to each other. We can navigate this type of association from both sides.
###################################################################################
###################################################################################
###################################################################################
Lets's get our hands Dirty :)
##First Example
 Student can enroll for multiple Subject. And a subject can have multiple students enrolled for it. We are considering Bidirectional mapping, means both side navigation is possible.

##Second Example
Consider the following domain model and relational model diagrams of many-to-many directional association.
An Employee can have any number of Addresses and an Address can belong to any number of Employees.


 Following technologies being used:

***Hibernate 4.3.5.Final
***MySQL Server 6.0.6
***Maven 3.1.1
***JDK 1.8
##
 JDK 1.8.0_121 | Hibernate 5.2.6.Final | Maven 3.3.9 | MySQL 5.7.12 | Eclipse Neon.3
##

Step 1: Create project directory structure
Step 2: Update pom.xml to include required Hibernate and MySQL dependency
Step 3: Create Model classes
Step 4: Create Hibernate configuration file
Step 5: Create Hibernate Utility class
Step 6: Create executable class to Run and perform operations on Database