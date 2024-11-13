package com.ubudehe.system.service;

import com.ubudehe.system.exception.CategoryAlreadyExistsException;
import com.ubudehe.system.exception.CategoryNotFoundException;
import com.ubudehe.system.model.Category;
import com.ubudehe.system.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public Category addCategory(Category category) {

        if (categoryAlreadyExists(category.getCategoryName())){
            throw new CategoryAlreadyExistsException(category.getCategoryName()+"already exists!");
        }
        return categoryRepository.save(category);
    }


    @Override
    public Category updateCategory(Category category, Long id) {
        return categoryRepository.findById(id).map(st -> {
            st.setCategoryName(category.getCategoryName());
            st.setCriteriaDescription(category.getCriteriaDescription());
            st.setMinimumCriteriaValue(category.getMinimumCriteriaValue());
            st.setMaximumCriteriaValue(category.getMaximumCriteriaValue());
            return categoryRepository.save(st);
        }).orElseThrow(()-> new CategoryNotFoundException("This Category Is not Found!!"));
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("No Category Found with this Id:"+id));
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)){
            throw new CategoryNotFoundException("This Category Is Not Found");
        }
        categoryRepository.deleteById(id);
    }

    private boolean categoryAlreadyExists(String categoryName){

        return categoryRepository.findByCategoryName(categoryName).isPresent();
    }
}
