package hospital_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	static String url = "jdbc:mariadb://localhost:3306/hospitalManagement";
	static String user = "root";
	static String password = "magi";

	Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("ERROR :" + e.getMessage() + " ERROR CODE : " + e.getErrorCode());
		}
		return connection;
	}

}
