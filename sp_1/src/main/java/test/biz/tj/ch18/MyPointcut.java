package test.biz.tj.ch18;

import java.lang.reflect.Method;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

	public class MyPointcut extends StaticMethodMatcherPointcut {
		public boolean matches(Method method, Class<?> cls) {
			return("one".equals(method.getName()) && cls==First.class);
		}
	
}
