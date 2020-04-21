package kss.sprringframework.beerbrewery.services;

import kss.sprringframework.beerbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
    CustomerDto saveNewCustomer(CustomerDto beer);
    void updateCustomer(UUID beerId, CustomerDto beer);
    void deleteCustomerById(UUID beerId);
}
