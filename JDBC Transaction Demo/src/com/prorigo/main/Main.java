package com.prorigo.main;
import java.sql.*;
import java.util.Scanner;

public class Main {

	private static final String url = "jdbc:mysql://localhost:3306/newdb";
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
			Connection connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(false);
			String debit_query = "UPDATE accounts SET balance = ? WHERE acc_no = ?";
			String credit_query = "UPDATE accounts SET balance = ? WHERE acc_no = ?";
			PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
			PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Account Number: ");
			int account_number = scanner.nextInt();
			System.out.println("Enter Amount: ");
			double amount = scanner.nextDouble();
			
			debitPreparedStatement.setDouble(1, amount);
			debitPreparedStatement.setInt(2, account_number);
			creditPreparedStatement.setDouble(1, amount);
			creditPreparedStatement.setInt(2, account_number);
			
			if(isSufficient(connection, 101, amount)) {
				int affectedRowsOne = debitPreparedStatement.executeUpdate();
				int affectedRowsTwo = creditPreparedStatement.executeUpdate();
			}else {
				System.out.println("Insufficient amount");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	
	static boolean isSufficient(Connection connection, int acc_no, double amount) {
		String query = "SELECT balance FROM accounts WHERE acc_no = ?";
		boolean isTrue = true;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, acc_no);
			
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				double current_balance = resultset.getDouble("balance");
				if(amount > current_balance) {
					isTrue = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isTrue;
	}

}
