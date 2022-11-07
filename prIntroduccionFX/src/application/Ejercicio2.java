package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ejercicio2 extends Application{

	public static void main(String[] args) {
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
BorderPane panel = new BorderPane();
		
		Rectangle r_centro = new Rectangle(300,300,Color.DARKBLUE);
		Rectangle r_arriba = new Rectangle(400,50,Color.DARKGREEN);
		Rectangle r_abajo = new Rectangle(400,50,Color.DARKGREEN);
		Rectangle r_izquierda = new Rectangle(50,300,Color.LIGHTGREY);
		Rectangle r_derecha = new Rectangle(50,300,Color.ALICEBLUE);
		
		
		panel.setCenter(r_centro);
		panel.setTop(r_arriba);
		panel.setBottom(r_abajo);
		panel.setRight(r_derecha);
		panel.setLeft(r_izquierda);
		
		Scene escena= new Scene(panel,400,400);
		primaryStage.setScene(escena);
		primaryStage.show();
		
	}

}
