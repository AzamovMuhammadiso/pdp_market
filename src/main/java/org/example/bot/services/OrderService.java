package org.example.bot.services;

import org.example.bot.model.Order;
import org.example.bot.model.Product;
import org.example.bot.model.User;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(User user, List<Product> products) {
        Order order = new Order(user, products);
        orders.add(order);
    }

    public List<Order> getOrdersForUser(User user) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUser().equals(user)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

}
