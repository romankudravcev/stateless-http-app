package com.example.http.models;

import java.time.Instant;

public class ExampleResponse {
    private String requestedIP;
    private Instant requestTime;
    private String reachedIP;

    public ExampleResponse() {
    }

    public ExampleResponse(String requestedIP, Instant requestTime, String reachedIP) {
        this.requestedIP = requestedIP;
        this.requestTime = requestTime;
        this.reachedIP = reachedIP;
    }

    public String getRequestedIP() {
        return requestedIP;
    }

    public void setRequestedIP(String requestedIP) {
        this.requestedIP = requestedIP;
    }

    public Instant getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Instant requestTime) {
        this.requestTime = requestTime;
    }

    public String getReachedIP() {
        return reachedIP;
    }

    public void setReachedIP(String reachedIP) {
        this.reachedIP = reachedIP;
    }
}