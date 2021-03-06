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

				if (resultSet.isBeforeFirst() == true) {
					while (resultSet.next()) {
						System.out.println("Patient Id : " + resultSet.getInt(1));
						System.out.println("Patient Name : " + resultSet.getString(2));
						System.out.println("Patient DOB : " + resultSet.getString(3));
						System.out.println("Patient PhNo : " + resultSet.getString(4));
						System.out.println("Patient Address : " + resultSet.getString(5));
						System.out.println("Patient Type : " + resultSet.getString(6));
					}
				} else {
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

	void showPatientListOfVisit(int patientId) {
		DataBaseConnection baseConnection = new DataBaseConnection();
		Connection connection = baseConnection.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"select DATE_OF_VISIT,PURPOSE_OF_VISIT,DOCTOR_TO_VISIT from appointment where PATIENT_ID = "
								+ patientId);

				if (resultSet.isBeforeFirst() == true) {
					System.out.println("List of visit for Patient Id : " + patientId);

					while (resultSet.next()) {
						System.out.println("\n-----------------------------------------\n");
						System.out.println("Date of visit : " + resultSet.getDate(1));
						System.out.println("Purpose of visit : " + resultSet.getString(2));
						System.out.println("Doctor to visit : " + resultSet.getInt(3));
						System.out.println("\n-----------------------------------------\n");
					}
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				} else {
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

	void showDateRangeVisitDetails(String fromDate, String toDate) {
		DataBaseConnection baseConnection = new DataBaseConnection();
		Connection connection = baseConnection.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"select PATIENT_ID,DATE_OF_VISIT,PURPOSE_OF_VISIT,DOCTOR_TO_VISIT from appointment WHERE DATE_OF_VISIT BETWEEN '"
								+ fromDate + "' AND '" + toDate + "'");

				if (resultSet.isBeforeFirst() == true) {
					System.out.println("List of visit for Date Range between " + fromDate + " and " + toDate);
					while (resultSet.next()) {
						System.out.println("\n-----------------------------------------\n");
						System.out.println("Patient Id : " + resultSet.getInt(1));
						System.out.println("Date of visit : " + resultSet.getDate(2));
						System.out.println("Purpose of visit : " + resultSet.getString(3));
						System.out.println("Doctor to visit : " + resultSet.getInt(4));
						System.out.println("\n-----------------------------------------\n");
					}
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				} else {
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

	void showFollowUpNeededPatient() {
		DataBaseConnection baseConnection = new DataBaseConnection();
		Connection connection = baseConnection.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select DISTINCT patient.PATIENT_ID,patient.PATIENT_NAME, "
						+ " FOLLOW_UP_NEEDED from consultationInformation "
						+ " JOIN patient ON patient.PATIENT_ID = consultationInformation.PATIENT_ID "
						+ " WHERE FOLLOW_UP_NEEDED = 'FOLLOW UP NEEDED'");
				if (resultSet.isBeforeFirst() == true) {
					System.out.println("List of patient who need follow up visit ");
					while (resultSet.next()) {
						System.out.println("\n-----------------------------------------\n");
						System.out.println("Patient Id : " + resultSet.getInt(1));
						System.out.println("Patient Name : " + resultSet.getString(2));
						System.out.println("is Follow up Needed? : " + resultSet.getString(3));
						System.out.println("\n-----------------------------------------\n");
					}
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				} else {
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

	void showListOfPatientByDoctorId(int doctorId) {
		DataBaseConnection baseConnection = new DataBaseConnection();
		Connection connection = baseConnection.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"select DISTINCT PATIENT_ID from appointment WHERE DOCTOR_TO_VISIT = " + doctorId);
				if (resultSet.isBeforeFirst() == true) {
					System.out.println("List of patient by doctor ID : " + doctorId);
					while (resultSet.next()) {
						System.out.println("\n-----------------------------------------\n");
						System.out.println("Patient Id : " + resultSet.getInt(1));
					}
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				} else {
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

	void showTypePatientList(String patientType) {
		DataBaseConnection baseConnection = new DataBaseConnection();
		Connection connection = baseConnection.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select PATIENT_ID, PATIENT_NAME, PATIENT_PHONE_NUMBER, PATIENT_TYPE from patient"
								+ " WHERE PATIENT_TYPE = '"+patientType+"'");
				if (resultSet.isBeforeFirst() == true) {
					System.out.println("List of In Patient");
					while (resultSet.next()) {
						System.out.println("Patient Id : " + resultSet.getInt(1));
						System.out.println("Patient Name : " + resultSet.getString(2));
						System.out.println("Patient Phone number : " + resultSet.getString(3));
						System.out.println("Patient Type : " + resultSet.getString(4));
					}
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				} else {
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
			System.out.println("Failed to get patient details from database because connection is null");
		}
	}

	void showTodayVisitPatientList() {
		DataBaseConnection baseConnection = new DataBaseConnection();
		Connection connection = baseConnection.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"select PATIENT_ID, DOCTOR_TO_VISIT, DATE_OF_VISIT, PURPOSE_OF_VISIT from appointment"
								+ " WHERE DATE_OF_VISIT = (select CURDATE() AS TODAY)");
				if (resultSet.isBeforeFirst() == true) {
					System.out.println("List of Out Patient");
					while (resultSet.next()) {
						System.out.println("\n-----------------------------------------\n");
						System.out.println("Patient Id : " + resultSet.getInt(1));
						System.out.println("Doctor to visit : " + resultSet.getString(2));
						System.out.println("Date of visit : " + resultSet.getString(3));
						System.out.println("PPurpose of visit : " + resultSet.getString(4));
					}
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				} else {
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
			System.out.println("Failed to get patient details from database because connection is null");
		}
	}
}
