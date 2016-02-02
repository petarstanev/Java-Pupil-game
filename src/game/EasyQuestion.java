package game;

public class EasyQuestion extends Question{
	
	@Override
	public void generateQuestion() {
		generateUniqueNumbersForAddition();
		symbol = '+';
	}
}
