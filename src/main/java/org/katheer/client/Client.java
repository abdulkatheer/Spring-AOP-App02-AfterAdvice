package org.katheer.client;

import org.katheer.bean.Account;
import org.katheer.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

      AccountService accountService = (AccountService) context.getBean("accountProxy");

      //Adding some accounts
      AccountService.addAccount((Account) context.getBean("account1"));
      AccountService.addAccount((Account) context.getBean("account2"));

      //Debit
      accountService.debit(101, 1000);
      accountService.debit(101, 10000);
      accountService.debit(102, 6000);
      accountService.debit(102, 100000);
      accountService.debit(103, 1000);

      //Credit
      accountService.credit(101, 10000);
      accountService.credit(101, 1000);
      accountService.credit(102, 1000000);
      accountService.credit(102, 10000);
      accountService.credit(103, 1000);
   }
}
