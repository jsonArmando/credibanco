package com.credibanco.repository;

import com.credibanco.entities.TransactionRegister;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRegisterRepository extends CrudRepository<TransactionRegister, Integer> {
}
