package conecta_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta_Personalizada1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 try {
		    	
			 //1. crear la conexion
				    	
			 Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Datos", "root", "1234");
				     
			//2 PREPARAR LA CONSULTA
			 
			 PreparedStatement mi_setencia=conexion.prepareStatement(" SELECT NOMBRE, NACIONALIDAD, APELLIDOS FROM DATOS_PERSONA WHERE NOMBRE =? AND NACIONALIDAD=?");
				
			 //3 ESTABLECER PARAMETROS DE CONSULTA
			 
			 mi_setencia.setString(1, "diego");
			 mi_setencia.setString(2, "colombiano");
			 
			 ResultSet consulta=mi_setencia.executeQuery();
			 
			 //4 EJECUTAR Y RECORRER 
			 
			 while (consulta.next()) {
				
				 System.out.println(consulta.getString("nombre")+ " " + consulta.getString("nacionalidad")+ " " + consulta.getString("apellidos"));
			}
			 consulta.close();
			 
		 	} catch (SQLException e){
				     
			System.out.println("No conecta");
			e.printStackTrace();
				  
				    }
	}	     
}