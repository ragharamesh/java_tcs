package com.test.cuentas.controller;

import com.test.cuentas.model.Transactions;
import com.test.cuentas.service.TransactionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
  @Autowired
  private TransactionService transactionService;

  @GetMapping("")
  public List<Transactions> getTransactions() {
    return transactionService.getTransactions();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Transactions> getTransactionById(@PathVariable("id") Integer id) {
    Optional<Transactions> transactionData = transactionService.findById(id);

    if (transactionData.isPresent()) {
      return new ResponseEntity<>(transactionData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping
  public ResponseEntity<?> create(@RequestBody Transactions transactions) {
    return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.save(transactions));

  }

  @PutMapping("/{id}")
  public ResponseEntity<Transactions> updateTutorial(@PathVariable("id") Integer id, @RequestBody Transactions transaction) {
    Optional<Transactions> transactionData = transactionService.findById(id);

    if (transactionData.isPresent()) {
      Transactions objTransaction = transactionData.get();
      objTransaction.setNumberDocument(transaction.getNumberDocument());
      objTransaction.setTransactionBalance(transaction.getTransactionBalance());
      return new ResponseEntity<>(transactionService.save(objTransaction), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  private void deleteCountry(@PathVariable("id") int id)
  {
    transactionService.delete(id);
  }
}
