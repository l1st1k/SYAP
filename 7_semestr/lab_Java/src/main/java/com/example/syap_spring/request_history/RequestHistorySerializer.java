package com.example.syap_spring.request_history;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class RequestHistorySerializer extends StdSerializer<RequestHistory> {

    public RequestHistorySerializer() {
        this(null);
    }

    public RequestHistorySerializer(Class<RequestHistory> t) {
        super(t);
    }

    @Override
    public void serialize(RequestHistory requestHistory, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("input", requestHistory.getInput());
        jsonGenerator.writeObjectField("result", requestHistory.getResult());
        jsonGenerator.writeNumberField("timestamp", requestHistory.getTimestamp());
        jsonGenerator.writeEndObject();
    }
}