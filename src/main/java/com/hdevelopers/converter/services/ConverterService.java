package com.hdevelopers.converter.services;

import com.hdevelopers.converter.controllers.request.QueryResponse;
import com.hdevelopers.converter.controllers.response.ConverterResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ConverterService {
    @Value("${API_KEY}")
    private String API_KEY;
    @Value("${API_URL}")
    private String API_URL;

    public ConverterResponse currencyConverter(String to, String from, String amount) {

        RestTemplate restTemplate = new RestTemplate();

        String url = API_URL + "exchangerates_data/convert?to=" + to
                + "&from=" + from
                + "&amount=" + amount;

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("apikey", API_KEY);

        HttpEntity headerRequest = new HttpEntity(httpHeaders);

        ResponseEntity<QueryResponse> queryResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                headerRequest,
                QueryResponse.class
        );

        if (queryResponse.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(queryResponse.getBody().getResult());
        } else {
            System.out.println("Request Failed");
            System.out.println(queryResponse.getStatusCode());
        }

        ConverterResponse converterResponse = currencyConverterResponse(queryResponse.getBody());

        return converterResponse;
    }

    private ConverterResponse currencyConverterResponse(QueryResponse queryResponse) {
        ConverterResponse converterResponse = new ConverterResponse();
        converterResponse.setResult(queryResponse.getResult());
        return converterResponse;
    }
}
