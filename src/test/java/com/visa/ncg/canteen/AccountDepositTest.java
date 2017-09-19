package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountDepositTest {

  @Test
  public void newAccountsHaveZeroBalance() throws Exception {
    Account account = new Account();

    assertThat(account.getBalance())
        .isZero();
  }

  @Test
  public void depositing10DollarsToNewAccountResultsInAccountHaving10Dollars() throws Exception {
    Account account = new Account();

    account.deposit(10);

    assertThat(account.getBalance())
        .isEqualTo(10);
  }

  @Test
  public void deposit5DollarsToAccountWith10DollarBalanceResultsIn15DollarBalance() throws Exception {
    Account account = new Account(10);

    account.deposit(5);

    assertThat(account.getBalance())
        .isEqualTo(15);
  }

  @Test
  public void withdraw3DollarsFromAccountHaving7DollarsResultsIn4DollarBalance() throws Exception {
    Account account = new Account(7);

    account.withdraw(3);

    assertThat(account.getBalance())
        .isEqualTo(4);
  }

  @Test
  public void withdrawMoneyFromAccountWithInsufficientBalanceThrowsException() throws Exception {
    Account account = new Account(2);

    assertThatThrownBy(() -> { account.withdraw(12); })
        .isInstanceOf(InsufficientBalanceException.class);
  }

  @Test
  public void withdrawAllOfAccountBalanceResultsInZeroBalance() throws Exception {
    Account account = new Account(9);

    account.withdraw(9);

    assertThat(account.getBalance())
        .isZero();
  }

  @Test
  public void depositInvalidAmountResultsInException() throws  Exception {
    Account account = new Account();

    assertThatThrownBy(() -> { account.deposit(-1); })
            .isInstanceOf(InvalidDepositException.class);
  }

  @Test
  public void withdralNegativeAmountThowsException() throws Exception {
    Account account = new Account();
    assertThatThrownBy(() -> {account.withdraw(-1);})
            .isInstanceOf(NegativeWithdralException.class);

  }


}
