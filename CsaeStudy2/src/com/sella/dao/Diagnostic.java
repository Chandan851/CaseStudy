package com.sella.dao;


import java.sql.*;

public class Diagnostic {
		Connection con ;
		public Diagnostic() throws SQLException {
			System.out.println("----------------------Diagnostic List------------------------");
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
		
		public void addOrder(String test,String pname,String sname,String orDate,String resDate) throws SQLException {
			try {
				Statement st = con.createStatement();
				String qry = "insert into diagnostic values('"+test+"','"+pname+"','"+sname+"',' ','"+orDate+"','"+resDate+"')";
				st.execute(qry);
			}
			catch(Exception e) {
				e.printStackTrace();
				con.close();
			}
		}
		
		
		
		public void display() throws SQLException {
			try {
				Statement st = con.createStatement();
				String qry = "select * from diagnostic";
				ResultSet rs= st.executeQuery(qry);
				System.out.println("---------------------------------------------------------------");
				while(rs.next()) {
					System.out.println("Test: "+rs.getString(1));
					System.out.println("Patient Name: "+rs.getString(2));
					System.out.println("Surgeon Name: "+rs.getString(3));
					System.out.println("Result: "+rs.getString(4));
					System.out.println("Order Date: "+rs.getString(5));
					System.out.println("Result Date: "+rs.getString(6));
					System.out.println("---------------------------------------------------------------");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			
			con.close();
		}}
		
		public void updateResult(String pname,String result) throws SQLException {
			try {
				Statement st = con.createStatement();
				String qry = "update diagnostic set result='"+result+"'where pname='"+pname+"'";
				st.executeUpdate(qry);
			}
			catch(Exception e) {
				e.printStackTrace();
				
			
			con.close();
		}}
	}


