package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ejercicio3 extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		GridPane panel= new GridPane();
		
		Button btn = new Button("0");
		Button btn1 = new Button("1");
		Button btn2 = new Button("2");
		Button btn3 = new Button("3");
		Button btn4 = new Button("4");
		Button btn5 = new Button("5");
		Button btn6 = new Button("6");
		Button btn7 = new Button("7");
		Button btn8= new Button("8");
		Button btn9 = new Button("9");
		Button btnColgar = new Button("Click aqui3");
		Button btnLlamar = new Button("Click aqui4");
		panel.setVgap(12);
		panel.setHgap(12);
		panel.setPadding(new Insets(15));
		
		panel.add(btn, 0, 0);
		panel.add(btn1, 0, 1);
		panel.add(btn2, 0, 2);
		panel.add(btn3, 1, 0);
		panel.add(btn4, 1, 1);
		panel.add(btn5, 1, 3);
		panel.add(btn6, 2, 0);
		panel.add(btn7, 2, 1);
		panel.add(btn8, 2, 2);
		panel.add(btn9, 3, 0);
		panel.add(btnColgar, 1, 0);
		panel.add(btnLlamar, 1, 1);
		
		Scene scene = new Scene(panel,1200,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
