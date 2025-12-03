****JPIT – Jollibee Product Inventory Tracker**


<img width="227" height="222" alt="image" src="https://github.com/user-attachments/assets/fb33593e-d175-48ec-acce-c213522a0adf" />





**1. Project Overview / Description**
The Jollibee Product Inventory Tracker (JPIT) is a Java console-based application designed to manage and
track inventory levels of various Jollibee menu items. It simulates a real-world inventory system, allowing
users to: - Add products - Delete products - View product details - Update product quantities (sell/restock) -
Apply discounts - Search products - View inventory summary - Automatically restock items below a
threshold
This project demonstrates Object-Oriented Programming (OOP) principles and serves as an excellent
example of using abstraction, inheritance, encapsulation, and polymorphism in a practical program.

**2. OOP Concepts Applied**
 **Encapsulation**
All product data fields (SKU, name, price, quantity) are private.
Access is controlled through getters and setters.Encapsulation is achieved by keeping the data inside the `Product` class
private. This means fields like product name, category, and quantity cannot be
changed directly from outside the class. Access is only allowed through getter
and setter methods. This prevents unintended modifications and keeps the system
secure and organized.
 
 **Inheritance**
FoodItem and DrinkItem classes inherit from the abstract class Product.The project includes a base abstract class `Product`, from which specific
product categories can inherit—such as `ChickenProduct`, `BurgerProduct`, and
`BeverageProduct`. These subclasses inherit all properties from `Product` but
may include their own unique features or behaviors.

 **Abstraction**
Product is an abstract class that contains abstract methods:
displayDetails()
applyDiscount()
Subclasses are required to implement these methods.The abstract class `Product` contains abstract methods that subclasses must
implement. This enforces consistency while allowing flexibility for specialized
behavior. Abstraction hides complex logic and exposes only what the rest of the
program needs to use.

 **Polymorphism**
The program uses dynamic polymorphism when calling displayDetails() and
applyDiscount() .
Different product types behave differently using the same method names.Through method overriding, the system can treat all product types as `Product`
objects but still use their unique implementations. For example, each subclass
may override the `displayInfo()` method to show additional details about that
specific category.


 
The program uses dynamic polymorphism when calling displayDetails() and
applyDiscount() .
Different product types behave differently using the same method name
