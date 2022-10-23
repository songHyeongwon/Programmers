package com.szs.account.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.models.Transactions;
import com.szs.account.models.TransactionsType;
import com.szs.account.repositories.TransactionsRepository;

@Service
public class TransactionsService {

	@Resource
	private TransactionsRepository transactionsRepository;
	public Transactions addTransactions(long accountId, long amount, TransactionsType type, AuthorizedUser authorizedUser) throws Exception {
		
		
		
		Transactions transactions = new Transactions();
		transactions.setAccountId(accountId);
		transactions.setUserId(authorizedUser.getId());
		transactions.setAmount(amount);
		transactions.setType(type);
		return transactionsRepository.save(transactions);
	}

}
