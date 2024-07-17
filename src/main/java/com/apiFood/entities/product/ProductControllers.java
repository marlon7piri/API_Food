package com.apiFood.entities.product;


import com.apiFood.entities.category.Category;
import com.apiFood.entities.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RestController
@RequestMapping(path = "/api/products")
public class ProductControllers {

        @Autowired
        private ProductServices productServices;
        @Autowired
        private CategoryRepository categoryRepository;

    @GetMapping()
    public ResponseEntity<Object> getAllProductControllers(){
        Object category =  productServices.getAllProductServices();
        return new ResponseEntity<>(category, HttpStatus.OK);

    }


    @PostMapping("/create")
    public Product createProductControllers(@RequestBody ProductRequest productrequest){
        Category category = categoryRepository.
                findById(productrequest.getCategoryId()).
                orElseThrow(()->new RuntimeException("Category not found"));

        Product product = new Product();


        product.setName(productrequest.getName());
        product.setPrice(productrequest.getPrice());
        product.setQuantity(productrequest.getQuantity());

        product.setCategory(category);





        return productServices.createProductServices(product);
    }

    @GetMapping(value = "/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {

       return productServices.findProductsByCategoryIdNative(categoryId);


    }

   @GetMapping(value="/acabandose")
    public List<Product> findProductLessThanLimit(@RequestParam("quantity") Long quantity){




         return productServices.findProductLessThanLimit(quantity);



    }


}
