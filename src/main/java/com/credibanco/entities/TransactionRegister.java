package com.credibanco.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION_REGISTER")
public class TransactionRegister implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_number")
    private String code;
    @Column(name = "message")
    private String message;
    @Column(name = "transaction_status")
    private String transactionStatus;
    @Column(name = "reference_number")
    private Long referenceNumber;
}