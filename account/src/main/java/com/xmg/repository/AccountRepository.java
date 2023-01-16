package com.xmg.repository;

import com.xmg.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author makui
 * @created 2022/4/2
 **/
public interface AccountRepository extends JpaRepository<Account,Long> {
}
