package test.biz.tj.ch15;

import org.springframework.aop.framework.ProxyFactory;

public class HelloMain {
	
	public static void main(String[] args) {
		IPrintMsg target = new PrintMsg();
		// Proxy 빈껍데기 생성
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MyAroundAdvice()); // 충고 add
		pf.setTarget(target); // 타겟 add
		IPrintMsg proxy = (IPrintMsg) pf.getProxy();
		proxy.hello1();
		proxy.hello2();
		
		target = new PrintMsg2();
		pf.setTarget(target);
		proxy = (IPrintMsg) pf.getProxy();
		proxy.hello1();
		proxy.hello2();
	}
}
