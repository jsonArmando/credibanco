package com.credibanco.controller;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.dto.TransactionDto;
import com.credibanco.entities.CreditCard;
import com.credibanco.entities.Transaction;
import com.credibanco.exception.CreditCardException;
import com.credibanco.service.CreditCardService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "/api", tags = "CrediBanco")
@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/creditbank")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Slf4j
public class CreditCardController {
    private CreditCardService cardService;
    @PostMapping(value ="/create",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardDto> create(@Valid @RequestBody CreditCard creditCard)
            throws CreditCardException {
        return new ResponseEntity<CreditCardDto>(cardService.create(creditCard),HttpStatus.CREATED);
    }

    @PutMapping(value ="/update/{numberCard}/{numberValidation}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardDto> update(@PathVariable("numberCard") Long numberCard, @PathVariable("numberValidation") Integer numberValidation)
            throws CreditCardException {
        return new ResponseEntity<CreditCardDto>(cardService.findByNumberCardAndNumberValidation(numberCard,numberValidation),HttpStatus.CREATED);
    }

    @GetMapping(value ="/findId/{numberCard}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreditCard>> findId(@PathVariable("numberCard") Long numberCard)
            throws CreditCardException {
        return new ResponseEntity<List<CreditCard>>(cardService.findByNumberCard(numberCard),HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/delete/{numberCard}/{numberValidation}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("numberCard") Long numberCard,Integer numberValidation)
            throws CreditCardException {
            cardService.delete(numberCard,numberValidation);
    }

    @PostMapping(value ="/transaction/create",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDto> createTransaction(@Valid @RequestBody Transaction transaction) throws CreditCardException {
        return new ResponseEntity<TransactionDto>(cardService.create(transaction),HttpStatus.CREATED);
    }
}
