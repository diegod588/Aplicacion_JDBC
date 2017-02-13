package controlador;

import modelo.*;
import vista.*;

import java.awt.event.*;

public class Controlador_Carga_Menu extends WindowAdapter{
	


	public Controlador_Carga_Menu(Marco_Aplicacion_2 el_marco){
		
		this.el_marco=el_marco;
		
	}

	public void windowOpened (WindowEvent e){
		
		obj.ejecuta_consultas();
		
		try {
			
			while(obj.rs.next()){
				
				el_marco.secciones.addItem(obj.rs.getString(1));				
			}
			
             while(obj.rs_2.next()){
				
				el_marco.paises.addItem(obj.rs_2.getString(1));				
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	Carga_Menu obj= new Carga_Menu();
	
	private Marco_Aplicacion_2 el_marco;
}
