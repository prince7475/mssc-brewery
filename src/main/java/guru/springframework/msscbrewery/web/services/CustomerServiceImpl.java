package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomer(UUID id) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Prince Donkor")
                .build();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        // todo impl - would add a real impl to update customer
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting a beer");
    }
}
