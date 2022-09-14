package com.credibanco.entities;

import com.credibanco.utils.Constants;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_number")
    private Integer code;
    @Column(name ="validation_number")
    private Integer numberValidation;
    @Column(name = "card_number",length = 19)
    @Size(min = 16, max = 19)
    private Long numberCard;
    @Column(name = "headline")
    private String headline;
    @Column(name = "identification_card",length = 15)
    @Size(min = 10, max = 15)
    private String identificationCard;
    @Column(name = "type")
    private String type;
    @Column(name ="phone",length = 10)
    @Size(min = 7, max = 10)
    private Integer phone;
    @Column(name ="status")
    private String status;
}
