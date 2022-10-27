package com.osho.exchangeservice.controller;


import com.osho.exchangeservice.model.Exchange;
import com.osho.exchangeservice.service.ExchangeService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.io.IOException;

@RestController
@RequestMapping(path = "/change")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

//    @GetMapping("/{amount}")
////    public Exchange sekToEur(@RequestBody Exchange exchange) {
//    public Exchange sekToEur(@PathVariable("amount") double amount) {
//        System.out.println("I am in exchange-service Controller class method");
////        return exchangeService.getExchangeInfo(exchange.getAmount(), exchange.getFromCurrency(), exchange.getToCurrency());
//        Exchange exchange1 = new Exchange(amount, "SEK", "EUR", 0); // 0 temporary
//        return exchange1;
//    }

    @GetMapping("/{amount}")
//    public Exchange sekToEur(@RequestBody Exchange exchange) {
    public Exchange sekToEur(@PathVariable("amount") double amount) throws IOException, JSONException {
        System.out.println("I am in exchange-service Controller class method");
//        return exchangeService.getExchangeInfo(exchange.getAmount(), exchange.getFromCurrency(), exchange.getToCurrency());
        Exchange exchange1 = exchangeService.getExchangeInfo(amount);
        return exchange1;
    }

//    @GetMapping("/sekeur/{id}")
//    public Exchange sekToEur(@PathVariable("id") int id) {
//        System.out.println("I am in exchange-service Controller class method");
//        return exchangeService.getExchangeInfo(id);
//    }
}
