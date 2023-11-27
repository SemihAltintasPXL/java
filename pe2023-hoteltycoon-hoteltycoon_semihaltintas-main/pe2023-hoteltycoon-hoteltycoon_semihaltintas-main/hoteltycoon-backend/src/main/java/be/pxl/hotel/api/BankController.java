package be.pxl.hotel.api;

import be.pxl.hotel.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class BankController {

    @Autowired
    private BankService bankService;
    @GetMapping
    public ResponseEntity<Double> getAmmountOfCurrentWallet() {
        return new ResponseEntity<>(bankService.getAmountOfTheCurrentWallet(), HttpStatus.OK);
    }
}
