package com.credibanco.mapper;

import com.credibanco.dto.TransactionDto;
import com.credibanco.entities.TransactionRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(target = "code", source = "code")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "transactionStatus", source = "transactionStatus")
    @Mapping(target = "referenceNumber", source = "referenceNumber")
    TransactionDto toResponse(TransactionRegister transactionRegister);
}
