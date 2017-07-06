package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public interface SmallmartInterface {
	
	public String getProducts(String productName)throws Exception;
}
