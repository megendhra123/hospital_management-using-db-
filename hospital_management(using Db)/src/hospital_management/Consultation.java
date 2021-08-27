package hospital_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultation {
	public Consultation(ConsultationValidation consultationValidation) {
		DataBaseConnection dataBase = new DataBaseConnection();
		Connection connection = dataBase.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet=statement.executeQuery("select *from appointment where PATIENT_ID = "+consultationValidation.patientId+" AND DATE_OF_VISIT = (select CURDATE() as TODAY)");
				if(resultSet.isBeforeFirst()==true) {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into consultationInformation values(?,?,?,?,?,?)");
				preparedStatement.setInt(1, consultationValidation.getPatientVisitid());
				preparedStatement.setInt(2, consultationValidation.getPatientId());
				preparedStatement.setInt(3, consultationValidation.getDoctorId());
				preparedStatement.setString(4, consultationValidation.getDoctorRecommendation());
				preparedStatement.setInt(5, consultationValidation.getMedicineId());
				preparedStatement.setString(6, consultationValidation.getFollowUpNeeded());
				preparedStatement.executeUpdate();
				System.out.println("Consultation details inserted successfully");
				}else {
					System.out.println("The patient does not have appointment for today");
				}
			} catch (SQLException e) {
				if(e.getErrorCode()==1062) {
					System.out.println("The patient is already visted");
				}
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
