package com.hdevelopers.converter.controllers;

import com.hdevelopers.converter.controllers.response.ConverterResponse;
import com.hdevelopers.converter.enums.Currency;
import com.hdevelopers.converter.services.ConverterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
public class ConverterController {
    private final ConverterService converterService;

    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<ConverterResponse> currencyConverter (
            @RequestParam("to") Currency to,
            @RequestParam("from") Currency from,
            @RequestParam("amount") String amount
    ) {
        ConverterResponse converterResponse = converterService.currencyConverter(to, from, amount);
        return ResponseEntity.ok().body(converterResponse);
    }
}
