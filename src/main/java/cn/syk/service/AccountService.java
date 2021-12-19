package cn.syk.service;

import cn.syk.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  public boolean valid (Account account) {
    if("admin".equals(account.getName()) && "123456".equals(account.getPassWord())) {
      return true;
    }
    return false;
  }
}