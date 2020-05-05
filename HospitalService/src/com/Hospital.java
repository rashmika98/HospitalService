/**
 * 
 */
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author user
 *
 */
public class Hospital {

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hospital", "root", "root");
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// INSERT-----------------
	public String insertHospital(String HRegID, String HName, String HAddress, String HCity, String HDestrict,
			String HProvince, String HEmail, String HContactNum, String HUsername, String HPassword) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into hospital"
					+ "(`HRegID`,`HName`,`HAddress`,`HCity`,`HDestrict`,`HProvince`,`HEmail`,`HContactNum`,`HUsername`,`HPassword`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			System.out.println("VALUES");
			// binding values
			preparedStmt.setString(1, HRegID);
			preparedStmt.setString(2, HName);
			preparedStmt.setString(3, HAddress);
			preparedStmt.setString(4, HCity);
			preparedStmt.setString(5, HDestrict);
			preparedStmt.setString(6, HProvince);
			preparedStmt.setString(7, HEmail);
			preparedStmt.setString(8, HContactNum);
			preparedStmt.setString(9, HUsername);
			preparedStmt.setString(10, HPassword);
			// execute the statement
			System.out.println("VALUES1");
			preparedStmt.execute();
			System.out.println("VALUES3");
			con.close();
			String newHospitals = readHospitals();
			output = "{\"status\":\"success\", \"data\": \"" + newHospitals + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Hospital Details.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// READ--------------------
	public String readHospitals() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1' class='table table-striped table-dark'><tr class='bg-success'><th>HospitalRegID</th> <th>Hospital Name</th><th>Hospital Address</th>"
					+ "<th>Hospital City</th><th>Hospital District</th> <th>Hospital Province</th><th>Hospital Email</th>"
					+ "<th>Lab Contact Number</th> <th>Lab Username</th><th>Lab Password</th>"
					+ "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from Hospital";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String HRegID = rs.getString("HRegID");
				String HName = rs.getString("HName");
				String HAddress = rs.getString("HAddress");
				String HCity = rs.getString("HCity");
				String HDestrict = rs.getString("HDestrict");
				String HProvince = rs.getString("HProvince");
				String HEmail = rs.getString("HEmail");
				String HContactNum = rs.getString("HContactNum");
				String HUsername = rs.getString("HUsername");
				String HPassword = rs.getString("HPassword");

				// Add into the HTML table
				output += "<tr><td><input id='hidHospitalIDUpdate' name='hidHospitalIDUpdate' type='hidden' value='" + HRegID
						+ "'>" + HRegID + "</td>";
				output += "<td>" + HName + "</td>";
				output += "<td>" + HAddress + "</td>";
				output += "<td>" + HCity + "</td>";
				output += "<td>" + HDestrict + "</td>";
				output += "<td>" + HProvince + "</td>";
				output += "<td>" + HEmail + "</td>";
				output += "<td>" + HContactNum + "</td>";
				output += "<td>" + HUsername + "</td>";
				output += "<td>" + HPassword + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-info'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-hospitalid='"
						+ HRegID + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Hospital Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// UPDATE-----------------------------------------------------------------------------------
	public String updateHospital(String HRegID, String HName, String HAddress, String HCity, String HDestrict,
			String HProvince, String HEmail, String HContactNum, String HUsername, String HPassword) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE hospital SET HName=?,HAddress=?,HCity=?,HDestrict=?,HProvince=?,HEmail=?,HContactNum=?,HUsername=?,HPassword=? WHERE HRegID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, HName);
			preparedStmt.setString(2, HAddress);
			preparedStmt.setString(3, HCity);
			preparedStmt.setString(4, HDestrict);
			preparedStmt.setString(5, HProvince);
			preparedStmt.setString(6, HEmail);
			preparedStmt.setString(7, HContactNum);
			preparedStmt.setString(8, HUsername);
			preparedStmt.setString(9, HPassword);
			preparedStmt.setString(10, HRegID);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newHospitals = readHospitals();
			output = "{\"status\":\"success\", \"data\": \"" + newHospitals + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the  Hospital Details.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// DELETE-----------------------------------------
	public String deleteHospital(String HRegID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from hospital where HRegID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, HRegID);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newHospitals = readHospitals();
			output = "{\"status\":\"success\", \"data\": \"" + newHospitals + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the Hospital Details.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
