package modelo;

public class Productos {

	public Productos(){// se crea el constructor
		
		    articulo="";
			seccion="";
			pais="";
	        precio="";
	}
	//quedo en el video 211 minuto 9:57 
	
	//se crean getters y setters
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	// se encapsula las variables
	private String articulo;
	private String seccion;
	private String pais;
	private String precio;
}
