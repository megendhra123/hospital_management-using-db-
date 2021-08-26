package hospital_management;

import java.util.Date;
import java.util.Scanner;

public class AppointmentValidate {
	int patientId;
	String dateOfVisit;
	String purposeOfVisit;
	float bP;
	float temperature;
	int doctorToVisit;

	public void setPatientId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Ptient Id : ");
		int patientId = sc.nextInt();
		if (patientId > 39999 && patientId < 500000) {
			this.patientId = patientId;
		} else {
			System.out.println("Enter a valid patient Id");
			setPatientId();
		}
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setDateOfVisit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Date of Visit(yyyy/MM/dd) : ");
		String dateOfVisit = sc.next();
		try {
			Date.parse(dateOfVisit);
			this.dateOfVisit = dateOfVisit;
		} catch (Exception e) {
			System.out.println("Enter vaild date formate");
			setDateOfVisit();
		}
	}

	public String getDateOfVisit() {
		return this.dateOfVisit;
	}

	public void setPurposeOfVisit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Purpose of visit : ");
		String purposeOfVisit = sc.nextLine();
		if (purposeOfVisit != null && !purposeOfVisit.isEmpty()) {
			this.purposeOfVisit = purposeOfVisit;
		} else {
			System.out.println("Enter vaild purpose of visit details");
			setPurposeOfVisit();
		}
	}

	public String getPurposeOfVisit() {
		return this.purposeOfVisit;
	}

	public void setPatientBp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Patient Bp : ");
		float bP = sc.nextFloat();
		if (bP > 0) {
			this.bP = bP;
		} else {
			System.out.println("Enter a vaild BP measure");
			setPatientBp();
		}
	}

	public float getPatientBp() {
		return this.bP;
	}

	public void setPatientTemperature() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Patient Temperature : ");
		float temperature = sc.nextFloat();
		if (temperature > 0) {
			this.temperature = temperature;
		} else {
			System.out.println("Enter a vaild temperature measure");
			setPatientTemperature();
		}
	}

	public float getPatientTempetatue() {
		return this.temperature;
	}

	public void setDoctorToVisit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Doctor Id to visit : ");
		int doctorTovist = sc.nextInt();
		if (doctorTovist > 29999 && doctorTovist < 39999) {
			this.doctorToVisit = doctorTovist;
		} else {
			System.out.println("Enter a valid Doctor id");
			setDoctorToVisit();
		}
	}

	public int getDoctorToVisit() {
		return this.doctorToVisit;
	}
}
