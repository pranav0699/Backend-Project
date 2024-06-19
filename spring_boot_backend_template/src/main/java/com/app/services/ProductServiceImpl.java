package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	 	@Autowired
	    private ProductRepository productRepository;

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    @Override
	    public Product getProductById(Long id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    @Override
	    public List<Product> getProductsByCategoryId(Long categoryId) {
	        return productRepository.findByCategoryId(categoryId);
	    }

	    @Override
	    public List<Product> searchProducts(String keyword) {
	        return productRepository.findByPname(keyword);
	    }

	    @Override
	    public Product saveProduct(Product product) {
	        return productRepository.save(product);
	    }

	    @Override
	    public Product updateProduct(Product product) {
	        return productRepository.save(product);
	    }

	    @Override
	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
	    
	    @Override
	    public Product addProduct(Product product) {
	        // Optionally handle any logic before saving the product
	        return productRepository.save(product);
	    }
	    @Override
	    public Product updateProduct(Long id, Product product) {
	        Product existingProduct = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	        existingProduct.setPname(product.getPname());
	        existingProduct.setDescription(product.getDescription());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setStock(product.getStock());
	        existingProduct.setCategory(product.getCategory());

	        return productRepository.save(existingProduct);
	    }


}
