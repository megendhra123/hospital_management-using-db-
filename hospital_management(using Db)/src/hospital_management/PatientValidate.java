package hospital_management;

import java.util.Scanner;

public class PatientValidate {
	int patientid;
	String patientName;
	String patientDob;
	String patientPhoneNumber;
	String patientAddress;
	String patientType;

	public void setPatientid() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient Id : ");
		int patientid = sc.nextInt();
		if (patientid > 399999 && patientid < 499999) {
			this.patientid = patientid;
		} else {
			System.out.println("Enter a valid patient id");
			setPatientid();
		}
	}

	public int getPatientid() {
		return this.patientid;
	}

	public void setPatientName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient Name : ");
		String patientName = sc.nextLine();
		if (patientName != null && !patientName.isEmpty()) {
			this.patientName = patientName;
		} else {
			System.out.println("Enter a valid patient name");
			setPatientName();
		}
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientDob() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient Dob : ");
		String patiebtDob = sc.nextLine();
		if (DateValidate.dateValidate(patiebtDob)) {
			this.patientDob = patiebtDob;
		} else {
			System.out.println("Enter a valid date formate(yyyy/MM/dd) ");
			setPatientDob();
		}
	}

	public String getPatientDob() {
		return this.patientDob;
	}

	public void setPatientPhoneNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient Phone Number : ");
		String patientPhoneNumber = sc.next();
		if (patientPhoneNumber != null && !patientPhoneNumber.isEmpty() && patientPhoneNumber.length() == 10) {
			this.patientPhoneNumber = patientPhoneNumber;
		} else {
			System.out.println("Enter a valid patient Phone number");
			setPatientPhoneNumber();
		}
	}

	public String getPatientPhoneNumber() {
		return this.patientPhoneNumber;
	}

	public void setPatientAddress() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient patient address : ");
		String patientAddress = sc.nextLine();
		if (patientAddress != null && !patientAddress.isEmpty()) {
			this.patientAddress = patientAddress;
		} else {
			System.out.println("Enter a valid patient address ");
			setPatientAddress();
		}
	}

	public String getPatientAddress() {
		return this.patientAddress;
	}

	public void setPatientType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient patient type : ");
		String patientType = sc.nextLine();
		if (patientType.equalsIgnoreCase("IN PATIENT") || patientType.equalsIgnoreCase("OUT PATIENT")) {
			this.patientType = patientType;
		} else {
			System.out.println("Enter a valid patient type ");
			setPatientType();
		}
	}

	public String getPatientType() {
		return this.patientType;
	}

}
