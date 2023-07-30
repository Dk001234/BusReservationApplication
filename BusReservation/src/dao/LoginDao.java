package dao;

import java.io.IOException;
import java.sql.*;

import connectionmanager.*;
import model.Login;

public class LoginDao {
	public boolean validate(Login login)throws IOException,SQLException, ClassNotFoundException {
		String username=login.getUserName();
		String password=login.getPassword(); 
		String quary="select * from login";
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(quary);
		
		while(rs.next()) {
			if(username.equals(rs.getString(1))&& password.equals(rs.getString(2))) {
				conn.close();
				
				return true;
				
			}
		}
		conn.close();
		return false;
	}
	
	public void signUp(Login login) throws ClassNotFoundException, SQLException {
		String username=login.getUserName();
		String password=login.getPassword(); 
		String quary="insert into login values(?,?)";
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		PreparedStatement ps=con.prepareStatement(quary);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.executeUpdate();
		conn.close();
	}
}
