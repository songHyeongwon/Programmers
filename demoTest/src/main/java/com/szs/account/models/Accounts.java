package com.szs.account.models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Accounts {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="user_id")
    private Long userId;
    private String name;
    @CreatedDate
    @Column(name ="created_at")
    private LocalDateTime createdAt;

    public Map<String,Object> toMap() {
    	Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("id", this.id);
        obj.put("userId", this.userId);
        obj.put("name", this.name);
        obj.put("createdAt", this.createdAt);
        return obj;
    }
}
