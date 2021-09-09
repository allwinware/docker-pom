package com.allwin.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Spring Boot Application
 * BootApp.java
 * @author	john
 * @since	
 * @version	1.0
 * @see <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 9. 8.	john		최초생성
 * 
 * </pre>
 */
@SpringBootApplication
@EnableAsync
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class ,SecurityAutoConfiguration.class})
public class BootApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BootApp.class, args);
	}

}










