package com.osho.exchangeservice.controller;


import com.osho.exchangeservice.model.Exchange;
import com.osho.exchangeservice.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequestMapping(path = "/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/{amount}")
//    public Exchange sekToEur(@RequestBody Exchange exchange) {
    public Exchange sekToEur(@PathVariable("amount") double amount) {
        System.out.println("I am in exchange-service Controller class method");
//        return exchangeService.getExchangeInfo(exchange.getAmount(), exchange.getFromCurrency(), exchange.getToCurrency());
        Exchange exchange1 = new Exchange(100, "SEK", "EUR");
        return exchange1;
    }

//    @GetMapping("/sekeur/{id}")
//    public Exchange sekToEur(@PathVariable("id") int id) {
//        System.out.println("I am in exchange-service Controller class method");
//        return exchangeService.getExchangeInfo(id);
//    }
}
