package com.ProjetoWebService.demo.repositories;

import com.ProjetoWebService.demo.entities.Order;
import com.ProjetoWebService.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {



}
