package com.stackroute.AIChat.model.moderation;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
public class CategoryScores {
    private Double hate;
    private Double hateThreatening;
    private Double selfHarm;
    private Double sexual;
    private Double sexualMinors;
    private Double violence;
    private Double violenceGraphic;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CategoryScores() {
    }

    public CategoryScores(Double hate, Double hateThreatening, Double selfHarm, Double sexual, Double sexualMinors, Double violence, Double violenceGraphic, Map<String, Object> additionalProperties) {
        this.hate = hate;
        this.hateThreatening = hateThreatening;
        this.selfHarm = selfHarm;
        this.sexual = sexual;
        this.sexualMinors = sexualMinors;
        this.violence = violence;
        this.violenceGraphic = violenceGraphic;
        this.additionalProperties = additionalProperties;
    }
}
