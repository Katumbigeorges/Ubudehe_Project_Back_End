package com.ubudehe.system.controller;

import com.ubudehe.system.model.Category;
import com.ubudehe.system.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.FOUND);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);

    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Long id){
        return categoryService.updateCategory(category, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
