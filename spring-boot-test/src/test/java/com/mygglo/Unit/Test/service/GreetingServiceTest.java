package com.mygglo.Unit.Test.service;

import com.mygglo.Unit.Test.domain.ApiResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {


    private  WorldService worldservice;

    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        worldservice =  Mockito.mock(WorldService.class);
        Mockito.when(worldservice.world())
                .thenReturn("James");

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult("200");
        Mockito.when(worldservice.worldResponse())
                .thenReturn(apiResponse);

        greetingService = new GreetingService(worldservice);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void helloWorld() {

        ApiResponse response = greetingService.helloWorld();

        assertThat(worldservice.world()).isNotNull();
        assertThat(worldservice.world()).isEqualToIgnoringCase("James");
        assertThat(response.getResult()).isEqualToIgnoringCase("Hello James");

    }

    @Test
    void helloWorldResponse() {

        ApiResponse response = greetingService.helloDakar();
        System.out.println("=== response == " + response);
        assertThat(response.getResult()).isEqualToIgnoringCase("Hello 200");

    }
}
