package com.osho.exchangeservice.service;

import com.osho.exchangeservice.model.Exchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeService {

    // Test method. Works, returns created object
//    public Exchange getExchangeInfo(double amount, String fromCurrency, String toCurrency) {
//        System.out.println("I am in exchange-service Service class method");
//
//        Exchange exchangedReturned = new Exchange(amount, fromCurrency, toCurrency);
//        return exchangedReturned;
//    }



    public static final String ACCESS_KEY = "fJpXTOFjlF1oHbC2pUH1g4SbMI7NNy1z";
    public static final String BASE_URL = "https://api.apilayer.com/currency_data/";
    public static final String ENDPOINT = "convert";
    // Example: "https://api.apilayer.com/currency_data/convert?to=EUR&from=SEK&amount=1000"

//    @Value("${apilayer.api.key}") // See application.properties
//    String apiKey; // Use this in parameters, when send in request to the external api
    public Exchange getExchangeInfo(double amount) {
        System.out.println("I am in exchange-service Service class method");

        // Redo later so can take in separate variables (amount, sek, eur)
//        final String uri = "https://api.apilayer.com/currency_data/convert?to=EUR&from=SEK&amount=1000";

        Map<String, String> parameters = new HashMap<>();
        parameters.put("apiKey", "fJpXTOFjlF1oHbC2pUH1g4SbMI7NNy1z");

        RestTemplate restTemplate = new RestTemplate();
        Exchange exchange = restTemplate.getForObject("https://api.apilayer.com/currency_data/convert?to=EUR&from=SEK&amount=1000?api_key={apiKey}", Exchange.class, parameters);

        System.out.println(exchange);

//        Exchange exchangedReturned = new Exchange(amount, fromCurrency, toCurrency);
//        return exchangedReturned;
        return null;


        // get JSON response
//        String json = response.getBody();
    }


}
