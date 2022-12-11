package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtPrecio;
	@FXML
	private ChoiceBox opcionConsola;
	@FXML
	private ChoiceBox opcionPegi;
	@FXML
	private Button btnAñadir;
	@FXML
	private Button btnBorrar;
	@FXML
	private TableView <Videojuego>tableJuego;
	@FXML
	private TableColumn <Videojuego, String> columNombre;
	@FXML
	private TableColumn <Videojuego, Integer> columPrecio;
	@FXML
	private TableColumn <Videojuego, String> columConsola;
	@FXML
	private TableColumn <Videojuego, String> columPegi;

	private ObservableList<Videojuego> listaVideojuegos =FXCollections.observableArrayList(new Videojuego("Fifa 23", 49, "PSP5", "PEGI 3"));

	public 	ObservableList<String> consolas = FXCollections.observableArrayList("PS5","PS4", "Nintendo", "XBOX","PC");
	public 	ObservableList<String> pegis= FXCollections.observableArrayList("PEGI 3","PEGI 7", "PEGI 12", "PEGI 16", "PEGI 18");
	
	@FXML
	private void initialize() {
		opcionConsola.setItems(consolas);
		opcionPegi.setItems(pegis);
		columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
		columConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
		columPegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));
		
		ObservableList<Videojuego>listaVideojuegosBD=getVideojuegosBD();
		
		tableJuego.setItems(listaVideojuegosBD);
		
		
	}
	//Para refrescar la tabla despues de insertar un nuevo juego en la base de datos.
	private void refresh() {
		ObservableList<Videojuego>listaVideojuegosBD=getVideojuegosBD();
		
		tableJuego.setItems(listaVideojuegosBD);
	}
	//Borrar de bbdd
	private void borrarVideojuegosBD(Videojuego v) {
		DatabaseConnection dbConnection= new DatabaseConnection();
		Connection connection = dbConnection.getConnection();
		String nombre=v.getNombre();
		String query = "delete from videojuegos where nombre =?";
		
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, nombre);
				ps.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//Prueba de insercion en bbdd. Funciona correctamente
	private void setVideojuegosBD(Videojuego v) {
		DatabaseConnection dbConnection= new DatabaseConnection();
		Connection connection = dbConnection.getConnection();
		
		String query = "insert into videojuegos(nombre, precio, consola, pegi)"+"values (?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, v.getNombre());
			ps.setInt(2, v.getPrecio());
			ps.setString(3, v.getConsola());
			ps.setString(4, v.getPegi());
			ps.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Coger juegos de bbdd
	private ObservableList<Videojuego> getVideojuegosBD(){
		/**
		 * Creamos la observable list donde almacenaremos los videojuegos obtenidos de bd
		 */
		ObservableList<Videojuego>listaVideojuegosBD=
				FXCollections.observableArrayList();
		/*
		 * Nos conectamos a la bbdd
		 * 
		 */
		DatabaseConnection dbConnection= new DatabaseConnection();
		Connection connection = dbConnection.getConnection();
		
		String query = "select * from videojuegos";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				Videojuego videojuego= new Videojuego(
						rs.getString("nombre"),
						rs.getInt("precio"),
						rs.getString("consola"),
						rs.getString("pegi")
						);
				
				listaVideojuegosBD.add(videojuego);
			}
			
			
			//Cerramos la conexion
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return listaVideojuegosBD;
	}
	@FXML
	public void aniadirVideojuego(ActionEvent event) {
		
		if(txtNombre.getText().isBlank()||
				txtPrecio.getText().isBlank()||
				opcionConsola.getSelectionModel().isEmpty()||
				opcionPegi.getSelectionModel().isEmpty()) {
			Alert alerta= new Alert(AlertType.WARNING);
			alerta.setTitle("Informacion incompleta");
			alerta.setHeaderText("Falta informacion en algun campo");
			alerta.setContentText("Por favor introduzca todos los campos");
            alerta.showAndWait();
		}else {
		 if (esNumero(txtPrecio.getText())) {
		Videojuego juego1 = new Videojuego(txtNombre.getText(),
				Integer.parseInt(txtPrecio.getText()),
				opcionConsola.getValue().toString(),
				opcionPegi.getValue().toString());
		
		listaVideojuegos.add(juego1);
		setVideojuegosBD(juego1);
		refresh();
		
		
		
		txtNombre.clear();
		txtPrecio.clear();
		opcionConsola.getSelectionModel().clearSelection();
		opcionPegi.getSelectionModel().clearSelection();
		
		 }else {
			   Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error al insertar");
            alerta.setHeaderText("No se ha introducido un numero en el campo del precio");
            alerta.setContentText("Por favor introduzca un precio correcto");
            alerta.showAndWait();
		 }
		}
		
	}
    @FXML
    public void borrarVideojuego(ActionEvent event) {
      int indiceSeleccionado = tableJuego.getSelectionModel().getSelectedIndex();
      System.out.println("indice a borrar: "+indiceSeleccionado);
      if(indiceSeleccionado<=-1) {
    	  Alert alerta = new Alert(AlertType.ERROR);
    	  alerta.setTitle("Error al borrar");
    	  alerta.setHeaderText("no se ha seleccionado ningun videojuego");
    	  alerta.setContentText("porfavor seleciona un videojuego");
    	  alerta.showAndWait();
      }else {
    	  Videojuego j1=  tableJuego.getSelectionModel().getSelectedItem();
    	  borrarVideojuegosBD(j1);
    	  tableJuego.getItems().remove(indiceSeleccionado);
    	  tableJuego.getSelectionModel().clearSelection();
    	  
      }
   
    }
	
	public boolean esNumero(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
