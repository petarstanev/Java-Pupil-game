package game;

public class HardQuestion extends Question {

	@Override
	public void generateQuestion() {
		firstNumber = randomGenerator.nextInt(MAX_NUMBER);
		secondNumber = randomGenerator.nextInt(MAX_NUMBER);

		switch (randomGenerator.nextInt(4)) {
		case 0:
			generateUniqueNumbersForAddition();
			symbol = '+';
			break;
		case 1:
			generateUniqueNumbersForSubtraction();
			symbol = '-';
			break;
		case 2:
			generateUniqueNumbersForMultiplication();
			symbol = '*';
			break;
		case 3:
			generateUniqueNumbersForDivision();
			symbol = '/';
			break;

		}
	}

}
