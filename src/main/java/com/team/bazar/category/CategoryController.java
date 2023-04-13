package com.team.bazar.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public Iterable<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @PostMapping()
    public Category addCategory(@RequestBody Category category){
        return categoryService.save(category);
    }

}
