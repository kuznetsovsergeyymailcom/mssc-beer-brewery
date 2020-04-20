package kss.sprringframework.beerbrewery.services.v2;

import kss.sprringframework.beerbrewery.web.model.Beer;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BeerService2Impl implements BeerService2 {
    @Override
    public Beer getBeerById(UUID id) {
        return Beer.builder().id(id)
                .beerName("Galaxy beer")
                .beerStyle("Pale ale")
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
