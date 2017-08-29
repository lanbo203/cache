package com.example.demo.common.model;

/**
 * Created by lanbo on 2017/8/28.
 */
public class Result<T> {

    private boolean success;

    private T data;

    private String error;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
