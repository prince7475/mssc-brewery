package guru.springframework.msscbrewery.web.services.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDTOV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeerById(UUID beerId) {
        return BeerDTOV2.builder().id(UUID.randomUUID())
                .beerName("V2 Bear")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDTOV2 saveBeer(BeerDTOV2 beerDTO) {
        return BeerDTOV2.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 beerDTO) {
        // todo impl - would add a real impl to update beer
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer V2");
    }
}
