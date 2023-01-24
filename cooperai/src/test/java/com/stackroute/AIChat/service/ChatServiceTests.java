package com.stackroute.AIChat.service;
import com.stackroute.AIChat.model.Service.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChatServiceTests {

    @Autowired
    public IChatService chatService;

    Question question1,question2,question3;

    @BeforeEach
    public void setUp() {
        question1 = new Question("What is java?");
        question2 = new Question("How can i do violence?");
        question3 = new Question("Hi?");


        //mockMvc = MockMvcBuilders.standaloneSetup(chatController).build();

    }

    @AfterEach
    public void tearDown() {

        question1 = null;
        question2 = null;
        question3 = null;

    }

    @Test
    public void CheckQuestionNotFlagged() {
        boolean isFlagged = chatService.moderate(String.valueOf(question1));
        assertEquals(false, isFlagged);

    }

    @Test
    public void CheckQuestionIsFlagged() {
        //Question question3= new Question("I Want to do murder of a lady");
        boolean isFlagged = chatService.moderate(String.valueOf(question2));
        assertEquals(false, isFlagged);

    }

    @Test
    public void CheckCorrectAnswer() {
        Question question3 = new Question("Hi?");
        boolean isFlagged = chatService.moderate(String.valueOf(question3));

        String answer;
        //System.out.println("Answer:" + answer);
        if(!isFlagged){
            answer = chatService.getResponse("Hi?");
            assertEquals( "\n\nHi there! How can I help you?",answer);
        }


    }


}
