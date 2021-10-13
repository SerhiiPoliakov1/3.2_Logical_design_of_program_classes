package com.clickonlinetochka.clickonlinetochka.controller;

import com.clickonlinetochka.clickonlinetochka.model.Product;
import com.clickonlinetochka.clickonlinetochka.model.ProductDto;
import com.clickonlinetochka.clickonlinetochka.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getListProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDto productDto) {
        UUID uuid = UUID.randomUUID();
        Product product = new Product();
        product.setId(uuid.toString());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());

        productRepository.save(product);
        return uuid.toString();
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam String productId) {
        return productRepository.deleteById(productId).getId();
    }
}
