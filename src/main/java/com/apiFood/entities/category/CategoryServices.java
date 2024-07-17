package com.apiFood.entities.category;


import com.apiFood.entities.product.Product;
import com.apiFood.entities.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@EnableTransactionManagement
public class CategoryServices {

    HashMap request = new HashMap<>();

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    public List<Category> getAllCategoryServices(){
        return categoryRepository.findAll();
    }

    public Category createCategoryServices(Category category){



        return categoryRepository.save(category);
    }

    public Optional<Category> getCategoryByIdServices(Long categoryID) {
        Optional<Category> categoryFound = categoryRepository.findById(categoryID);

         return categoryFound;
    }

    public ResponseEntity<Object> deleteCategoryServices(Long idCategory){
        categoryRepository.deleteById(idCategory);

        request.put("message","Deleted succes!");

        return new ResponseEntity<>(request,HttpStatus.OK);
    }
    



    }
