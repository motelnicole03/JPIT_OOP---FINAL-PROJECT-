JPIT – Jollibee Product Inventory Tracker
1. Project Overview / Description
The Jollibee Product Inventory Tracker (JPIT) is a Java console-based application designed to manage and
track inventory levels of various Jollibee menu items. It simulates a real-world inventory system, allowing
users to: - Add products - Delete products - View product details - Update product quantities (sell/restock) -
Apply discounts - Search products - View inventory summary - Automatically restock items below a
threshold
This project demonstrates Object-Oriented Programming (OOP) principles and serves as an excellent
example of using abstraction, inheritance, encapsulation, and polymorphism in a practical program.
2. OOP Concepts Applied
 Encapsulation
All product data fields (SKU, name, price, quantity) are private.
Access is controlled through getters and setters.
 Inheritance
FoodItem and DrinkItem classes inherit from the abstract class Product .
 Abstraction
Product is an abstract class that contains abstract methods:
displayDetails()
applyDiscount()
Subclasses are required to implement these methods.
 Polymorphism
The program uses dynamic polymorphism when calling displayDetails() and
applyDiscount() .
Different product types behave differently using the same method names.
