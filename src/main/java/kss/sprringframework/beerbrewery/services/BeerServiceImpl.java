package kss.sprringframework.beerbrewery.services;

import kss.sprringframework.beerbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID id) {
        return BeerDto.builder().id(id)
                .beerName("Calaxy beer")
                .beerStyle("PALE_ALE")
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
