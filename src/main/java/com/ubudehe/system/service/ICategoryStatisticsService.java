package com.ubudehe.system.service;

import com.ubudehe.system.model.CategoryStatistics;

import java.util.List;

public interface ICategoryStatisticsService {
    CategoryStatistics addCategoryStatistics(CategoryStatistics categoryStatistics);

    List<CategoryStatistics> getCategoryStatistics();

    CategoryStatistics updateCategoryStatistics(CategoryStatistics categoryStatistics, Long id);

    CategoryStatistics getCategoryStatisticsById(Long id);

    void deleteCategoryStatistics(Long id);
}
