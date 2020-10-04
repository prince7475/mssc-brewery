package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDTOV2;
import guru.springframework.msscbrewery.web.services.v2.BeerServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
@Slf4j
public class BeerControllerV2 {

    private final BeerServiceV2 beerServicev2;

    public BeerControllerV2(BeerServiceV2 beerServicev2) {
        this.beerServicev2 = beerServicev2;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POSt - create new beer
    public ResponseEntity handlePost(@RequestBody BeerDTOV2 beerDTOV2){
        log.info("handle Post Request Body {}", beerDTOV2);

        BeerDTOV2 savedDTO = beerServicev2.saveBeer(beerDTOV2);
        HttpHeaders headers = new HttpHeaders();
        // Todo add host name to url
        headers.add("Location","/api/v2/beer" + savedDTO.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTOV2 beerDTOV2){
        beerServicev2.updateBeer(beerId,beerDTOV2);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerServicev2.deleteBeer(beerId);
    }
}
