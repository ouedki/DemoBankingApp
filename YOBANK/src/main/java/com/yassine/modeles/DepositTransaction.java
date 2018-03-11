package com.yassine.modeles;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class DepositTransaction extends Transaction {

	public DepositTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepositTransaction(Date date, double amount, Account account) {
		super(date, amount, account);
		// TODO Auto-generated constructor stub
	}

}
