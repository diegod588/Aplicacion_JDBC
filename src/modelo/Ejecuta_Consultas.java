package modelo;
import java.sql.*;

public class Ejecuta_Consultas {

	public Ejecuta_Consultas(){
		
		mi_conexion= new Conexion();
	}
	
public ResultSet filtra_BBDD (String seccion, String pais){
		
		Connection conecta=mi_conexion.dame_conexion();// realizamos la conexion
		
		
		try {
			rs=null;
			
		if(!seccion.equals("Todos")&&pais.equals("Todos")){
			envia_consulta_seccion=mi_conexion.prepareStatement(consulta_seccion);
			envia_consulta_seccion.setString(1, seccion);
			rs=envia_consulta_seccion.executeQuery();
		}else if(seccion.equals("Todos")&&!pais.equals("Todos")){
			
		}else {
		
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	
	private Conexion mi_conexion;
	private PreparedStatement envia_consulta_seccion;
	private PreparedStatement envia_consulta_pais;
	private PreparedStatement envia_consulta_todos;
	private final String consulta_seccion ="SELECT NOMBRE_ARTICULO, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE SECCION =?";
	private final String consulta_pais ="SELECT NOMBRE_ARTICULO, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE PAIS =?";
	private final String consulta_todos ="SELECT NOMBRE_ARTICULO, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE SECCION =? AND PAIS =?";
	private ResultSet rs;
	
}
