package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountWebController {

    private AccountRepository accountRepository;
    private CurrencyService currencyService;

    @Autowired
    AccountWebController(AccountRepository accountRepo, CurrencyService currService) {
        accountRepository = accountRepo;
        currencyService = currService;
    }

    @GetMapping("/account/{id}")
    public String accountView(@PathVariable("id") String id,
                              Model model) {
        Account acc = accountRepository.findOne(Long.parseLong(id));
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setBalance(acc.getBalance());
        accountResponse.setId(acc.getId());
        accountResponse.setName(acc.getName());

        model.addAttribute("account", accountResponse);

        int convertCurrency = currencyService.convertToGbp(accountResponse.getBalance());
        model.addAttribute("gbpBalance", convertCurrency);

        return "account-view";
    }

    @GetMapping("/account")
    public String allAccount(Model model){
        List<Account> accountsList = (List<Account>) accountRepository.findAll();
        model.addAttribute("accounts", accountsList);
        return "all-accounts";
    }

    @GetMapping("/create-account")
    public String createAccountView(Model model) {
        createForm newForm = new createForm();
        newForm.setInitialDeposit(10);

        model.addAttribute("createForm", newForm);
        return "create-account";
    }

    @PostMapping("/create-account")
    public String createAccount(@ModelAttribute("createForm") createForm filledForm) {
        Account newAccount = new Account();
        newAccount.setName(filledForm.getAccountName());
        newAccount.setBalance(filledForm.getInitialDeposit());
        accountRepository.save(newAccount);

        return "redirect:/account/" + newAccount.getId();
    }

}
