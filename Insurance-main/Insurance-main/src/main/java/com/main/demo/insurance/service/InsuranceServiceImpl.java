package com.main.demo.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.demo.insurance.entity.Plan;
import com.main.demo.insurance.repository.PlanRepository;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final PlanRepository planRepository;

    @Autowired
    public InsuranceServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public void addPlan(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public Plan getPlanById(String id) {
        return planRepository.findById(id).orElse(null);
    }
}

