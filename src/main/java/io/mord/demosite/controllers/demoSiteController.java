package io.mord.demosite.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoSiteController {

    private final String SITE_IS_UP = "Site is up!";
    private final String SITE_IS_DOWN = "Site is Down!";
    private final String INCORRECT_URL = "URL is Incorrect";


    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String returnMessage = ""; 

        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseStatusNumber = conn.getResponseCode();
            if(responseStatusNumber >= 200 && responseStatusNumber <= 300) {
                returnMessage = SITE_IS_UP;
            } else {
                returnMessage = SITE_IS_DOWN;
            }  
        } catch (MalformedURLException e) {
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            returnMessage = SITE_IS_DOWN;
        }
        return returnMessage;
    }

    
}
