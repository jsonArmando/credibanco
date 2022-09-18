package com.credibanco.service.impl;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.dto.TransactionDto;
import com.credibanco.entities.CreditCard;
import com.credibanco.entities.Transaction;
import com.credibanco.entities.TransactionRegister;
import com.credibanco.exception.CreditCardException;
import com.credibanco.mapper.CreditCardMapper;
import com.credibanco.mapper.TransactionMapper;
import com.credibanco.repository.CreditCardRepository;
import com.credibanco.repository.TransactionRegisterRepository;
import com.credibanco.repository.TransactionRepository;
import com.credibanco.service.CreditCardService;
import com.credibanco.utils.Constants;
import com.credibanco.utils.CreditCardError;
import com.credibanco.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionRegisterRepository dtoRepository;
    private final CreditCardMapper creditCardMapper;

    private final TransactionMapper transactionMapper;
    @Override
    @Transactional
    public CreditCardDto create(CreditCard creditCard) throws CreditCardException {
        log.debug("create (create prms)" + creditCard);
        var creditDto = new CreditCardDto();
        var lstCreditCard = creditCardRepository.findByNumberCard(creditCard.getNumberCard());

        if(lstCreditCard.size()>0){
            throw new CreditCardException(CreditCardError.UNEXPECTED_ERROR);
        }

        if (CollectionUtils.isEmpty(lstCreditCard)) {

            creditCard.setNumberValidation(Utils.getNumber());
            creditCard.setStatus(Constants.CREATED.getMessage());

            creditCardRepository.save(creditCard);

            creditDto = creditCardMapper.toSave(creditCard);
            creditDto.setCode(Constants.SUCCESS.getCode());
            creditDto.setMessage(Constants.SUCCESS.getMessage());
            creditDto.setNumberCard(Utils.getReplaceChar(creditCard.getNumberCard().toString()));

        }
        return creditDto;
    }

    @Override
    public CreditCardDto findByNumberCardAndNumberValidation(Long numberCard, Integer numberValidation) throws CreditCardException {
        log.debug("create (create findByNumberCardAndNumberValidation)" + numberCard+ " " +numberValidation);
        var creditDto = new CreditCardDto();

        var creditCard = creditCardRepository.findByNumberCardAndNumberValidation(numberCard, numberValidation);

        if (creditCard==null) {
            creditDto.setCode(Constants.FAILED_NOT_EXIST.getCode());
            creditDto.setMessage(Constants.FAILED_NOT_EXIST.getMessage());
        }else{
            creditCard.setStatus(Constants.ENROLDADA.getMessage());

            creditCardRepository.save(creditCard);

            creditDto = creditCardMapper.toSave(creditCard);
            creditDto.setCode(Constants.SUCCESS.getCode());
            creditDto.setMessage(Constants.SUCCESS.getMessage());
        }
        creditDto.setNumberValidation(numberValidation);
        creditDto.setNumberCard(Utils.getReplaceChar(numberCard.toString()));
        return creditDto;
    }

    @Override
    public List<CreditCard> findByNumberCard(Long numberCard) throws CreditCardException {
        if(numberCard==null){
            throw new CreditCardException(CreditCardError.RESOURCE_INFORMATION_NOT_FOUND);
        }
        return  creditCardRepository.findByNumberCard(numberCard);
    }

    @Override
    public void delete(Long numberCard, Integer numberValidation) throws CreditCardException {
        var creditCard = creditCardRepository.findByNumberCardAndNumberValidation(numberCard, numberValidation);
        if(creditCard==null){
            throw new CreditCardException(CreditCardError.RESOURCE_INFORMATION_NOT_FOUND);
        }
        creditCardRepository.delete(creditCard);
    }

    @Override
    public TransactionDto create(Transaction transaction) throws CreditCardException{
        var lstCreditCard = creditCardRepository.findByNumberCard(transaction.getNumberCard());
        var register = new TransactionRegister();
        var dto = new TransactionDto();

        Double reference = (100000 + Math.random() * 999999);
        if(lstCreditCard.size()>1){
            throw new CreditCardException(CreditCardError.TARJETA_DUPLICADA);
        }

        if (CollectionUtils.isEmpty(lstCreditCard)) {
            register.setCode(Constants.RECHAZADA.getCode());
            register.setMessage(CreditCardError.TARJETA_NOT_ENROLADA.getMessage());
            register.setTransactionStatus(Constants.RECHAZADA.getMessage());
            register.setReferenceNumber(reference.longValue());
            dtoRepository.save(register);
            dto= transactionMapper.toResponse(register);

        }else{
            for(CreditCard card:lstCreditCard){
                if(card.getStatus()==Constants.ENROLDADA.getMessage()){

                    transaction.setNumberCard(card.getNumberCard());
                    transaction.setReferenceNumber(reference.longValue());
                    transactionRepository.save(transaction);
                    register.setCode(Constants.COMPRA_EXITOSA.getCode());
                    register.setMessage(Constants.COMPRA_EXITOSA.getMessage());
                    register.setTransactionStatus(Constants.APROBADA.getMessage());
                    register.setReferenceNumber(reference.longValue());

                    dtoRepository.save(register);
                    dto= transactionMapper.toResponse(register);

                }else{
                    throw new CreditCardException(CreditCardError.TARJETA_NOT_ENROLADA);
                }
            }
        }
        return dto;
    }
}


