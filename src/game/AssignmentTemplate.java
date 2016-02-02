package game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AssignmentTemplate extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private Scene scene;
	private TabPane root;
	private BorderPane tab1Pane, tab2Pane;
	private Tab tab1, tab2;
	private Label questionLabel, scoreLabel, difficultyLabel, livesLabel;
	private Button answersButtons[] = new Button[4];
	private int score, difficulty, counter, lives;
	private QuestionFactory questionFactory;
	private BorderPane topPane;
	private HBox answersBox;

	public void start(Stage stage) throws Exception {
		stage.setTitle("Software Architectures – Petar Stanev");
		root = new TabPane();
		scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		// ----------------------------------
		tab1 = new Tab();
		tab1.setText("Game");
		tab1.setClosable(false);
		// write

		// ----Game Start
		// ---Top Start
		tab1Pane = new BorderPane();

		tab1Pane.setStyle("-fx-background-color: #FFFF99;");

		tab2Pane = new BorderPane();
		// ----Top End

		setUpStartScreen();

		// ----Game End
		// ------------Bottom Start------------

		// ------------Bottom End------------
		tab1.setContent(tab1Pane);
		// end tab1
		root.getTabs().add(tab1);
		// ----------------------------------

		// ----------------------------------
		tab2 = new Tab();

		tab2.setText("Tutorial");
		tab2.setClosable(false);
		tab2.setContent(tab2Pane);
		setTab2();
		root.getTabs().add(tab2);
		// ----------------------------------
		stage.show();
	}

	private void setTab2() {
		Label title = new Label("   How to play:");
		title.setStyle("-fx-font: 42 arial; -fx-base: #b6e7c9;");
		BorderPane.setAlignment(title, Pos.CENTER);
		Image img = new Image("tutorial1.png", 700, 500, false, false);
		ImageView imgView = new ImageView(img);

		tab2Pane.setCenter(imgView);

		tab2Pane.setTop(title);
	}

	private void topInit() {
		score=0;
		scoreLabel = new Label("Score: " + score);
		scoreLabel.setStyle("-fx-font: 32 arial;");
		scoreLabel.setTextFill(Color.web("#199EFF"));

		lives = 3;
		livesLabel = new Label("Lives: " + lives);
		livesLabel.setStyle("-fx-font: 32 arial;");
		livesLabel.setTextFill(Color.web("#199EFF"));

		difficulty = 0;
		difficultyLabel = new Label(getDifficultyOperations());
		difficultyLabel.setStyle("-fx-font: 32 arial; -fx-base: #EFFFF3;");
		difficultyLabel.setTextFill(Color.web("#199EFF"));
		topPane = new BorderPane();
		topPane.setLeft(difficultyLabel);
		topPane.setRight(scoreLabel);
		topPane.setCenter(livesLabel);
		tab1Pane.setTop(topPane);
		// topPane.setVisible(false);
	}

	public void setUpStartScreen() {

		BorderPane menu = new BorderPane();
		Button startGameButton = new Button("Start Game");
		startGameButton.setStyle("-fx-font: 48 arial;fx-base: #EFFFF3;");
		startGameButton.setTextFill(Color.web("#199EFF"));
		startGameButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				startGameButton.setVisible(false);
				setUpGame();
			}
		});
		menu.setCenter(startGameButton);

		tab1Pane.setCenter(menu);

	}

	public void setUpGame() {
		topInit();
		questionLabel = new Label();
		questionLabel.setStyle("-fx-font: 60 arial;");
		questionLabel.setTextFill(Color.web("#199EFF"));
		tab1Pane.setCenter(questionLabel);
		// ----- Top end

		// ---- Left Start

		// tab1Pane.setRight(livesLabel);
		// ---Left end

		// ------ Bottom start
		answersBox = new HBox(10);
		answersBox.setAlignment(Pos.CENTER);
		answersBox.setPadding(new Insets(10));
		tab1Pane.setBottom(answersBox);

		for (int i = 0; i < answersButtons.length; i++) {
			answersButtons[i] = new Button();
			answersButtons[i]
					.setStyle("-fx-font: 48 arial; -fx-base: #D6FFEA;");
			answersButtons[i].setTextFill(Color.web("#199EFF"));
			answersBox.getChildren().add(answersButtons[i]);
		}

		// other
		difficulty = 0;
		counter = 0;
		score = 0;

		questionFactory = new QuestionFactory();
		generateQuestion();
	}

	public void generateQuestion() {
		Question question = questionFactory.createQuestion(difficulty);
		questionLabel.setText(question.getQuestion());

		for (int i = 0; i < answersButtons.length; i++) {
			answersButtons[i].setText(Integer.toString(question.getAnswer(i)));
			answersButtons[i].setDisable(false);
			if (i == question.getCorrectAnswerPositon()) {
				answersButtons[i].setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						counter++;
						if (counter == 5 && difficulty < 2) {
							difficulty++;
							updateDifficulty();
							counter = 0;
						}

						generateQuestion();
						updateScore(100);
					}
				});
			} else {
				final int n = i;
				answersButtons[i].setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						answersButtons[n].setDisable(true);
						lives--;
						counter = 0;

						updateLives();
						if (lives < 1) {
							setUpStartScreen();
							answersBox.setVisible(false);
						}
					}
				});
			}
		}
	}

	private void updateScore(int scoreChange) {
		score += scoreChange;
		scoreLabel.setText("Score: " + score);
	}

	private void updateDifficulty() {
		difficultyLabel.setText(getDifficultyOperations());
	}

	private void updateLives() {
		livesLabel.setText("Lives: " + lives);
	}

	private String getDifficultyOperations() {
		switch (difficulty) {
		case 0:
			return "Easy (+)";
		case 1:
			return "Medium (+ -)";
		case 2:
			return "Hardest (+ - * /)";
		}
		return "";
	}

}