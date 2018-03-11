package com.yassine.modeles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "ACC_TYPE", 
discriminatorType = DiscriminatorType.STRING, length=2)
public abstract class Account implements Serializable {
	@Id
	private String id;
	private double balance;
	private Date creationDate;
	@ManyToOne
	@JoinColumn(name = "CUST_ID")
	private Customer customer;
	@OneToMany(mappedBy = "account", fetch=FetchType.LAZY)
	private Collection<Transaction> transactions;  
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Collection<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public Account(String id, double balance, Date creationDate, Customer customer) {
		super();
		this.id = id;
		this.balance = balance;
		this.creationDate = creationDate;
		this.customer = customer;
	}
	
	public Account() {
		super();
	}
	
	

}
