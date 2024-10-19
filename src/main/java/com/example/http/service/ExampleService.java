package com.example.http.service;

import com.example.http.models.ExampleResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class ExampleService {

    public ExampleResponse post(String requestedIP, String reachedIp) {
        return new ExampleResponse(requestedIP, Instant.now(), reachedIp);
    }
}
