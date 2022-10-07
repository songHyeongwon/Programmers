package com.szs.account.auth;

import lombok.Data;

@Data
public class AuthorizedUser {

	private long id;

	private long expire;

	public AuthorizedUser(Long id2, Long expire2) {
		this.id = id2;
		this.expire = expire2;
	}

	public boolean isExpired() {
		return System.currentTimeMillis() >= expire;
	}
}
