package com.pankajsoni.microservice.servicecommunication.service;

import java.util.List;

import com.pankajsoni.microservice.servicecommunication.rest.Account;

public interface AccountService {
	public List<Account> getAccountList() ;
	public Account getAccount(long accountNumber) ;
	public Account createAccount(Account account) ;
	public Account updateAccount(Account account) ;
	public Account deleteAccount(long accountNumber) ;

}
