package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ejercicio1 extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.show();
		primaryStage.setTitle("Programa de Aleja");
		primaryStage.getIcons().add(new Image("/application/icon.png"));
		
		
		
		StackPane panel1 = new StackPane();
		Rectangle r1 = new Rectangle(400,400,Color.DARKGREEN);
		Rectangle r2 = new Rectangle(300,300,Color.GREEN);
		Rectangle r3 = new Rectangle(200,200,Color.LIGHTGREEN);
		
		panel1.getChildren().addAll(r1,r2,r3);
		Scene scene = new Scene(panel1,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
