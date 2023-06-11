package com.main.demo.insurance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.demo.insurance.entity.Plan;

public interface PlanRepository extends MongoRepository<Plan, String> {

}
