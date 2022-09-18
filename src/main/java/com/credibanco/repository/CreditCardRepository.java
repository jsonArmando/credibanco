package com.credibanco.repository;

import com.credibanco.entities.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository  extends CrudRepository<CreditCard, Integer> {
    List<CreditCard> findByNumberCard(Long numberCard);
    CreditCard findByNumberCardAndNumberValidation(Long numberCard, Integer numberValidation);
}
