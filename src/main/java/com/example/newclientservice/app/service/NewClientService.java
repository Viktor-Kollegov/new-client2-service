package com.example.newclientservice.app.service;


import com.example.newclientservice.app.connector.FeignConnector;
import com.example.newclientservice.app.controller.NewClientController;
import com.example.newclientservice.app.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class NewClientService {

    private final FeignConnector feignConnector;

    private final RestTemplate restTemplate;

    private final Logger logger = Logger.getLogger(NewClientController.class.getName());

    public NewClientService(FeignConnector feignConnector, RestTemplate restTemplate) {
        this.feignConnector = feignConnector;
        this.restTemplate = restTemplate;
    }

    public List<Book> getAllBooksList() {
        return feignConnector.getAllBooksList();
    }

    public String data() {
        String response = restTemplate.getForObject("http://localhost:8081/data", String.class);
        logger.log(Level.INFO, response);
        return response;
    }

}