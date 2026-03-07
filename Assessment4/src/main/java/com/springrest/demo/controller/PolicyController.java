package com.springrest.demo.controller;

import com.springrest.demo.dto.PolicyRequestDTO;
import com.springrest.demo.dto.PolicyResponseDTO;
import com.springrest.demo.service.PolicyService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public PolicyResponseDTO createPolicy(@Valid @RequestBody PolicyRequestDTO dto) {
        return policyService.createPolicy(dto);
    }

    @GetMapping
    public List<PolicyResponseDTO> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicy(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @GetMapping("/type")
    public List<PolicyResponseDTO> getPoliciesByType(@RequestParam String type) {
        return policyService.getPoliciesByType(type);
    }

    @GetMapping("/customer")
    public List<PolicyResponseDTO> getPoliciesByCustomer(@RequestParam Long customerId) {
        return policyService.getPoliciesByCustomer(customerId);
    }

    @GetMapping("/premium")
    public List<PolicyResponseDTO> getPoliciesByPremium(@RequestParam double min,
                                                        @RequestParam double max) {
        return policyService.getPoliciesByPremium(min, max);
    }

    @GetMapping("/email")
    public List<PolicyResponseDTO> getPoliciesByCustomerEmail(@RequestParam String email) {
        return policyService.getPoliciesByCustomerEmail(email);
    }

    @GetMapping("/page")
    public Page<?> getPolicies(Pageable pageable) {
        return policyService.getPoliciesWithPagination(pageable);
    }

    @PutMapping("/cancel/{id}")
    public String cancelPolicy(@PathVariable Long id) {
        policyService.cancelPolicy(id);
        return "Policy cancelled successfully";
    }
}