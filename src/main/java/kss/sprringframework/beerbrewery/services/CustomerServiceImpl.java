package kss.sprringframework.beerbrewery.services;

import kss.sprringframework.beerbrewery.web.model.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer getCustomerById(UUID id) {

        return Customer.builder().id(id).name("New customer").build();
    }

    @Override
    public Customer saveNewCustomer(Customer beer) {
        return Customer.builder().id(beer.getId()).name("New customer").build();
    }

    @Override
    public void updateCustomer(UUID beerId, Customer beer) {
        // to do add update logic
    }

    @Override
    public void deleteCustomerById(UUID beerId) {
        // todo add delete logic
    }
}
