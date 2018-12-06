package com.taotao.email.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AllBean implements ApplicationContextAware{
	   
    private static ApplicationContext applicationContext; 
   
    public void setApplicationContext(ApplicationContext context) {
       AllBean.applicationContext = context;
       }
   
    public static Object getBean(String name){
         return applicationContext.getBean(name);
    }
    
     public static ApplicationContext getApplicationContext() {  
          return applicationContext;  
      }  
}
