# Computer Accessories Shop - Java Application (Apr 2024)

## Project Overview
This Java application simulates a **Computer Accessories Shop** for managing products like keyboards and mice. It includes functionalities for both **Admin** and **Customer** users, enabling stock management, product browsing, and checkout processes via a simple GUI or CLI interface.

---

## Features

### Admin Functionalities
- View **all products**, including original cost, sorted by retail price (ascending).
- Add new products to the stock.
- Prevent duplicate products (based on barcode).

### Customer Functionalities
- View **available products**, excluding original cost, sorted by retail price.
- Add items to shopping basket.
- View and cancel shopping basket.
- Purchase items using:
  - Credit Card (6-digit card, 3-digit CVV)
  - PayPal (email-based)
- Filter/Search products by:
  - **Barcode**
  - **Mouse buttons count**
- Receive a **purchase receipt** with payment and delivery details.
- Automatic **stock update** post-purchase.

---

## File Structure

- `src/` — Java source files (each class in its own `.java` file)
- `UserAccounts.txt` — Contains user info (admin + customers)
- `Stock.txt` — Initial stock data (products in the store)
- `cas.jar` — Executable JAR file
- `ClassDiagram.pdf` — Object-oriented class structure

---

## Technologies Used
- Java (OOP principles)
- File I/O using `.txt` files
- Optional: Java Swing / JavaFX for GUI
- Platform-independent file paths

---

## How to Run

### Prerequisites
- Java 8 or higher
- Eclipse IDE or any Java IDE
- Git (if using version control)

### Run via Eclipse
1. Open Eclipse.
2. Import the project folder as a Java project.
3. Run the `Main` class.

### Run via Terminal
```bash
java -jar cas.jar
```

## Object-Oriented Programming

The system adheres to strong object-oriented programming (OOP) principles:
- Inheritance
- Interfaces
- Encapsulation
- Polymorphism

A full class diagram is provided in `ClassDiagram.pdf`
