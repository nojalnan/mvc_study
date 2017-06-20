package web;

public class Calc {

	public int executeResult(String operator, int num1, int num2){
		int result = 0;
		if("+".equals(operator)) {
			result = num1 + num2;
		} else if("-".equals(operator)) {
			result = num1 - num2;
		} else if("/".equals(operator)) {
			result = num1 / num2;
		} else if("*".equals(operator)) {
			result = num1 * num2;
		}
		
		return result;
	}
}
