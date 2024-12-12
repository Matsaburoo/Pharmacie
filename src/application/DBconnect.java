package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	public Connection conn;
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
}
