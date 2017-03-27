package com.pankajsoni.microservice.servicecommunication.rest;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.pankajsoni.microservice.servicecommunication.service.AccountServicePersistentImpl;

@Named
@Path("/")
public class AccountRestController {

//	// @Autowired
//
	private static AccountServicePersistentImpl accServicePersistentImpl = new AccountServicePersistentImpl();
//
//	static {
//
//		accServicePersistentImpl.createDummyAccounts();
//
//	}

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

	@PUT
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
