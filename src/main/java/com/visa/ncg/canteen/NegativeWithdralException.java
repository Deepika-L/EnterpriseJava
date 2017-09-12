package com.visa.ncg.canteen;

public class NegativeWithdralException extends RuntimeException{
    public NegativeWithdralException() {super();}
    public NegativeWithdralException(String msg) {
        super(msg);
    }
}
