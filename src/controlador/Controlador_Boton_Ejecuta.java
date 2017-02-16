package controlador;

import java.awt.event.*;
import java.sql.*;
import modelo.*;
import vista.*;

public class Controlador_Boton_Ejecuta implements ActionListener {
	
	public Controlador_Boton_Ejecuta (Marco_Aplicacion_2 el_marco){
		this.el_marco=el_marco;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String seleccion_seccion=(String)el_marco.secciones.getSelectedItem();
		String seleccion_pais=(String)el_marco.paises.getSelectedItem();	
		resultadoconsulta=obj.filtra_BBDD(seleccion_seccion, seleccion_pais);
		
		try {
			el_marco.resultado.setText(" ");
			
			while(resultadoconsulta.next()){
				
				el_marco.resultado.append(resultadoconsulta.getString(1));
				el_marco.resultado.append(", ");
				el_marco.resultado.append(resultadoconsulta.getString(2));
				el_marco.resultado.append(", ");
				el_marco.resultado.append(resultadoconsulta.getString(3));
				el_marco.resultado.append(", ");
				el_marco.resultado.append(resultadoconsulta.getString(4));
				el_marco.resultado.append(", ");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    
	private Marco_Aplicacion_2 el_marco;
	Ejecuta_Consultas obj= new Ejecuta_Consultas();
	private ResultSet resultadoconsulta;

}
