package com.tropcool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class TatuagemTropCoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TatuagemTropCoolApplication.class, args);
	}

	/**
	 * @return
	 */
	@Bean
	public MessageSource messageSource()
	{
		final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setAlwaysUseMessageFormat( true );
		messageSource.setDefaultEncoding( "UTF-8" );
		messageSource.setBasenames( "classpath:i18n/exceptions" );
		return messageSource;
	}
	
	/**
	 * @return
	 */
	@Bean
	public Validator validator()
	{
		return new LocalValidatorFactoryBean();
	}
}
