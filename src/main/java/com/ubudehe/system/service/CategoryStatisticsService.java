package com.ubudehe.system.service;

import com.ubudehe.system.exception.ResourceNotFoundException;
import com.ubudehe.system.model.CategoryStatistics;
import com.ubudehe.system.repository.CategoryStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryStatisticsService implements ICategoryStatisticsService {

    private final CategoryStatisticsRepository categoryStatisticsRepository;

    @Override
    public List<CategoryStatistics> getCategoryStatistics() {
        return categoryStatisticsRepository.findAll();
    }

    @Override
    public CategoryStatistics addCategoryStatistics(CategoryStatistics categoryStatistics) {
        return categoryStatisticsRepository.save(categoryStatistics);
    }


    @Override
    public CategoryStatistics updateCategoryStatistics(CategoryStatistics categoryStatistics, Long id) {
        return categoryStatisticsRepository.findById(id).map(cs -> {
            cs.setCategory(categoryStatistics.getCategory());
            cs.setStatisticType(categoryStatistics.getStatisticType());
            cs.setStatisticValue(categoryStatistics.getStatisticValue());
            cs.setDateUpdated(categoryStatistics.getDateUpdated());
            return categoryStatisticsRepository.save(cs);
        }).orElseThrow(()-> new ResourceNotFoundException("CategoryStatistics not found for this id : " + id));
    }

    @Override
    public CategoryStatistics getCategoryStatisticsById(Long id) {
        return categoryStatisticsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CategoryStatistics not found for this id : " + id));
    }

    @Override
    public void deleteCategoryStatistics(Long id) {
        if (!categoryStatisticsRepository.existsById(id)){
            throw new ResourceNotFoundException("CategoryStatistics not found for this id : " + id);
        }
        categoryStatisticsRepository.deleteById(id);

    }
}
