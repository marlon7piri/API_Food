package com.apiFood.entities.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(value = "SELECT c FROM Category c WHERE c.id = :idCategory")
    Category obtenerCategoriaPorId(@Param("idCategory") Long idCategory);
}
