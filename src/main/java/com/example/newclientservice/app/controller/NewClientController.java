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
    private final Logger LOG = Logger.getLogger(NewClientController.class.getName());

    public NewClientController(NewClientService newClientService, Environment env) {
        this.newClientService = newClientService;
        this.env = env;
    }

    @RequestMapping("/")
    public String home() {
        String home = "Client2-Service running at port: " + env.getProperty("local.server.port");
        LOG.info(home);
        return home;
    }

    @GetMapping("/getAllData")
    public List<Book> getAllData() {
        LOG.info("Get data from database (Feign Client on client2-service side)");
        return newClientService.getAllData();
    }


}
