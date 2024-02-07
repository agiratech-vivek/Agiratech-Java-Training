# Inventory Management Console Based Application using Java

An Inventory Management System is a quintessential mini-project for new learners of any programming language. The inventory can pertain to various types, such as a Tea Shop, Water Can, Flower Shop, Bank, etc. Essentially, it's a form of bookkeeping program used to track inventory items and sales.

Learning any programming language involves proper practice. While practicing individual concepts sequentially is beneficial, real-world projects present challenges that require integrating multiple concepts seamlessly without disrupting existing code. Thus, creating mini-projects becomes the most effective way to practice and solidify core Java concepts.

To embark on creating your own inventory management application, it's essential to grasp the following core concepts:
### Pre-requisite
- **Object-Oriented Programming(OOP)**
  - Abstraction
  - Inheritance
  - Abstraction
  - Polymorphism
- **Classes and Objects**
- **Interfaces**
- **Exception Handling**

Once you have learned all these concepts then you are ready to proceed with your Proof Of Concept(POC) project

Now to get started with the project there are 3 main steps.
- **Requirement Gathering**
- **Class Diagram**
- **Code**

### Requirement Gathering
Requirement Gathering is the most important step here. The reason is all your code and project design will depend on how
have you understood the project requirement. Now in most cases, a set of requirements will be given to you, in that case you can go ahead
with creating the class diagram for it. But in few cases, if the same is not provided then you will have to paint a picture in 
your mind, covering the core functionalities and flow of the program.
For example, in Water Can Inventory Management, you can either think from a perspective of customer or owner. Let's think from an Owner's
perspective. 
- **WaterCan** inventory will have an **Owner**.
- In inventory there will be different **types of Water Cans like 1 litre, 5 litre, 10 litre and 25 litre**.
- An owner can either **sell** or **stock** new water cans.

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

### Code Snippet

We have our Owner Class here which will have a name, an address, phone number and **Water Can**, in which there is a HAS-A relationship between
Owner and Water Can. That's why there is a dependency in the Owner Class on Water Can.
Now while creating an object of Owner Class we need some validation to be there so that, no wrong or buggy data is put into the system.
So we can have some validation in the constructor which will not let the program create the object if that validation does not pass.

    public class Owner {
      private String name;
      private String address;
      private String phoneNumber;
      private WaterCan waterCanList;
  
      public Owner(String name, String address, String phoneNumber) throws InvalidOwnerException {
          if(name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()){
              throw new InvalidOwnerException("Please provide all owner details");
          }
          if(name.contains("@")){
              throw new InvalidOwnerException("Name should not contain any special characters");
          } else if (address.length() > 50){
              throw new InvalidOwnerException("Address provided is too long, Kindly mention address in 50 characters");
          } else if(phoneNumber.length() != 10){
              throw new InvalidOwnerException("Phone number incorrect, it should contain 10 digits");
          }
          this.name = name;
          this.address = address;
          this.phoneNumber = phoneNumber;
          this.waterCanList = new WaterCan();
    }

Now since in the inventory management, we have to do specific type of operation like add and remove (stock and sale in case of water can management).
We can add the methods of the same in the Owner Class as Owner has the right to either Stock or Sell. We can do the same by creating another Interface called 
Service and create a OwnerServiceImplementation Class to implement the interface. That will ensure that the code is a loose coupling.
Though here for a simple mini project, having the operation in the class itself is fine enough. But, while creating the logic for add and remove, we should also
think about how we will handle the exception.

Here in the first code snippet, I am handling the exception by throwing it to the caller function. So whichever method will be calling this
function, will have to handle the exception. The exception logic is simple here, I am just checking if I am trying to add negative values to the water can
then it should throw an exception.

    public void stockWaterCan(WaterCan waterCan) throws RuntimeException{
    if (this.name.isEmpty() && this.address.isEmpty() && this.phoneNumber.isEmpty()) {
    throw new RuntimeException("Kindly add the owner first");
    }
    if (waterCan.getOneLitre() < 0
    || waterCan.getFiveLitre() < 0
    || waterCan.getTenLitre() < 0
    || waterCan.getTwentyFiveLitre() < 0)
    {
    throw new RuntimeException("Kindly provide correct water-can details to continue");
    }
    waterCanList.setOneLitre(waterCanList.getOneLitre() + waterCan.getOneLitre());
    waterCanList.setFiveLitre(waterCanList.getFiveLitre() + waterCan.getFiveLitre());
    waterCanList.setTenLitre(waterCanList.getTenLitre() + waterCan.getTenLitre());
    waterCanList.setTwentyFiveLitre(waterCanList.getTwentyFiveLitre() + waterCan.getTwentyFiveLitre());
    System.out.println();
    System.out.println("Water-cans inventory has been updated");
    System.out.println(waterCanList.toString());
    System.out.println();
    }

In the second code snippet, I am selling the water can, unlike the first code, where I am throwing the exception and asking the caller function
to handle it, here I am handling the exception on my own using try, catch block. So, this is another way to handle the exception gracefully.
The condition here I am checking is the owner should not be able to sell more water cans than what is there in the stock.

    public void sellWaterCan(WaterCan waterCan) {
        try {
            if (
                    waterCan.getOneLitre() > waterCanList.getOneLitre()
                            || waterCan.getFiveLitre() > waterCanList.getFiveLitre()
                            || waterCan.getTenLitre() > waterCanList.getTenLitre()
                            || waterCan.getTwentyFiveLitre() > waterCanList.getTwentyFiveLitre()
            ) {
                throw new RuntimeException("Cannot sell! You can sell units upto the inventory size of respective water-cans");
            }
            waterCanList.setOneLitre(waterCanList.getOneLitre() - waterCan.getOneLitre());
            waterCanList.setFiveLitre(waterCanList.getFiveLitre() - waterCan.getFiveLitre());
            waterCanList.setTenLitre(waterCanList.getTenLitre() - waterCan.getTenLitre());
            waterCanList.setTwentyFiveLitre(waterCanList.getTwentyFiveLitre() - waterCan.getTwentyFiveLitre());
            System.out.println();
            System.out.println("Water-cans inventory has been updated");
            System.out.println(waterCanList.toString());
            System.out.println();
        } catch (RuntimeException runtimeException) {
            System.err.println(runtimeException.getMessage());
        }
    }

We saw that the owner class is having a dependency on Water Can. So lets see how the Water Can class looks like.

    public class WaterCan {
    private int oneLitre;
    private int fiveLitre;
    private int tenLitre;
    private int twentyFiveLitre;

    public WaterCan() {
    }

    public WaterCan(int oneLitre, int fiveLitre, int tenLitre, int twentyFiveLitre) {
        this.oneLitre = oneLitre;
        this.fiveLitre = fiveLitre;
        this.tenLitre = tenLitre;
        this.twentyFiveLitre = twentyFiveLitre;
    }

So, apart from having all the boilerplate codes, we have these two methods, toString() and totalWaterCans(). The toString() method 
is just returning a string with the count of all the water cans individually. totalWaterCans() method is just returning overall count
of the total water cans.

    public String toString() {
    return "Water-Can Stock: " +
    "\n1 Litre Bottle: " + oneLitre +
    "\n5 Litre Can: " + fiveLitre +
    "\n10 Litre Can: " + tenLitre +
    "\n25 Litre Can: " + twentyFiveLitre;
    }

    public int totalWaterCans(){
        return oneLitre + fiveLitre + tenLitre + twentyFiveLitre;
    }

Now let's have a look on the WaterCanRunner which will act as the controller or from where will run our program. One of the good practice
we discussed was that the code should not exist, the user should have the control over quiting the application. Hence, we have 2 nested 
while loops here for that purpose only. The first while loop is acting like a main menu here from where user will have to enter his details,
like name, address and phone number and also provide the number of stocks to stock the water can.
The second while loop will handle the operation, stock and sell.

    public class WaterCanRunner {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while(true) {
        try {
            System.out.println("Welcome to Water-can inventory, Please provide new owner details");
            System.out.println("Please provide owner name, address and phone number separated by a comma");
            Owner owner = createNewOwner(scanner);
            if(owner == null){
                System.out.println("Please provide correct details for owner");
                System.out.println();
            continue;
        }
    while(true) {
    System.out.println("You have " + owner.getWaterCanList().totalWaterCans() + " water-cans.");
    System.out.println("Enter 1: Show inventory\nEnter 2: Stock Water Cans\nEnter 3: Sell Water Cans\nEnter 4: Exit to main menu");
    byte option = scanner.nextByte();
    scanner.nextLine();
    try {
    if (option == 1){
    System.out.println(owner.getWaterCanList().toString());
    } else if (option == 2) {
    stockWaterCan(scanner, owner);
    } else if (option == 3) {
    sellWaterCan(scanner, owner);
    } else if (option == 4) {
    break;
    } else {
    throw new IncorrectInputException("You have selected wrong option: " + option);
    }
    } catch (Exception exception){
    System.err.println(exception.getMessage());
    System.out.println("Please enter correct option to continue");
    }
    }
    System.out.println("Press 1 to continue\nPress 2 to exit this app");
    byte mainMenuOption = scanner.nextByte();
    scanner.nextLine(); // to clean buffer
    if(mainMenuOption == 2){
    break;
    } else if(mainMenuOption == 1){
    continue;
    } else {
    throw new IncorrectInputException("You have selected wrong option: " + mainMenuOption);
    }
    } catch (IncorrectInputException incorrectInputException) {
    System.err.println(incorrectInputException.getMessage());
    System.out.println();
    } catch (Exception exception){
    System.err.println(exception.getMessage());
    System.out.println();
    }
    }
    }

At last, we have some custom exception class, which will be invoked if specific type of exception occurs.

public class IncorrectInputException extends Exception {
public IncorrectInputException(String message) {
super(message);
}
}

public class InvalidOwnerException extends Exception {
public InvalidOwnerException(String message) {
super(message);
}
}

As the name implies, these exceptions will come when we have either entered incorrect input or provided invalid owner.