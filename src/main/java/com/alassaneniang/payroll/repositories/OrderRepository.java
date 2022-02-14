package com.alassaneniang.payroll.repositories;

import com.alassaneniang.payroll.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
