package com.example.newclientservice.app.connector;


import com.example.newclientservice.app.config.FeignConfig;
import com.example.newclientservice.app.connector.fallback.BookServiceFallback;
import com.example.newclientservice.app.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "book-service-update", url = "${book-service-update.url}"
        , configuration = FeignConfig.class)
public interface FeignUpdateConnector {

    @GetMapping("/show")
    List<Book> getAllBooksList();

}
