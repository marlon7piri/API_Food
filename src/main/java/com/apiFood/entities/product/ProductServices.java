package com.apiFood.entities.product;


import com.apiFood.entities.category.Category;
import com.apiFood.entities.category.CategoryRepository;
import com.apiFood.entities.category.CategoryServices;
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
public class ProductServices {
    HashMap request = new HashMap<>();

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;







    public List<Product> getAllProductServices(){
        return productRepository.findAll();
    }

    public Product createProductServices( Product product){


         return productRepository.save(product);
    }

    public ResponseEntity<Optional> getProductByIdServices(Long productID) {
        Optional productFound = productRepository.findById(productID);


        return new ResponseEntity<>(productFound, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteProductServices(Long productID){
        productRepository.deleteById(productID);

        request.put("message","Deleted succes!");

        return new ResponseEntity<>(request,HttpStatus.OK);
    }
    public List<Product> findProductsByCategoryIdNative(Long categoryId) {

        return productRepository.findProductsByCategoryIdNative(categoryId);

    }

   public List<Product> findProductLessThanLimit(Long quantity){
        return productRepository.findProductLessThanLimit(quantity);

   }

}
