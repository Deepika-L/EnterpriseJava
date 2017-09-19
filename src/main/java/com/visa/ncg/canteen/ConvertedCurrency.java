package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

@Service
public class ConvertedCurrency {
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getConverted() {
        return converted;
    }

    public void setConverted(int converted) {
        this.converted = converted;
    }

    private String currency;
    private int converted;
}
