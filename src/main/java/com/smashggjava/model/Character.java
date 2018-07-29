package com.smashggjava.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smashggjava.controller.GGController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private static final Logger LOG = LoggerFactory.getLogger(Character.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    private String id;
    private String name;
    private boolean isCommon;
    private Integer videoGameId;

    public Character() {
        // JSON initializer  
    }

    public Character(String id, String name, boolean isCommon, Integer videoGameId) {
        this.id = id;
        this.name = name;
        this.isCommon = isCommon;
        this.videoGameId = videoGameId;
    }

    public Optional<Character> getCharacterById(String id) throws IOException {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("id", id);
        LOG.info("Getting character by id... ", id);
        Optional<String> resBody = GGController.getObject("characters", Optional.of(queryParams));
        if (resBody.isPresent()) {
            String body = resBody.get();
            Character c = mapper.readValue(body, Character.class);
            LOG.info("Created character ... ", c.toString());
            return Optional.of(c);
        }
        return Optional.empty();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCommon() {
        return isCommon;
    }

    public void setIsCommon(boolean isCommon) {
        this.isCommon = isCommon;
    }

    public int videoGameId() {
        return videoGameId;
    }

    public void setVideoGameId(Integer videoGameId) {
        this.videoGameId = videoGameId;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Character : { \n");
        s.append("Id: " + id + " \n");
        s.append("Name: " + name + " \n");
        s.append("IsCommon: " + isCommon + " \n");
        s.append("Video Game Id: " + videoGameId + "\n}");
        return s.toString();
    }
}