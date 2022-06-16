package com.test.cuentas.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nameClient;
	private String numberAccount;
	private String typeAccount;
	private String balance;

	@ManyToOne
	private Transactions transactions;
}
