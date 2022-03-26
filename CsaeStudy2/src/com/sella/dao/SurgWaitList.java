package com.sella.dao;


import java.sql.*;

public class SurgWaitList {
	Connection con ;
	public SurgWaitList() throws SQLException  {
		System.out.println("---------------------Surgical Waiting List-------------------");
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
	
	public void addPatient(String pname,String opType,int priority,String sname,String opDate,String disDate) throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "insert into waitlist values('"+pname+"','"+opType+"',"+priority+",'"+sname+"','"+opDate+"','"+disDate+"')";
			st.execute(qry);
                        System.out.println("data inserted Successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
	public void display() throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "select * from waitlist";
			ResultSet rs= st.executeQuery(qry);
			System.out.println("---------------------------------------------------------------");
			while(rs.next()) {
				System.out.println("Patient Name: "+rs.getString(1));
				System.out.println("Type of Operation: "+rs.getString(2));
				System.out.println("Priority: "+rs.getInt(3));
				System.out.println("Surgeon Name: "+rs.getString(4));
				System.out.println("Operation Date: "+rs.getString(5));
				System.out.println("Discharge Date: "+rs.getString(6));
				System.out.println("---------------------------------------------------------------");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
	public void removePatient(String pname) throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "delete from waitlist where pname='"+pname+"'";
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
}

