package com.credibanco.controller;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.entities.CreditCard;
import com.credibanco.exception.CreditCardException;
import com.credibanco.service.CreditCardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/v1/creditbank")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@Slf4j
public class CreditCardController {

    private CreditCardService cardService;

    @PostMapping(value ="/create",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardDto> createPatientStatus(@Valid @RequestBody CreditCard creditCard)
            throws CreditCardException {
        cardService.create(creditCard);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
