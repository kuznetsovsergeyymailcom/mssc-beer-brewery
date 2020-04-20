package kss.sprringframework.beerbrewery.web.controller;

import kss.sprringframework.beerbrewery.services.CustomerService;
import kss.sprringframework.beerbrewery.web.model.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(CustomerController.CUSTOMER_CONTROLLER_URL)
public class CustomerController {
    public static final String CUSTOMER_CONTROLLER_URL = "/api/v1/customer";
    public static final String CUSTOMER_GET_BY_ID = "/{customerID}";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({CUSTOMER_GET_BY_ID})
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerID") UUID customerId){
        Customer customerById = customerService.getCustomerById(customerId);
        return new ResponseEntity(customerById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.saveNewCustomer(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", CUSTOMER_CONTROLLER_URL);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    @PutMapping({CUSTOMER_GET_BY_ID})
    public void updateCustomer(@PathVariable("customerID") UUID customerId, @RequestBody Customer customer){
        customerService.updateCustomer(customerId, customer);
    }
    @DeleteMapping({CUSTOMER_GET_BY_ID})
    public void deleteCustomerById(@PathVariable("customerID") UUID customerId){
        customerService.deleteCustomerById(customerId);
    }

}
