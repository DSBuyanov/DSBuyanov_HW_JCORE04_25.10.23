package ru.gb.safronov;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            // Проверка логина и пароля
            boolean isValid = checkCredentials("username", "password", "password");
            System.out.println("Credentials valid: " + isValid);

            // Эмуляция интернет-магазина
            Customer[] customers = {new Customer("Alina"), new Customer("Roman")};
            Product[] products = {new Product("Laptop"), new Product("Phone")};

            ArrayList<Order> orders = new ArrayList<>();
            orders.add(makePurchase("Alina", "Laptop", 1));
            orders.add(makePurchase("Roman", "Phone", 2));

            System.out.println("Total orders: " + orders.size());

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static boolean checkCredentials(String login, String password, String confirmPassword) 
            throws WrongLoginException, WrongPasswordException {
        if (login.length() >= 20) {
            throw new WrongLoginException("Login length should be less than 20 characters.");
        }
        if (password.length() >= 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password is either too long or doesn't match.");
        }
        return true;
    }

    public static Order makePurchase(String customerName, String productName, int quantity) throws Exception {
        if (customerName == null || productName == null || quantity <= 0) {
            throw new Exception("Invalid purchase parameters.");
        }
        return new Order(customerName, productName, quantity);
    }
}
