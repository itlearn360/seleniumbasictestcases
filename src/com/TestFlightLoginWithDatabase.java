package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.WebElement;

public class TestFlightLoginWithDatabase {

	private static String username;
	private static String password;

	public static void main(String[] args) {
		// get firefox driver
		CommonCodes.getDriver();
		// get the username and password from database and assign into username
		// and password variable
		getDatabaseForLogin();
		// open the newtours flight reservation application..
		CommonCodes.openBrowser("http://newtours.demoaut.com");
		// get the username field object¦
		WebElement user = CommonCodes.getWebElement("name", "userName");
		// pass username into field by sendKeys method..
		user.sendKeys(username);
		// get the password field object¦
		WebElement pass = CommonCodes.getWebElement("name", "password");
		// pass username into field by sendKeys method..
		pass.sendKeys(password);
		// submit the form..
		pass.submit();
		// get the sign-off element object¦.
		WebElement logout = CommonCodes.getWebElement("link", "SIGN-OFF");
		// click on sign-off element by click_element of CommonCodes method..
		CommonCodes.click_element(logout, "name", "userName");
		// close the driver by CommonCodes closeDriver method and browser
		// will be close
		CommonCodes.closeDriver();
	}

	private static void getDatabaseForLogin() {
		Connection con = null;
		try {
			// register mysql driver : this step causes JVM to load the desired
			// driver implementation into memory so fill your JDBC requests.
			Class.forName("com.mysql.jdbc.Driver");
			// get object of connection by help of Drivermanager getConnetion
			// method.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			// get the object of CreateStatement to execute database query..
			Statement stmt = con.createStatement();
			String sql = "select username, password from flight_login LIMIT 1";
			// get the result set object which holds the records fetched by
			// database query.
			ResultSet rs = stmt.executeQuery(sql);
			// check if resul tset has any record, if yes then extract the data
			// from resultset object by passing column what we passed into
			// database query.
			if (rs.next()) {
				// extract username from resultset object and assign into
				// username variable
				username = rs.getString("username");
				// extract password from resultset object and assign into
				// password variable
				password = rs.getString("password");
			}
		}
		// catch the exception if driver class does not find.
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// catch the database access error or other error
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}