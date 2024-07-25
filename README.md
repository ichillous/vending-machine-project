# Vending Machine Application

## 🚀 Overview

Welcome to the Vending Machine Application! This Java-based project simulates a vending machine system, demonstrating object-oriented programming principles and design patterns. It's perfect for learning about inheritance, generics, and basic data structures in Java.

## 🌟 Features

- **Product Management**: Create and manage various types of products (snacks and beverages).
- **Slot System**: Organize products in slots with quantity tracking.
- **Vending Operations**: Add products, dispense items, and display available products.
- **Extensible Design**: Easily add new product types or vending machine features.

## 🏗️ Project Structure

The project consists of the following main classes:

- `Product`: Base class for all vending machine products.
- `Snack`: Extends `Product`, adds vegan status.
- `Beverage`: Extends `Product`, adds fluid ounces.
- `Slot<T extends Product>`: Generic class to hold products and their quantities.
- `VendingMachine`: Manages the vending operations.
- `VendRunner`: Demonstrates the usage of the vending machine system.

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, etc.) or a text editor

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/vending-machine-application.git
   ```
2. Open the project in your preferred IDE or navigate to the project directory in your terminal.

### Running the Application

1. Compile the Java files:
   ```
   javac *.java
   ```
2. Run the VendRunner class:
   ```
   java VendRunner
   ```

## 🎮 Usage Example

```java
public class VendRunner {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // Create products
        Snack chips = new Snack("Potato Chips", 1.50, false);
        Beverage soda = new Beverage("Cola", 2.00, 12.0);

        // Add products to vending machine
        vendingMachine.addProduct("A1", new Slot<>(chips, 10));
        vendingMachine.addProduct("B2", new Slot<>(soda, 5));

        // Display available products
        vendingMachine.displayProducts();

        // Dispense a product
        Product dispensedProduct = vendingMachine.dispenseProduct("A1");
        if (dispensedProduct != null) {
            System.out.println("Dispensed: " + dispensedProduct);
        }
    }
}
```

## 📊 UML Diagram

Here's the UML class diagram for our Vending Machine Application:

![UML Diagram](https://imgur.com/UyPr8AP))

This diagram shows the relationships between the classes in our system, including inheritance, composition, and dependencies.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Thanks to all contributors who have helped shape this project.
- Inspired by real-world vending machines and object-oriented design principles.

---

Happy Vending! 🎉
