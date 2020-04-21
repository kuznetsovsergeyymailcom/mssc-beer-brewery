package kss.sprringframework.beerbrewery.web.mappers;

import kss.sprringframework.beerbrewery.web.domain.Customer;
import kss.sprringframework.beerbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto dto);
    CustomerDto customerToCUstomerDto(Customer customer);
}
