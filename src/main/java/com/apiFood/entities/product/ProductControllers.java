package com.apiFood.entities.product;


import com.apiFood.entities.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(path = "/api/products")
public class ProductControllers {

        @Autowired
        private ProductServices productServices;

    @GetMapping()
    public ResponseEntity<Object> getAllProductControllers(){
        Object category =  productServices.getAllProductServices();
        return new ResponseEntity<>(category, HttpStatus.OK);

    }


    @PostMapping(value = "/create")
    public Product createProductControllers(@RequestBody Product product){
        return productServices.createProductServices(product);
    }

}
