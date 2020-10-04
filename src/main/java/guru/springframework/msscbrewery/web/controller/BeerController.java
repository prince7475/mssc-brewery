package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import guru.springframework.msscbrewery.web.services.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
@Slf4j
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POSt - create new beer
    public ResponseEntity handlePost(@RequestBody BeerDTO beerDTO){
        log.info("handle Post Request Body {}", beerDTO);

        BeerDTO savedDTO = beerService.saveBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        // Todo add host name to url
        headers.add("Location","/api/v1/beer" + savedDTO.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO){
        beerService.updateBeer(beerId,beerDTO);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeer(beerId);
    }
}
