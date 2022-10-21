package com.szs.account.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.models.Accounts;
import com.szs.account.repositories.AccountsRepository;

@Service
public class AccountsService {
  @Resource
  private AccountsRepository accountsRepository;

  private final long MAX_ACCOUNTS = 3L;
  public Accounts createAccounts(AuthorizedUser user, String name) throws Exception{
    //3개 이상이면 에러 반환 
    if(accountsRepository.countUser(user.getId()) >= MAX_ACCOUNTS) {
      throw new Exception("계좌 최대 갯수 초과");
    }
    Accounts accounts = new Accounts();
    
    accounts.setUserId(user.getId());
    accounts.setName(name);
    return accountsRepository.save(accounts);
  }
  
  public List<Accounts> getAccountsList() {
    return accountsRepository.findAllByOrderByIdDesc();
  }


  private Map<String,Object> errorMessage(String error) {
	Map<String,Object> result = new HashMap<String,Object>();
    result.put("data", null);
    result.put("error", error);
    return result;
  }
}
