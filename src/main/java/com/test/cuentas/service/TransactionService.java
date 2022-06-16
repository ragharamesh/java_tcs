package com.test.cuentas.service;

import com.test.cuentas.model.Accounts;
import com.test.cuentas.model.Transactions;
import com.test.cuentas.repository.AccountRepository;
import com.test.cuentas.repository.TransactionsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {
  @Autowired
  private TransactionsRepository transactionsRepository;

  public List<Transactions> getTransactions() {
    return transactionsRepository.findAll();
  }

  public Transactions save(Transactions accounts) {
    return transactionsRepository.save(accounts);
  }


  public Optional<Transactions> findById(Integer id) {
    return transactionsRepository.findById(id);
  }


  public void delete(int id) {
    transactionsRepository.deleteById(id);
  }
}

