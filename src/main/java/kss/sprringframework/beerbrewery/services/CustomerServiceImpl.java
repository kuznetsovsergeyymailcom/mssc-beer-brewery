package kss.sprringframework.beerbrewery.services;

import kss.sprringframework.beerbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {

        return CustomerDto.builder().id(id).name("New customer").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto beer) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("New customer").build();
    }

    @Override
    public void updateCustomer(UUID beerId, CustomerDto beer) {
        // to do add update logic
    }

    @Override
    public void deleteCustomerById(UUID beerId) {
        // todo add delete logic
    }
}
