package com.shantimargyatra.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shantimargyatra.service.TelegramService;

@Service
public class TelegramServiceImpl implements TelegramService {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.chat.id}")
    private String chatId;

    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public void sendMessage(String message) {

        String url =
                "https://api.telegram.org/bot"
                + botToken
                + "/sendMessage";

        Map<String, String> request = new HashMap<>();

        request.put("chat_id", chatId);
        request.put("text", message);

        restTemplate.postForObject(
                url,
                request,
                String.class
        );
    }
}