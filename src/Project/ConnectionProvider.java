package Project;
import java.sql.*;


public class ConnectionProvider {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost/pet_clinic";
	    static final String USER = "root";
	    static final String PASS = "123456.Abc";
	    
	public static Connection getConn() {
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	       
	      return conn;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	
}