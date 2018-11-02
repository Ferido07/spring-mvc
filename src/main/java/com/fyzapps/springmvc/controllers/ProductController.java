package com.fyzapps.springmvc.controllers;

import com.fyzapps.springmvc.domain.Product;
import com.fyzapps.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"/products","/products/list"})
    public String listAllProducts(Model model){
        model.addAttribute("products",productService.getAll());
        return "product/list";
    }

    @RequestMapping("/products/{id}")
    public String getProduct(@PathVariable int id, Model model){
        model.addAttribute("product",productService.getById(id));
        return "product/show";
    }

    @RequestMapping("/products/create")
    public String createProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/productForm";
    }

    @RequestMapping(value = "/products/create", method = RequestMethod.POST)
    public String createOrUpdate(Product product){
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/products/" + savedProduct.getId();
    }

    @RequestMapping("/products/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.getById(id));
        return "product/productForm";
    }

    @RequestMapping("/products/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/products";
    }
}
