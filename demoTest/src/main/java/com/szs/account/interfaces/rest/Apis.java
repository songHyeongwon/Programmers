package com.szs.account.interfaces.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.auth.JwtTokenProvider;
import com.szs.account.auth.TokenResponse;
import com.szs.account.interfaces.rest.dto.ApiResult;
import com.szs.account.models.Accounts;
import com.szs.account.models.Greeting;
import com.szs.account.models.Transactions;
import com.szs.account.models.TransactionsType;
import com.szs.account.services.AccountsService;
import com.szs.account.services.GreetingService;
import com.szs.account.services.TransactionsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
public class Apis {
	@Resource
	private GreetingService greetingService;
	@Resource
	private AccountsService accountsService;
	@Resource
	private TransactionsService transactionsService;
	@Resource
	private JwtTokenProvider jwtTokenProvider; 

	@GetMapping("/login/{id}/{expire}")
    public ResponseEntity<TokenResponse>  login(@PathVariable long id, @PathVariable long expire) {
		//log.info(authorizedUser.toString());
		AuthorizedUser authorizedUser = new AuthorizedUser(id, expire);
		System.out.println(authorizedUser.toString());
		String token = jwtTokenProvider.createToken(authorizedUser);
		return ResponseEntity.ok().body(new TokenResponse(token, "bearer"));
    }
	
	@GetMapping("/greeting/{greetingId}")
	public ApiResult<String> greeting(@RequestAttribute(required = false) AuthorizedUser authorizedUser,
			@PathVariable long greetingId) {
		return ApiResult.succeed(
				greetingService.getMessage(greetingId).map(Greeting::getMessage).orElse("fallback greeting message!"));
	}

	@PostMapping("/account")
	public ApiResult<Accounts> createAccount(@RequestAttribute(required = false) AuthorizedUser authorizedUser,
			@RequestBody String name) {
		try {
			return ApiResult.succeed(accountsService.createAccounts(authorizedUser, name));
		} catch (Exception e) {
			return ApiResult.failed(e.getMessage());
		}
	}

	@GetMapping("/accounts")
	public ApiResult<List<Accounts>> getAccountsList(
			@RequestAttribute(required = false) AuthorizedUser authorizedUser) {
		return ApiResult.succeed(accountsService.getAccountsList());
	}

	@PostMapping("/api/account/{accountId}/transaction")
	public ApiResult<Transactions> getTransaction(@RequestAttribute(required = false) AuthorizedUser authorizedUser,
			@PathVariable long accountId, @RequestBody long amount, @RequestBody TransactionsType type) {
		try {
			return ApiResult.succeed(transactionsService.addTransactions(accountId, amount, type, authorizedUser));
		} catch (Exception e) {
			return ApiResult.failed(e.getMessage());
		}
	}

}
