package com.example.Desafio3.dto;

import java.time.Instant;

public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;



    public CustomError(Instant timestamp, String path, String error, Integer status) {
        this.timestamp = timestamp;
        this.path = path;
        this.error = error;
        this.status = status;
    }

    public CustomError(Instant now, int value, String message, String requestURI) {
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public String getError() {
        return error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
