package com.credibanco.service;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.dto.TransactionDto;
import com.credibanco.entities.CreditCard;
import com.credibanco.entities.Transaction;
import com.credibanco.exception.CreditCardException;

import javax.persistence.Column;
import java.util.List;

public interface CreditCardService {
    CreditCardDto create(CreditCard creditCard) throws CreditCardException;

    CreditCardDto findByNumberCardAndNumberValidation(Long numberCard, Integer numberValidation)throws CreditCardException;

    List<CreditCard> findByNumberCard(Long numberCard) throws CreditCardException;

    void delete(Long numberCard, Integer numberValidation)throws CreditCardException;
    TransactionDto create(Transaction transaction) throws CreditCardException;

    TransactionDto cancelTransaction(Long numberCard,Long referenceNumber)throws CreditCardException;
}

