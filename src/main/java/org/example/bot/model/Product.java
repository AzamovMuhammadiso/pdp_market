package org.example.bot.model;

import lombok.Data;

@Data
public class Product {
    private String name;
    private String description;
    private double price;
    private String imageUrl;

}