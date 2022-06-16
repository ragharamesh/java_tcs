package com.test.cuentas.repository;


import com.test.cuentas.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

}
