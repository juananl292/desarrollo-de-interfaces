package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio4 extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
			
		VBox panel = new VBox(15);
		Label lbl_nombre= new Label("Nombre");
		TextField txt_nombre = new TextField();
		Label lbl_contrasena = new Label("Contraseña");
		PasswordField psw_contrasena= new PasswordField();
		Button btn=new Button("Entrar");
		Label lbl_bienvenida = new Label();
		
		panel.getChildren().addAll(lbl_nombre,txt_nombre,lbl_contrasena,psw_contrasena,btn,lbl_bienvenida);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				lbl_bienvenida.setText("Bienvenid@ " +txt_nombre.getText());
			}
		});
		
		Scene scene = new Scene(panel,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

}
