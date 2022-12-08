package com.example.newclientservice.app.connector.fallback;


import com.example.newclientservice.app.connector.FeignConnector;
import com.example.newclientservice.app.model.Book;
import com.example.newclientservice.app.service.NewClientService;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.logging.Logger;

@Component
public class BookServiceFallback implements FeignConnector {

    private final Logger LOG = Logger.getLogger(BookServiceFallback.class.getName());
    private final NewClientService newClientService;

    public BookServiceFallback(NewClientService newClientService) {
        this.newClientService = newClientService;
    }

    @Override
    public List<Book> getAllBooksList() {
        LOG.info("ERROR: service is not available now");
        LOG.info("Calling book-service-update by Feign Client");
        return newClientService.getAllDataFromFallback();
    }

}
