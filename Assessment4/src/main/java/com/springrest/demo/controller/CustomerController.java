package com.springrest.demo.controller;

import com.springrest.demo.dto.CustomerRequestDTO;
import com.springrest.demo.dto.CustomerResponseDTO;
import com.springrest.demo.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponseDTO createCustomer(@Valid @RequestBody CustomerRequestDTO dto) {
        return customerService.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable Long id,
                                              @RequestBody CustomerRequestDTO dto) {
        return customerService.updateCustomer(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}