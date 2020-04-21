package kss.sprringframework.beerbrewery.web.mappers;

import kss.sprringframework.beerbrewery.web.domain.Beer;
import kss.sprringframework.beerbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
