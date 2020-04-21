package kss.sprringframework.beerbrewery.web.controller.v2;

import kss.sprringframework.beerbrewery.services.CustomerService;
import kss.sprringframework.beerbrewery.web.controller.CustomerController;
import kss.sprringframework.beerbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(CustomerController2.CUSTOMER_CONTROLLER_URL2)
public class CustomerController2 {
    public static final String CUSTOMER_CONTROLLER_URL2 = "/api/v2/customer";
    public static final String CUSTOMER_GET_BY_ID = "/{customerID}";

    private final CustomerService customerService;

    public CustomerController2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({CUSTOMER_GET_BY_ID})
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerID") UUID customerId){
        CustomerDto customerDtoById = customerService.getCustomerById(customerId);
        return new ResponseEntity(customerDtoById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNewCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = customerService.saveNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", CUSTOMER_CONTROLLER_URL2 + "/" + customerDto1.getId());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({CUSTOMER_GET_BY_ID})
    public void updateCustomer(@PathVariable("customerID") UUID customerId, @Valid @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }
    @DeleteMapping({CUSTOMER_GET_BY_ID})
    public void deleteCustomerById(@PathVariable("customerID") UUID customerId){
        customerService.deleteCustomerById(customerId);
    }

}

