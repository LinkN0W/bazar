package com.team.bazar.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Iterable<Category> findAllById(Iterable<UUID> categoryIds){
        return  categoryRepository.findAllById(categoryIds);
    }
}
