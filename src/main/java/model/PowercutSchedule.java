package model;

import java.sql.*;

public class PowercutSchedule {

	
 //A common method to connect to the DB
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	public String insertPowercutSchedule(String code, String description, String date, String time)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 // create a prepared statement
	 String query = " insert into PowercutSchedule
	 (`PowercutScheduleCode`,`PowercutScheduleDescription`,`PowercutScheduleDate`,`PowercutScheduleTime`)"
	 + " values (?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, code);
	 preparedStmt.setString(3, description);
	 preparedStmt.setString(4, date);
	 preparedStmt.setString(5, time);
	 
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while inserting the PowercutSchedule.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	public String readPowercutSchedule()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>PowercutSchedule Code</th><th>PowercutSchedule Description</th>" +
	 "<th>PowercutSchedule Date</th>" +
	 "<th>PowercutSchedule Time</th>" +
	 "<th>Update</th><th>Remove</th></tr>";

	 String query = "select * from PowercutSchedule";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String PowercutScheduleID = Integer.toString(rs.getInt("PowercutScheduleID"));
	 String PowercutScheduleCode = rs.getString("PowercutScheduleCode");
	 String PowercutScheduleDescription = rs.getString("PowercutScheduleDescription");
	 String PowercutScheduleDate = rs.getString("PowercutScheduleDate");
	 String PowercutScheduleTime = rs.getString("PowercutScheduleTime");
	
	 // Add into the html table
	 output += "<tr><td>" + PowercutScheduleCode + "</td>";
	 output += "<td>" + PowercutScheduleDescription + "</td>";
	 output += "<td>" + PowercutScheduleDate + "</td>";
	 output += "<td>" + PowercutScheduleTime + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update'
	 class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove'
	 class='btn btn-danger'>"
	 + "<input name='PowercutScheduleID' type='hidden' value='" + PowercutScheduleID
	 + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the PowercutSchedule.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	public String updatePowercutSchedule(String ID, String code, String description, String date, String time)
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 String query = "UPDATE PowercutSchedule SET PowercutScheduleCode=?,PowercutScheduleDescription=?,PowercutScheduleDate=?,PowercutScheduleTime=?
		 WHERE itemID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, code);
		 preparedStmt.setString(2, description);
		 preparedStmt.setString(3, date);
		 preparedStmt.setString(4, time);
		 preparedStmt.setInt(5, Integer.parseInt(ID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the PowercutSchedule.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
	
	public String deletePowercutSchedule(String PowercutScheduleID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from PowercutSchedule where itemID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(PowercutScheduleID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the PowercutSchedule.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	} 

