/*
 * Name : Madhan Balaji Rao
 * G# : G01374078
 * Email : mbalajir@gmu.edu
 */
//Server status endpoint
package com.example.surveybackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    public String helloRoot() {
        return "Webapp live!";
    }
    @GetMapping("/api/live")
    public String checkHealth() {
        return "API is live and running!";
    }
}
