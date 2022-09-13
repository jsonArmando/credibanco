package com.credibanco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardDto implements Serializable {
    private Integer code;
    private String message;
    private Integer numberValidation;
    private Integer numberCard;
}
