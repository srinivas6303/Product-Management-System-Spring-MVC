package com.example.PMS_SPRING_MVC;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer>{

    List<Product> findByName(String name);

    List<Product> findByPlace(String place);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.name = :name")
    void deleteByName(@Param("name") String name);

}


