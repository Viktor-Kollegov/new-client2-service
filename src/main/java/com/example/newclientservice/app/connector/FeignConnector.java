package com.example.newclientservice.app.connector;


import com.example.newclientservice.app.config.FeignConfig;
import com.example.newclientservice.app.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "book-service", url = "${book-service.url}", configuration = FeignConfig.class)
public interface FeignConnector {

    @GetMapping("/show")
    List<Book> getAllBooksList();

}
