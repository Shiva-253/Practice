package com.prorigo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prorigo.beans.Student;
import com.prorigo.resources.SpringConfigFile;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class); // Using Java configuration file
		
//		Student student = (Student) context.getBean("stdId1"); // name of bean method
//		student.display();
//		OR
//		Student student = (Student) context.getBean(Student.class); // name of class
//		student.display();
//		OR
		Student student = (Student) context.getBean("stuObj"); // name of bean object
		student.display();
	}

}
