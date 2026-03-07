package com.springrest.demo.service;

import com.springrest.demo.dto.CustomerRequestDTO;
import com.springrest.demo.dto.CustomerResponseDTO;
import com.springrest.demo.model.Customer;
import com.springrest.demo.exception.CustomerNotFoundException;
import com.springrest.demo.mapper.CustomerMapper;
import com.springrest.demo.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {

        Customer customer = CustomerMapper.toEntity(dto);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerMapper.toDTO(savedCustomer);
    }

    public List<CustomerResponseDTO> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        return CustomerMapper.toDTO(customer);
    }

    public CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO dto) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setAddress(dto.getAddress());

        Customer updatedCustomer = customerRepository.save(customer);

        return CustomerMapper.toDTO(updatedCustomer);
    }

    public void deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customerRepository.delete(customer);
    }
}
