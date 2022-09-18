package com.credibanco.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_number")
    private Integer code;
    @Column(name = "number_card")
    private Long numberCard;
    @Column(name = "reference_number")
    private Long referenceNumber;
    @Column(name = "total_purchase")
    private Double totalPurchase;
    @Column(name = "address")
    private String address;
}
