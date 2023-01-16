package com.xmg.repository;

import com.xmg.entity.Product;
import org.springframework.data.jpa.repository.*;

/**
 * @author makui
 * @created 2022/4/2
 **/
public interface ProductRepository extends JpaRepository<Product,Long> {
}
