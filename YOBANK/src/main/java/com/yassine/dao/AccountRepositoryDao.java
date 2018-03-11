package com.yassine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.modeles.Account;

public interface AccountRepositoryDao extends JpaRepository<Account, String>{

}
