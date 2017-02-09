package conecta_bd;
import java.sql.*;

public class Actualiza_Datos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 try {
		    	
		 //1. crear la conexion
			    	
		 Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Datos", "root", "1234");
			     
		// 2. crear objeto statement
			     
		 Statement miStatement = conexion.createStatement();
	     
			     // INSTRUCCION SQL PARA INSERTAR DATOS 
			     
			     /*String Insertar_datos =" INSERT INTO PERSONA (id_persona,nombre,apellidos,edad) VALUES (9, 'Erika','Rios',32)";
			     
			     miStatement.executeUpdate(Insertar_datos);
			     
			     System.out.println("Datos insertados correctamente");*/
			     
			     // INSTRUCCION PARA ACTUALIZAR O MODIFICAR INFORMACION
                
			     String actualiza_datos ="UPDATE  PERSONA SET NOMBRE ='rosalba' WHERE id_persona =4";
			     
			     miStatement.executeUpdate(actualiza_datos);
			     
			     // INSTRUCCION PARA BORRAR DATOS
			     
                String borrar_datos =" DELETE FROM PERSONA WHERE NOMBRE = 'ELIECER' ";
			     
			     miStatement.executeUpdate(borrar_datos);
			     
			     System.out.println("Datos actualizados correctamente");
			     
			     System.out.println("Datos borrados correctamente");
			     
			     		     
			     	     
			    } catch (SQLException e){
			     
			    	System.out.println("No conecta");
			    	
			    	e.printStackTrace();
			  
			    }
			     

			 
			  
				
			     
				}
			
		
	}


