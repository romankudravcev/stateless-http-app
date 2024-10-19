package com.example.http.controller;

import com.example.http.models.ExampleResponse;
import com.example.http.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Controller
@RequestMapping(value = "/http")
public class ExampleController {
    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping
    public ResponseEntity<ExampleResponse[]> getAll() {
        //create an array of example responses
        ExampleResponse[] exampleResponses = new ExampleResponse[2];

        LocalDateTime localDateTime1 = LocalDateTime.of(2024, 9, 30, 0, 0);
        Instant instant1 = localDateTime1.toInstant(ZoneOffset.UTC);

        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 10, 2, 12, 0);
        Instant instant2 = localDateTime2.toInstant(ZoneOffset.UTC);

        exampleResponses[0] = new ExampleResponse("1", instant1, "2");
        exampleResponses[1] = new ExampleResponse("2", instant2 , "3");

        return ResponseEntity.ok(exampleResponses);
    }

    @PostMapping
    public ResponseEntity<ExampleResponse> post(@RequestBody String requestedIP, HttpServletRequest httpServletRequest) {
        String reachedIp = httpServletRequest.getLocalAddr();
        return ResponseEntity.ok(exampleService.post(requestedIP, reachedIp));
    }
}
