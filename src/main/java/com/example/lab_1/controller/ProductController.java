package com.example.lab_1.controller;


import com.example.lab_1.dto.CreateProductRequest;
import com.example.lab_1.model.Product;
import com.example.lab_1.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getAll()
    {
        return productService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody CreateProductRequest request)
    {
        return productService.create(request);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/min-price")
    public List<Product>getByMinimumPrice(@RequestParam("price") BigDecimal price)
    {
        return productService.getByMinimumPrice(price);
    }

    @GetMapping("/by-category")
    public List<Product> getByCategory(
            @RequestParam("name") String categoryName) {
        return productService.getByCategoryName(categoryName);
    }

}
