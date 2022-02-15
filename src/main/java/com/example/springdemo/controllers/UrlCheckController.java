package com.example.springdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//the java extensions will automatically import all necessary code as you type it
@RestController
public class UrlCheckController {
  /* This will be a REST controller, which needs to be imported */
  private final String SITE_IS_UP = "Site is up!";
  private final String SITE_IS_DOWN = "Site is down!";
  private final String INCORRECT_URL = "URL is incorrect";
  private final String SITE_DOES_NOT_EXISTS = "URL does not exists";

  @GetMapping("/check")
  public String getUrlStatusMessage(@RequestParam String url) {
    /* make an http connection (get request) */
    String returnMessage = "";
    try {
      URL urlObj = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();
      if (conn.getResponseCode() < 200 || conn.getResponseCode() > 299) {
        returnMessage = SITE_IS_DOWN;
      } else {
        returnMessage = SITE_IS_UP;
      }
    } catch (MalformedURLException e) {
      returnMessage = INCORRECT_URL;
    } catch (IOException e) {
      // this means the site is down
      returnMessage = SITE_DOES_NOT_EXISTS;
    }
    return returnMessage;
  }
}
