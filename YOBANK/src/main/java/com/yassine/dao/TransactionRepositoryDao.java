package com.yassine.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yassine.modeles.Transaction;

public interface TransactionRepositoryDao extends JpaRepository<Transaction, Long> {
	@Query("select t from Transaction t where t.account.id = :x order by t.date desc")
	public Page<Transaction> getTransactions (@Param("x") String accId, Pageable pageable);
}
