package org.example.bot.services;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    // Map to store product categories and their respective products
    private final Map<String, Map<String, ProductInfo>> productCategories;

    public ProductService() {
        productCategories = new HashMap<>();

        addCategory("Clothing");
        addProduct("Clothing", "T-Shirt", "Comfortable cotton t-shirt", 19.99, "https://example.com/t-shirt.jpg");
        addProduct("Clothing", "Jeans", "Classic denim jeans", 39.99, "https://example.com/jeans.jpg");

        addCategory("Food");
        addProduct("Food", "Fruit", "Assorted fresh fruits", 2.99, "https://example.com/fruit.jpg");
        addProduct("Food", "Vegetables", "Variety of fresh vegetables", 3.99, "https://example.com/vegetables.jpg");

        addCategory("Shoes");
        addProduct("Shoes", "Sneakers", "Stylish sneakers for everyday wear", 49.99, "https://example.com/sneakers.jpg");
        addProduct("Shoes", "Boots", "Durable boots for outdoor activities", 79.99, "https://example.com/boots.jpg");

        addCategory("Electronics");
        addProduct("Electronics", "Smartphone", "Latest smartphone model with advanced features", 599.99, "https://example.com/smartphone.jpg");
        addProduct("Electronics", "Laptop", "High-performance laptop for work and entertainment", 899.99, "https://example.com/laptop.jpg");

        addCategory("Children's Products");
        addProduct("Children's Products", "Toy Blocks", "Colorful building blocks for creative play", 29.99, "https://example.com/toy-blocks.jpg");
        addProduct("Children's Products", "Doll", "Soft plush doll for cuddling", 19.99, "https://example.com/doll.jpg");

        addCategory("Household Goods");
        addProduct("Household Goods", "Kitchenware Set", "Complete set of essential kitchen utensils", 49.99, "https://example.com/kitchenware.jpg");
        addProduct("Household Goods", "Bedding Set", "Luxurious bedding set for a comfortable sleep", 79.99, "https://example.com/bedding.jpg");

        addCategory("Sports & Recreation");
        addProduct("Sports & Recreation", "Yoga Mat", "Non-slip yoga mat for exercise and relaxation", 24.99, "https://example.com/yoga-mat.jpg");
        addProduct("Sports & Recreation", "Tennis Racket", "Premium tennis racket for tennis enthusiasts", 89.99, "https://example.com/tennis-racket.jpg");

        addCategory("Books");
        addProduct("Books", "Bestseller Novel", "Exciting novel that keeps you hooked till the end", 14.99, "https://example.com/novel.jpg");
        addProduct("Books", "Cookbook", "Collection of delicious recipes for home cooking", 19.99, "https://example.com/cookbook.jpg");
    }

    private void addCategory(String categoryName) {
        productCategories.put(categoryName, new HashMap<>());
    }

    private void addProduct(String categoryName, String productName, String description, double price, String imageUrl) {
        Map<String, ProductInfo> categoryProducts = productCategories.get(categoryName);
        if (categoryProducts != null) {
            categoryProducts.put(productName, new ProductInfo(description, price, imageUrl));
        }
    }
    public Map<String, ProductInfo> getCategoryProducts(String categoryName) {
        return productCategories.get(categoryName);
    }

    private static class ProductInfo {
        private final String description;
        private final double price;
        private final String imageUrl;

        public ProductInfo(String description, double price, String imageUrl) {
            this.description = description;
            this.price = price;
            this.imageUrl = imageUrl;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }

}
