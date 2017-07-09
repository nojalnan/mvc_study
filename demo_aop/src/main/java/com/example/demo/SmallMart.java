package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SmallMart implements SmallmartInterface {

	@Override
	public String getProducts(String productName) throws Exception {
		String str = "Method : getProducts[" + productName + "]";
		return str;
	}

}
