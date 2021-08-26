package hospital_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Report {
	
	void showPatientDetails(int patientId, String patientName) {
		DataBaseConnection baseConnection = new DataBaseConnection();
		Connection connection = baseConnection.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select *from patient where PATIENT_ID = " + patientId
						+ " AND PATIENT_NAME = '" + patientName + "'");
				 if(resultSet.next()) {
					 resultSet.beforeFirst();
				while (resultSet.next()) {
					System.out.println("Patient Id : " + resultSet.getInt(1));
					System.out.println("Patient Name : " + resultSet.getString(2));
					System.out.println("Patient DOB : " + resultSet.getString(3));
					System.out.println("Patient PhNo : " + resultSet.getString(4));
					System.out.println("Patient Address : " + resultSet.getString(5));
					System.out.println("Patient Type : " + resultSet.getString(6));
					}
				}else {
					System.out.println("record not found");
				}
			} catch (SQLException e) {
				System.out.println("ERROR : " + e.getMessage() + "ERROR CODE : " + e.getErrorCode());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close the connection while getting patient details");
					System.out.println("ERROR : " + e.getMessage() + "\nERROR CODE : " + e.getErrorCode());
				}
			}
		} else {
			System.out.println("Failed to get patient details from database bease connection is null");
		}
	}

}
