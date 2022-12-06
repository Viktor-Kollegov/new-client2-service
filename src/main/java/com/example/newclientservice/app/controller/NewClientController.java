package com.example.newclientservice.app.controller;

import com.example.newclientservice.app.model.Book;
import com.example.newclientservice.app.service.NewClientService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class NewClientController {
    private final NewClientService newClientService;
    private final Environment env;
    private final Logger logger = Logger.getLogger(NewClientController.class.getName());

    public NewClientController(NewClientService newClientService, Environment env) {
        this.newClientService = newClientService;
        this.env = env;
    }

    @RequestMapping("/")
    public String home() {
        String home = "Client-Service running at port: " + env.getProperty("local.server.port");
        logger.info(home);
        return home;
    }

    @GetMapping("/getAllBooksByFeignClient")
    public List<Book> getAllBooksList() {
        logger.info("Get data from database (Feign Client on client-service side)");
        return newClientService.getAllBooksList();
    }

    @GetMapping("/getAllBooksByRestTemplate")
    public String data() {
        logger.info("Get data from database (RestTemplate on client-service side)");
        return newClientService.data();
    }

}
