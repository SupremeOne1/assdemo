package com.demo.dao;

import com.demo.models.Category;
import com.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDAO {
    List<Product> productList = new ArrayList<>();
    @Autowired CategoryDAO categoryDAO;

    public List<Product> getAll() {
        return productList;
    }

    public void addProduct(Product product) {
        int id = 1;
        if(productList.size() > 0) {
            id = productList.get(productList.size()-1).getId() + 1;
        }

        product.setId(id);

        if(product.getCategory() != null) {
            Category category = categoryDAO.findById(product.getCategory().getId());
            product.setCategory(category);
        }

        productList.add(product);
    }

    public Product findById(int id) {
        return productList.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .get();
    }

    public void updateProduct(Product product) {
        if(product.getCategory() != null) {
            Category category = categoryDAO.findById(product.getCategory().getId());
            product.setCategory(category);
        }

        for(int i = 0; i < productList.size(); i++) {
            if(product.getId() == productList.get(i).getId()) {
                productList.set(i, product);
            }
        }
    }

    public void delete(int id) {
        productList = productList.stream()
                        .filter(p -> p.getId() != id)
                        .collect(Collectors.toList());
    }
}
