package connectionmanager;
import java.sql.*;
import java.io.*;

public class ConnectionManager{
	   Connection con=null;
	   public Connection establishConnection()throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root");
			return con;
		}
		
		public void close()throws SQLException{
			con.close();
		}
}
