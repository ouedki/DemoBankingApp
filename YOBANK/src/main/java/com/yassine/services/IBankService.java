package com.yassine.services;

import org.springframework.data.domain.Page;

import com.yassine.modeles.Account;
import com.yassine.modeles.Transaction;

public interface IBankService {
	public Account checkAccount (String accId);
	public void deposit(String acc, double amont);
	public void withdraw(String acc, double amount);
	public void transfer(String acc1, String acc2, double amount);
	public Page<Transaction> getTransactions (String acc, int page, int size);

}
