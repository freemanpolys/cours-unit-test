package com.mygglo.Unit.Test.controller;

import com.mygglo.Unit.Test.domain.ApiResponse;
import com.mygglo.Unit.Test.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James Kokou GAGLO on 10/07/2020.
 */
@RestController
public class TestController {
    private final GreetingService greetingService;

    public TestController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public ResponseEntity<ApiResponse> greeting() {
        return ResponseEntity.ok().body(greetingService.helloWorld());
    }
}
