package dao;

import java.sql.*;
import java.util.Date;

import connectionmanager.ConnectionManager;
import model.Booking;

public class BookingDao {
	public int getBookingCount(int busNo,Date date) throws ClassNotFoundException, SQLException {
		String quary="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		PreparedStatement ps=con.prepareStatement(quary);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		
		ps.setInt(1, busNo);
		ps.setDate(2, sqldate);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return rs.getInt(1);
		
	}
	
	public void addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		String quary="insert into booking values(?,?,?)";
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		PreparedStatement ps=con.prepareStatement(quary);
		ps.setString(1, booking.passengerName);
		ps.setInt(2, booking.busNo);
		ps.setDate(3,sqldate);
		ps.executeUpdate();
			
	}
}
  