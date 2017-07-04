package com.test.ioc.exam2;

public class DogManager {
	private Pudle pudle;
	private Jindo jindo;
	
	public void setPudle(Pudle pudle){
		this.pudle = pudle;
	}
	
	public void setJindo(Jindo jindo){
		this.jindo = jindo;
	}
	public void bark() {
		pudle.bark();
		jindo.bark();
	}
}
