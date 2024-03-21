package org.example.bot.db;

import lombok.Data;
import org.example.bot.model.Product;
import org.example.bot.model.User;

import java.util.List;

@Data
public class Db {
    private List<User> users;
    private List<Product> products;
    private User session;
}
