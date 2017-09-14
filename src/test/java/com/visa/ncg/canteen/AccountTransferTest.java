package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTransferTest {
    @Test
    public void accountTransferTest()  throws Exception {
        AccountTransferService transferService = new AccountTransferService();

        Account a1 = new Account(100);
        Account a2 = new Account(20);

        transferService.transfer(a1,a2,50);

        assertThat(a2.getBalance()).isEqualTo(70);
    }

    @Test
    public void accountTransferFailForInsufficientFundsTest()  throws Exception {
        AccountTransferService transferService = new AccountTransferService();

        Account a1 = new Account(40);
        Account a2 = new Account(20);

        assertThatThrownBy(() -> {transferService.transfer(a1,a2,50);})
                .isInstanceOf(InsufficientFundsException.class);
    }

    @Test
    public void accountTransferFailForNegativeAmountTest()  throws Exception {
        AccountTransferService transferService = new AccountTransferService();

        Account a1 = new Account(40);
        Account a2 = new Account(20);

        assertThatThrownBy(() -> {transferService.transfer(a1,a2,-50);})
                .isInstanceOf(InvalidAmountException.class);
    }


    @Test
    public void accountTransferFailForNullAccountTest()  throws Exception {
        AccountTransferService transferService = new AccountTransferService();

        Account a1 = null ;
        Account a2 = new Account(20);

        assertThatThrownBy(() -> {transferService.transfer(a1,a2,50);})
                .isInstanceOf(IllegalArgumentException.class);
    }
}
