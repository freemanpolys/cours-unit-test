package com.mygglo.Unit.Test.domain;

/**
 * Created by James Kokou GAGLO on 10/07/2020.
 */
public class ApiResponse {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "result='" + result + '\'' +
                '}';
    }
}
