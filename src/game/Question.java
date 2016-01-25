package game;

import java.util.Arrays;
import java.util.Random;

/**
 * Class question using for creating question and answers.
 * 
 * @author Petar Stanev
 */
public class Question {
	private int answers[];
	private int firstNumber, secondNumber, correctAnswer, maximumNumber;
	private char symbol;
	private Random randomGenerator;

	public Question(int[] answers, int correctAnswer) {
		this.answers = answers;
		this.correctAnswer = correctAnswer;
	}

	public Question(int maximumNumber) {
		randomGenerator = new Random();
		this.maximumNumber = maximumNumber;
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

	public String getQuestion() {
		return firstNumber + " " + symbol + " " + secondNumber;
	}

	private void generateQuestion() {

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

	private void generateAnswers() {
		answers = new int[4];
		int correctAnswerPositon = randomGenerator.nextInt(answers.length);
		answers[correctAnswerPositon] = correctAnswer;

		for (int i = 0; i < answers.length; i++) {
			if (i != correctAnswerPositon)
				answers[i] = generateUniqueAnswer();
		}
		System.out.println();
	}

	private int generateUniqueAnswer() {
		int testAnswer;
		do {
			testAnswer = randomGenerator.nextInt(maximumNumber);
		} while (contains(testAnswer));

		return testAnswer;
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
