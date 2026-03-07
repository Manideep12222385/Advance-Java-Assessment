package com.springrest.demo.service;


import com.springrest.demo.dto.PolicyRequestDTO;
import com.springrest.demo.dto.PolicyResponseDTO;
import com.springrest.demo.model.Customer;
import com.springrest.demo.model.Policy;
import com.springrest.demo.exception.CustomerNotFoundException;
import com.springrest.demo.exception.PolicyNotFoundException;
import com.springrest.demo.mapper.PolicyMapper;
import com.springrest.demo.repository.CustomerRepository;
import com.springrest.demo.repository.PolicyRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    private PolicyRepository policyRepository;
    private CustomerRepository customerRepository;

    public PolicyService(PolicyRepository policyRepository,
                         CustomerRepository customerRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
    }

    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        Policy policy = PolicyMapper.toEntity(dto, customer);

        Policy savedPolicy = policyRepository.save(policy);

        return PolicyMapper.toDTO(savedPolicy);
    }

    public List<PolicyResponseDTO> getAllPolicies() {

        return policyRepository.findAll()
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PolicyResponseDTO getPolicyById(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        return PolicyMapper.toDTO(policy);
    }

    public Page<Policy> getPoliciesWithPagination(Pageable pageable) {

        return policyRepository.findAll(pageable);
    }

    public List<PolicyResponseDTO> getPoliciesByType(String type) {

        return policyRepository.findByPolicyType(type)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByCustomer(Long customerId) {

        return policyRepository.findByCustomerId(customerId)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByPremium(double min, double max) {

        return policyRepository.findByPremiumAmountBetween(min, max)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByCustomerEmail(String email) {

        return policyRepository.findPoliciesByCustomerEmail(email)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void cancelPolicy(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setStatus("CANCELLED");

        policyRepository.save(policy);
    }
}