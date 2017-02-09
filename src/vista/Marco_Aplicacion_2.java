package vista;

import java.awt.*;
import controlador.*;
import javax.swing.*;

public class Marco_Aplicacion_2 extends JFrame{

public Marco_Aplicacion_2(){
		
		setTitle ("Consulta los articulos del Almacen");
		setBounds(500,300,400,400);
		setLayout(new BorderLayout());
		JPanel menus=new JPanel();
		menus.setLayout(new FlowLayout());
		secciones=new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("Todos");
		paises=new JComboBox();
		paises.setEditable(false);
		paises.addItem("Todos");
		resultado= new JTextArea(4,50);
		resultado.setEditable(false);
		add(resultado);
		menus.add(secciones);
		menus.add(paises);	
		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		JButton botonConsulta=new JButton("Consulta");
		add(botonConsulta, BorderLayout.SOUTH);
		addWindowListener(new Controlador_Carga_Secciones(this));
	
   }

		public JComboBox secciones;
		private JComboBox paises;
		private JTextArea resultado;	

}
