package model;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import dao.BookingDao;
import dao.BusDao;
public class Booking {
	public String passengerName;
	public int busNo;
	public Date date;
	
	public Booking(){
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter passenger Name :");
	passengerName=sc.next();
	System.out.println("Enter Bus_No :");
	busNo=sc.nextInt();
	System.out.println("Enter date dd-MM-yyyy:");
	String dateInput=sc.next();
	SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
	
	try {
		date=dateformat.parse(dateInput);
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
	public boolean isAvailable() throws ClassNotFoundException, SQLException {
		BusDao busdao=new BusDao();
		BookingDao bookingdao=new BookingDao();
		
		int capacity=busdao.getCapacity(busNo); 
		int booked=bookingdao.getBookingCount(busNo,date);
		
		return booked<capacity;
	}
}
	