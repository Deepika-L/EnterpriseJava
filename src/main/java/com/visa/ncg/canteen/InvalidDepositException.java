package com.visa.ncg.canteen;

public class InvalidDepositException extends RuntimeException {
        public InvalidDepositException() {
            super();
        }

        public InvalidDepositException(String message) {
            super(message);
        }

}
