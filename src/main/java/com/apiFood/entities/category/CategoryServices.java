package com.apiFood.entities.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@EnableTransactionManagement
public class CategoryServices {

    HashMap request = new HashMap<>();

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategoryServices(){
        return categoryRepository.findAll();
    }

    public Category createCategoryServices(Category category){
        return categoryRepository.save(category);
    }

    public ResponseEntity<Optional> getCategoryByIdServices(Long categoryID) {
        Optional categoryFound = categoryRepository.findById(categoryID);


        return new ResponseEntity<>(categoryFound, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteCategoryServices(Long idcategory){
        categoryRepository.deleteById(idcategory);

        request.put("message","Deleted succes!");

        return new ResponseEntity<>(request,HttpStatus.OK);
    }


    }
