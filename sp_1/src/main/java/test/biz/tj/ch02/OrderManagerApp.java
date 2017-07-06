package test.biz.tj.ch02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class OrderManagerApp {

	public static void main(String[] args){
		FileSystemResource fsr = new FileSystemResource("src/main/resources/ioc2.xml");
		BeanFactory factory = new XmlBeanFactory(fsr);
		OrderManager manager = (OrderManager)factory.getBean("orderManager");
		manager.order();
	}
}
