package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioSesionController {
	@FXML
	private TextField txtNombre;
	@FXML
	private Button btnEnviar;
	@FXML
	private Label lblMensajeMuestra;
	@FXML
	private PasswordField contrasena;
	
	public void mostrarMensaje(ActionEvent event) {
		lblMensajeMuestra.setText("Bienvenido a Cenec "+txtNombre.getText());
		txtNombre.setText(null);
		contrasena.setText(null);
	}
}
