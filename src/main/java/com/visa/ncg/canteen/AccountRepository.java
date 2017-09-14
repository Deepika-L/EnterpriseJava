package com.visa.ncg.canteen;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccountRepository {
    HashMap<Long, Account> accountList;
    AtomicLong current;
    public AccountRepository() {
        accountList = new HashMap<Long, Account>();
        current = new AtomicLong();
    }

    public AccountRepository(List<Account> accounts) {
        accountList = new HashMap<Long, Account>();
        for(Account account : accounts) {
            accountList.put(account.getId(), account);
        }
    }

    public Account findOne(Long id) {
        // returns the Account that has the given id,
        // if there's no Account with that id, return null
        return accountList.get(id);
    }

    public Account save(Account entity) {
        // if account's id is already set, DON'T replace it
        // if the account came in with NO id, replace it with one generated from AtomicLong.
        // return the Account object that must now have its id set
        if(entity.getId() == -1) {
            long id = current.getAndIncrement();

            entity.setId(id);
        }

        accountList.put(entity.getId(), entity);

        return entity;
    }

    public List<Account> findAll() {
        // return all accounts as a List, or an empty List if there are no accounts
        //System.out.println(accountList.size());
        return new ArrayList<Account>(accountList.values());
    }
}
