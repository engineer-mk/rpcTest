package com.xmg.repository;

import com.xmg.entity.Order;
import org.springframework.data.jpa.repository.*;

/**
 * @author makui
 * @created 2022/4/2
 **/
public interface ProductRepository extends JpaRepository<Order, Long> {
}
