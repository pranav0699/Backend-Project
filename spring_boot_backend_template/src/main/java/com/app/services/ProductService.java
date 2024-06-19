package com.app.services;

import java.util.List;

import com.app.entities.Product;

public interface ProductService {
	List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> getProductsByCategoryId(Long categoryId);
    List<Product> searchProducts(String keyword);
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    Product addProduct(Product product);
    
    Product updateProduct(Long id, Product product);

}
