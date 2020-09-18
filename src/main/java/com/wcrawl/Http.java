package com.wcrawl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {

    private static HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static int getRequestCode(String url) throws Exception {
        
        HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(url))
        .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return (response.statusCode());
    }
}