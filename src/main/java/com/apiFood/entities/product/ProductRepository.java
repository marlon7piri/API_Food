package com.apiFood.entities.product;

import com.apiFood.entities.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {



     //List<Product> findByCategoryId(Long categoryId);

     // @Query(value = "SELECT p FROM Product p  WHERE p.category = :categoryId")
    //List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM product p WHERE p.category_id = :categoryId",nativeQuery = true)
    List<Product> findProductsByCategoryIdNative(@Param("categoryId") Long categoryId);

  @Query(value = "SELECT * FROM product p WHERE p.quantity < :quantity",nativeQuery = true)
  List<Product> findProductLessThanLimit(@RequestParam("quantity") Long quantity);


}
