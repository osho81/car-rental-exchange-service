package com.osho.exchangeservice.service;

import com.netflix.discovery.converters.Auto;
import com.osho.exchangeservice.model.Exchange;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeService {

//    @Autowired
//    private RestTemplate restTemplate;

    // Test method. Works, returns created object
//    public Exchange getExchangeInfo(double amount, String fromCurrency, String toCurrency) {
//        System.out.println("I am in exchange-service Service class method");
//
//        Exchange exchangedReturned = new Exchange(amount, fromCurrency, toCurrency);
//        return exchangedReturned;
//    }


//    public static final String ACCESS_KEY = "fJpXTOFjlF1oHbC2pUH1g4SbMI7NNy1z";
//    public static final String BASE_URL = "https://api.apilayer.com/currency_data/";
//    public static final String ENDPOINT = "convert";
    // Example: "https://api.apilayer.com/currency_data/convert?to=EUR&from=SEK&amount=1000"

    //    @Value("${apilayer.api.key}") // See application.properties
//    String apiKey; // Use this in parameters, when send in request to the external api
    public Exchange getExchangeInfo(double amount) throws IOException {
        System.out.println("I am in exchange-service Service class method");

        // Redo later so can take in separate variables (amount, sek, eur)
//        final String uri = "https://api.apilayer.com/currency_data/convert?to=EUR&from=SEK&amount=1000";

//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("apikey", "fJpXTOFjlF1oHbC2pUH1g4SbMI7NNy1z");

//        RestTemplate restTemplate = new RestTemplate();
//        Exchange exchange = restTemplate.getForObject("https://api.apilayer.com/currency_data/convert?to=EUR&from=SEK&amount=1000", Exchange.class, "fJpXTOFjlF1oHbC2pUH1g4SbMI7NNy1z");
//
//        System.out.println(exchange);

//        Exchange exchangedReturned = new Exchange(amount, fromCurrency, toCurrency);
//        return exchangedReturned;
//        return null;

        // get JSON response
//        String json = response.getBody();


        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
//                .url("https://api.apilayer.com/currency_data/convert?to={to}&from={from}&amount={amount}")
                .url("https://api.apilayer.com/currency_data/convert?to=SEK&from=EUR&amount=" + amount)
                .addHeader("apikey", "*****************")
                .build();
//                .method("GET", }).build();

        Response response = client.newCall(request).execute();
//        String json = response.body().string();
//        Exchange exchangedReturned = new Exchange(amount, response.body(), toCurrency);
        System.out.println(response.body().string());

        return null;


    }


}
