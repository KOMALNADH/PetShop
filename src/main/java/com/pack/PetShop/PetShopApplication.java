package com.pack.PetShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class PetShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetShopApplication.class, args);
	}
	 @Bean
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        messageSource.setBasename("classpath:validation");
	        messageSource.setDefaultEncoding("UTF-8");
	        return messageSource;
	    }
	    @Bean
	    public LocalValidatorFactoryBean validator() {
	        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	        bean.setValidationMessageSource(messageSource());
	        return bean;
	    }
}
