package com.ubudehe.system.service;

import com.ubudehe.system.model.CategoryAssignment;

import java.util.List;

public interface ICategoryAssignmentService {
    CategoryAssignment addCategoryAssignment(CategoryAssignment categoryAssignment);

    List<CategoryAssignment> getCategoryAssignment();

    CategoryAssignment updateCategoryAssignment(CategoryAssignment categoryAssignment, Long id);

    CategoryAssignment getCategoryAssignmentById(Long id);

    void deleteCategoryAssignment(Long id);
}
