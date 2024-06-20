// src/main/java/com/example/demo/controller/ChatGPTController.java

package com.translator.ikini.controller;

import com.translator.ikini.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/chatgpt")
public class ChatGPTController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/ask")
    public String askQuestion(@RequestParam String prompt) {
        try {
            return openAIService.getChatGPTResponse(prompt);
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
