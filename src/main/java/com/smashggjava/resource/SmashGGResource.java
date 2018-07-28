package com.smashggjava.resource;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.client.RestTemplate;


public class SmashGGResource {
    @Autowired
    private RestTemplate restTemplate;

    private static ObjectMapper mapper = new ObjectMapper();

    private static Logger LOG = LoggerFactory.getLogger(SmashGGResource.class);
    
    public Optional<Character> getAllCharacters() throws IOException {
        String url = "https://api.smash.gg/characters";
        
        String res = restTemplate.getForObject(url, String.class);
        LOG.info(res);
        try {
            Optional<Character> c = Optional.ofNullable(mapper.readValue(res, Character.class));
            return c;
        } catch (IOException e ) {
            LOG.info("Could not create character", e);
            return Optional.empty();
        }
    }
}