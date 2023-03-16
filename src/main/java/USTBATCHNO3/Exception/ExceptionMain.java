package USTBATCHNO3.Exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExceptionMain {

	public static void main(String[] args) throws InvalidPhoneNumberException {
		// TODO Auto-generated method stub
		ExceptionEmp e1 = new ExceptionEmp ("8136917714","finlana@gmail.com","nettikadan",01,"Finla","Trivandrum",23500);
		//ExceptionEmp e2 = new ExceptionEmp ("9400627642","finitana@gmail.com","Pallan",01,"Finita","Kochi",35000);
		//ExceptionEmp e3 = new ExceptionEmp ("9847260793","fionana@gmail.com","Parapully",01,"Fiona","Bombay",40000);
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		e1.setPhoneno(s1);
		
	
		try {
			 if (!e1.getPhoneno().matches("\\d{10}$")) {
			        throw new InvalidPhoneNumberException("Invalid phone number: ");
		} 
			 String s2 = in.next();
			 e1.setEmailid(s2);
			 try {
					if (!e1.getEmailid().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
				        throw new InvalidEmailIdException("Invalid email ID: " );
				    }
				}
				catch(InvalidEmailIdException e) {
					System.err.println(e.getMessage());
				}
			 
		}
		catch (InvalidPhoneNumberException e) {
		    System.err.println(e.getMessage());
		}
		
		String url = "jdbc:mysql://localhost:3306/emps";
	    String username = "root";
	    String password = "pass@word1";
	    try {
	        
	        Connection conn = DriverManager.getConnection(url, username, password);

	        
	        Statement stmt = conn.createStatement();

//	        String sql = "CREATE TABLE employee ("
//	                   + " phoneno VARCHAR(255),"
//	                   + "emailid VARCHAR(255),"
//	                   + "address VARCHAR(255),"
//	                   + "empid INT,"
//	                   + "empname VARCHAR(255),"
//	                   + "location VARCHAR(255),"
//	                   + "salary INT"
//	                   + ")";
	        //stmt.executeUpdate(sql);
	        String sql = "INSERT INTO employee (phoneno,emailid,address,empid,empname,location,salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

//	        String[] phoneno = {"9847260793", "8136917714", "9876543210"};
//	        String[] emailid = {"finla@gmail.com", "eira@gmail.com", "erica@gmail.com"};
//	        String[] address = {"nettikadan", "pallan", "parappully"};
//	        int[] empid = {01, 02, 03};
//	        String[] empname = {"Finla", "Eira", "Erica"};
//	        String[] location = {"TVM","Kochi","Mumbai"};
//	        int[] salary = {23000,30000,40000};
	        
	       // for (int i = 0; i < phoneno.length; i++) {
	            pstmt.setString(1, e1.getPhoneno());
	            pstmt.setString(2, e1.getEmailid());
	            pstmt.setString(3, e1.getAddress());
	            pstmt.setInt(4, e1.getEmpid());
	            pstmt.setString(5, e1.getEmpname());
	            pstmt.setString(6,e1.getLocation());
	            pstmt.setInt(7, (int) e1.getSalary());
	            pstmt.executeUpdate();
	          //}

//	        stmt.close();
//	        conn.close();
	        
//	        System.out.println("Employee table created successfully!");

	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	}
	public static class InvalidPhoneNumberException extends Exception {
	    public InvalidPhoneNumberException(String message) {
	        super(message);
	    }
	}
	public static class InvalidEmailIdException extends Exception {
	    public InvalidEmailIdException(String message) {
	        super(message);
	    }
	}
}
	
	
	
