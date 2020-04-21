package kss.sprringframework.beerbrewery.services.v2;

import kss.sprringframework.beerbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BeerService2Impl implements BeerService2 {
    @Override
    public BeerDto getBeerById(UUID id) {
        return BeerDto.builder().id(id)
                .beerName("Galaxy beer")
                .beerStyle("Pale ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // TODO some logic
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        // todo delete logic
    }
}
