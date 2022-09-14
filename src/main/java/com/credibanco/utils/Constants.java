package com.credibanco.utils;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
public enum Constants {
    SUCCESS("00", "Éxito"),
    FAILED("01", "Fallido"),
    CREATED("02", "Creada"),
    DEFAULT_MESSAGE_NOT_NULL("03","can not be null"),
    DEFAULT_MESSAGE_NOT_EMPTY("04","it cant be empty");
    private final String code;
    private final String message;
}