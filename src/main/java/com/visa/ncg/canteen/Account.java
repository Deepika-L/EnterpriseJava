package com.visa.ncg.canteen;

public class Account {
  private int balance;

  public Account(int initialAmount) {
    balance = initialAmount;
  }

  public Account() {
    balance = 0;
  }

  public int balance() {
    return balance;
  }

  public void deposit(int amount) {
    if(amount<0) {
      throw new InvalidDepositException();
    }

    balance += amount;
  }

  public void withdraw(int amount) {
    if (amount > balance) {
      throw new InsufficientBalanceException();
    } else if(amount < 0) {
      throw new NegativeWithdralException();
    }
    balance -= amount;
  }
}
