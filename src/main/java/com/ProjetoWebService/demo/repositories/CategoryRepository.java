package com.ProjetoWebService.demo.repositories;

import com.ProjetoWebService.demo.entities.Category;
import com.ProjetoWebService.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {



}
