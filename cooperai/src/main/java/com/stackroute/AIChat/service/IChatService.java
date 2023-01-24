package com.stackroute.AIChat.service;

import org.springframework.stereotype.Service;

@Service
public interface IChatService {

    public String getResponse(String question);
    public boolean moderate(String question);
}
