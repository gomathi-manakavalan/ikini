package com.translator.ikini.request;

public class OpenAIMessage {
    private String role;
    private String content;

    public OpenAIMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }
}
