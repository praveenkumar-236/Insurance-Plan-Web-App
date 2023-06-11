package com.main.demo.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.main.demo.insurance.entity.Plan;
import com.main.demo.insurance.service.InsuranceService;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class PlanController {

    private final InsuranceService insuranceService;

    @Autowired
    public PlanController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/addplan")
    public ResponseEntity<String> addPlan(@RequestBody Plan plan) {
        insuranceService.addPlan(plan);
        return new ResponseEntity<>("Plan added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/viewplan")
    public ResponseEntity<List<Plan>> getAllPlans() {
        List<Plan> plans = insuranceService.getAllPlans();
        if (!plans.isEmpty()) {
            return new ResponseEntity<>(plans, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable String id) {
        Plan plan = insuranceService.getPlanById(id);
        if (plan != null) {
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
