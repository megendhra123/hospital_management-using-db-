package hospital_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Process {

	void setPatientDetails(int patientId,String patientName, String patientDob, String patientPhoneNumber,
			String patientAddress, String patientType) {
		DataBaseConnection dataBase = new DataBaseConnection();
		Connection connection = dataBase.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into patient values(?,?,?,?,?,?)");
				preparedStatement.setInt(1, patientId);
				preparedStatement.setString(2, patientName);
				preparedStatement.setString(3, patientDob);
				preparedStatement.setString(4, patientPhoneNumber);
				preparedStatement.setString(5, patientAddress);
				preparedStatement.setString(6, patientType);
				preparedStatement.executeUpdate();
				System.out.println("Patient details inserted successfully");
			} catch (SQLException e) {
				System.out.println("Failed to insert details");
				System.out.println("ERROR : " + e.getMessage() + "\nERROR CODE : " + e.getErrorCode());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Connection not closed");
					System.out.println("ERROR : " + e.getMessage() + "\nERROR CODE : " + e.getErrorCode());
				}
			}
		} else {
			System.out.println("Failed to insert details because connection is null");
		}
	}
}
