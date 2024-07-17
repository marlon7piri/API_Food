package com.apiFood.entities.category;


import com.apiFood.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@Controller
@RequestMapping(path = "/api/category")
public class CategoryControllers {



    @Autowired
    private CategoryServices categoryServices;


    @GetMapping()
    public ResponseEntity<Object> getAllCategoryControllers(){
        Object category =  categoryServices.getAllCategoryServices();
         return new ResponseEntity<>(category, HttpStatus.OK);

    }


    @PostMapping(value = "/create")
    public Category createCategoryControllers(@RequestBody Category category){

        return categoryServices.createCategoryServices(category);
    }

    @DeleteMapping(value = "/{idCategory}")
    public ResponseEntity<Object> deletecategoryControllers(@PathVariable("idCategory") Long idCategory){
         categoryServices.deleteCategoryServices(idCategory);
        return new ResponseEntity(HttpStatus.OK);

    }
    @GetMapping(value = "/{idCategory}")
    public ResponseEntity<Object> getCategoryByIdControllers(@PathVariable("idCategory") Long idCategory){
         categoryServices.getCategoryByIdServices(idCategory);
        return new ResponseEntity(HttpStatus.OK);

    }

}
