package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Galaxy")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beerDTO){
        return BeerDTO.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        // todo impl - would add a real impl to update beer
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer");
    }
}
