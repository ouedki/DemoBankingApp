package com.yassine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.modeles.Customer;

public interface CustomerRepositoryDao 
extends JpaRepository<Customer, Long>  {

}
