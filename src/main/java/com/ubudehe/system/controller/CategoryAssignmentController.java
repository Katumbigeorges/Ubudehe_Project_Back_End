package com.ubudehe.system.controller;

import com.ubudehe.system.model.CategoryAssignment;
import com.ubudehe.system.service.ICategoryAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/category-assignment")
@RequiredArgsConstructor
public class CategoryAssignmentController {
    private final ICategoryAssignmentService categoryAssignmentService;

    @GetMapping
    public ResponseEntity<List<CategoryAssignment>> getCategoryAssignment(){
        return new ResponseEntity<>(categoryAssignmentService.getCategoryAssignment(), HttpStatus.FOUND);
    }

    @PostMapping
    public CategoryAssignment addCategoryAssignment(@RequestBody CategoryAssignment categoryAssignment){
        return categoryAssignmentService.addCategoryAssignment(categoryAssignment);
    }

    @PutMapping("/update/{id}")
    public CategoryAssignment updateCategoryAssignment(@RequestBody CategoryAssignment categoryAssignment, @PathVariable Long id){
        return categoryAssignmentService.updateCategoryAssignment(categoryAssignment, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryAssignment(@PathVariable Long id){
        categoryAssignmentService.deleteCategoryAssignment(id);
    }

    @GetMapping("/category-assignment/{id}")
    public CategoryAssignment getCategoryAssignmentById(@PathVariable Long id){
        return categoryAssignmentService.getCategoryAssignmentById(id);
    }

}
