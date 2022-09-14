package com.credibanco.exception;

import java.util.Date;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@Data
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}