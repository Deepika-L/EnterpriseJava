package com.visa.ncg.canteen;

public class Account {
  private int balance;
  private long id;

  public Account(int initialAmount) {
    id=-1;
    balance = initialAmount;
  }

  public Account() {
    balance = 0;
    id=-1;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance){
    this.balance = balance;
  }
    public void setId(long id) {
      this.id = id;
    }
    public long getId() {
      return id;
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
