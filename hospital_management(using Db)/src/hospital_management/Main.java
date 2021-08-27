package hospital_management;

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
			getDetailsOptions();
		} else {
			System.out.println("Enter a valid option");
			optionsMain();
		}
	}

	void setDetailsOptions() {
		System.out.println("1. Entry new patient");
		System.out.println("2. Book appointment for Existing patient");
		System.out.println("3. Enter consultation information");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch (option) {
		case 1:
			setPatientDetails();
			exit();
			break;
			
		case 2:
			setAppointmentDetails();
			exit();
			break;
			
		case 3:
			setConsultationDetails();
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
			exit();
			break;
			
		case 2:
			getPatientListOfVisit();
			exit();
			break;
			
		case 3:
			getDateRangeVisitList();

		default:
			System.out.println("Enter a valid option");
			exit();
			break;
		}

	}

	void setPatientDetails() {
		PatientValidate patientValidate=new PatientValidate();
		patientValidate.setPatientid();
		patientValidate.setPatientName();
		patientValidate.setPatientDob();
		patientValidate.setPatientPhoneNumber();
		patientValidate.setPatientAddress();
		patientValidate.setPatientType();
		new Patient(patientValidate);
	}
	
	void setAppointmentDetails() {
		AppointmentValidate appointmentValidate=new AppointmentValidate();
		appointmentValidate.setPatientId();
		appointmentValidate.setDateOfVisit();
		appointmentValidate.setPurposeOfVisit();
		appointmentValidate.setPatientBp();
		appointmentValidate.setPatientTemperature();
		appointmentValidate.setDoctorToVisit();
		new Appointment(appointmentValidate);
	}
	
	void setConsultationDetails(){
		ConsultationValidation consultationValidation=new ConsultationValidation();
		consultationValidation.setPatientVisitid();
		consultationValidation.setPatientId();
		consultationValidation.setDoctorId();
		consultationValidation.setDoctorRecommendation();
		consultationValidation.setMedicineId();
		consultationValidation.setFollowUpNeeded();
		new Consultation(consultationValidation);
	}

	void getPatientDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Patient Name");
		String patientName = sc.next();
		System.out.println("Enter you Patient Id :");
		int patientId = sc.nextInt();
		if (patientName != null && !patientName.isEmpty() && patientId > 399999 && patientId < 500000) {
			Report report = new Report();
			report.showPatientDetails(patientId, patientName);
		} else {
			System.out.println("Enter a vaid details");
		}
	}
	
	void getPatientListOfVisit(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter you Patient Id :");
		int patientId = sc.nextInt();
		if ( patientId > 399999 && patientId < 500000) {
			Report report = new Report();
			report.showPatientListOfVisit(patientId);
		} else {
			System.out.println("Enter a vaid details");
		}
	}
	
	void getDateRangeVisitList() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Date from(yyyy/MM/dd) :");
		String fromDate = sc.next();
		System.out.println("Date to(yyyy/MM/dd) :");
		String toDate = sc.next();
		if(DateValidate.dateValidate(fromDate) && DateValidate.dateValidate(toDate)) {
			Report report = new Report();
			report.showDateRangeVisitDetails(fromDate, toDate);
		}else {
			System.out.println("Enter a vaild date formate");
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
