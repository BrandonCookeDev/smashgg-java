package com.smashggjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    private String id;
    private String name;
    private boolean isCommon;
    private int videoGameId;

    public Character() {
        // JSON initializer
    }

    public Character(String id, String name, boolean isCommon, Integer videoGameId) {
        this.id = id;
        this.name = name;
        this.isCommon = isCommon;
        this.videoGameId = videoGameId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCommon() {
        return isCommon;
    }

    public int videoGameId() {
        return videoGameId;
    }

    @Override
    public String toString() {
        return "Character " + name;
    }
}