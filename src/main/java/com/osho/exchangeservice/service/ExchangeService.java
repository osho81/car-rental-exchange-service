package com.osho.exchangeservice.service;

import com.osho.exchangeservice.model.Exchange;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

// Service class for calling external api layer; external url is:
// "https://api.apilayer.com/currency_data/convert?to={to}&from={from}&amount={amount}"
// Example: "https://api.apilayer.com/currency_data/convert?to=EUR&from=SEK&amount=1000"

@Service
public class ExchangeService {

    // Declare and assign main url-values for http request to external api
    public static final String APIKEY = "fJpXTOFjlF1oHbC2pUH1g4SbMI7NNy1z";
    public static final String BASE_URL = "https://api.apilayer.com/currency_data/";
    public static final String ENDPOINT = "convert";

    public Exchange getExchangeInfo(double amount) throws IOException, JSONException {
        System.out.println("I am in exchange-service Service class method");

        String toCurrency = "EUR";
        String fromCurrency = "SEK";

        // The OkHttp client works well with spring
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Build request with url components; add path-var and other args to the path url
        // and add header with apikey retrieved from https://apilayer.com/
        Request request = new Request.Builder()
                .url(
                        BASE_URL
                        + ENDPOINT
                        + "?to=" +toCurrency
                        + "&from=" + fromCurrency
                        + "&amount=" + amount)
                .addHeader("apikey", APIKEY)
                .build();

        Response response = client.newCall(request).execute();
        JSONObject jo = new JSONObject(response.body().string()); // string(), NOT toString()

        // Pass in returned response values into exchange object; return it to requesting twCarRental service
        Exchange exchangedReturned = new Exchange(amount, fromCurrency, toCurrency, jo.getDouble("result"));
        return exchangedReturned;

    }
}
