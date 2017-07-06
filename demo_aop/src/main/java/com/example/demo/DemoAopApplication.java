package com.example.demo;

import javax.inject.Inject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoAopApplication.class, args);
	}
	
	@Inject
	private SmallmartInterface smi;
	
	public void run(String... args) throws Exception{
		this.smi.getProducts("사이다 + 파전");
	}
}
