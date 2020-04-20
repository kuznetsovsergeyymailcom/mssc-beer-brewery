package kss.sprringframework.beerbrewery.services;

import kss.sprringframework.beerbrewery.web.model.Beer;
import kss.sprringframework.beerbrewery.web.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID id);
    Customer saveNewCustomer(Customer beer);
    void updateCustomer(UUID beerId, Customer beer);
    void deleteCustomerById(UUID beerId);
}
