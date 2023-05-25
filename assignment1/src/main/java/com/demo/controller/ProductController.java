package com.demo.controller;

import com.demo.dao.CategoryDAO;
import com.demo.dao.ProductDAO;
import com.demo.models.Product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/")
    public String listProduct(Model model){
        model.addAttribute("productList", productDAO.getAll());
        return "product/list";
    }

    @GetMapping("/create-product")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryDAO.getAll());
        return "product/form";
    }

    @GetMapping("/confirm-delete-product/{id}")
    public String confirmDeleteProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return "product/confirm_delete";
    }

    @GetMapping("/update-product/{id}")
    public String updateProduct(@PathVariable Integer id, Model model) {
        Product product = productDAO.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryDAO.getAll());
        return "product/form";
    }

    @PostMapping("/save-product")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
        System.out.println(product);
        
        //bindingResult là đối tượng do Spring tạo để lưu trữ kết quả quá trình validate
        if (bindingResult.hasErrors()) {
        	// TODO: Validate data
            // If data is not valid, show error messages
            return "product/form";
        }
        
        // If data is valid, use productDAO to save data
        productDAO.addProduct(product);
        
        return "redirect:/";
    }

    @PostMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id, Product product) {
        // TODO: Delete product
    	productDAO.delete(id);
        return "redirect:/";
    }
}
