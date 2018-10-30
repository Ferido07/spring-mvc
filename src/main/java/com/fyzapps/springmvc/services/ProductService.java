package com.fyzapps.springmvc.services;

import com.fyzapps.springmvc.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);
}
