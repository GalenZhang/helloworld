package com.mopon;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/")
    public String greeting() {
		System.out.println("当前时间：" + new Date());
		// save a couple of customers
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

		// fetch an individual customer by ID
		Customer customer = repository.findOne(1L);
		log.info("Customer found with findOne(1L):");
		log.info("--------------------------------");
		log.info(customer.toString());
		log.info("");

		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		for (Customer bauer : repository.findByLastName("Bauer")) {
			log.info(bauer.toString());
		}
		log.info("");
        return "Hello World!";
    }

	public static void main(String[] args) {
//		ConfigurableApplicationContext context  = SpringApplication.run(Application.class, args);
//		context.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
//
//	        @Override
//	        public void onApplicationEvent(ContextClosedEvent event) {
//	            System.out.println("Do something");
//	        }
//	    });
//		context.registerShutdownHook();
		
		SpringApplication.run(Application.class);
	}
}
