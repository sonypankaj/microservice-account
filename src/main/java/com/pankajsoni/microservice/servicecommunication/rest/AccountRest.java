package com.pankajsoni.microservice.servicecommunication.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class AccountRest {

	private static List<Account> accountList = new ArrayList<Account>();

	static {

		Account accounts1 = new Account();
		accounts1.setId(1);
		accounts1.setBalance(10000);

		Account accounts2 = new Account();
		accounts2.setId(2);
		accounts2.setBalance(20000);

		Account accounts3 = new Account();
		accounts3.setId(3);
		accounts3.setBalance(30000);

		Account accounts4 = new Account();
		accounts4.setId(4);
		accounts4.setBalance(40000);

		accountList.add(accounts1);
		accountList.add(accounts2);
		accountList.add(accounts3);
		accountList.add(accounts4);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAccounts() {
		return accountList;
	}

	@GET
	@Path("account")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@QueryParam("id") long id) {

		Account account = null;

		for (Account c : accountList) {

			if (c.getId() == id)
				account = c;

		}

		return account;
	}

}
