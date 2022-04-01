package com.evaluacion.ejemplo.controller;

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

import com.evaluacion.ejemplo.model.Transaction;
import com.evaluacion.ejemplo.service.TransactionService;

@RestController
@RequestMapping("/api/v1/Transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService TransactionService;

	@GetMapping()
	public List<Transaction> getTransactions() {
		return TransactionService.getTransactions();
	}

	@PostMapping()
	public ResponseEntity<?> postTransaction(@RequestBody Transaction Transaction) {
		return ResponseEntity.status(HttpStatus.CREATED).body(TransactionService.save(Transaction));

	}
	
	
	@DeleteMapping("/{Transactionid}")
	private void deleteTransaction(@PathVariable("Transactionid") int id)
	{
		TransactionService.delete(id);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Transaction> updateTutorial(@PathVariable("id") Integer id, @RequestBody Transaction Transaction) {
	 Optional<Transaction> tutorialData = TransactionService.findById(id);
	 if (tutorialData.isPresent()) {
	  Transaction _Transaction = tutorialData.get();
	  _Transaction.setName(Transaction.getName());
	  _Transaction.setCode(Transaction.getCode());
	  return new ResponseEntity<>(TransactionService.save(_Transaction), HttpStatus.OK);
	 } else {
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	}

}