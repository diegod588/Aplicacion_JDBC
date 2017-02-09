package conecta_bd;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
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
		botonConsulta.addActionListener(new ActionListener(){ // se pone en escucha el boton con una clase interna

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ejecuta_consulta();
			}
			
			
		});
		add(botonConsulta, BorderLayout.SOUTH);
		
		// ***************conexion a la base de datos	
		
		 try {
		    	
	    //1. crear la conexion
		 conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=almacen", "root", "1234");
         // 2. crear objeto statement
	     Statement sentencia = conexion.createStatement();
	     // CARGA JCOMBOBOX SECCIONES
	     String consulta="SELECT DISTINCT SECCION FROM PRODUCTOS";
		 ResultSet RS=sentencia.executeQuery(consulta);
	     
	     while (RS.next()) {
			
	    	 secciones.addItem(RS.getString(1));
		}
	     RS.close();
	     // CARGA JCOMBOBOX PAISES
	     consulta="SELECT DISTINCT PAIS FROM PRODUCTOS";
		 RS=sentencia.executeQuery(consulta);
	     
	     while (RS.next()) {
			
	    	 paises.addItem(RS.getString(1));
		}
	     RS.close();
		 } 	
		 catch (Exception e) {
			// TODO: handle exception
		}
	}	
	private void ejecuta_consulta (){
		
		ResultSet rs = null;
		
		try {
			resultado.setText("");
			String seccion=(String)secciones.getSelectedItem();
			String pais=(String)paises.getSelectedItem();
			
			if (!seccion.equals("Todos")&& pais.equals("Todos")) {
				envia_consulta_seccion=conexion.prepareStatement(consulta_seccion);
				envia_consulta_seccion.setString(1, seccion);
				rs=envia_consulta_seccion.executeQuery(); 
			} else if (seccion.equals("Todos")&& !pais.equals("Todos")){
				envia_consulta_pais=conexion.prepareStatement(consulta_pais);
				envia_consulta_pais.setString(1, pais);
				rs=envia_consulta_pais.executeQuery(); 
			}else if (!seccion.equals("Todos")&& !pais.equals("Todos")){
				envia_consulta_todos=conexion.prepareStatement(consulta_todos);
				envia_consulta_todos.setString(1, seccion);
				envia_consulta_todos.setString(2, pais);
				rs=envia_consulta_todos.executeQuery();
				
			}
			
			while (rs.next()) {
				resultado.append(rs.getString(1));
				resultado.append(", ");
				resultado.append(rs.getString(2));
				resultado.append(", ");
				resultado.append(rs.getString(3));
				resultado.append(", ");
				resultado.append(rs.getString(4));
				resultado.append(", ");
				resultado.append("\n");
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private Connection conexion;
	private PreparedStatement envia_consulta_seccion;
	private PreparedStatement envia_consulta_pais;
	private PreparedStatement envia_consulta_todos;
	private final String consulta_seccion ="SELECT NOMBRE_ARTICULO, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE SECCION =?";
	private final String consulta_pais ="SELECT NOMBRE_ARTICULO, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE PAIS =?";
	private final String consulta_todos ="SELECT NOMBRE_ARTICULO, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE SECCION =? AND PAIS =?";
	private JComboBox secciones;
	private JComboBox paises;
	private JTextArea resultado;	
	

	
}


