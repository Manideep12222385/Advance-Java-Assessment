package com.springrest.demo.mapper;

import com.springrest.demo.dto.PolicyRequestDTO;
import com.springrest.demo.dto.PolicyResponseDTO;
import com.springrest.demo.model.Policy;
import com.springrest.demo.model.Customer;

public class PolicyMapper {

    public static Policy toEntity(PolicyRequestDTO dto, Customer customer) {

        Policy policy = new Policy();

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setCustomer(customer);
        policy.setStatus("ACTIVE");

        return policy;
    }

    public static PolicyResponseDTO toDTO(Policy policy) {

        PolicyResponseDTO dto = new PolicyResponseDTO();

        dto.setId(policy.getId());
        dto.setPolicyNumber(policy.getPolicyNumber());
        dto.setPolicyType(policy.getPolicyType());
        dto.setPremiumAmount(policy.getPremiumAmount());
        dto.setCoverageAmount(policy.getCoverageAmount());
        dto.setStartDate(policy.getStartDate());
        dto.setEndDate(policy.getEndDate());
        dto.setStatus(policy.getStatus());

        dto.setCustomer(CustomerMapper.toDTO(policy.getCustomer()));

        return dto;
    }
}