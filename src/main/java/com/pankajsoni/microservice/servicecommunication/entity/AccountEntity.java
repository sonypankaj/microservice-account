package com.pankajsoni.microservice.servicecommunication.entity;

import org.springframework.data.annotation.Id;

public class AccountEntity {
	private static long nextAccountNumber=1 ;
	@Id
	private String id;  
	private final Long accountNumber;
	private String accountHolderName; 
	private String branchName; 
	private double balance;
	

	public AccountEntity(){
		accountNumber = nextAccountNumber++;
	}

	

	public AccountEntity(String accountHolderName, 
			String branchName, double balance) {
		this();
		this.accountHolderName = accountHolderName;
		this.branchName = branchName;
		this.balance = balance;
		
	}



	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getId() {
		return id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	
	
	


}
