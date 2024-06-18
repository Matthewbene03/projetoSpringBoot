package com.matthews.projetoCourse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matthews.projetoCourse.entidades.OrderItem;
import com.matthews.projetoCourse.entidades.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
