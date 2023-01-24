package com.stackroute.AIChat.model.moderation;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
public class Categories {
    private Boolean hate;
    private Boolean hateThreatening;
    private Boolean selfHarm;
    private Boolean sexual;
    private Boolean sexualMinors;
    private Boolean violence;
    private Boolean violenceGraphic;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Categories() {
    }

    public Categories(Boolean hate, Boolean hateThreatening, Boolean selfHarm, Boolean sexual, Boolean sexualMinors, Boolean violence, Boolean violenceGraphic, Map<String, Object> additionalProperties) {
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
