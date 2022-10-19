package com.szs.account.repositories;

import java.util.List;

import com.szs.account.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM accounts WHERE user_id = ?1")
    long countUser(long id);

    List<Accounts> findAllByOrderByIdDesc();
}

