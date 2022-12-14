package com.credibanco.entities;

import lombok.*;
import javax.persistence.*;

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
    @Column(name = "number_card")
    private Long numberCard;
    @Column(name = "headline")
    private String headline;
    @Column(name = "identification_card")
    private String identificationCard;
    @Column(name = "type")
    private String type;
    @Column(name = "phone")
    private Integer phone;
    @Column(name ="status")
    private String status;
}
