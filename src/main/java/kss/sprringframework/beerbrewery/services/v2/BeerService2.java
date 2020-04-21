package kss.sprringframework.beerbrewery.services.v2;

import kss.sprringframework.beerbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService2 {
    BeerDto getBeerById(UUID id);
    BeerDto saveNewBeer(BeerDto beerDto);
    void updateBeer(UUID beerId, BeerDto beerDto);
    void deleteBeerById(UUID beerId);
}
