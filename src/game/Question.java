package game;

import java.util.Random;

/**
 * Class question using for creating question and answers.
 * 
 * @author Petar Stanev
 */
public class Question {
	private int answers[];
	private int firstNumber, secondNumber, correctAnswer;
	private char symbol;
	private Random randomGenerator;

	public Question(int[] answers, int correctAnswer) {
		this.answers = answers;
		this.correctAnswer = correctAnswer;
	}

	public Question(int maximumNumber) {
		randomGenerator = new Random();
		generateQuestion(maximumNumber);
		generateCorrectAnswer();
		generateAnswers(maximumNumber);
	}

	public int[] getAnswers() {
		return answers;
	}

	public int getAnswer(int position) {
		return answers[position];
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public String getQuestion() {
		return firstNumber + " " + symbol + " " + secondNumber;
	}

	private void generateQuestion(int maximumNumber) {

		firstNumber = randomGenerator.nextInt(maximumNumber);
		secondNumber = randomGenerator.nextInt(maximumNumber);

		switch (randomGenerator.nextInt(3)) {
		case 0:
			symbol = '+';
			break;
		case 1:
			symbol = '-';
			break;
		case 2:
			symbol = '*';
			break;
		case 3:
			symbol = '/';
			break;
		}
	}

	private void generateCorrectAnswer() {
		switch (symbol) {
		case '+':
			correctAnswer = firstNumber + secondNumber;
			break;
		case '-':
			correctAnswer = firstNumber - secondNumber;
			break;
		case '*':
			correctAnswer = firstNumber * secondNumber;
			break;
		case '/':
			correctAnswer = firstNumber / secondNumber;
			break;
		}	
	}
	
	private void generateAnswers(int maximumNumber) {
		answers = new int[4];
		int correctAnswerPositon = randomGenerator.nextInt(answers.length);
		
		
		for (int i = 0; i < answers.length; i++) {
			if(i==correctAnswerPositon){
				answers[i]=correctAnswer;
			}else{
				answers[i] = randomGenerator.nextInt(maximumNumber);
			}
		}
		System.out.println();
	}
}
