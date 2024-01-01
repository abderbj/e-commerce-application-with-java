# Console E-Commerce Application

## Overview

This console-based E-Commerce application is developed in Java, utilizing Object-Oriented Programming (OOP) concepts. The application provides a simple and intuitive interface for both administrators and customers. It includes features such as authentication, product management, shopping cart functionality, order processing, and more.

## Features

### Authentication

- **Login**: Users can log in by providing their credentials.
- **Signup**: New users can sign up for an account by providing necessary information.

### Admin Actions

Once logged in as an admin, the following actions are available:

1. **Add a New Product**: Admins can add new products to the inventory.
2. **Update a Product**: Admins can modify the details of existing products.
3. **Delete a Product**: Admins have the ability to remove products from the inventory.
4. **Log Out**: Admins can log out of the system.

### Customer Actions

Once logged in as a customer, the following actions are available:

1. **Create a New Shopping Cart**: Customers can create a new shopping cart to add products.
2. **Search for a Product**: Customers can search for products within the inventory.
3. **View Recommendations**: Customers can view product recommendations based on their preferences.
4. **View Shopping Carts**: Customers can see their existing shopping carts.
5. **Add a New Order**: Customers can add products from the shopping cart to create a new order.
6. **View Orders**: Customers can view their order history.
7. **Confirm an Order**: Customers can confirm and finalize an order.
8. **Create an Order**: Customers can initiate the order creation process.
9. **Add a Product Rating**: Customers can rate and provide feedback on purchased products.
10. **Log Out**: Customers can log out of the system.

## Implementation Details

The application is implemented in Java, following OOP principles:

- **Abstract Product Class**: Serves as the parent class for different types of products (e.g., clothes, electronic products).
- **User Class**: Manages user authentication and authorization.
- **Shopping Cart Class**: Represents the shopping cart for customers, including the list of products.
- **Order Class**: Confirms a shopping cart with a payment method, with separate classes for payment methods (e.g., PayPal, Credit Card).
- **Data Storage**: Entity data, such as products and user information, is stored in text files.

## Getting Started

1. Clone the repository.
2. Compile and run the application using a Java development environment.
3. Follow the on-screen instructions to navigate through the application.

Feel free to explore and enhance the application as needed. Happy coding!
