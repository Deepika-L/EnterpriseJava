package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryTest {

    @Test
    public void findAllShouldReturn2Accounts() {
        List<Account> accounts = new ArrayList<>();

        Account a1 = new Account();
        a1.setId(1L);
        Account a2 = new Account();
        a2.setId(2L);
        accounts.add(a1);
        accounts.add(a2);
        InMemAccountRepository repo = new InMemAccountRepository(accounts);
        assertThat(repo.findAll())
                .hasSize(2);
    }

    @Test
    public void findOneReturnsOne() {
        List<Account> accounts = new ArrayList<>();

        Account a1 = new Account();
        a1.setId(1L);
        Account a2 = new Account();
        a2.setId(2L);
        accounts.add(a1);
        accounts.add(a2);

        InMemAccountRepository repo = new InMemAccountRepository(accounts);
        assertThat(repo.findOne(1L).getId()).isEqualTo(a1.getId());
    }

    @Test
    public void saveAddsAccountToRepo() {
        Account a1 = new Account();
        InMemAccountRepository repo = new InMemAccountRepository();
        assertThat(repo.save(a1)
                .getId()).isEqualTo(1);
    }
}