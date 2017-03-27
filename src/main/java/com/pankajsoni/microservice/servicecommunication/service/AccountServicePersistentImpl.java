package com.pankajsoni.microservice.servicecommunication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pankajsoni.microservice.servicecommunication.entity.AccountEntity;
import com.pankajsoni.microservice.servicecommunication.entity.AccountRepository;
import com.pankajsoni.microservice.servicecommunication.rest.Account;

public class AccountServicePersistentImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	public void createDummyAccounts() {

		AccountEntity accounts = new AccountEntity("Pankaj Soni", "Aundh", 1000);
		accountRepository.save(accounts);
		accounts = new AccountEntity("Madhur Sambhar", "Aundh", 2000);
		accountRepository.save(accounts);
		accounts = new AccountEntity("Harsh Agrawal", "Baner", 4000);
		accountRepository.save(accounts);
		accounts = new AccountEntity("Shital Agarkar ", "Baner", 10000); //10000 as she works for NICE
		accountRepository.save(accounts);

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
		return new Account(accountEntity.getAccountNumber(), accountEntity.getAccountHolderName(), accountEntity.getBranchName(), accountEntity.getBalance());
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
