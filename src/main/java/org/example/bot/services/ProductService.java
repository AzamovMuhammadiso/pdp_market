package org.example.bot.services;

import org.example.bot.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private Map<String, List<Product>> productCategories;
    private Map<String, Integer> productCategoryCounts;

    public ProductService() {
        productCategories = new HashMap<>();
        productCategoryCounts = new HashMap<>();
        initializeProducts();
    }

    private void initializeProducts() {
        addCategory("Clothing");
        addProduct("Clothing", "T-Shirt", "Comfortable cotton t-shirt", 19.99, "https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTA4L3Jhd3BpeGVsX29mZmljZV8yNV9waG90b19vZl93aGl0ZV9tYWxlX3RzaGlydF9tb2NrdXBfd2hpdGVfdHNoaV85YjNmOWZjZS03MTZkLTQxYmUtODkzZS05MzkwZWY1NmZiZmFfMi5qcGc.jpg");
        addProduct("Clothing", "Jeans", "Classic denim jeans", 39.99, "https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTA4L3Jhd3BpeGVsX29mZmljZV8yNV9waG90b19vZl93aGl0ZV9tYWxlX3RzaGlydF9tb2NrdXBfd2hpdGVfdHNoaV85YjNmOWZjZS03MTZkLTQxYmUtODkzZS05MzkwZWY1NmZiZmFfMi5qcGc.jpg");

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
        for (String category : productCategories.keySet()) {
            List<Product> products = productCategories.get(category);
            productCategoryCounts.put(category, products.size());
        }
    }

    private void addCategory(String category) {
        if (!productCategories.containsKey(category)) {
            productCategories.put(category, new ArrayList<>());
            productCategoryCounts.put(category, 0);
        }
    }

    private void addProduct(String category, String name, String description, double price, String imageUrl) {
        List<Product> products = productCategories.get(category);
        if (products != null) {
            products.add(new Product(name, description, price, imageUrl));
            productCategoryCounts.put(category, products.size());
        }
    }


    public List<Product> getProductsForCategory(String category) {
        return productCategories.getOrDefault(category, new ArrayList<>());
    }

    public int getProductCountForCategory(String category) {
        return productCategoryCounts.getOrDefault(category, 0);
    }

}
