package com.credibanco.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTIONS")
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
    @Column(name="date_register")
    private Date date;
}
