package hospital_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Appointment {
	public Appointment(AppointmentValidate appointmentValidate) {
		int count = 1;
		boolean isPatientAvailable,isBookedAlready,isInPatient;
		DataBaseConnection dataBase = new DataBaseConnection();
		Connection connection = dataBase.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet;
				 resultSet = statement.executeQuery(
						"select * from patient where PATIENT_ID =" + appointmentValidate.getPatientId());
				isPatientAvailable=resultSet.isBeforeFirst();
				
				resultSet = statement.executeQuery(
						"select count(*) from appointment WHERE PATIENT_ID = "+appointmentValidate.getPatientId());
				while(resultSet.next()) {
					count=resultSet.getInt(1);
				}
				resultSet = statement.executeQuery(
						"select * from appointment WHERE PATIENT_ID = "+appointmentValidate.getPatientId()+" AND DATE_OF_VISIT = "+appointmentValidate.getDateOfVisit());
				isBookedAlready=resultSet.isBeforeFirst();
				
				if(isPatientAvailable==true) {
						if(count<4) {
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
				}else {
					System.out.println("THe patient visited more than 3 times please book as in patient");
					convertInPatient(appointmentValidate.getPatientId()); 
					}
					}else {
						System.out.println("The Patient is InPatient");
				}
				}catch (SQLException e) {
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
	
	void convertInPatient(int patientId) {
		DataBaseConnection dataBase = new DataBaseConnection();
		Connection connection = dataBase.getConnection();
		Statement statement;
		ResultSet resultSet;
		int newInPatientId = 0,newBedId = 0;
		
		if (connection != null) {
			try {
				statement = connection.createStatement();
				resultSet = statement
						.executeQuery("select InPatient_ID,BED_ID from InPatient ORDER BY InPatient_ID  DESC LIMIT 1");
				while(resultSet.next()) {
					newInPatientId=resultSet.getInt(1)+1;
					newBedId=resultSet.getInt(2)+1;
				}
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into InPatient values(?,?,?)");
				preparedStatement.setInt(1, patientId);
				preparedStatement.setInt(2, newInPatientId);
				preparedStatement.setInt(3, newBedId);
				preparedStatement.executeUpdate();
				System.out.println("InPatient details inserted successfully");
				//code  to get in patient details
			}catch (SQLException e) {
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
		}
	}
}
