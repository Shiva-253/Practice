package com.prorigo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prorigo.beans.Student;

public class Main {

	public static void main(String[] args) {

		String file_path = "com/prorigo/resources/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(file_path);

		Student std = (Student) context.getBean("student");
		std.display();
	}

}
