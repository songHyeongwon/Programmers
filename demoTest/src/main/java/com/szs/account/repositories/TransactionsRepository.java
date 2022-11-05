package com.szs.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szs.account.models.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}

