package com.prorigo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prorigo.beans.Student;

public class Main {

	public static void main(String[] args) {
		
		String config_loc = "/com/prorigo/resources/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config_loc); // ClassPathXmlApplicationContext is implemented class for ApplicationContext
		
		Student std1 = (Student) context.getBean("stdId1");
		std1.display();
		
		System.out.println("-----------------");
		
		Student std2 = (Student) context.getBean("stdId2");
		std2.display();
	}

}

// 1. spring-beans-xxx.jar
// 2. spring-core-xxx.jar
// 3. spring-context-xxx.jar
// 4. commons-logging-xxx.jar
// 5. spring-expression-xx.jar