package com.evaluacion.ejemplo.dto;

import com.evaluacion.ejemplo.model.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	private Integer ideAccount;
	private String numAccount;
	
	public Account toEntity() {
		return new Account(ideAccount,numAccount);
	}
}
