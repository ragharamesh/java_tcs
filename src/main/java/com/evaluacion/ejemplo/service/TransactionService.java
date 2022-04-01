package com.evaluacion.ejemplo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.ejemplo.model.Transaction;
import com.evaluacion.ejemplo.repository.TransactionRepo;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepo TransactionRepo;
	
	public List<Transaction> getTransactions()
	{
		return TransactionRepo.findAll();
	}
	
	public Transaction save(Transaction Transaction) {

		return TransactionRepo.save(Transaction);
	}
	
	public void delete(int id)
	{
		TransactionRepo.deleteById(id);
	}

	//updating a record
	public void update(Transaction Transaction, int id)
	{
		
		
		
		TransactionRepo.save(Transaction);
	}

	public Optional<Transaction> findById(Integer id) {				
		
		return TransactionRepo.findById(id);
	}
}
