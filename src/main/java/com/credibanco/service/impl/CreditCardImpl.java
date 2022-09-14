package com.credibanco.service.impl;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.entities.CreditCard;
import com.credibanco.exception.CreditCardException;
import com.credibanco.mapper.CreditCardMapper;
import com.credibanco.repository.CreditCardRepository;
import com.credibanco.service.CreditCardService;
import com.credibanco.utils.Constants;
import com.credibanco.utils.CreditCardError;
import com.credibanco.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final CreditCardMapper creditCardMapper;
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
}


