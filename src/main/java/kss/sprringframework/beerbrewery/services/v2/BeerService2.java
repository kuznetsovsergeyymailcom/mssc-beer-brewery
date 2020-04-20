package kss.sprringframework.beerbrewery.services.v2;

import kss.sprringframework.beerbrewery.web.model.Beer;

import java.util.UUID;

public interface BeerService2 {
    Beer getBeerById(UUID id);
    Beer saveNewBeer(Beer beer);
    void updateBeer(UUID beerId, Beer beer);
    void deleteBeerById(UUID beerId);
}
