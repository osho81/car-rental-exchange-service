package com.osho.exchangeservice.controller;

import com.osho.exchangeservice.model.Exchange;
import com.osho.exchangeservice.service.ExchangeService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
// path = "/change" to differ it from get-method "/exchange" in twCarRental
@RequestMapping(path = "/change")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/{amount}") // USER ROLE REQUIRED
    public Exchange sekToEur(@PathVariable("amount") double amount) throws IOException, JSONException {
        System.out.println("I am in exchange-service Controller class method"); // Control print
        Exchange exchange = exchangeService.getExchangeInfo(amount);
        return exchange;
    }
}
