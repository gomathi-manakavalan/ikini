package com.translator.ikini.request;

import java.util.List;

public class OpenAIRequest {
    private String model;
    private List<OpenAIMessage> messages;

    public OpenAIRequest(String model, List<OpenAIMessage> messages) {
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public List<OpenAIMessage> getMessages() {
        return messages;
    }

}
