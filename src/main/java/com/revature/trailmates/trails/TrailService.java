package com.revature.trailmates.trails;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.trailmates.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.awt.image.RescaleOp;

@Service
@Transactional
public class TrailService {

    @Inject
    private final TrailAPIConnector trailAPIConnector;

    @Inject
    @Autowired
    public TrailService(TrailAPIConnector trailAPIConnector) {
        this.trailAPIConnector = trailAPIConnector;
    }

    public Trail createTrail(String id) {

        JsonNode content = trailAPIConnector.getPlainJSON(id);

        Trail trail = new Trail();
        trail.setId(getId(content));
        /*trail.setName(getName(content));
        trail.setShort_desc(getShort_desc(content));
        trail.setLong_desc(getLong_desc(content));
        trail.setImage_url(getImage_url(content));
        trail.setWebsite_url(getWebsite_url(content));
        trail.setReservationRequired(getReservationRequired(content));
        trail.setArePetsPermitted(getPetsPermitted(content));
        trail.setDoFeesApply(getFeesApply(content));
        trail.setDuration(getDuration(content));*/

        return trail;
    }

    private String getId(JsonNode content) {
        String id = content.get("id").asText();
        return id;
    }
}
