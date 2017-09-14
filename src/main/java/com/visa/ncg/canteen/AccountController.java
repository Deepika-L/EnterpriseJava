package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController {

    AccountRepository accountRepository;
    AccountController(AccountRepository accountRepo) {
        accountRepository = accountRepo;
    }

    @GetMapping("/api/accounts/{id}")
    public AccountResponse accountInfo(@PathVariable("id") Long accountId) {
        Account account =accountRepository.findOne(accountId);
        AccountResponse a1 = new AccountResponse();
        a1.setId(account.getId());
        a1.setBalance(account.getBalance());

        return a1;
    }
}
