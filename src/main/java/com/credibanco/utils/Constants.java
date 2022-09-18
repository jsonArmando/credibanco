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
    DEFAULT_MESSAGE_NOT_EMPTY("04","it cant be empty"),
    FAILED_NOT_EXIST("01","Tarjeta no existe"),
    ENROLDADA("00", "Enrolada"),
    RECHAZADA("01","Rechazada"),
    COMPRA_EXITOSA("00","Compra Exitosa"),
    APROBADA("10","Aprobada");
    private final String code;
    private final String message;
}
