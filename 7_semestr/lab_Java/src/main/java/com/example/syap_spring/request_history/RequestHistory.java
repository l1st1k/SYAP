package com.example.syap_spring.request_history;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Objects;

@JsonSerialize(using = RequestHistorySerializer.class)
public class RequestHistory implements Serializable {
    private final Object input;
    private final Object result;
    private final long timestamp;

    public RequestHistory(Object input, Object result) {
        this.input = input;
        this.result = result;
        this.timestamp = System.currentTimeMillis();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestHistory that = (RequestHistory) o;
        return input.equals(that.input) && result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, result);
    }

    public Object getInput() {
        return input;
    }

    public Object getResult() {
        return result;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
