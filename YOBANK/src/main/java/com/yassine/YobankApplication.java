package com.yassine;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yassine.dao.AccountRepositoryDao;
import com.yassine.dao.CustomerRepositoryDao;
import com.yassine.dao.TransactionRepositoryDao;
import com.yassine.modeles.Account;
import com.yassine.modeles.CheckingAccount;
import com.yassine.modeles.Customer;
import com.yassine.modeles.DepositTransaction;
import com.yassine.modeles.SavingAccount;
import com.yassine.modeles.WithdrawalTransaction;
import com.yassine.services.IBankService;

@SpringBootApplication
public class YobankApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepositoryDao customerRepositoryDao;
	@Autowired
	private AccountRepositoryDao accountRepositoryDao;
	@Autowired
	private TransactionRepositoryDao transactionRepositoryDao;
	
	@Autowired
	private IBankService bankService;
	
	public static void main(String[] args) {
		SpringApplication.run(YobankApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		Customer c1 = customerRepositoryDao.save(new Customer("Yassine", "yassine@gmail.com", "112233"));
//		Customer c2 = customerRepositoryDao.save(new Customer("Reda", "reda@gmail.com", "222222"));
//		Customer c3 = customerRepositoryDao.save(new Customer("hassan", "hassan@gmail.com", "333333"));
//		Customer c4 = customerRepositoryDao.save(new Customer("Rachid", "rachid@gmail.com", "555555"));
//		
//		Account acc1 = accountRepositoryDao.save(new CheckingAccount("C1", 5000, new Date(), c1, 4000));
//		Account acc2 = accountRepositoryDao.save(new CheckingAccount("C2", 10000, new Date(), c2, 3300));
//		Account acc3 = accountRepositoryDao.save(new SavingAccount("C3", 34000, new Date(), c3, 2.2));
//		Account acc4 = accountRepositoryDao.save(new SavingAccount("C4", 9000, new Date(), c4, 5.2));
//		
//		transactionRepositoryDao.save(new DepositTransaction(new Date(), 888888, acc1));
//		transactionRepositoryDao.save(new DepositTransaction(new Date(), 100000, acc2));
//		transactionRepositoryDao.save(new DepositTransaction(new Date(), 44444, acc3));
//		transactionRepositoryDao.save(new DepositTransaction(new Date(), 22222, acc4));
//		transactionRepositoryDao.save(new DepositTransaction(new Date(), 700, acc1));
//		transactionRepositoryDao.save(new DepositTransaction(new Date(), 23444, acc2));
//		transactionRepositoryDao.save(new DepositTransaction(new Date(), 609, acc3));
//		transactionRepositoryDao.save(new DepositTransaction(new Date(), 1009, acc4));
//		transactionRepositoryDao.save(new WithdrawalTransaction(new Date(), 20000, acc1));
//		transactionRepositoryDao.save(new WithdrawalTransaction(new Date(), 30033, acc2));
//		transactionRepositoryDao.save(new WithdrawalTransaction(new Date(), 600, acc4));
//		
//		bankService.deposit("C1", 77777777);
//		bankService.withdraw("C1", 66666666);
	}
}
