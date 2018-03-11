package com.yassine.modeles;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue("SA")
public class SavingAccount extends Account{
	private double interest;

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}


	public SavingAccount(String id, double balance, Date creationDate, Customer customer, double interest) {
		super(id, balance, creationDate, customer);
		this.interest = interest;
	}

	public SavingAccount() {
		super();
	}
	
	
}
