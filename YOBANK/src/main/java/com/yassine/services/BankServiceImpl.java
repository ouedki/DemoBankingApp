package com.yassine.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yassine.dao.AccountRepositoryDao;
import com.yassine.dao.TransactionRepositoryDao;
import com.yassine.modeles.Account;
import com.yassine.modeles.CheckingAccount;
import com.yassine.modeles.DepositTransaction;
import com.yassine.modeles.Transaction;
import com.yassine.modeles.WithdrawalTransaction;
@Service
@Transactional
public class BankServiceImpl implements IBankService {
	@Autowired
	private AccountRepositoryDao accountRepositoryDao;
	@Autowired
	private TransactionRepositoryDao transactionRepositoryDao;
	
	@Override
	public Account checkAccount(String accId) {
		Account acc = accountRepositoryDao.findOne(accId);
		if(acc==null) {
			throw new RuntimeException("Account Not Found");
		}
		return acc;
	}

	@Override
	public void deposit(String accId, double amount) {
		Account acc = checkAccount(accId);
		DepositTransaction deposit = new DepositTransaction(new Date(), amount, acc);
		transactionRepositoryDao.save(deposit);
		acc.setBalance(acc.getBalance()+amount);
		accountRepositoryDao.save(acc);
	}

	@Override
	public void withdraw(String accId, double amount) {
		Account acc = checkAccount(accId);
		double overdraft = 0;
		if (acc instanceof CheckingAccount) {
			overdraft = ((CheckingAccount)acc).getMinBalance() + acc.getBalance();
			if(amount > overdraft) throw new RuntimeException("Unavailable Balance");
		}
		WithdrawalTransaction withdraw = new WithdrawalTransaction(new Date(), amount, acc);
		transactionRepositoryDao.save(withdraw);
		acc.setBalance(acc.getBalance()-amount);
		accountRepositoryDao.save(acc);
		
	}

	@Override
	public void transfer(String acc1, String acc2, double amount) {
		if(acc1.equals(acc2)) {
			throw new RuntimeException("Invalide Transaction, choose a different account");
		}
		withdraw(acc1, amount);
		deposit(acc2, amount);
	}

	@Override
	public Page<Transaction> getTransactions(String accId, int page, int size) {
		return transactionRepositoryDao.getTransactions(accId, new PageRequest(page, size));
	}

}
