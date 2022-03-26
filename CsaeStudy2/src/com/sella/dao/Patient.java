package com.sella.dao;


import java.sql.*;

public class Patient {
		Connection con ;
		public Patient() throws SQLException {
			System.out.println("------------------------Patient table ------------------------");
			try {
				  Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				System.out.println("\t\t\t\t\t\tConnected...");
			}
			catch(Exception e) {
				e.printStackTrace();
				con.close();
			}
		}
		
		public void addPatient(String name,String dob,String gender) throws SQLException {
			try {
				Statement st = con.createStatement();
				//"insert into customer values('"+name+"',"+salary+","+age+",'"+state1+"')");
				String qry = "insert into patient values('"+name+"','"+dob+"','"+gender+"')";
				st.execute(qry);
	                        System.out.println("Patient Details Added To database");
			}
			catch(Exception e) {
				e.printStackTrace();
				con.close();
			}
		}
		
		public void display() throws SQLException {
			try {
				Statement st = con.createStatement();
				String qry = "select * from patient";
				ResultSet rs= st.executeQuery(qry);
				System.out.println("-----------------------------------------------------------");
				while(rs.next()) {
	                               
					System.out.println("Name: "+rs.getString(1));
					System.out.println("DOB: "+rs.getString(2));
					System.out.println("Gender: "+rs.getString(3));
					System.out.println("--------------------------------------------------------");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				con.close();
			}
		}
		
		public void removePatient(String name) throws SQLException {
			try {
				Statement st = con.createStatement();
				String qry = "delete from patient where name='"+name+"'";
				int res=st.executeUpdate(qry);
	                        if(res==1)
	                        {
	                            System.out.println(name+" details are removed from database");
	                        }
	                        else
	                        {
	                            System.out.println("details of "+name+" not Found");
	                        }
	                        
			}
			catch(Exception e) {
				e.printStackTrace();
				con.close();
			}
		}

			}
	

