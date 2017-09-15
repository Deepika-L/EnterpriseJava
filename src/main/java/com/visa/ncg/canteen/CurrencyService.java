package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    public CurrencyService() {};

    int convertToGbp(int amount) {
        RestTemplate restTemplate = new RestTemplate();
        String convertUrl = "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";

        Map<String, String> params = new HashMap<>();
        params.put("from", "USD");
        params.put("to", "GBP");
        params.put("amount", Integer.toString(amount));
        ConvertedCurrency conversion = restTemplate
                .getForObject(convertUrl, ConvertedCurrency.class, params);
        return conversion.getConverted();
    }
}
