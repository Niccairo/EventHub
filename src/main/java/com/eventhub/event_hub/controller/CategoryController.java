package com.eventhub.event_hub.controller;

import com.eventhub.event_hub.Service.CategoryService;
import com.eventhub.event_hub.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/")
    public Category createCategory(@RequestBody Category newCategory){
        return categoryService.createCategory(newCategory);
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id,@RequestBody Category category){
        Optional<Category> categoryOpt = categoryService.updateCategory(id,category);
        if(categoryOpt.isPresent()){
            return ResponseEntity.ok("Category updated");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        Optional<Category> categoryOpt = categoryService.deleteCategory(id);
        if (categoryOpt.isPresent()){
            return ResponseEntity.ok("Category deleted");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllCategories(){
        categoryService.deleteAllCategories();
        return ResponseEntity.ok("All categories have been deleted");
    }

    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

}