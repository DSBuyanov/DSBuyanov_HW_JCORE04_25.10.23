package ru.gb.safronov;

public class Order {
    public String customer;
    public String product;
    public int quantity;

    public Order(String customer, String product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }
}
