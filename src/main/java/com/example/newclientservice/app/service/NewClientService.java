package com.example.newclientservice.app.service;


import com.example.newclientservice.app.connector.FeignConnector;
import com.example.newclientservice.app.connector.FeignUpdateConnector;
import com.example.newclientservice.app.controller.NewClientController;
import com.example.newclientservice.app.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class NewClientService {

    private final FeignConnector feignConnector;
    private final FeignUpdateConnector feignUpdateConnector;
    private final RestTemplate restTemplate;

    private final Logger LOG = Logger.getLogger(NewClientController.class.getName());

    public NewClientService(FeignConnector feignConnector, FeignUpdateConnector feignUpdateConnector, RestTemplate restTemplate) {
        this.feignConnector = feignConnector;
        this.feignUpdateConnector = feignUpdateConnector;
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getAllDataFromFallback")
    public List<Book> getAllData() {
        return feignConnector.getAllBooksList();
    }

    public List<Book> getAllDataFromFallback() {
        return feignUpdateConnector.getAllBooksList();
    }

}