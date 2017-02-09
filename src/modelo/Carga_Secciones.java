package modelo;

import java.sql.*;
import controlador.*;

public class Carga_Secciones {

	public Carga_Secciones(){
		
		mi_conexion= new Conexion();
	}
	
	public String ejecuta_consultas(){
		
		Productos mi_producto= null;
		Connection accesoBBDD=mi_conexion.dame_conexion();
		
		try {
			
			Statement secciones = accesoBBDD.createStatement();
			rs=secciones.executeQuery("SELECT DISTINCT SECCION FROM PRODUCTOS");
			
			while(rs.next()){
				
				mi_producto= new Productos();
				mi_producto.setSeccion(rs.getString(1));
				return mi_producto.getSeccion();
			}
				rs.close();
		} catch (Exception e) {
			
		}
		  return mi_producto.getSeccion();
	}
	
	Conexion mi_conexion;
	public ResultSet rs;
	
	
}
