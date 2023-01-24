package com.stackroute.AIChat.model.moderation;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
public class ModerationRes {
    private String id;
    private String model;
    private List<Result> results = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ModerationRes() {
    }

    public ModerationRes(String id, String model, List<Result> results, Map<String, Object> additionalProperties) {
        this.id = id;
        this.model = model;
        this.results = results;
        this.additionalProperties = additionalProperties;
    }
}
