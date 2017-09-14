package com.visa.ncg.canteen;

public class AccountResponse {
    private long id;
    private int balance;

    public AccountResponse(){};

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }
}
