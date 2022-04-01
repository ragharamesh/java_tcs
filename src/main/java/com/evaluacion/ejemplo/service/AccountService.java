package com.evaluacion.ejemplo.service;

import java.util.List;
import java.util.Optional;

import com.evaluacion.ejemplo.dto.AccountDto;
import com.evaluacion.ejemplo.exception.ResourceNotFoundException;

public interface AccountService {

	public List<AccountDto> getCountries();

	public AccountDto saveAccount(AccountDto Account);

	public AccountDto update(AccountDto Account, int id) throws ResourceNotFoundException;

	public void deleteAccount(int id) throws ResourceNotFoundException;

	public Optional<AccountDto> findAccount(Integer id);
}
