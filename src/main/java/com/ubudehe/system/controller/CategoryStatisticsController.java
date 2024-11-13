package com.ubudehe.system.controller;

import com.ubudehe.system.model.CategoryStatistics;
import com.ubudehe.system.model.Citizen;
import com.ubudehe.system.service.ICategoryStatisticsService;
import com.ubudehe.system.service.ICitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/category-statistics")
@RequiredArgsConstructor
public class CategoryStatisticsController {
    private final ICategoryStatisticsService categoryStatisticsService;

    @GetMapping
    public ResponseEntity<List<CategoryStatistics>> getCategoryStatistics(){
        return new ResponseEntity<>(categoryStatisticsService.getCategoryStatistics(), HttpStatus.FOUND);
    }

    @PostMapping
    public CategoryStatistics addCategoryStatistics(@RequestBody CategoryStatistics categoryStatistics){
        return categoryStatisticsService.addCategoryStatistics(categoryStatistics);
    }

    @PutMapping("/update/{id}")
    public CategoryStatistics updateCategoryStatistics(@RequestBody CategoryStatistics categoryStatistics, @PathVariable Long id){
        return categoryStatisticsService.updateCategoryStatistics(categoryStatistics, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryStatistics(@PathVariable Long id){
        categoryStatisticsService.deleteCategoryStatistics(id);
    }

    @PutMapping
    public CategoryStatistics getCategoryStatisticsById(@PathVariable Long id){
        return categoryStatisticsService.getCategoryStatisticsById(id);
    }

}

