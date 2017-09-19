package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

@Service
public class AccountTransferService {

    public AccountTransferService(){};

    public void transfer(Account source, Account destination, int amount) {
        if (source == null|| destination == null) {
            throw new IllegalArgumentException();
        }
        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        if(source.getBalance() < amount){
            throw new InsufficientFundsException();
        }

        source.withdraw(amount);
        destination.deposit(amount);
    }
}
