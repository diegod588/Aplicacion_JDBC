package conecta_bd;

import java.sql.*;

public class Conecta_Usuarios {

	 public static void main(String[] args) {
	     
	    try {
	    	
	    //1. crear la conexion
	    	
	     Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Datos", "root", "1234");
	     
	     // 2. crear objeto statement
	     
	     Statement miStatement = conexion.createStatement();
	     
	     //3  ejecutar sql
	     
	     ResultSet consulta=miStatement.executeQuery("SELECT * FROM PERSONA");
	     
	     //4 RECORRER EL RESULTSET
	     
	     while (consulta.next()) {
	    	 
	    	 System.out.println(consulta.getString("id_persona")+ " " + consulta.getString("nombre")+ " " + consulta.getString("apellidos")+ " " +consulta.getString("edad"));
		
		}
	     
	     	     
	    } catch (SQLException e){
	     
	    	System.out.println("No conecta");
	    	
	    	e.printStackTrace();
	  
	    }
	     

	 
	  
		
	     
		}
	}