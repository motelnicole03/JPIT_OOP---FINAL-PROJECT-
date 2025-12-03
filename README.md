**JPIT – Jollibee Product Inventory Tracker**

<img width="300" height="200" alt="image" src="https://github.com/user-attachments/assets/96172274-851c-4eab-be1c-b1262718540f" />


**1. Project Overview / Description**
- The Jollibee Product Inventory Tracker (JPIT) is a Java console-based application designed to manage and
track inventory levels of various Jollibee menu items. It simulates a real-world inventory system, allowing
users to: - Add products - Delete products - View product details - Update product quantities (sell/restock) -
Apply discounts - Search products - View inventory summary - Automatically restock items below a
threshold
This project demonstrates Object-Oriented Programming (OOP) principles and serves as an excellent
example of using abstraction, inheritance, encapsulation, and polymorphism in a practical program.

**2. OOP Concepts Applied**
 **Encapsulation**
- All product data fields (SKU, name, price, quantity) are private.
Access is controlled through getters and setters.Encapsulation is achieved by keeping the data inside the `Product` class
private. This means fields like product name, category, and quantity cannot be
changed directly from outside the class. Access is only allowed through getter
and setter methods. This prevents unintended modifications and keeps the system
secure and organized.
 
 **Inheritance**
- FoodItem and DrinkItem classes inherit from the abstract class Product.The project includes a base abstract class `Product`, from which specific
product categories can inherit—such as `ChickenProduct`, `BurgerProduct`, and
`BeverageProduct`. These subclasses inherit all properties from `Product` but
may include their own unique features or behaviors.

 **Abstraction**
- Product is an abstract class that contains abstract methods:
displayDetails()
applyDiscount()
Subclasses are required to implement these methods.The abstract class `Product` contains abstract methods that subclasses must
implement. This enforces consistency while allowing flexibility for specialized
behavior. Abstraction hides complex logic and exposes only what the rest of the
program needs to use.

 **Polymorphism**
- The program uses dynamic polymorphism when calling displayDetails() and
applyDiscount() .
Different product types behave differently using the same method names.Through method overriding, the system can treat all product types as `Product`
objects but still use their unique implementations. For example, each subclass
may override the `displayInfo()` method to show additional details about that
specific category.

**Program Structure**
- The structure of the Jollibee Product Inventory Tracker (JPIT) is organized using a modular and object-oriented design, ensuring clarity, flexibility, and easy maintenance. At its core, the system consists of a main class that handles all user interactions through a console-based menu, allowing the user to navigate features such as adding items, updating stocks, viewing inventory, and removing products. The main logic of storing and manipulating data is delegated to the InventoryManager class, which maintains a dynamic list of all products in the system. Each product is represented by an abstract Product class that defines the shared attributes and behaviors of all menu items, while specific categories like chicken, burgers, and beverages are implemented as subclasses that inherit from this base class. This structure ensures that common functions are centralized, while specialized behaviors are handled individually. Overall, the program follows a clear separation of responsibilities—user interface, data management, and product modeling—making the system efficient, expandable, and easy to understand.

**How to Run the Program**
- To run the Jollibee Product Inventory Tracker (JPIT), the user must first ensure that the Java Development Kit (JDK) is installed on their computer. Once Java is available, all the program’s .java files should be placed together inside one folder. The user must then open a terminal or command prompt and navigate to that folder using the cd command. After reaching the correct directory, the program is compiled by typing javac *.java, which converts all source code files into executable .class files. When the compilation is successful and no errors are found, the program can be started by typing java JollibeeInventoryApp. This will launch the console-based menu, allowing the user to interact with the system and perform operations such as adding, updating, deleting, and viewing product inventory records. With these simple steps, the JPIT application becomes fully functional and ready for use.

**Sample Output**

<img width="300" height="300" alt="image" src="https://github.com/user-attachments/assets/801223cd-8d84-4237-bca3-8e28e81d3a8b" />

<img width="300" height="300" alt="image" src="https://github.com/user-attachments/assets/2b2452d4-3b03-4876-a715-f31230570497" />

<img width="300" height="300" alt="image" src="https://github.com/user-attachments/assets/a119604d-5676-4bf8-bbee-06fa5f71faa5" />

<img width="300" height="300" alt="image" src="https://github.com/user-attachments/assets/b86b9685-55be-4817-aaa0-e9f4b1d57292" />

<img width="300" height="300" alt="image" src="https://github.com/user-attachments/assets/afbe3ab9-c6dc-4464-bddf-edf61724a0d5" />

<img width="300" height="300" alt="image" src="https://github.com/user-attachments/assets/271518e4-c039-46b6-8faa-eecd1b2be071" />





**Author and Acknowledgement**
- This Jollibee Product Inventory Tracker (JPIT) program was collaboratively developed by **Mendoza, Nicole Ann H**., **Motel, Nicole V.**, and **Nitro, James Kerby N.** as part of the requirements in object-oriented programming.We would like to thank **Sir Emmanuel Charlie Enriquez** for guiding us and helping us understand the concepts needed to complete this work.

**References**
- Jollibee Food Corporation.
  **https://www.jollibeefoods.com/**
- Encapsulation **https://stackify.com/oop-concept-for-beginners-what-is-encapsulation/**
- Inheritamce **https://stackify.com/oop-concept-inheritance/**
- Abstraction **https://www.w3schools.com/java/java_abstract.asp**
- Polymorphism **https://www.w3schools.com/java/java_polymorphism.asp** 










