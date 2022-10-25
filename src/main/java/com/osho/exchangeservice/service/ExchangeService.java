package com.osho.exchangeservice.service;

import com.osho.exchangeservice.model.Exchange;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    public Exchange getExchangeInfo(double amount, String fromCurrency, String toCurrency) {
        System.out.println("I am in exchange-service Service class method");

        Exchange exchangedReturned = new Exchange(amount, fromCurrency, toCurrency);
        return exchangedReturned;
    }


}
