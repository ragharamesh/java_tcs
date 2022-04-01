package com.test.cuentas.controller;


import com.test.cuentas.model.Accounts;
import com.test.cuentas.service.AccountService;
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
@RequestMapping("/api/v1/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("")
	public List<Accounts> getAccounts() {
		return accountService.getAccounts();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Accounts accounts) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accounts));

	}

	@PutMapping("/{id}")
	public ResponseEntity<Accounts> updateAccount(@PathVariable("id") Integer id, @RequestBody Accounts accounts) {
		Optional<Accounts> accountData = accountService.findById(id);

		if (accountData.isPresent()) {
			Accounts objAccounts = accountData.get();
			objAccounts.setNameClient(accounts.getNameClient());
			objAccounts.setNumberAccount(accounts.getNumberAccount());
			return new ResponseEntity<>(accountService.save(objAccounts), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	private void deleteCountry(@PathVariable("id") int id)
	{
		accountService.delete(id);
	}
}
