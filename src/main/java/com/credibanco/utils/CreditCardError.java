package com.credibanco.utils;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@ToString
public enum CreditCardError {
    UNEXPECTED_ERROR(0, "Error inesperado."),
    BAD_REQUEST_INVALID_ARGUMENTS(1,"Error de Validacion. Detalle en el campo 'errors'."),
    BAD_REQUEST_INVALID_PARAMETERS(2, "Falta parametro requerido."),
    ENDPOINT_NOT_FOUND(3, "Endpoint no encontrado."),
    RESOURCE_INFORMATION_NOT_FOUND(100, "Recurso Información Tarjeta no encontrada ."),
    RESOURCE_ERROR_TYPE_ID(1, "No corresponde un tipo de identificación valido: "),
    TARJETA_NOT_ENROLADA(101, "Tarjeta no Enrolada."),
    TARJETA_DUPLICADA(102, "Tarjeta duplicada informe al administrador."),
    TARJETA_NOT_EXISTE(103, "Tarjeta no existe"),
    REGISTRO_COMPRA(104, "Registro de la compra no Existe!!!");

    private final Integer code;
    private final String message;

    public HttpStatus getStatus() {
        switch (this) {
            case BAD_REQUEST_INVALID_ARGUMENTS:
            case BAD_REQUEST_INVALID_PARAMETERS:
                return HttpStatus.BAD_REQUEST;
            case ENDPOINT_NOT_FOUND:
            case RESOURCE_INFORMATION_NOT_FOUND:
                return HttpStatus.NOT_FOUND;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
