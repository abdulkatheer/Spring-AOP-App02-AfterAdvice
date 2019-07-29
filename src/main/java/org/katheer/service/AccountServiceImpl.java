package org.katheer.service;

import org.katheer.bean.Account;

public class AccountServiceImpl implements AccountService {
   @Override
   public String debit(int accNo, float amount) {
      //if account exists
      if (AccountService.isExists(accNo)) {
         float currentBalance = AccountService.getBalance(accNo);
         //if sufficient funds not available
         if (amount > currentBalance) {
            return "Insufficient Funds! Current Balance = " + currentBalance;
         }
         //if sufficient funds available
         else {
            accounts.get(accNo).setBalance(currentBalance - amount);
            return "Money successfully debited! Current Balance = " + AccountService.getBalance(accNo);
         }
      }
      //if not exists
      else {
         return "Sorry! Account not found!!";
      }
   }

   @Override
   public String credit(int accNo, float amount) {
      //if account exists
      if (AccountService.isExists(accNo)) {
         float currentBalance = AccountService.getBalance(accNo);
         accounts.get(accNo).setBalance(currentBalance + amount);
         return "Amount credited successfully! Current Balance = " + AccountService.getBalance(accNo);
      }
      //if account not exists
      else {
         return "Sorry! Account not found!!";
      }
   }
}
