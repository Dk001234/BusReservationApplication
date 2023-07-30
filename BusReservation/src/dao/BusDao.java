package dao;
import model.*;
import connectionmanager.ConnectionManager;
import java.sql.*;
public class BusDao {
	public void displayBusInfo() throws ClassNotFoundException, SQLException {
		String quary="select * from bus1";
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(quary);
		while(rs.next()) {
			System.out.print("Bus_No :"+rs.getInt(1)+  "  ||");
			if(rs.getInt(2)==0)
				System.out.print("AC :No"+  "  ||");
			else
				System.out.print("AC :Yes"+  "  ||");
			System.out.println("Capacity :"+rs.getInt(3));
		}
		conn.close();
	}
	
	 public int getCapacity(int id) throws ClassNotFoundException, SQLException {
		 String quary="select capacity from bus1 where bus_no="+id;
		 ConnectionManager conn=new ConnectionManager();
		 Connection con=conn.establishConnection();
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(quary);
		 rs.next();
		 return rs.getInt(1);
	 }
	 
	 public void addBus(Bus bus) throws ClassNotFoundException, SQLException {
		 String quary="insert into bus1 values(?,?,?)";
		 ConnectionManager conn=new ConnectionManager();
		 Connection con=conn.establishConnection();
		 PreparedStatement ps=con.prepareStatement(quary);
		 ps.setInt(1,bus.getBus_No());
		 ps.setInt(2, bus.getAc());
		 ps.setInt(3, bus.getCapacity());
		 ps.executeUpdate();
		 conn.close();
	 }
}
