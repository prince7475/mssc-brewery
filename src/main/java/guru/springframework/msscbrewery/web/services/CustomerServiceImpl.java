package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomer(UUID id) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Prince Donkor")
                .build();
    }
}
