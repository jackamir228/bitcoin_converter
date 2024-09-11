package com.example.bitcoin_converter;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateTest {
    public static void main(String[] args) {
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity
                .get(url)
                .build();
        ResponseEntity<Map> responseEntity = restTemplate.exchange(request, Map.class);
        System.out.println(responseEntity);
    }
}
