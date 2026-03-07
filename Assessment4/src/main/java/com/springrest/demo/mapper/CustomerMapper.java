package com.springrest.demo.mapper;

import com.springrest.demo.dto.CustomerRequestDTO;
import com.springrest.demo.dto.CustomerResponseDTO;
import com.springrest.demo.model.Customer;

public class CustomerMapper {

    public static Customer toEntity(CustomerRequestDTO dto) {

        Customer customer = new Customer();

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setAddress(dto.getAddress());

        return customer;
    }

    public static CustomerResponseDTO toDTO(Customer customer) {

        CustomerResponseDTO dto = new CustomerResponseDTO();

        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setAddress(customer.getAddress());

        return dto;
    }
}