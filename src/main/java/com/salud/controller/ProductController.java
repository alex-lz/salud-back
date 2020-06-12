package com.salud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.salud.exception.ResourceNotFoundException;
import com.salud.model.Product;
import com.salud.repository.ProductRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long prodId)
        throws ResourceNotFoundException {
        Product prod = productRepository.findById(prodId)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + prodId));
        return ResponseEntity.ok().body(prod);
    }
    
    @PostMapping("/register/product")
    public Product createProduct(@Valid @RequestBody Product prod) {
        return productRepository.save(prod);
    }

    @PutMapping("/update/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long prodId,
         @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product prod = productRepository.findById(prodId)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + prodId));

        prod.setCategoryID(productDetails.getCategoryID());
        prod.setProductName(productDetails.getProductName());
        prod.setProductDescription(productDetails.getProductDescription());
        prod.setSupplier(productDetails.getSupplier());
        prod.setUnitPrice(productDetails.getUnitPrice());
        prod.setProductSize(productDetails.getProductSize());
        prod.setColor(productDetails.getColor());
        prod.setProductURLPicture(productDetails.getProductURLPicture());
        prod.setDiscountAvailable(productDetails.getDiscountAvailable());
        final Product updatedProduct = productRepository.save(prod);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/product/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long prodId)
         throws ResourceNotFoundException {
        Product prod = productRepository.findById(prodId)
       .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + prodId));

        productRepository.delete(prod);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

