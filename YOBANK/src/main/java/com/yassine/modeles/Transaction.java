package com.yassine.modeles;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "OPRT_TYPE", 
discriminatorType = DiscriminatorType.STRING, length=1)
public abstract class Transaction implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private double amount;
	@ManyToOne
	@JoinColumn(name="ACC_ID")
	private Account account;
	
	public Transaction() {
		super();
	}


	public Transaction(Date date, double amount, Account account) {
		super();
		this.date = date;
		this.amount = amount;
		this.account = account;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
