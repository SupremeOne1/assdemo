package com.demo.dao;

import com.demo.models.Category;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryDAO {
    List<Category> categoryList = Arrays.asList(
        new Category(1, "Nhóm 1"),
        new Category(2, "Nhóm 2")
    );

    public List<Category> getAll(){
        return categoryList;
    }

    public Category findById(int id) {
        return categoryList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .get();
    }
}
