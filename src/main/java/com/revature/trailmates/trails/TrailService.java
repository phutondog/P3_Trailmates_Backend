package com.revature.trailmates.trails;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.trailmates.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrailService {

    @Inject
    private final TrailAPIConnector trailAPIConnector;
    private final TrailRepository trailRepository;

    @Inject
    @Autowired
    public TrailService(TrailAPIConnector trailAPIConnector, TrailRepository trailRepository) {
        this.trailAPIConnector = trailAPIConnector;
        this.trailRepository = trailRepository;
    }



    public List<Trail> searchTrailByName(String name, int page) {
        List<Trail> trails = new ArrayList<>();
        JsonNode temp = trailAPIConnector.getAllPlainJSON(0);

        int total = temp.get("total").asInt();
        for (int i = 0; i < total/10; i++) {
            JsonNode content = trailAPIConnector.getAllPlainJSON(i);

            int totalTemp = content.get("total").asInt() - (i * 10);
            if (totalTemp > 10) {
                for (int j = 0; j < 10; j++) {
                    trails.add(getTrailAPI(content.at("/data").get(j).get("id").asText()));
                }
            }
            else if (totalTemp > 0){
                for (int j = 0; j < totalTemp; j++) {
                    trails.add(getTrailAPI(content.at("/data").get(j).get("id").asText()));
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return trails;
    }

    public List<Trail> getAllTrailsAPI(int page) {
        JsonNode content = trailAPIConnector.getAllPlainJSON(page);
        List<Trail> trails = new ArrayList<>();

        int total = content.get("total").asInt() - (page * 10);
        System.out.println(total);
        if (total > 10) {
            for (int i = 0; i < 10; i++) {
                trails.add(getTrailAPI(content.at("/data").get(i).get("id").asText()));
                addTrail(trails.get(trails.size()-1));
            }
        }
        else if (total > 0){
            for (int i = 0; i < total; i++) {
                trails.add(getTrailAPI(content.at("/data").get(i).get("id").asText()));
                addTrail(trails.get(trails.size()-1));
            }
        }
        return trails;
    }

    public Trail getTrailAPI(String id) {

        JsonNode content = trailAPIConnector.getPlainJSON(id);

        Trail trail = new Trail();
        trail.setId(getId(content));
        trail.setName(getName(content));
        trail.setShort_desc(getShort_desc(content));
        trail.setLong_desc(getLong_desc(content));
        trail.setImage_url(getImage_url(content));
        trail.setWebsite_url(getWebsite_url(content));
        trail.setReservationRequired(getReservationRequired(content));
        trail.setArePetsPermitted(getPetsPermitted(content));
        trail.setDoFeesApply(getFeesApply(content));
        trail.setDuration(getDuration(content));

        return trail;
    }

    private String getId(JsonNode content) {
        String id = content.get("id").asText();
        return id;
    }

    private String getName(JsonNode content) {
        String name = "";
        if (content.at("/relatedParks").get(0) != null)
            name = content.at("/relatedParks").get(0).get("fullName").asText();
        return name;
    }

    private String getShort_desc(JsonNode content) {
        String short_desc = content.get("shortDescription").asText();
        return short_desc;
    }

    private String getLong_desc(JsonNode content) {
        String long_desc = content.get("longDescription").asText();
        return long_desc;
    }

    private String getImage_url(JsonNode content) {
        String image_url = "";
        if (content.at("/images").get(0) != null)
            image_url = content.at("/images").get(0).get("url").asText();
        return image_url;
    }

    private String getWebsite_url(JsonNode content) {
        String web_url = "";
        if (content.at("/relatedParks").get(0) != null)
            web_url = content.at("/relatedParks").get(0).get("url").asText();
        return web_url;
    }

    private Boolean getReservationRequired(JsonNode content) {
        Boolean reservation = content.get("isReservationRequired").asBoolean();
        return reservation;
    }

    private Boolean getPetsPermitted(JsonNode content) {
        Boolean pets = content.get("arePetsPermitted").asBoolean();
        return pets;
    }

    private Boolean getFeesApply(JsonNode content) {
        Boolean fees = content.get("doFeesApply").asBoolean();
        return fees;
    }

    private String getDuration(JsonNode content) {
        String duration = content.get("duration").asText();
        return duration;
    }

    public void addTrail(Trail trail) {
        trailRepository.saveTrailName(trail.getId(), trail.getName(), trail.getShort_desc(), trail.getLong_desc(), trail.getImage_url(), trail.getWebsite_url(), trail.getReservationRequired(), trail.getArePetsPermitted(), trail.getDoFeesApply(), trail.getDuration());
    }
}
