package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert("Rocketry","Madhavan","Simran Bagga",2022,"Anand Mahadevan");
	insert("D-Block","Arulnidhi","Avantika Mishra",2022,"Vijai Kumar");
	insert("Mudhal Nee Mudivum Nee","Kishen Das","Darbuka Siva",2022,"Darbuka Siva");
	insert("Thittam Irandu","Aishwarya Rajesh","Subash Selvan",2021,"Vignesh Karthik");
	insert("Aruvam","Siddharth","Catherine Tresa",2019,"Sai Sekar");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
