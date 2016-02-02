package game;

import java.util.Random;

/**
 * Class question using for creating question and answers.
 * 
 * @author Petar Stanev
 */
public abstract class Question {
	protected int answers[];
	protected int firstNumber, secondNumber, correctAnswer, correctAnswerPositon;
	protected static final int MAX_NUMBER = 20;
	protected char symbol;
	protected Random randomGenerator;

	public Question() {
		randomGenerator = new Random();
		generateQuestion();
		generateCorrectAnswer();
		generateAnswers();
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

	public int getCorrectAnswerPositon() {
		return correctAnswerPositon;
	}

	public String getQuestion() {
		return firstNumber + " " + symbol + " " + secondNumber;
	}

	public abstract void generateQuestion();

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

	private void generateAnswers() {
		answers = new int[4];
		correctAnswerPositon = randomGenerator.nextInt(answers.length);
		answers[correctAnswerPositon] = correctAnswer;

		for (int i = 0; i < answers.length; i++) {
			if (i != correctAnswerPositon)
				answers[i] = generateUniqueAnswer();
		}
	}

	private int generateUniqueAnswer() {
		int testAnswer;
		do {
			testAnswer = randomGenerator.nextInt((int) (MAX_NUMBER * 1.5));
		} while (contains(testAnswer));

		return testAnswer;
	}
	
	protected void generateUniqueNumbersForAddition(){
		firstNumber = randomGenerator.nextInt(50);
		secondNumber = randomGenerator.nextInt(50);
	}
	
	protected void generateUniqueNumbersForSubtraction(){
		firstNumber = randomGenerator.nextInt(100);
		secondNumber = randomGenerator.nextInt(firstNumber);
	}
	
	protected void generateUniqueNumbersForMultiplication(){
		firstNumber = randomGenerator.nextInt(10);
		secondNumber = randomGenerator.nextInt(10);
	}
	
	protected void generateUniqueNumbersForDivision(){
		int save = 	 randomGenerator.nextInt(10)+1;
		secondNumber = randomGenerator.nextInt(10)+1;
		firstNumber = save * secondNumber;
	}

	private boolean contains(int test) {
		for (int i : answers) {
			if (i == test) {
				return true;
			}
		}
		return false;
	}

}
