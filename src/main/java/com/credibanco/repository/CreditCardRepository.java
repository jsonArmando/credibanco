package com.credibanco.repository;

import com.credibanco.entities.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository  extends CrudRepository<CreditCard, Integer> {
}
