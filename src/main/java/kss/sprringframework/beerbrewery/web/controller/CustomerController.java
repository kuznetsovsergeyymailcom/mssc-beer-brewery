package kss.sprringframework.beerbrewery.web.controller;

import kss.sprringframework.beerbrewery.services.CustomerService;
import kss.sprringframework.beerbrewery.web.model.CustomerDto;
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
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerID") UUID customerId){
        CustomerDto customerDtoById = customerService.getCustomerById(customerId);
        return new ResponseEntity(customerDtoById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNewCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = customerService.saveNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", CUSTOMER_CONTROLLER_URL + "/" + customerDto1.getId());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({CUSTOMER_GET_BY_ID})
    public void updateCustomer(@PathVariable("customerID") UUID customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }
    @DeleteMapping({CUSTOMER_GET_BY_ID})
    public void deleteCustomerById(@PathVariable("customerID") UUID customerId){
        customerService.deleteCustomerById(customerId);
    }

}
