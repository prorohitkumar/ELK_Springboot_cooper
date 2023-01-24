package com.stackroute.AIChat.model.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SerRes {

    private String answer;

    public SerRes() {
    }

    public SerRes(String answer) {
        this.answer = answer;
    }
}
