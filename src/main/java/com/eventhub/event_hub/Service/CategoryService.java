package com.eventhub.event_hub.Service;

import com.eventhub.event_hub.entity.Category;
import com.eventhub.event_hub.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired private CategoryRepository categoryRepository;

    public Category createCategory(Category newCategory){
        return categoryRepository.save(newCategory);
    }

    public Optional<Category> getCategory(Long id){
        return categoryRepository.findById(id);
    }

    public Optional<Category> updateCategory(Long id,Category category){
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        if(categoryOpt.isPresent()){
            categoryOpt.get().setName(category.getName());
            categoryRepository.save(categoryOpt.get());
        }
        return categoryOpt;
    }

    public Optional<Category> deleteCategory(Long id){
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        if (categoryOpt.isPresent()){
            categoryRepository.deleteById(id);
        }
        return categoryOpt;
    }

    public void deleteAllCategories(){
        categoryRepository.deleteAll();
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

}