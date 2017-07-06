package test.biz.tj.ch12;

public class DogManager {
	private Pudle pudle;
	private Jindo jindo;

	public void setDog1(Pudle pudle) {
		this.pudle = pudle;
	}

	public void setDog2(Jindo jindo) {
		this.jindo = jindo;
	}

	public void bark() {
		jindo.bark();
		pudle.bark();
	}
}
