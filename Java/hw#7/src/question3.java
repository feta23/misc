import java.util.Scanner;
/*
 * George Fotiou
 * 4/16/2020
 * This program uses the Student Object for a student to print a report
 */
public class question3 {

	public static void PrintProperties(Student a) {
		System.out.println("Student Progress Report " + a.getFormalName() + " (" + a.getID() + ")");
		System.out.println("Exam Scores");
		System.out.println("Exam 1 = " + a.getExamScore(1));
		System.out.println("Exam 2 = " + a.getExamScore(2));
		System.out.println("Exam 3 = " + a.getExamScore(3));
		System.out.println("Final = " + a.getFinalExamScore());
		System.out.println("Average = " + a.Average());
		System.out.println("Letter Grade = " + a.LetterGrade());
	}

	public static void main(String[] args) {

		Scanner kbd = new Scanner(System.in);
		Student student1 = new Student();

		int quit = 0;
		while (quit == 0) {
			System.out.println("");
			System.out.println("1. Input Student's Name");
			System.out.println("2. Input Student ID");
			System.out.println("3. Input Exam Score ");
			System.out.println("4. Input Final Exam Score ");
			System.out.println("5. Print Exam Average without the Final Exam");
			System.out.println("6. Calculate Final Exam Projection");
			System.out.println("7. Print Student Report");
			System.out.println("8. Quit");
			System.out.println("");
			System.out.print("Selection: ");
			int selection = kbd.nextInt();

			String firstName = " ";
			String lastName = " ";
			int id = 0;
			int examNumber = 0;
			double score = 0.0;
			double Finalscore = 0.0;
			double target = 0.0;
			double projection = 0.0;
			if (selection == 1) {
				System.out.print("Enter First Name:");
				firstName = kbd.next();
				System.out.print("Enter Last Name:");
				lastName = kbd.next();
				student1.setName(firstName, lastName);
			} else if (selection == 2) {
				System.out.print("Enter ID:");
				id = kbd.nextInt();
				student1.setID(id);
			} else if (selection == 3) {
				System.out.print("Enter Exam Number:");
				examNumber = kbd.nextInt();
				System.out.print("Enter Exam Score:");
				score = kbd.nextInt();
				student1.setExamScore(examNumber, score);
			} else if (selection == 4) {
				System.out.print("Enter Final Exam Score:");
				Finalscore = kbd.nextInt();
				student1.setFinalExamScore(Finalscore);
			}
			else if (selection == 5) {
				System.out.print("Exam Average: " + student1.ExamAverage());
				System.out.println("");
			} else if (selection == 6) {
				System.out.print("Target Average: ");
				target = kbd.nextDouble();
				projection = student1.FinalProjection(target);
				System.out.print("Final exam score need to get a " + target + "% at the end of the course is "+ projection + " out of 200");
				System.out.println("");
			} else if (selection == 7) {
				PrintProperties(student1);
			} else if (selection == 8) {
				++quit;
			} else {
				System.out.print("Try again. Enter a valid selection.");
				System.out.println("");
			}
		}
	}

}
