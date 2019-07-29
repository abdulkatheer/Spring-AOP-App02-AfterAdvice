package org.katheer.service;

import org.katheer.bean.Account;

import java.util.HashMap;
import java.util.Map;

public interface AccountService {
   Map<Integer, Account> accounts = new HashMap<>();
   String debit(int accNo, float amount);
   String credit(int accNo, float amount);

   static float getBalance(int accNo) {
      return accounts.get(accNo).getBalance();
   }

   static String addAccount(Account a) {
      if (accounts.containsKey(a.getAccNo())) {
         return "Account with no " + a.getAccNo() + " already exists!";
      } else {
         accounts.put(a.getAccNo(), a);
         return "Hurray! Account created!!";
      }
   }

   static boolean isExists(int accNo) {
      return accounts.containsKey(accNo);
   }
}
