package com.stackroute.AIChat.model.moderation;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ModerationReq {
    private String input;

    public ModerationReq() {
    }

    public ModerationReq(String input) {
        this.input = input;
    }

}
