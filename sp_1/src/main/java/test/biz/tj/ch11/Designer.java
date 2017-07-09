package test.biz.tj.ch11;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class Designer implements MethodReplacer{

	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		return "이게 프로그램의 워크를 호출한게 맞을껄요? 디자이너 일하고 있어요";
	}


}
