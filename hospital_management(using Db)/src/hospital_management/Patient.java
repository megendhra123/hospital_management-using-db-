package hospital_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Patient {
	public Patient(PatientValidate patientValidate) {
		DataBaseConnection dataBase = new DataBaseConnection();
		Connection connection = dataBase.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into patient values(?,?,?,?,?,?)");
				preparedStatement.setInt(1, patientValidate.getPatientid());
				preparedStatement.setString(2, patientValidate.getPatientName());
				preparedStatement.setString(3, patientValidate.getPatientDob());
				preparedStatement.setString(4, patientValidate.getPatientPhoneNumber());
				preparedStatement.setString(5, patientValidate.getPatientAddress());
				preparedStatement.setString(6, patientValidate.getPatientType());
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
	
