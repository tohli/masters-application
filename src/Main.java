//Masters application program. Last edited 7.39 PM 04/06/2022
//Feyza Ozturk & Yusuf Coskun

public class Main {

    public static void main(String[] args) {
		Applicant [] applicants= {

				//Applicant ID, Name, Surname, ALES Score, GPA, Exam score, Interviewer 1, Interviewer 2

				new Applicant("123123", "Feyza", "Ozturk", 99, 4, 70, 11, 7),
				new Applicant("345634", "Yusuf", "Coskun", 50, 3, 70, 8 ,7),
				new Applicant("354321", "Ali", "Demirag", 50, 3, 100, 9 ,8),
				new Applicant("234234", "Husna", "Agirbas", 100, 4, 100, 10, 10),
				new Applicant("356321", "Ferman", "Akgul", 100, 4, 70, 8 ,7),
		};


	
		
		Applicant.sort(applicants, true); //True sorts by descending order, false sorts by ascending order.
		

		System.out.printf("%3s %2s %5s %2s %10s %4s %14s %n", "Applicant ID", "|", "Name","|", "Surname", "|"
				, "Final Score");
		System.out.println("---------------------------------------------------------------------");


		for (Applicant s:applicants) {

			System.out.println(s.toString());
		}
	}
}