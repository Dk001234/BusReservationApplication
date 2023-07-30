package controller;
import java.io.IOException;

import java.sql.*;
import java.util.*;
import connectionmanager.*;
import dao.BookingDao;
import dao.BusDao;
import dao.LoginDao;
import model.Booking;
import model.*;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Scanner sc=new Scanner(System.in);
		Login login=new Login();
		LoginDao logindao=new LoginDao();
		BusDao busdao=new BusDao();
		Bus bus=new Bus();
		BookingDao bookingdao=new BookingDao();
		int option;int option1=0;
		
		// booking details user and admin 
		do {
			System.out.println("Enter your option  ");
			System.out.println("1.User");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("-----------------------------------------------------------------------");
			option=sc.nextInt();
			
			//user details and booking 
			switch(option) {
				case 1:{
					System.out.println("Enter your option  ");
					System.out.println("1.Login");
					System.out.println("2.SignUp");
					option1=sc.nextInt();
					
					
						switch(option1) {
						//login information
					
					case 1:{
						System.out.println("---------------------------------------------------------------------\n");
						System.out.println("Enter username");
						String username=sc.next();
						System.out.println("Enter password");
						String password=sc.next();
						login.setUserName(username);
						login.setPassword(password);
						boolean result=logindao.validate(login);
				
						if(result==true) 
							System.out.println("lOGIN successful\n ------------------------------------------------------------------\n");
						int opt=1;
						busdao.displayBusInfo();
				
						while(opt==1) {
							System.out.println("Enter 1 is book (or) Enter 2 Exit \n-------------------------------------------------------------\n");
							opt=sc.nextInt();
							if(opt==1) {
								Booking booking=new Booking();
								if(booking.isAvailable()) {
									bookingdao.addBooking(booking);
									System.out.println("Your Booking is conformed");
								}
								else {
									System.out.println("Sorry. Bus is full. Try another Bus (or) Date");
								}
								System.out.println("----------------------------------------------------------------\n");
							}
						}
						break;
					}
					case 2:{
						//signUp details for user
						
						System.out.println("---------------------------------------------------------------------\n");
						System.out.println("Enter your FullName");
						String username=sc.next();
						System.out.println("Enter your new password");
						String password=sc.next();
						System.out.println("Enter your conform password");
						String password1=sc.next();
						login.setUserName(username);
						if(password.equals(password1)) 
							login.setPassword(password);
						logindao.signUp(login);
						System.out.println("lOGIN successful\n ------------------------------------------------------------------\n");
						
						int opt=1;
						busdao.displayBusInfo();
				
						while(opt==1) {
							System.out.println("Enter 1 is book (or) Enter 2 Exit \n-------------------------------------------------------------\n");
							opt=sc.nextInt();
							if(opt==1) {
								Booking booking=new Booking();
								if(booking.isAvailable()) {
									bookingdao.addBooking(booking);
									System.out.println("Your Booking is conformed");
								}
								else {
									System.out.println("Sorry. Bus is full. Try another Bus (or) Date");
								}
								System.out.println("----------------------------------------------------------------\n");
							}
						}
					}
				}
						break;
			}
				// Admin details 
				case 2:{
					//Admin loginId
					
					System.out.println("---------------------------------------------------------------------\n");
					System.out.println("Enter username");
					String username=sc.next();
					System.out.println("Enter password");
					String password=sc.next();
					login.setUserName(username);
					login.setPassword(password);
					boolean result=logindao.validate(login);
			
					if(result==true) { 
						System.out.println("lOGIN successful\n ------------------------------------------------------------------\n");
					
						//adding bus details
					do {
						System.out.println("Enter your option  ");
						System.out.println("1.addBus");
						System.out.println("2.Exit");
						option1=sc.nextInt();
						switch(option1) {
						case 1:{
							System.out.println("--------------------------------------------");
							System.out.println("Enter bus number");
							int bus_no=sc.nextInt();
							bus.setBus_No(bus_no);
							System.out.println("Enter Ac (or) Not like a 0 (or) 1 ");
							int ac=sc.nextInt();
							bus.setAc(ac);
							System.out.println("Enter Bus capacity");
							int capacity=sc.nextInt();
							bus.setCapacity(capacity);
							busdao.addBus(bus);
							
						}
						}
					}while(option1!=2);
				}
				}
			}
		}while(option!=3);
	}
}