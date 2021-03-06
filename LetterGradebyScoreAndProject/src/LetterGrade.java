import java.io.BufferedReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.io.InputStreamReader;
/*
 * compute the score and then covert it to a letter grade
 * the overall score = exam_score * 0.7 + project_score *.3 
 */
public class LetterGrade {
	int examScore, projectScore;
	final double EXAM_SCORE_PERCENT = 0.7;     // define percentage of exam score
	final double PROJECT_SCORE_PERCENT = 0.3;  // define percentage of project score
	
	public static void main(String[] args) {

		LetterGrade lg = new LetterGrade();
		try {
			System.out.print("Enetr the Exam score = ");
			InputStreamReader isr1 = new InputStreamReader(System.in);
			BufferedReader br1 = new BufferedReader(isr1);
			lg.examScore = Integer.parseInt(br1.readLine());
			
			System.out.print("Enetr the Project score = ");		
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			lg.projectScore = Integer.parseInt(br.readLine());	
			
			char grade = lg.letterGrade(lg.examScore, lg.projectScore);
	        System.out.println("The grade of is " + grade);	        
		} catch (NumberFormatException ex) {
			System.out.println("Not an integer !");
		} catch (IOException e) {
			e.printStackTrace();
		}     

	}  

	/*
	 * This method is to calculate the letter grade with two inputs:
	 * exam score and project score
	 */
	public char letterGrade(int exam, int project) throws InvalidParameterException {
		double score;
		char grade;
		
		// add exception handling for invalid input parameters
		try {
			if((exam<0 || exam>100) || (project<0 || project >100))
				throw new InvalidParameterException("invalid parameters");
		} catch (Exception e) {
			System.out.println("invalid input: out of input range!");
			throw new InvalidParameterException("invalid parameters");
		}
		
		score = exam* EXAM_SCORE_PERCENT + project* PROJECT_SCORE_PERCENT;
		if (score <0 || score > 100)
			grade = 'X';
		else if (score>=90 && score <=100)
			grade = 'A';
		else if (score>=80 && score <90)
			grade = 'B';
		else if (score>=70 && score <80)
			grade = 'C';
		else if (score>=60 && score <70)
			grade = 'D';
		else
			grade ='F';
		return grade;	
	}
}


