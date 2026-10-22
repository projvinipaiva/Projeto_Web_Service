package com.ProjetoWebService.demo.repositories;

import com.ProjetoWebService.demo.entities.Order;
import com.ProjetoWebService.demo.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {



}
