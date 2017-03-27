package com.pankajsoni.microservice.servicecommunication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pankajsoni.microservice.servicecommunication.entity.AccountEntity;
import com.pankajsoni.microservice.servicecommunication.entity.AccountRepository;
import com.pankajsoni.microservice.servicecommunication.rest.Account;

@Component
public class AccountServicePersistentImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	AccountServicePersistentImpl(AccountRepository accountRepository){
		this.accountRepository = accountRepository ;
	}

	public void createDummyAccounts() {

		AccountEntity accounts = new AccountEntity("Pankaj Soni", "Aundh", 1000);
		accountRepository.save(accounts);
		AccountEntity account2 = new AccountEntity("Madhur Sambhar", "Aundh", 2000);
		accountRepository.save(account2);
		AccountEntity account3 = new AccountEntity("Harsh Agrawal", "Baner", 4000);
		accountRepository.save(account3);
		AccountEntity account4 = new AccountEntity("Shital Agarkar ", "Baner", 10000); //10000 as she works for NICE
		accountRepository.save(account4);

	}

	@Override
	public List<Account> getAccountList() {

		List<Account> accountList = new ArrayList<>();

		for (AccountEntity accountEntity : accountRepository.findAll()) {
			accountList.add(new Account(accountEntity.getAccountNumber(), accountEntity.getAccountHolderName(), 
					accountEntity.getBranchName(), accountEntity.getBalance()));
		}

		return accountList;
	}

	@Override
	public Account getAccount(long accountNumber) {
		AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber);
		
		Account account = null; 
		if (accountEntity != null){
			account = new Account(accountEntity.getAccountNumber(), accountEntity.getAccountHolderName(), accountEntity.getBranchName(), accountEntity.getBalance());
		}
		
		return account ; 
	}
	
	@Override
	public List<Account> getAccountByName(String name) {
		List<AccountEntity>  accountEntityList = accountRepository.findByAccountHolderName(name);
		List<Account> accountList = new ArrayList<>(); 
		
		for (AccountEntity accountEntity : accountEntityList) {
			accountList.add(new Account(accountEntity.getAccountNumber(), accountEntity.getAccountHolderName(), 
					accountEntity.getBranchName(), accountEntity.getBalance()));
		}

		
		
		return accountList ; 
	}

	@Override
	public Account createAccount(Account account) {
		AccountEntity accountPersistent = new AccountEntity(account.getAccountHolderName(), account.getBranchName(),account.getBalance());
		accountRepository.save(accountPersistent);
		account.setAccountNumber(accountPersistent.getAccountNumber());
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		
		AccountEntity accountEntity = accountRepository.findByAccountNumber(account.getAccountNumber());
		accountEntity.setAccountHolderName(account.getAccountHolderName());
		accountEntity.setBranchName(account.getBranchName());
		accountEntity.setBalance(account.getBalance());
		account.setAccountNumber(accountEntity.getAccountNumber());
		return account;
	}

	@Override
	public Account deleteAccount(long accountNumber) {
		AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber);
		accountRepository.delete(accountEntity);
		return new Account(accountEntity.getAccountNumber(), accountEntity.getAccountHolderName(), accountEntity.getBranchName(), accountEntity.getBalance());
	}

}
