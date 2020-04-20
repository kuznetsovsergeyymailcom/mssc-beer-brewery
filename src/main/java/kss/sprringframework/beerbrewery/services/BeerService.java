package kss.sprringframework.beerbrewery.services;

import kss.sprringframework.beerbrewery.web.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
    Beer saveNewBeer(Beer beer);
    void updateBeer(UUID beerId, Beer beer);
    void deleteBeerById(UUID beerId);
}
