package com.example.demo;

import com.main.demo.insurance.entity.Plan;
import com.main.demo.insurance.repository.PlanRepository;
import com.main.demo.insurance.service.InsuranceServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InsuranceServiceImplTest {

    private InsuranceServiceImpl insuranceService;

    @Mock
    private PlanRepository planRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        insuranceService = new InsuranceServiceImpl(planRepository);
    }

    @Test
    void addPlan_ShouldSavePlan() {
        // Arrange
        Plan plan = new Plan();
        
        // Act
        insuranceService.addPlan(plan);
        
        // Assert
        verify(planRepository, times(1)).save(plan);
    }

    @Test
    void getAllPlans_ShouldReturnAllPlans() {
        // Arrange
        List<Plan> plans = new ArrayList<>();
        plans.add(new Plan());
        plans.add(new Plan());

        when(planRepository.findAll()).thenReturn(plans);

        // Act
        List<Plan> result = insuranceService.getAllPlans();

        // Assert
        assertEquals(2, result.size());
        equals( result.get(0).getPlanName());
        equals( result.get(1).getPlanName());
    }

    @Test
    void getPlanById_WithExistingId_ShouldReturnPlan() {
        // Arrange
        Plan plan = new Plan();

        when(planRepository.findById("1")).thenReturn(Optional.of(plan));

        // Act
        Plan result = insuranceService.getPlanById("1");

        // Assert
        assertEquals(plan, result);
    }

    @Test
    void getPlanById_WithNonExistingId_ShouldReturnNull() {
        // Arrange
        when(planRepository.findById("2")).thenReturn(Optional.empty());

        // Act
        Plan result = insuranceService.getPlanById("2");

        // Assert
        assertEquals(null, result);
    }
}
