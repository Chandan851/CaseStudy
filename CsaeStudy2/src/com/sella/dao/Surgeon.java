package com.sella.dao;


import java.sql.*;

public class Surgeon {
	Connection con ;
	public Surgeon() throws SQLException {
		System.out.println("---------------------------Surgeon-------------------------");
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
	
	public void addSurgeon(String name,String spclty) throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "insert into surgeon values('"+name+"','"+spclty+"')";
			st.execute(qry);
                        System.out.println("Detials Are Inserted Successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
	public void display() throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "select * from surgeon";
			ResultSet rs= st.executeQuery(qry);
			System.out.println("---------------------------------------------------------------");
			while(rs.next()) {
				System.out.println("Name: "+rs.getString(1));
				System.out.println("Specialty: "+rs.getString(2));
				System.out.println("---------------------------------------------------------------");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
	
	public void removeSurgeon(String name) throws SQLException {
		try {
			Statement st = con.createStatement();
			String qry = "delete from surgeon where name='"+name+"'";
			int res=st.executeUpdate(qry);
                          if(res==1)
                        {
                            System.out.println(name+ " details are removed");
                        }
                        else
                        {
                            System.out.println("Details of "+name+" Not Found");
                        }
		}
		catch(Exception e) {
			e.printStackTrace();
			con.close();
		}
	}
}

