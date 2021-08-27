package hospital_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Appointment {
	public Appointment(AppointmentValidate appointmentValidate) {
		int count = 1, patientAvailable = 0;
		boolean isPatientAvailable,isBookedAlready;
		DataBaseConnection dataBase = new DataBaseConnection();
		Connection connection = dataBase.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet;
				 resultSet = statement.executeQuery(
						"select count(*) from patient where PATIENT_ID =" + appointmentValidate.getPatientId());
				isPatientAvailable=resultSet.isBeforeFirst();
				
				resultSet = statement.executeQuery(
						"select count(*) from appointment WHERE PATIENT_ID = "+appointmentValidate.getPatientId()+" AND DATE_OF_VISIT = "+appointmentValidate.getDateOfVisit());
				isBookedAlready=resultSet.isBeforeFirst();
				
				if(isPatientAvailable==true) {
					 if(isBookedAlready==false) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("insert into appointment values(?,?,?,?,?,?)");
						preparedStatement.setInt(1, appointmentValidate.getPatientId());
						preparedStatement.setString(2, appointmentValidate.getDateOfVisit());
						preparedStatement.setString(3, appointmentValidate.getPurposeOfVisit());
						preparedStatement.setFloat(4, appointmentValidate.getPatientTempetatue());
						preparedStatement.setFloat(5, appointmentValidate.getPatientBp());
						preparedStatement.setInt(6, appointmentValidate.getDoctorToVisit());
						preparedStatement.executeUpdate();
						System.out.println("Appointment Booked successfully");
					} else {
						System.out.println("Appointment for the patient is already booked on the date");
				}
				} else {
					System.out.println("Patient record not found please create a patient record to book appointment");
				}
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
