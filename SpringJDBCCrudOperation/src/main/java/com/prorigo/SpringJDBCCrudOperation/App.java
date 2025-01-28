package com.prorigo.SpringJDBCCrudOperation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.prorigo.beans.Student;
import com.prorigo.resources.SpringConfigFile;
import com.prorigo.mappers.StduentRowMapper;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int std_rollno = 102;
    	String std_name = "Shivam";
    	float std_marks = 34.5f;
    	
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class); // Creating the Object of JDBC Template
        
        // Insert Opertion
//        String insert_sql_query = "INSERT INTO student VALUES (?, ?, ?)";
//        int count = jdbcTemplate.update(insert_sql_query, std_rollno, std_name, std_marks);
//        
//        if(count > 0) {
//        	System.out.println("Insertion success");
//        }
//        else {
//        	System.out.println("Insertion failed");
//        }
        
        // Update Operation
        
//        String update_sql_query = "UPDATE student SET std_marks=? WHERE std_roll=?";
//        int count = jdbcTemplate.update(update_sql_query, std_marks, std_rollno);
//        
//        if(count > 0) {
//        	System.out.println("Updation success");
//        }
//        else {
//        	System.out.println("Updation failed");
//        }
        
        // Delete Operation
        
//      String delete_sql_query = "DELETE FROM student WHERE std_roll=?";
//      int count = jdbcTemplate.update(delete_sql_query, std_rollno);
//      
//      if(count > 0) {
//      	System.out.println("Deletion success");
//      }
//      else {
//      	System.out.println("Deletion failed");
//      }
        
        // SELECT OPERATION
        
        String select_sql_query = "SELECT * FROM student";
      
        List<Student> std_list =  jdbcTemplate.query(select_sql_query, new StduentRowMapper());
        
        for(Student std : std_list) {
        	System.out.println("Roll no : "+std.getRollno());
        	System.out.println("Name : "+std.getName());
        	System.out.println("Marks : "+std.getMarks());
        	System.out.println("------------------------------------");
        }
        
    }
}
