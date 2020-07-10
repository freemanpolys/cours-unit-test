package com.mygglo.Unit.Test.service;

import com.mygglo.Unit.Test.domain.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Created by James Kokou GAGLO on 10/07/2020.
 */
@Service
public class WorldService {

    public String world() {
        return "World";
    }

    public ApiResponse worldResponse() {
        ApiResponse response = new ApiResponse();
        response.setResult("Dakar");
        return response;
    }
}
