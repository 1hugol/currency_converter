package com.hdevelopers.converter.services;

import com.hdevelopers.converter.controllers.request.QueryRequest;
import com.hdevelopers.converter.controllers.response.QueryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ConverterService {
    @Value("${API_KEY}")
    private String API_KEY;

    public QueryResponse currencyConverter(String to, String from, String amount) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.apilayer.com/exchangerates_data/convert?to=" + to
                + "&from=" + from
                + "&amount=" + amount;

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("apikey", API_KEY);

        HttpEntity headerRequest = new HttpEntity(httpHeaders);

        ResponseEntity<QueryRequest> queryRequest = restTemplate.exchange(
                url,
                HttpMethod.GET,
                headerRequest,
                QueryRequest.class
        );

        if (queryRequest.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(queryRequest.getBody().getResult());
        } else {
            System.out.println("Request Failed");
            System.out.println(queryRequest.getStatusCode());
        }

        QueryResponse queryResponse = currencyConverterResponse(queryRequest.getBody());

        return queryResponse;
    }

    private QueryResponse currencyConverterResponse(QueryRequest queryRequest) {
        QueryResponse queryResponse = new QueryResponse();
        queryResponse.setResult(queryRequest.getResult());
        return queryResponse;
    }
}
