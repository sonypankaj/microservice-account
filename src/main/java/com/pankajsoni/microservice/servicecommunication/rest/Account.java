package com.pankajsoni.microservice.servicecommunication.rest;

public class Account {

	private Long accountNumber;
	private String accountHolderName;
	private String branchName;
	private double balance;

	public Account(Long accountNumber, String accountHolderName,
			String branchName, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.branchName = branchName;
		this.balance = balance;
	}

	public Account(String accountHolderName,
			String branchName, double balance) {
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

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

}
