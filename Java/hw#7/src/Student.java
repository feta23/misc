
public class Student {
	/*
	 * George Fotiou
	 * 4/16/2020
	 * This object is used for a student report
	 */
	
	private String firstName;
	private String lastName;
	private int idNumb;
	private double exam1;
	private double exam2;
	private double exam3;
	private double Finalexam;
	private double average;
	private double projection;

	public Student() {
		firstName = "";
		lastName = "";
		idNumb = 0;
		exam1 = 0;
		exam2 = 0;
		exam3 = 0;
		Finalexam = 0;
		average = 0;
		projection = 0;
	}

	public void setName(String first, String last) {

		firstName = first;
		lastName = last;
	}

	public String getName() {
		String fullName = firstName + " " + lastName;
		return fullName;
	}

	public String getFormalName() {
		String formalName = lastName + ", " + firstName;
		return formalName;
	}

	public void setID(int id) {
		idNumb = id;
	}

	public int getID() {
		return idNumb;
	}

	public void setExamScore(int examNumber, double score) {
		if (score > 100) {
			score = 100;
		}
		if (score < 0) {
			score = 0;
		}
		if (examNumber == 1) {
			exam1 = score;
		} else if (examNumber == 2) {
			exam2 = score;
		} else if (examNumber == 3) {
			exam3 = score;
		}
	}

	public double getExamScore(int examNumber) {
		if (examNumber == 1) {
			return exam1;
		}
		if (examNumber == 2) {
			return exam2;
		}
		if (examNumber == 3) {
			return exam3;
		} else
			return 0;
	}

	public void setFinalExamScore(double score) {
		if (score > 200) {
			score = 200;
		}
		if (score < 0) {
			score = 0;
		}
		Finalexam = score;
	}

	public double getFinalExamScore() {
		return Finalexam;
	}

	public double ExamAverage() {
		average = (exam1 + exam2 + exam3) / 3.0;
		return average;
	}

	public double Average() {
		average = (exam1 + exam2 + exam3 + Finalexam) / 5.0;
		return average;
	}

	public double FinalProjection(double target) {
		target = (target * .01);
		projection = (500 * target) - (ExamAverage() * 3);
		return projection;
	}

	public String LetterGrade() {

		if (average < 60) {
			return "F";
		}
		if (average >= 60 && average < 70) {
			return "D";
		}
		if (average >= 70 && average < 80) {
			return "C";
		}
		if (average >= 80 && average < 90) {
			return "B";
		}
		if (average >= 90) {
			return "A";
		} else
			return "";
	}

}
