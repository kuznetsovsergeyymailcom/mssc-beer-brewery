package kss.sprringframework.beerbrewery.services;

import kss.sprringframework.beerbrewery.web.model.Beer;
import kss.sprringframework.beerbrewery.web.model.v2.BeerStyleEnum;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {
        return Beer.builder().id(id)
                .beerName("Calaxy beer")
                .beerStyle("PALE_ALE")
                .build();
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        return Beer.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, Beer beer) {
        // TODO some logic
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        // todo delete logic
    }
}
