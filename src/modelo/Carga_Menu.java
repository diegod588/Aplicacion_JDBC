package modelo;

import java.sql.*;


public class Carga_Menu {

	public Carga_Menu(){
		
		mi_conexion= new Conexion();
	}
	
	public String ejecuta_consultas(){
		
		Productos mi_producto= null;
		Connection accesoBBDD=mi_conexion.dame_conexion();
		
		try {
			
			Statement secciones = accesoBBDD.createStatement();
			Statement pais = accesoBBDD.createStatement();
			rs=secciones.executeQuery("SELECT DISTINCT SECCION FROM PRODUCTOS");
			rs_2=pais.executeQuery("SELECT DISTINCT PAIS FROM PRODUCTOS");
			mi_producto= new Productos();
			mi_producto.setSeccion(rs.getString(1));
			mi_producto.setPais(rs_2.getString(1));
			rs.close();
			rs_2.close();
			accesoBBDD.close();
     		
		} catch (Exception e) {
			
		}
		  return mi_producto.getSeccion();
	}
	
	public Conexion mi_conexion;
	public ResultSet rs;
	public ResultSet rs_2;
	
	
}
