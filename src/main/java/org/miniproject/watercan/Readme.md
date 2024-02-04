## Inventory Management Console Based Application using Java

Inventory Management System is one of the most famous mini project which is asked to create from a new programming language learner.
The inventory can be of any type, like Tea Shop, Water Can, Flower, Bank, etc. This program is nothing but a type of bookkeeping program 
, which can be used to keep track of inventory items and sells. 

We cannot learn any programming languages without proper practice. Now practice can be of two types also, one is practicing the concepts one by one as we
read. This is a good practice but in real projects the challenge will come when we have to implement one concept with another
concept and also keeping in mind that it should affect already written codes and other functionalities. That is why the 
other way to practice is to create mini projects. While creating these projects we will face many such problems which I 
mentioned before but since it will a small project then it will be easy to grasp those concepts. Hence, the motive behind practicing creating any
inventory management application is to solidify the core concepts of Core Java.

Now the question arises that what are the concepts you need to know in order to create your own inventory management application:
- Object-Oriented Programming(OOP)
  - Abstraction
  - Inheritance
  - Abstraction
  - Polymorphism
- Classes and Objects
- Interfaces
- Exception Handling

So, if you already have learned all these concepts then for a POC, you can go ahead with creating your own inventory
management application.

Now to get started with the project there are 3 main steps.
- Requirement Gathering
- Class Diagram
- Code

### Requirement Gathering
Requirement Gathering is the most important step here. The reason is all your code and project design will depend on how
have you understood the project requirement. Now in most cases, a set of requirements will be given to you, in that case you can go ahead
with creating the class diagram for it. But in few cases, if the same is not provided then you will have to paint a picture in 
your mind, covering the core functionalities and flow of the program.
For example, in Water Can Inventory Management, you can either think from a perspective of customer or owner. Let's think from an Owner's
perspective. 
- Water Can inventory will have an Owner.
- In inventory there will be types of Water Cans like 1 litre, 5 litre, 10 litre and 25 litre.
- An owner can either sell or stock new water cans.

Now this is very small perspective of how Water Can Inventory should work. But depending on the size of the project which you
want to create, you can add new functionalities to the requirement.

### Class Diagram
Once you have gathered all the requirements, then comes the steps to design your classes to cater the requirements.
In this step you will come up with the Class name and the relationships between 2 classes.
There are 2 simple tricks to come up with Classes for a project.
1. **Visualization:** What I mean by visualization is again of how an Inventory Management System works, then create Classes for those who you think 
could be an entity.
2. **Nouns from the requirement:** Select all the nouns from the requirement list.

### Code
This is the most fun part of all the process, Code. If you have correctly understood the requirements and 
have created the Classes and their relationship, the coding part becomes easy. First you need to make sure,
you have an IDE (Intellij, Eclipse) and JDK installed on your system. Now go ahead with creating your project.
In Java, there isn't a strict naming convention specifically for project names, but it's generally recommended to
follow some conventions to maintain consistency and readability across projects.
- **Use Meaningful Names:** Choose a name that reflects the purpose of the project.
- **lowercase-with-hyphens:** Use lower case letters and put hyphens instead of space with 2 words.
- **Avoid special character:** Stick to alphanumeric and avoid using special characters.

Now that you have created your project, lets go ahead with how we should create the Package and Classes and Methods.
For package name, the above 3 conventions is recommended, for Classes and Methods, we can avoid the "lowercase-with-hyphens"
conventions. The other conventions are :
- **Classes names should always start with UpperCase**
- **Method names should be in camelCasing**
- **Enums and Static Final Variables should be UPPERCASE_WITH_UNDERSCORE**

While creating the functions for the project, always make sure to follow **DRY Principle**.
DRY principle has a simple meaning Don't Repeat Yourself, it basically means if you are writing same code logic with few tweaks like
different variable names or return type across the projects, then consider creating a single method for it and use it 
wherever it is required. This not only improves the readability of the code, but also provides re-usability and saves time.

The other aspect which is often ignored while creating the simple console based application is handling the exceptions. 
A good code is something which works well in normal usage as well as can handle the exceptions gracefully and not break in
between the operations. So while creating the methods and writing the logic always consider how it should behave in case of 
unfavourable inputs and corner cases. Also consider in those unfavourable cases, how you will let the client know that what 
went wrong. 

Another aspect which we can consider is that the program should not exit after one or two operation. This is not a very important
aspect, but it improves the user experience. Think from a perspective of user, how would you like, if an application always quits
after one operation. So, give user the power to quit the application.
