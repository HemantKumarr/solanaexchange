package com.solanaexchange.project.dao;

import com.solanaexchange.project.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
}
