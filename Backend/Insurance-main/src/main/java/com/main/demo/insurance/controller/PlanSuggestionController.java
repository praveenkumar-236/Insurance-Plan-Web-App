package com.main.demo.insurance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import com.main.demo.insurance.entity.Request;
import com.main.demo.insurance.service.InsuranceService;

@RestController
@CrossOrigin(value = "*")
public class PlanSuggestionController {

    @Autowired
    public InsuranceService service;


 final String uri = "http://localhost:9090/DecisionService/rest/v1/deployment_configuration/decision_operation";

    String username = "resAdmin";
    String password = "resAdmin";

    @PostMapping("/filtered-plans")
    public ResponseEntity<String> getFilteredPlans(@RequestBody Request request) {
        request.getAllPacks().addAll(service.getAllPlans());

        Map<String, Request> recommendedResponse = new HashMap<>();
        recommendedResponse.put("request", request);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> recommend = restTemplate.postForEntity(uri, recommendedResponse, String.class);

        return recommend;
    }
}

// final String uri = "http://localhost:9090/DecisionService/rest/v1/deployment_configuration/decision_operation";
