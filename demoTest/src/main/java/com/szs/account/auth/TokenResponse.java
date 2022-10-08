package com.szs.account.auth;

import lombok.Data;

@Data
public class TokenResponse {
	public TokenResponse(String token, String string) {
		// TODO Auto-generated constructor stub
		this.accessToken = token;
		this.tokenType = string;
	}
	private String accessToken;
	private String tokenType;
}
