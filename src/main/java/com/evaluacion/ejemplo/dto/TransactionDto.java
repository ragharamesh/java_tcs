package com.evaluacion.ejemplo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

	private Integer ideTransaction;
	private String typTransaction;
	private long valTransaction;
	private AccountDto account;
	
}
