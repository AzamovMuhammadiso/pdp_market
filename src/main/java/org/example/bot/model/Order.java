package org.example.bot.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private User user;
    private List<Product> products;
}
