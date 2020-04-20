package kss.sprringframework.beerbrewery.web.controller.v2;

import kss.sprringframework.beerbrewery.services.v2.BeerService2;
import kss.sprringframework.beerbrewery.web.controller.BeerController;
import kss.sprringframework.beerbrewery.web.model.Beer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(BeerController2.BEER_CONTROLLER_URL)
public class BeerController2 {
    public static final String BEER_CONTROLLER_URL = "/api/v2/beer";
    private final BeerService2 beerService;

    public BeerController2(BeerService2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity getBeerById(@PathVariable("beerId") UUID beerId){
        Beer beerById = beerService.getBeerById(beerId);
        return new ResponseEntity(beerById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody Beer beer){
        Beer new_beer = beerService.saveNewBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", BEER_CONTROLLER_URL + "/" + new_beer.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer){
        beerService.updateBeer(beerId, beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("delete method calls");
        beerService.deleteBeerById(beerId);
    }
}
