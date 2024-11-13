package com.ubudehe.system.service;

import com.ubudehe.system.exception.ResourceNotFoundException;
import com.ubudehe.system.model.CategoryAssignment;
import com.ubudehe.system.repository.CategoryAssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryAssignmentService implements ICategoryAssignmentService {

    private final CategoryAssignmentRepository categoryAssignmentRepository;

    @Override
    public List<CategoryAssignment> getCategoryAssignment() {
        return categoryAssignmentRepository.findAll();
    }

    @Override
    public CategoryAssignment addCategoryAssignment(CategoryAssignment categoryAssignment) {
        return categoryAssignmentRepository.save(categoryAssignment);
    }


    @Override
    public CategoryAssignment updateCategoryAssignment(CategoryAssignment categoryAssignment, Long id) {
        return categoryAssignmentRepository.findById(id).map(ca -> {
            ca.setCitizen(categoryAssignment.getCitizen());
            ca.setCategory(categoryAssignment.getCategory());
            ca.setDateAssigned(categoryAssignment.getDateAssigned());
            ca.setAssignedBy(categoryAssignment.getAssignedBy());
            return categoryAssignmentRepository.save(ca);
        }).orElseThrow(()-> new ResourceNotFoundException("CategoryAssignment not found for this id : " + id));

    }

    @Override
    public CategoryAssignment getCategoryAssignmentById(Long id) {
        return categoryAssignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CategoryAssignment not found for this id : " + id));
    }

    @Override
    public void deleteCategoryAssignment(Long id) {
        if (!categoryAssignmentRepository.existsById(id)){
            throw new ResourceNotFoundException("CategoryAssignment not found for this id : " + id);
        }
        categoryAssignmentRepository.deleteById(id);

    }
}

