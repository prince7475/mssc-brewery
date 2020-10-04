package guru.springframework.msscbrewery.web.controller;


import guru.springframework.msscbrewery.web.model.CustomerDTO;
import guru.springframework.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID customerId){
        return ResponseEntity.ok(this.customerService.getCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDTO){
        CustomerDTO savedCustomerDTO = customerService.saveCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer" + savedCustomerDTO.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerId,customerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){customerService.deleteCustomer(customerId);}
}
