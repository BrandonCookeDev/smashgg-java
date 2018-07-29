package com.smashggjava.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Request.Builder;

public class GGController {
    private static final Logger LOG = LoggerFactory.getLogger(Character.class);
    private static final String baseUrl = "https://api.smash.gg/";
    private static final Builder builder = new Request.Builder();
    private static final OkHttpClient client = new OkHttpClient();

    public GGController() {
        
    }

    /**
     * (Potentially trying to make this a universal GET)
     * Returns an optional string after the request is made
     * @param endpoint the endpoint that will be hit
     * @param params A hashmap representing the params and their values
     * 
     * @return A string representing the JSON response of the SmashGG api call
     */
    public static Optional<String> getObject(String endpoint, Optional<HashMap<String, String>> params) {
        Request req = builder
            .url(buildUrl(endpoint, params))
            .build();

        try {
            Response res = client.newCall(req).execute();
            if (res.isSuccessful()) {
                String body = res.body().string();
                res.body().close();
                return Optional.of(body);
            }
            else return Optional.empty();   
        } catch (IOException e) {
            LOG.info("Could not make request...", e);
            return Optional.empty();
        }
    }

    /**
     * Builds a url from a string representing the endpoign to hit and an optional set of params
     * 
     * @param endpoint the enpoint of the request
     * @param queryParams an optional hashmap of query params for the request
     */
    private static HttpUrl buildUrl(String endpoint, Optional<HashMap<String, String>> queryParams) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl + "/" + endpoint).newBuilder();
        if (queryParams.isPresent()) {
            HashMap<String, String> params = queryParams.get();
            params.forEach(((key, val) -> urlBuilder.addQueryParameter(key, val)));
        }
        return urlBuilder.build();
    }
}
