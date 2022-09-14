package com.credibanco.mapper;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.entities.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditCardMapper {
    @Mapping(target = "numberValidation", source = "numberValidation")
    @Mapping(target = "numberCard", source = "numberCard")
    CreditCardDto toResponse(CreditCard creditCard);
}
