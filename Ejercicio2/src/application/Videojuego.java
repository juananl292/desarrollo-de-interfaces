package application;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Videojuego {
	private  SimpleStringProperty nombre;
	private SimpleIntegerProperty precio;
	private SimpleStringProperty consola;
	private SimpleStringProperty pegi;
	  public Videojuego(String nombre, int precio, String consola,
	            String pegi) {
	        super();
	        this.nombre = new SimpleStringProperty(nombre);
	        this.precio = new SimpleIntegerProperty(precio);
	        this.consola = new SimpleStringProperty(consola);
	        this.pegi = new SimpleStringProperty(pegi);

	    }
	public SimpleStringProperty getNombre() {
		return nombre;
	}
	public void setNombre(SimpleStringProperty nombre) {
		this.nombre = nombre;
	}
	public SimpleIntegerProperty getPrecio() {
		return precio;
	}
	public void setPrecio(SimpleIntegerProperty precio) {
		this.precio = precio;
	}
	public SimpleStringProperty getConsola() {
		return consola;
	}
	public void setConsola(SimpleStringProperty consola) {
		this.consola = consola;
	}
	public SimpleStringProperty getPegi() {
		return pegi;
	}
	public void setPegi(SimpleStringProperty pegi) {
		this.pegi = pegi;
	}
	
	
}
