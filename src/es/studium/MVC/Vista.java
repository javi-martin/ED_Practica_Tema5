package es.studium.MVC;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;

public class Vista extends Frame
{
	private static final long serialVersionUID = 1L;

	// Declarar la Barra de Men�

	MenuBar barraMenu = new MenuBar();

	// Declarar las opciones de la Barra de Men�

	Menu empleados = new Menu("Empleados");
	
	// Declarar las opciones del submen� de Empleado

	MenuItem nuevo = new MenuItem("Nuevo Empleado");
	MenuItem eliminar = new MenuItem("Eliminar Empleado");
	MenuItem consultar = new MenuItem("Consultar Empleado");
	MenuItem modificar = new MenuItem("Modificar Empleado");
	
	// Creamos el cuadro de di�logo Nuevo Empleado

	Dialog dialogoNuevo = new Dialog(this, "Nuevo Empleado", true);	
	Label lblNombreEmpleado = new Label("Nombre:");
	TextField txtNombreEmpleado = new TextField(20);
	Button btnNuevoEmpleado = new Button("Acepta");
	Button btnCancelarNuevoEmpleado = new Button("Cancelar");
	
	// Creamos el cuadro de di�logo Eliminar Empleado

	Dialog dialogoEliminar = new Dialog(this, "Eliminar Empleado", true);
	Label lblEliminarEmpleado = new Label("Empleado a borrar:");
	Choice choEmpleado = new Choice();
	Button btnEliminarEmpleado = new Button("Borrar");
	Button btnCancelarEliminarEmpleado = new Button("Cancelar");
	
	// Creamos el cuadro de di�logo Consultar Empleado

	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	Dialog dialogoConsultar = new Dialog(this, "Consultar Empleado", true);
	Label lblIdEmpleado = new Label("Introducir n�mero de empleado:");
	TextField txtIdEmpleado = new TextField(5);
	TextField txtIdEmpleado2 = new TextField(5);
	TextField txtNombreEmpleado2 = new TextField(20);
	Button btnConsultarEmpleado = new Button("Consultar");
	Button btnSalirConsultarEmpleado = new Button("Salir");
	
	// Creamos el cuadro de di�logo Modificar Empleado

	Dialog dialogoModificar = new Dialog(this, "Modificar Empleado", true);
	Label lblModificarEmpleado = new Label("Empleado a modificar:");
	Choice choEmpleadoModificar = new Choice();
	Label lblNombreEmpleadoModificar = new Label("Nombre empreado a MODIFICAR:");
	Button btnModificarEmpleado = new Button("Modificar");
	Button btnCancelarModificarEmpleado = new Button("Cancelar");
	
	// Creamos el cuadro de di�logo Informar Resultado

	Dialog dialogoInformar = new Dialog(this,"Informaci�n", true);
	Label lblEtiqueta1 = new Label();	
	Button btnSalir = new Button("Salir");		
		
	public Vista() 
	{
		setLayout(new FlowLayout());	
		setTitle("Men�");
	
		//Establecemos la barra de men� como tal
	
		setMenuBar(barraMenu);		
	
		//A�adimos al men� Art�culo las opciones de submen�, con separador entre ellas
	
		empleados.add(nuevo);	
		empleados.addSeparator();	
		empleados.add(eliminar);	
		empleados.addSeparator();	
		empleados.add(consultar);
		empleados.addSeparator();	
		empleados.add(modificar);
		
		//A�adimos las opciones de men� a la barra de men�
		
		barraMenu.add(empleados);
		
		setSize(350,200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Establecemos el layout del cuadro de di�logo Nuevo Empleado y su tama�o
		
		dialogoNuevo.setLayout(new FlowLayout());	
		dialogoNuevo.setSize(300,150);
		dialogoNuevo.setLocationRelativeTo(null);
		
		//Establecemos el layout del cuadro de di�logo Eliminar Empleado y su tama�o
		
		dialogoEliminar.setLayout(new FlowLayout());	
		dialogoEliminar.setSize(220,150);
		dialogoEliminar.setLocationRelativeTo(null);
		
		//Establecemos el layout del cuadro de di�logo Consultar Empleado y su tama�o
		
		dialogoConsultar.setLayout(new FlowLayout());	
		dialogoConsultar.setSize(300,200);
		dialogoConsultar.setLocationRelativeTo(null);
		
		//Establecemos el layout del cuadro de di�logo Modificar Empleado y su tama�o
		
		dialogoModificar.setLayout(new FlowLayout());	
		dialogoModificar.setSize(250,200);
		dialogoModificar.setLocationRelativeTo(null);
		
		//Establecemos el layout del cuadro de di�logo Modificar Empleado y su tama�o
		
		dialogoInformar.setLayout(new FlowLayout());	
		dialogoInformar.setSize(230,150);
		dialogoInformar.setLocationRelativeTo(null);
	}	

}
