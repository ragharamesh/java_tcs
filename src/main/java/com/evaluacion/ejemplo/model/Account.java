package com.evaluacion.ejemplo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ide_account;
	private String num_account;
	@OneToMany(mappedBy = "ide_transaction", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transaction> transaction = new ArrayList<>();
}
