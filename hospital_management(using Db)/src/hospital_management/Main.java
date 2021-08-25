package hospital_management;

import java.util.Date;
import java.util.Scanner;

public class Main {

	void optionsMain() {
		System.out.println("Enter 1 for set details");
		System.out.println("Enter 2 for get details");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if (option == 1) {
			setDetailsOptions();
		} else if (option == 2) {
			getPatientDetails();
		} else {
			System.out.println("Enter a valid option");
			optionsMain();
		}
	}

	void setDetailsOptions() {
		System.out.println("1. book appointment for new patient");
		System.out.println("2. book appointment for Existing patient");
		System.out.println("3. enter consultation information");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();

		switch (option) {
		case 1:
			setPatientDetails();

			break;

		default:
			System.out.println("Enter a valid option");
			exit();
			break;
		}
	}

	void getDetailsOptions() {
		System.out.println("1. Display patient details for patient id and name");
		System.out.println("2. Display list of visit for patient id");
		System.out.println("3. Display visit details for given date range");
		System.out.println("4. Display list of patient who need follow visit");
		System.out.println("5. Display the list of patient by doctor id");
		System.out.println("6. Display all patient who are InPatient");
		System.out.println("7. Display ponly out patient");
		System.out.println("8. Display today visited patient");
		System.out.print("Enter your choice : ");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();

		switch (option) {
		case 1:
			getPatientDetails();
			break;

		default:
			System.out.println("Enter a valid option");
			exit();
			break;
		}

	}

	void setPatientDetails() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter patient Id : ");
		int patientId = sc.nextInt();
		if (patientId > 399999 && patientId < 500000) {
			System.out.print("Enter patient name : ");
			String patientName = sc.nextLine();
			if (patientName != null && !patientName.isEmpty()) {
				System.out.print("Enter patient DOB : ");
				String patientDob = sc.next();
				if (patientDob != null && !patientDob.isEmpty()) {
					System.out.print("Enter patient phone number : ");
					String patientPhoneNumber = sc.next();
					if (patientPhoneNumber != null && !patientPhoneNumber.isEmpty()
							&& patientPhoneNumber.length() == 10) {
						System.out.print("Enter patient location : ");
						String patientAddress = sc.next();
						if (patientAddress != null && !patientAddress.isEmpty()) {
							System.out.print("Enter patient type : ");
							String patientType = sc.nextLine();
							if (patientType.equalsIgnoreCase("in patient") ||patientType.equalsIgnoreCase("out patient") ) {
								Process process = new Process();
								process.setPatientDetails(patientId, patientName, patientDob, patientPhoneNumber,
										patientAddress, patientType);
							} else {
								System.out.println("please enter a vaid patient type");
							}
						} else {
							System.out.println("please enter a valid patient address");
						}
					} else {
						System.out.println("please enter a vaild patient phone number");
					}
				} else {
					System.out.println("please enter a valid patient dob");
				}
			} else {
				System.out.println("please enter a vaid patient name");
				exit();
			}
		} else {
			System.out.println("please enter a valid patient id");
			exit();
		}
	}

	void getPatientDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Patient Name");
		String patientName = sc.next();
		System.out.println("Enter you Patient Id :");
		int patientId = sc.nextInt();
		if (patientName != null && !patientName.isEmpty() && patientId > 399999 && patientId < 500000) {
			DataStorage patient = new DataStorage();
			patient.showPatientDetails(patientId, patientName);
		} else {
			System.out.println("Enter a vaid details");
		}
	}

	void exit() {
		System.out.println("Press any key then press enter to exit");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		optionsMain();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.optionsMain();
	}

}
