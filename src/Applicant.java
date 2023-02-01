import java.io.PrintWriter;
import java.io.StringWriter;

public class Applicant extends Person implements Comparable <Applicant> {

	String appID;
	private double ales;
	private double gpa;
	private double exam;
	private double interview;
	private double interview2;	
	private static double alesWeight= 0.35;
	private static double examWeight= 0.30;
	private static double intWeight= 0.15;
	private static double gpaWeight= 0.20;


	public Applicant(String appID, String firstName, String lastName, double ales, double gpa, double exam, double interview, double interview2) {

		super(firstName, lastName);
		this.appID = appID;
		setAles(ales);
		setGpa(gpa);
		setExam(exam);
		setInterview(interview);
		setInterview2(interview2);

	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public double getAles() {
		return ales;
	}

	public void setAles(double ales) {
		try {
			checkAles(ales);

		} catch (IncorrectScoreException ia) {

			StringWriter sw = new StringWriter();
			ia.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();				
			String err = exceptionAsString;

			String parts [] = err.split("at");
			int size = parts.length;
			String msg = parts[size-1];

			String msgparts [] = msg.split(":");
			int msgsize = msgparts.length;
			int id = msgsize-1;		
			String line = msgparts[id];

			System.out.printf("Exception ocurred: " + ia + " at line:%n%n" + msg +"%nScore of applicant at line  ("+ line +  "in main has been mapped to 0 due to this error.%n"
					+ "-----------------------------------------------------------------------------------------------------------------------------%n");
		}

		finally {
			this.ales=ales;
		}
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		try {
			checkGpa(gpa);

		} catch (IncorrectScoreException ia) {

			StringWriter sw = new StringWriter();
			ia.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();   
			String err = exceptionAsString;

			String parts [] = err.split("at");
			int size = parts.length;
			String msg = parts[size-1];

			String msgparts [] = msg.split(":");
			int msgsize = msgparts.length;
			int id = msgsize-1;		
			String line = msgparts[id];

			System.out.printf("Exception ocurred: " + ia + " at line:%n%n" + msg +"%nScore of applicant at line  ("+ line +  "in main has been mapped to 0 due to this error.%n" + "-----------------------------------------------------------------------------------------------------------------------------%n");

		}

		finally {
			this.gpa= gpa*25;
		}

	}

	public double getExam() {
		return exam;
	}

	public void setExam(double exam) {
		try {
			checkExam(exam);

		} catch (IncorrectScoreException ia) {

			StringWriter sw = new StringWriter();
			ia.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();		
			String err = exceptionAsString;

			String parts [] = err.split("at");
			int size = parts.length;
			String msg = parts[size-1];

			String msgparts [] = msg.split(":");
			int msgsize = msgparts.length;
			int id = msgsize-1;		
			String line = msgparts[id];

			System.out.printf("Exception ocurred: " + ia + " at line:%n%n" + msg +"%nScore of applicant at line  ("+ line +  "in main has been mapped to 0 due to this error.%n" + "-----------------------------------------------------------------------------------------------------------------------------%n");

		}

		finally {
			this.exam = exam;
		}

	}

	public double getInterview() {
		return interview;
	}

	public void setInterview(double interview) {
		try {
			checkInt1(interview);

		} catch (IncorrectScoreException ia) {

			StringWriter sw = new StringWriter();
			ia.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();			
			String err = exceptionAsString;

			String parts [] = err.split("at");
			int size = parts.length;
			String msg = parts[size-1];

			String msgparts [] = msg.split(":");
			int msgsize = msgparts.length;
			int id = msgsize-1;		
			String line = msgparts[id];

			System.out.printf("Exception ocurred: " + ia + " at line:%n%n" + msg +"%nScore of applicant at line  ("+ line +  "in main has been mapped to 0 due to this error.%n" + "-----------------------------------------------------------------------------------------------------------------------------%n");

		}

		finally {
			this.interview = interview*10;
		}

	}

	public double getInterview2() {
		return interview2;
	}

	public void setInterview2(double interview2) {
		try {
			checkInt2(interview2);

		} catch (IncorrectScoreException ia) {

			StringWriter sw = new StringWriter();
			ia.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			String err = exceptionAsString;

			String parts [] = err.split("at");
			int size = parts.length;
			String msg = parts[size-1];

			String msgparts [] = msg.split(":");
			int msgsize = msgparts.length;
			int id = msgsize-1;		
			String line = msgparts[id];

			System.out.printf("Exception ocurred: " + ia + " at line:%n%n" + msg +"%nScore of applicant at line  ("+ line +  "in main has been mapped to 0 due to this error.%n" + "-----------------------------------------------------------------------------------------------------------------------------%n");

		}

		finally {
			this.interview2 = interview2 * 10;
		}

	}

	public double getPoints() {
		double points = 0;

		if(getGpa()>=50) {
			points = getAles()*alesWeight + getGpa()*gpaWeight + getExam()*examWeight + ((getInterview()+getInterview2())/2)*intWeight;
		} 
		if (getGpa()<50) {
			points = 0;
		}
		if (getAles()<0) {
			points = 0;
		}
		if (getAles()>100)  {
			points = 0;
		}
		if (getExam()<0) {
			points = 0;
		}
		if (getExam()>100) {
			points = 0;
		}
		if (getInterview()>100) {
			points = 0;
		}
		if (getInterview()<0) {
			points = 0;
		}
		if (getInterview2()>100) {
			points = 0;
		}
		if (getInterview2()<0) {
			points = 0;
		}

		return points;
	}

	@Override
	public int compareTo(Applicant a) {
		if(getPoints() == a.getPoints()) {
			return 0;
		}
		else if(getPoints()> a.getPoints()){
			return -1;
		}
		else {
			return 1;
		}
	}

	public String toString(){	
		return String.format(getAppID() + "\t\t" +getFirstName() + "\t " + getLastName() +"  \t\t" +  getPoints());	
	}

	public static <E extends Comparable<E>> void sort(E[] list, boolean option) {

		if(option) {
			E currentMin;
			int currentMinIndex;
			for ( int i = 0; i < list.length - 1; i++) {
				currentMin = list[i];
				currentMinIndex = i;
				for( int j = i + 1; j < list.length; j++) {
					if(currentMin.compareTo(list[j]) > 0) {
						currentMin = list[j];
						currentMinIndex = j;
					}
				}

				if(currentMinIndex != i) {
					list[currentMinIndex] = list[i];
					list[i] = currentMin;
				}
			}	
		}

		else {
			E currentMax;
			int currentMaxIndex;
			for ( int i = 0; i < list.length - 1; i++) {
				currentMax = list[i];
				currentMaxIndex = i;
				for( int j = i + 1; j < list.length; j++) {
					if(currentMax.compareTo(list[j]) < 0) {
						currentMax = list[j];
						currentMaxIndex = j;
					}
				}

				if(currentMaxIndex != i) {
					list[currentMaxIndex] = list[i];
					list[i] = currentMax;
				}
			}	
		}
	}

	public static void checkAles(double ales)throws IncorrectScoreException  {
		if(ales>100 || ales<0) {
			throw new IncorrectScoreException("ALES score must be between 0 and 100");
		} else {

		}
	}

	public static void checkGpa(double gpa)throws IncorrectScoreException {
		if(gpa>4 || gpa<0) {
			throw new IncorrectScoreException("GPA must be between 0 and 4");
		} else {

		}
	}	

	public static void checkExam(double exam)throws IncorrectScoreException {
		if(exam>100 || exam<0) {
			throw new IncorrectScoreException("Exam score must be between 0 and 100");
		} else {

		}
	}

	public static void checkInt1(double interview)throws IncorrectScoreException {
		if(interview>10 || interview<0) {
			throw new IncorrectScoreException("Interview score must be between 0 and 10");
		} else {

		}
	}

	public static void checkInt2(double interview2) throws IncorrectScoreException {
		if(interview2>10 || interview2<0) {
			throw new IncorrectScoreException("Interview score must be between 0 and 10");
		} else {
		}

	}  
}


