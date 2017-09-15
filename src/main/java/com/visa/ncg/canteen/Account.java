package com.visa.ncg.canteen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
  private int balance;
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String name;

  public Account(int initialAmount) {
    id=null;
    balance = initialAmount;
  }

  public Account() {
    balance = 0;
    id=null;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance){
    this.balance = balance;
  }
  public void setId(Long id) {
      this.id = id;
    }
  public Long getId() {
      return id;
    }

  public String getName(){ return name; }
  public void setName(String name) {this.name = name;}


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
