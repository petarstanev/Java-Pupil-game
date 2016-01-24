package game;
/**
 * Class question using for creating question and answers.
 * 
 * @author Petar Stanev
 */
public class Question {
	private String question;
	private int answers[]; 
	private int correctAnswer;

	public Question(int[] answers, int correctAnswer) {
		this.answers = answers;
		this.correctAnswer = correctAnswer;
	}

	public int[] getAnswers() {
		return answers;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}
}
