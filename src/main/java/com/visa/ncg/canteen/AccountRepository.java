package com.visa.ncg.canteen;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
//    Account findByName(String name);
//    @Query("account.id != 1 and account.balance > 3")
//    Account findByNameAndBalanceGreaterThan(String name, int balance)
}
