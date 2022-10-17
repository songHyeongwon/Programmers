package com.szs.account.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
public class Transactions {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="account_id")
    private Long accountId;
    @Column(name ="user_id")
    private Long userId;
    private Long amount;


	@Enumerated(EnumType.STRING)
    private TransactionsType type;
    
    @CreatedDate
    @Column(name ="created_at")
    private LocalDateTime createdAt;
}
