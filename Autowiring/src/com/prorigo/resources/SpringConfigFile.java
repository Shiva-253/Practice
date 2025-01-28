package com.prorigo.resources;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prorigo.beans.Address;
import com.prorigo.beans.Student;
import com.prorigo.beans.Subjects;

@Configuration
public class SpringConfigFile {
	
	@Bean
	public Address createAddrObj1() {
		Address add = new Address();
		
		add.setHouseno(100);
		add.setCity("Pune");
		add.setPincode(424525);
		
		return add;
	}
	
	@Bean
	public Address createAddrObj2() {
		Address add = new Address();
		
		add.setHouseno(110);
		add.setCity("Mumbai");
		add.setPincode(434525);
		
		return add;
	}
	
	@Bean
	public Student createStdObj() {
		Student stud = new Student();
		
		stud.setName("Krishna");
		stud.setRollno(101);
		//stud.setAddress(createAddrObj());  // manually DI
		
		return stud;
	}
	
	@Bean
	public Subjects createSubObj(){
		Subjects sub = new Subjects();
		
		ArrayList<String> s = new ArrayList<>();
		
		s.add("English");
		s.add("Java");
		s.add("Service Life Cycle Management");
		
		sub.setSub(s);
		
		return sub;
	}
	
}
