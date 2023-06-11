package com.main.demo.insurance.service;

import java.util.List;

import com.main.demo.insurance.entity.Plan;


public interface InsuranceService {
    void addPlan(Plan plan);
    List<Plan> getAllPlans();
    Plan getPlanById(String id);
}
