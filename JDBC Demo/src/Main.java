import java.sql.*;
import java.util.Scanner;

public class Main {
	
	private static final String url = "jdbc:mysql://localhost:3306/mydb";
	private static final String username = "root";
	private static final String password = "rOOt@25SK";
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password); // Connection is interface which holds the connection and DriverManager
			String query = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";
			PreparedStatement prepareStatement = connection.prepareStatement(query);                                                                       // is class which getConnection method is used to make connection
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("Enter name: ");
				String name = sc.next();
				System.out.println("Enter age: ");
				int age = sc.nextInt();
				System.out.println("Enter marks: ");
				double marks = sc.nextDouble();
				System.out.println("Enter more data: Y/N ");
				String choice = sc.next();
				
				prepareStatement.setString(1, name);
				prepareStatement.setInt(2, age);
				prepareStatement.setDouble(3, marks);
				
				prepareStatement.addBatch();
				if(choice.toUpperCase().equals("N")) {
					break;
				}
			}
			
			
		  // This is the initial query which we have defined for inserting. Not hard coded
//			PreparedStatement prepareStatement = connection.prepareStatement(query);
//			
//			prepareStatement.setString(1, "Vaishnavi");
//			prepareStatement.setInt(2, 18);
//			prepareStatement.setDouble(3, 94.23);
//			
			int[] arr = prepareStatement.executeBatch(); // executeBatch is used to execute a batch
			
//			if(rowsAffected > 0) {
//				System.out.println("Data inserted Successfully");
//			}
//			else {
//				System.out.println("Data Not Found");
//			}
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == 0) {
					System.out.println("Query: "+i+" not executed successfully");
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
