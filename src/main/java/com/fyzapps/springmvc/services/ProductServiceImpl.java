package com.fyzapps.springmvc.services;

import com.fyzapps.springmvc.models.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private HashMap<Integer,Product> products;

    public ProductServiceImpl() {
        this.products = loadProducts();
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }

    private HashMap<Integer,Product> loadProducts(){
        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal(12.99));
        product1.setImageUrl("http://link.com");
        products.put(1,product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("Product 2");
        products.put(2,product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setDescription("Product 3");
        products.put(3,product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setDescription("Product 4");
        products.put(4,product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("77"));
        products.put(5,product5);

        return products;
    }
}
