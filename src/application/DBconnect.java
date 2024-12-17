package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnect {
	public Connection conn;
//------------Connect to my SQL---------------------
	public void DBconnection() {
		String url = "jdbc:mysql://localhost:3306/BaseUsers?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "Basededonne123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
	}
//--------------------------------------------------
	public Connection getConnection() {
		return this.conn;
	}
	public void close() {
		try {
			this.conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void LogIn(String input_name,String input_pas) {
		String query ="SELECT * FROM Users WHERE name =? AND password=?";

		try(PreparedStatement ps=conn.prepareStatement(query)){
			ps.setString(1, input_name);
			ps.setString(2, input_pas);
			ResultSet rs=ps.executeQuery();//for fetching result
			if(rs.next()) {
				System.out.println("Log In succeful");//7ot welcome wala ay 7aja
			}else {
				System.out.println("Log In Failed !");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SignUp(User u,String input_name,String input_Email,String input_pas) {
		if(!u.verifEmail(input_Email) && !u.verifPas(input_pas)) {
			System.out.println("Please enter valid field"); //7ot msg hetha fi kol field
		}
		String query="INSERT INTO Users (name,email,password) VALUES(?,?,?)";
		try(PreparedStatement ps=conn.prepareStatement(query)){
			ps.setString(1,input_name);
			ps.setString(2,input_Email);
			ps.setString(3,input_pas);
			
			int rowsAffected=ps.executeUpdate();//modify data
			if(rowsAffected>0) {
				System.out.println("Sing Up was succeful");
			}else {
				System.out.println("Sign Up failed");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
