package game;

public class QuestionFactory implements FactoryInterface{
	Question question = null;

	public Question createQuestion(int difficulty) {
		switch (difficulty) {
		case 0:
			return question = new EasyQuestion();
		case 1:
			return question = new MediumQuestion();
		case 2:
			return question = new HardQuestion();
		}
		return question;
	}
}
