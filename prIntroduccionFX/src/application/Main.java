package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Button btn = new Button("Click aqui");
		//	btn.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
			//btn.setOnAction(new EventHandler<ActionEvent>() {
				//public void handle(ActionEvent event) {
				//	System.out.println("hola mundo");
				//}
			//});
			Label lb = new Label("hola mundo");
			//StackPane panel = new StackPane();
			
			//panel.getChildren().add(btn);
//			panel.setAlignment(lb,Pos.TOP_CENTER);
//			panel.setAlignment(btn,Pos.CENTER);
//			panel.getChildren().addAll(lb,btn);
			
			
			//	VBox
//			VBox caja = new VBox(15);
//			caja.setPadding(new Insets(13));
//			caja.getChildren().addAll(lb,btn);
			
			
			
			//BorderPane
			/*
			VBox caja = new VBox(15);
			caja.setPadding(new Insets(13));
			caja.getChildren().addAll(lb,btn);
			BorderPane panel = new BorderPane();
			//panel.setCenter(btn);
			panel.setRight(caja);
			*/
			//GridPane
			
			//GridPane panel= new GridPane();
			
//			Button btn = new Button("Click aqui1");
//			Button btn1 = new Button("Click aqui2");
//			Button btn2 = new Button("Click aqui3");
//			Button btn3 = new Button("Click aqui4");
//			panel.setVgap(12);
//			panel.setHgap(12);
//			panel.setPadding(new Insets(15));
//			
//			panel.add(btn, 0, 0);
//			panel.add(btn1, 0, 1);
//			panel.add(btn2, 1, 0);
//			panel.add(btn3, 1, 1);
			
			//Scene scene = new Scene(panel,1200,800);
			//primaryStage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
