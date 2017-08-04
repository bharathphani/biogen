package com.src.magnushealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.src.magnushealth.service.ServiceFacade;

/**
 * @author Rakesh Rai
 *
 */
@SpringBootApplication
public class Application implements ApplicationRunner {

	@Autowired
	private ServiceFacade userService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		userService.doService("insertBatch");
	}

}
