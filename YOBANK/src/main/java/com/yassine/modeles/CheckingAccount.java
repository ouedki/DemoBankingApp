package com.yassine.modeles;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class CheckingAccount extends Account {
	private double minBalance;

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public CheckingAccount(String id, double balance, Date creationDate, Customer customer, double minBalance) {
		super(id, balance, creationDate, customer);
		this.minBalance = minBalance;
	}

	public CheckingAccount() {
		super();
	}
	
}
