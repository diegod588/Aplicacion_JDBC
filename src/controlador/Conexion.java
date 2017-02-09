package controlador;
import java.sql.*;

public class Conexion {

	Connection mi_conexion=null;// se crea el objeto de construccion	
	
	public Conexion (){// se crea el constructor
		
	}
	
	public Connection dame_conexion(){// se crea un metodo para crear la conexion
		
		try {
			 //1. crear la conexion
			  mi_conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=almacen", "root", "1234");
		} catch (Exception e) {
			// TODO: handle exception
		}
			return mi_conexion;
	}
}
