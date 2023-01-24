package com.stackroute.AIChat.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.AIChat.model.Service.Question;
import com.stackroute.AIChat.service.IChatService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ChatControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Mock
    IChatService chatService;

    @InjectMocks
    ChatController chatController;

    Question question1,question2;

    @BeforeEach
    public void setUp() {
        question1 = new Question("What is java?");
        question2 = new Question("How can i do violence?");


        mockMvc = MockMvcBuilders.standaloneSetup(chatController).build();

    }

    @AfterEach
    public void tearDown() {

        question1 = null;
        question2 = null;

    }


    @Test
    void CheckPostMappingStausOK() throws Exception {
        mockMvc.perform(post("/AIChat/chat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(question1)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }

    @Test
    void CheckPostMappingStatus() throws Exception {
        //String answer = "";
        mockMvc.perform(post("/AIChat/chat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(question2)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

//	@Test
//	void Test3() throws Exception {
//		//when(chatService.moderate(String.valueOf(question1))).thenReturn(true);
//		mockMvc.perform(post("/AIChat/chat")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(jsonToString(question1)))
//				.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//
//	}

    private static String jsonToString(final Object o) throws JsonProcessingException {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(o);
            result = jsonContent;
            return result;

        } catch (JsonProcessingException e) {
            result = "JsonProcessingException";
        }
        return result;
    }


}
