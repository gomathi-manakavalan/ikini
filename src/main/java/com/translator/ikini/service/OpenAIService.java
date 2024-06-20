// src/main/java/com/example/demo/service/OpenAIService.java

package com.translator.ikini.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.translator.ikini.config.OpenAIConfig;
import com.translator.ikini.request.OpenAIMessage;
import com.translator.ikini.request.OpenAIRequest;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenAIService {

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String SYSTEM = "system";
    private static final String SYSTEM_CONTENT = "You are a translating assistant helps to translate any languaage.";
    private static final String USER = "user";
    private static final String USER_CONTENT = "Translate any text to english:";
    private static final String MODAL = "gpt-3.5-turbo";


    @Autowired
    private OpenAIConfig openAIConfig;

    private final OkHttpClient client = new OkHttpClient();

    public String getChatGPTResponse(String translationText) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

    /*    String json = "{\n" +
                "  \"model\": \"gpt-3.5-turbo\",\n" +
                "  \"prompt\": \"" + prompt + "\",\n" +
                "  \"max_tokens\": 150\n" +
                "}";*/

        RequestBody body = RequestBody.create(buildJson(translationText), JSON);
        Request request = new Request.Builder()
                .url(OPENAI_API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + openAIConfig.getApiKey())
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            return response.body().string();
        }
    }

    public String buildJson(String transaltionText) throws JsonProcessingException {
        String appendTranslationText = USER_CONTENT + transaltionText;

        OpenAIMessage systemMessage = new OpenAIMessage(SYSTEM, SYSTEM_CONTENT);
        OpenAIMessage userMessage = new OpenAIMessage(USER, appendTranslationText);

        List<OpenAIMessage> openAIMessageList = new ArrayList<>();
        openAIMessageList.add(systemMessage);
        openAIMessageList.add(userMessage);

        OpenAIRequest openAIRequest = new OpenAIRequest(MODAL, openAIMessageList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(openAIRequest);
    }
}
