package hospital_management;

import java.util.Scanner;

public class ConsultationValidation {
	int visitId;
	int patientId;
	int doctorId;
	String doctorRecommendation;
	int medicineId;
	String followUpNeeded;

	public void setPatientVisitid() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Visit Id : ");
		int visitId = sc.nextInt();
		if (visitId > 499) {
			this.visitId = visitId;
		} else {
			System.out.println("Enter a valid visit id ");
			setPatientVisitid();
		}
	}

	public int getPatientVisitid() {
		return this.visitId;
	}

	public void setPatientId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Patient Id : ");
		int patientId = sc.nextInt();
		if (patientId > 399999 && patientId < 499999) {
			this.patientId = patientId;
		} else {
			System.out.println("Enter a valid patient id ");
			setPatientId();
		}
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setDoctorId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Doctor Id : ");
		int doctorId = sc.nextInt();
		if (doctorId > 29999 && doctorId < 39999) {
			this.doctorId = doctorId;
		} else {
			System.out.println("Enter a valid doctor id ");
			setDoctorId();
		}
	}

	public int getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorRecommendation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter doctor recommendation : ");
		String doctorRecommendation = sc.nextLine();
		if (doctorRecommendation != null && !doctorRecommendation.isEmpty()) {
			this.doctorRecommendation = doctorRecommendation;
		} else {
			System.out.println("Enter a  valid doctor recommendation");
			setDoctorRecommendation();
		}
	}

	public String getDoctorRecommendation() {
		return this.doctorRecommendation;
	}

	public void setMedicineId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Medicine Id : ");
		int medicineId = sc.nextInt();
		if (medicineId > 1999 && medicineId < 2999) {
			this.medicineId = medicineId;
		} else {
			System.out.println("Enter a valid meicine id ");
			setMedicineId();
		}
	}

	public int getMedicineId() {
		return this.medicineId;
	}

	public void setFollowUpNeeded() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Is follow up needed | type 'y' for Yes OR 'n' for No ");
		String isFollowUpNeeded = sc.nextLine();
		if (isFollowUpNeeded.equalsIgnoreCase("y")) {
			this.followUpNeeded = "FOLLOW UP NEEDED";
		} else if(isFollowUpNeeded.equalsIgnoreCase("n")){
			this.followUpNeeded = "FOLLOW UP NOT NEEDED";
		}else {
			System.out.println("Enter a valid details ");
			setFollowUpNeeded();
		}
	}
	
	public String getFollowUpNeeded() {
		return this.followUpNeeded;
	}

}
