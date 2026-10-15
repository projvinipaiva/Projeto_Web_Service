package com.ProjetoWebService.demo.repositories;

import com.ProjetoWebService.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
