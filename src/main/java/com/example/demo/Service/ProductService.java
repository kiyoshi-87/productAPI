package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(long productId, Product newProductData) throws Exception {
        
        Product product = productRepository.findById(productId).orElseThrow(()-> new Exception("invalid product id"));
                
        product.setProductName(newProductData.getProductName());
        product.setProductPrice(newProductData.getProductPrice());

        return productRepository.save(product);
    }

    public void deleteProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.delete(product.get());
            return;
        }

        throw new IllegalArgumentException("Product id is invalid!");
    }
    public Product getProductByProductId(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return product.get();
        }
        throw new IllegalArgumentException("Product id is invalid!");
    }
}
