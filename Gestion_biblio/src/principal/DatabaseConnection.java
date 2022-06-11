package principal;
import java.sql.*;
import java.util.*;
public class DatabaseConnection {
	private static Connection conn = null;

		public DatabaseConnection(){
			String urlMysql="jdbc:mysql://localhost:3306/gestion_biblio";
		    String slogin="root";
		    String spass="aymane2021";
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
		     conn=DriverManager.getConnection(urlMysql, slogin, spass);
				System.out.println("connected!!");
		}
			catch(Exception e){
				System.out.println("connected not yet!!");
				
			}

	}
		public  Connection getConn() {
			return conn;
		}
	}


