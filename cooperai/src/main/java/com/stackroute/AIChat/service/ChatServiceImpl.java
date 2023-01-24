package com.stackroute.AIChat.service;

import com.stackroute.AIChat.model.ReqModel;
import com.stackroute.AIChat.model.ResModel;
import com.stackroute.AIChat.model.moderation.ModerationReq;
import com.stackroute.AIChat.model.moderation.ModerationRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatServiceImpl implements IChatService {

    @Value("${api-key}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Override
    public String getResponse(String question) {

        //URL
        String url = "https://api.openai.com/v1/completions";

        // Headers info
        headers.set("Host", "<calculated when request is sent>");
        headers.set("User-Agent", "PostmanRuntime/7.29.2");
        headers.set("Accept", "*/*");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", apiKey);

        // Request model
        ReqModel reqModel = new ReqModel();
        reqModel.setModel("text-davinci-003");
        reqModel.setPrompt(question);
        reqModel.setTemperature(0.7);
        reqModel.setMax_tokens(256);
        reqModel.setTop_p(1);
        reqModel.setFrequency_penalty(0);
        reqModel.setPresence_penalty(0);

        // Make a post call to third party api
        HttpEntity entity = new HttpEntity(reqModel, headers);
        ResModel data = restTemplate.exchange(url, HttpMethod.POST, entity, ResModel.class).getBody();
        String response = data.getChoices().get(0).getText();

        return response;
    }

    @Override
    public boolean moderate(String question) {
        System.out.println("API key:"+apiKey);
        //URL
        String url = "https://api.openai.com/v1/moderations";

        // Headers info
        headers.set("Host", "<calculated when request is sent>");
        headers.set("User-Agent", "PostmanRuntime/7.29.2");
        headers.set("Accept", "*/*");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", apiKey);

        // Request model
        ModerationReq modReq = new ModerationReq();
        modReq.setInput(question);

        // Make a post call to third party api
        HttpEntity entity = new HttpEntity(modReq, headers);
        ModerationRes data = restTemplate.exchange(url, HttpMethod.POST, entity, ModerationRes.class).getBody();
        boolean flagged = data.getResults().get(0).isFlagged();
        return flagged;
    }
}
