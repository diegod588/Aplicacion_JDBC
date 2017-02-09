package controlador;

import modelo.*;
import vista.*;

import java.awt.event.*;

public class Controlador_Carga_Secciones extends WindowAdapter{
	


	public Controlador_Carga_Secciones(Marco_Aplicacion_2 el_marco){
		
		this.el_marco=el_marco;
		
	}

	public void windowOpened (WindowEvent e){
		
		obj.ejecuta_consultas();
		
		try {
			
			while(obj.rs.next()){
				
				el_marco.secciones.addItem(obj.rs.getString(1));				
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	Carga_Secciones obj= new Carga_Secciones();
	
	private Marco_Aplicacion_2 el_marco;
}
