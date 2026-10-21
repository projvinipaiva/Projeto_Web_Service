package com.ProjetoWebService.demo.repositories;

import com.ProjetoWebService.demo.entities.Category;
import com.ProjetoWebService.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}
