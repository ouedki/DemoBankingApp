package com.yassine.modeles;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("W")
public class WithdrawalTransaction extends Transaction {

	public WithdrawalTransaction() {
		super();
	}

	public WithdrawalTransaction(Date date, double amount, Account account) {
		super(date, amount, account);
		// TODO Auto-generated constructor stub
	}

	
	
}
