package com.pankajsoni.microservice.servicecommunication.entity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountEntity, Long> {

	List<AccountEntity> findByBranchName(String branchName);
	List<AccountEntity> findByAccountHolderName(String accountHolderName);
	AccountEntity findByAccountNumber(Long accountNumber);
}