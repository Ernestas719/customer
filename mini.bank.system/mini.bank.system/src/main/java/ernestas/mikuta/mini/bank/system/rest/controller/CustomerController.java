package ernestas.mikuta.mini.bank.system.rest.controller;

import ernestas.mikuta.mini.bank.system.rest.dto.CustomerDto;
import ernestas.mikuta.mini.bank.system.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(CustomerController.URL)
@RequiredArgsConstructor
public class CustomerController {

    static final String URL = "/customers";

    private final CustomerService customerService;


//    @PostMapping("/update")
//    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
//        try {
//            return new ResponseEntity<>(customerService.updateCustomer(customerDto));
//        } catch (Exception e) {
//            log.error("customer not found: ", e);
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//        }
//    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        try {
            return new ResponseEntity<>(customerService.saveCustomerAndLinkToAccount(customerDto), HttpStatus.OK);
        } catch (Exception e) {
            log.error("error: ", e);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
