package lpIIIjavaweb.daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
  public static Connection getConnection(){
  	String url = "jdbc:postgresql://localhost/lpIII2022a?user=postgres&password=2108";
  	Connection conn = null;
  	try {
  			Class.forName("org.postgresql.Driver");
  			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	return conn;    		  
  }
}
