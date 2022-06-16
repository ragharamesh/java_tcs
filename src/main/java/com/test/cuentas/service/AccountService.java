package com.test.cuentas.service;

import com.test.cuentas.model.Accounts;
import com.test.cuentas.repository.AccountRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public List<Accounts> getAccounts() {
    return accountRepository.findAll();
  }

  public Accounts save(Accounts accounts) {
    return accountRepository.save(accounts);
  }


  public Optional<Accounts> findById(Integer id) {
    return accountRepository.findById(id);
  }


  public void delete(int id) {
    accountRepository.deleteById(id);
  }
}
