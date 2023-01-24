package com.stackroute.AIChat.model.moderation;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
public class Result {
    private Categories categories;
    private CategoryScores categoryScores;
    private boolean flagged;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Result() {
    }

    public Result(Categories categories, CategoryScores categoryScores, boolean flagged, Map<String, Object> additionalProperties) {
        this.categories = categories;
        this.categoryScores = categoryScores;
        this.flagged = flagged;
        this.additionalProperties = additionalProperties;
    }

    public boolean isFlagged() {
        return flagged;
    }
}
