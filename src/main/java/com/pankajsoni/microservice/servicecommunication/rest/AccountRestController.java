package com.pankajsoni.microservice.servicecommunication.rest;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.pankajsoni.microservice.servicecommunication.service.AccountServicePersistentImpl;

@Named
@Path("/")
public class AccountRestController {

	private AccountServicePersistentImpl accServicePersistentImpl ;
	
	@Autowired
	AccountRestController(AccountServicePersistentImpl accServicePersistentImpl){
		this.accServicePersistentImpl = accServicePersistentImpl;
		accServicePersistentImpl.createDummyAccounts();
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAccounts() {
		return accServicePersistentImpl.getAccountList();
	}

	@GET
	@Path("account")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@QueryParam("accountNumber") long accountNumber) {

		return accServicePersistentImpl.getAccount(accountNumber);

	}
	
	@GET
	@Path("account_by_name")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAccount(@QueryParam("account_by_name") String name) {

		return accServicePersistentImpl.getAccountByName(name);

	}

	// 	http://localhost:8081/create_account?accountHolderName=Pankaj Soni&branchName=pune&balance=100
	
	@GET
	@Path("create_account")
	@Produces(MediaType.APPLICATION_JSON)
	public Account createAccount(
			@QueryParam("accountHolderName") String accountHolderName,
			@QueryParam("branchName") String branchName,
			@QueryParam("balance") double balance) {

		Account account = new Account(accountHolderName, branchName, balance);
		account = accServicePersistentImpl.createAccount(account);

		return account;
	}

}
