package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomer(UUID id);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomer(UUID customerId);
}
