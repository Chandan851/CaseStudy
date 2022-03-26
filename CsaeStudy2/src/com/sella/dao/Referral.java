package com.sella.dao;


import java.sql.*;

public class Referral {
	Connection con ;
	public Referral() throws SQLException {
		System.out.println("------------------------Referral List------------------------");
		try {
			 Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			System.out.println("Connected...");
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
	public void addRef(String pname,String date,int priority,String sname,String appDate) throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "insert into referral values('"+pname+"','"+date+"',"+priority+",'"+sname+"','"+appDate+"')";
			st.execute(qry);
                        System.out.println(" details are inserted into database");
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
	public void display() throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "select * from referral";
			ResultSet rs= st.executeQuery(qry);
			System.out.println("---------------------------------------------------------------");
			while(rs.next()) {
				System.out.println("Patient Name: "+rs.getString(1));
				System.out.println("Date: "+rs.getString(2));
				System.out.println("Priority: "+rs.getInt(3));
				System.out.println("Surgeon Name: "+rs.getString(4));
				System.out.println("Appointment Date: "+rs.getString(5));
				System.out.println("---------------------------------------------------------------");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
	public void removeRef(String pname) throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "delete from referral where pname='"+pname+"'";
			int res=st.executeUpdate(qry);
                        if(res==1)
                        {
                            System.out.println(pname+ " details are removed");
                        }
                        else
                        {
                            System.out.println("Details of "+pname+" Not Found");
                        }
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
	public void updateAppDate(String pname,String appDate) throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "update referral set appdate='"+appDate+"'where pname='"+pname+"'";
			int res=st.executeUpdate(qry);
                        
                        if(res==1)
                        {
                            System.out.println(pname+ " details are updated");
                        }
                        else
                        {
                            System.out.println("Details of "+pname+" Not Found");
                        }
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
}
