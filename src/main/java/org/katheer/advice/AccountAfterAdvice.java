package org.katheer.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AccountAfterAdvice implements AfterReturningAdvice {
   @Override
   public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
      System.out.println("After Executing " + method.getName() + "() method : ");
      System.out.println("Returns : " + returnValue);
   }
}
