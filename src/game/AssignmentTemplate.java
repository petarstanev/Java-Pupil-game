package game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AssignmentTemplate extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	Scene scene;
	TabPane root;
	BorderPane tab1Pane;
	Tab tab1, tab2;

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
		
		//----Game Start
		//---Top Start
		tab1Pane = new BorderPane();
		
		//----Top End
	
		setUpStartScreen();
		
		
		//----Game End
		//------------Bottom Start------------
		
		
	
		//------------Bottom End------------
		tab1.setContent(tab1Pane);
		// end tab1
		root.getTabs().add(tab1);
		// ----------------------------------

		// ----------------------------------
		tab2 = new Tab();
		tab2.setText("Score");
		tab2.setClosable(false);
		root.getTabs().add(tab2);
		// ----------------------------------
		stage.show();
			
	}
	
	

	public void setUpStartScreen(){
		Button startGame = new Button("startGame");
		startGame.setStyle("-fx-font: 48 arial; -fx-base: #b6e7c9;");

		 
			startGame.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	startGame.setVisible(false);
	            	setUpGame();
	            }
	        });
			
		tab1Pane.setCenter(startGame);
	}
	
	public void setUpGame(){
		HBox questionBox = new HBox();
		questionBox.setSpacing(10);
		questionBox.setAlignment(Pos.CENTER);
		questionBox.setPadding(new Insets(10));
		tab1Pane.setTop(questionBox);

		Label question = new Label("4 + 3 = ");
		question.setStyle("-fx-font: 48 arial; -fx-base: #b6e7c9;");
		
		questionBox.getChildren().add(question);
		HBox answersBox = new HBox(10);
		answersBox.setAlignment(Pos.CENTER);
		answersBox.setPadding(new Insets(10));
		tab1Pane.setBottom(answersBox);

		Button answer1 = new Button("1");
		answer1.setStyle("-fx-font: 48 arial; -fx-base: #b6e7c9;");
		answersBox.getChildren().add(answer1);

		Button answer2 = new Button("2");
		answer2.setStyle("-fx-font: 48 arial; -fx-base: #b6e7c9;");
		answersBox.getChildren().add(answer2);

		Button answer3 = new Button("3");
		answer3.setStyle("-fx-font: 48 arial; -fx-base: #b6e7c9;");
		answersBox.getChildren().add(answer3);

		Button answer4 = new Button("4");
		answer4.setStyle("-fx-font: 48 arial; -fx-base: #b6e7c9;");
		answersBox.getChildren().add(answer4);
	}
	
	public void generateQuestion(){
		
	}
}