package com.osho.exchangeservice.service;

import com.osho.exchangeservice.model.Exchange;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ExchangeService {

//    public static final String ACCESS_KEY = "fJpXTOFjlF1oHbC2pUH1g4SbMI7NNy1z";
//    public static final String BASE_URL = "https://api.apilayer.com/currency_data/";
//    public static final String ENDPOINT = "convert";
    // Example: "https://api.apilayer.com/currency_data/convert?to=EUR&from=SEK&amount=1000"

    public Exchange getExchangeInfo(double amount) throws IOException, JSONException {
        System.out.println("I am in exchange-service Service class method");

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
//                .url("https://api.apilayer.com/currency_data/convert?to={to}&from={from}&amount={amount}")
                .url("https://api.apilayer.com/currency_data/convert?to=SEK&from=EUR&amount=" + amount)
                .addHeader("apikey", "fJpXTOFjlF1oHbC2pUH1g4SbMI7NNy1z")
                .build();

        Response response = client.newCall(request).execute();
        JSONObject jo = new JSONObject(response.body().string()); // string(), NOT toString()

        // Control printouts
//        System.out.println(response.body().string());
//        System.out.println(jo.getDouble("result"));

        // Pass in returned values into exchange object and return to requesting TW CAR PROJECT
        Exchange exchangedReturned = new Exchange(amount, "SEK", "EUR", jo.getDouble("result"));
        return exchangedReturned;


    }


}
