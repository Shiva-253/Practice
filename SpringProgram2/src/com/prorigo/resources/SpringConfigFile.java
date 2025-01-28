package com.prorigo.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prorigo.beans.Student;

@Configuration // This tell that it is configuration file
public class SpringConfigFile {
	
	@Bean("stuObj") //This annotation is used to declare methods as a factory for creating and configuring a bean managed by the Spring container 
	public Student stdId1()
	{
		Student std = new Student();
		
		std.setName("Krishna");
		std.setRollno(101);
		std.setEmail("krishna@gmail.com");
		
		return std;
	}
}
