package com.stackroute.AIChat.controller;

import com.stackroute.AIChat.model.Service.Question;
import com.stackroute.AIChat.model.Service.SerRes;
import com.stackroute.AIChat.service.IChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

//import static org.springframework.boot.autoconfigure.AutoConfigurationImportSelector.logger;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/AIChat")
public class ChatController {

    @Autowired
    IChatService chatService;

    Logger log = LoggerFactory.getLogger(ChatController.class);

    @GetMapping("/greet")
    public String greet() {
        return "Good Morning, Have a nice day";
    }


    @PostMapping("/chat")
    public ResponseEntity<?> chat(@RequestBody Question question) {
        SerRes response = new SerRes();
        String aiQuestion = question.getQuestion();
//        System.out.println("Question:" + aiQuestion);
        String answer;
        boolean isFlagged = chatService.moderate(aiQuestion);
        if (!isFlagged) {
            System.out.println("question not Flagged");
//            logger.info("logger is here :"+aiQuestion);
            answer = chatService.getResponse(aiQuestion);
        } else {
            System.out.println("Question flagged");
            answer = "Your question query contains Harm/Sexual/Violence contents.";
        }

//        answer = chatService.getResponse(aiQuestion);
        response.setAnswer(answer);
        log.info("Question : " + aiQuestion);
        log.info("Answer : " + answer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
