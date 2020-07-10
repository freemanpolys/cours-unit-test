package com.mygglo.Unit.Test.service;

import com.mygglo.Unit.Test.domain.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Created by James Kokou GAGLO on 10/07/2020.
 */
@Service
public class GreetingService {
    private final  WorldService worldservice;

    public GreetingService(WorldService worldservice) {
        this.worldservice = worldservice;
    }

    public ApiResponse helloWorld(){
        ApiResponse response = new ApiResponse();
        response.setResult("Hello " + worldservice.world());
        return response;
    }

    public ApiResponse helloDakar(){
        ApiResponse response = new ApiResponse();
        ApiResponse worldResponse = worldservice.worldResponse();
        response.setResult("Hello " + worldResponse.getResult());
        return response;
    }
}
