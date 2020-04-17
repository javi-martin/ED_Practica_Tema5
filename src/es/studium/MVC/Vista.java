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

	// Declarar la Barra de Menú

	MenuBar barraMenu = new MenuBar();

	// Declarar las opciones de la Barra de Menú

	Menu empleados = new Menu("Empleados");
	
	// Declarar las opciones del submenú de Empleado

	MenuItem nuevo = new MenuItem("Nuevo Empleado");
	MenuItem eliminar = new MenuItem("Eliminar Empleado");
	MenuItem consultar = new MenuItem("Consultar Empleado");
	MenuItem modificar = new MenuItem("Modificar Empleado");
	
	// Creamos el cuadro de diálogo Nuevo Empleado

	Dialog dialogoNuevo = new Dialog(this, "Nuevo Empleado", true);	
	Label lblNombreEmpleado = new Label("Nombre:");
	TextField txtNombreEmpleado = new TextField(20);
	Button btnNuevoEmpleado = new Button("Acepta");
	Button btnCancelarNuevoEmpleado = new Button("Cancelar");
	
	// Creamos el cuadro de diálogo Eliminar Empleado

	Dialog dialogoEliminar = new Dialog(this, "Eliminar Empleado", true);
	Label lblEliminarEmpleado = new Label("Empleado a borrar:");
	Choice choEmpleado = new Choice();
	Button btnEliminarEmpleado = new Button("Borrar");
	Button btnCancelarEliminarEmpleado = new Button("Cancelar");
	
	// Creamos el cuadro de diálogo Consultar Empleado

	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	Dialog dialogoConsultar = new Dialog(this, "Consultar Empleado", true);
	Label lblIdEmpleado = new Label("Introducir número de empleado:");
	TextField txtIdEmpleado = new TextField(5);
	TextField txtIdEmpleado2 = new TextField(5);
	TextField txtNombreEmpleado2 = new TextField(20);
	Button btnConsultarEmpleado = new Button("Consultar");
	Button btnSalirConsultarEmpleado = new Button("Salir");
	
	// Creamos el cuadro de diálogo Modificar Empleado

	Dialog dialogoModificar = new Dialog(this, "Modificar Empleado", true);
	Label lblModificarEmpleado = new Label("Empleado a modificar:");
	Choice choEmpleadoModificar = new Choice();
	Label lblNombreEmpleadoModificar = new Label("Nombre empreado a MODIFICAR:");
	Button btnModificarEmpleado = new Button("Modificar");
	Button btnCancelarModificarEmpleado = new Button("Cancelar");
	
	// Creamos el cuadro de diálogo Informar Resultado

	Dialog dialogoInformar = new Dialog(this,"Información", true);
	Label lblEtiqueta1 = new Label();	
	Button btnSalir = new Button("Salir");		
		
	public Vista() 
	{
		setLayout(new FlowLayout());	
		setTitle("Menú");
	
		//Establecemos la barra de menú como tal
	
		setMenuBar(barraMenu);		
	
		//Añadimos al menú Artículo las opciones de submenú, con separador entre ellas
	
		empleados.add(nuevo);	
		empleados.addSeparator();	
		empleados.add(eliminar);	
		empleados.addSeparator();	
		empleados.add(consultar);
		empleados.addSeparator();	
		empleados.add(modificar);
		
		//Añadimos las opciones de menú a la barra de menú
		
		barraMenu.add(empleados);
		
		setSize(350,200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Establecemos el layout del cuadro de diálogo Nuevo Empleado y su tamaño
		
		dialogoNuevo.setLayout(new FlowLayout());	
		dialogoNuevo.setSize(300,150);
		dialogoNuevo.setLocationRelativeTo(null);
		
		//Establecemos el layout del cuadro de diálogo Eliminar Empleado y su tamaño
		
		dialogoEliminar.setLayout(new FlowLayout());	
		dialogoEliminar.setSize(220,150);
		dialogoEliminar.setLocationRelativeTo(null);
		
		//Establecemos el layout del cuadro de diálogo Consultar Empleado y su tamaño
		
		dialogoConsultar.setLayout(new FlowLayout());	
		dialogoConsultar.setSize(300,200);
		dialogoConsultar.setLocationRelativeTo(null);
		
		//Establecemos el layout del cuadro de diálogo Modificar Empleado y su tamaño
		
		dialogoModificar.setLayout(new FlowLayout());	
		dialogoModificar.setSize(250,200);
		dialogoModificar.setLocationRelativeTo(null);
		
		//Establecemos el layout del cuadro de diálogo Modificar Empleado y su tamaño
		
		dialogoInformar.setLayout(new FlowLayout());	
		dialogoInformar.setSize(230,150);
		dialogoInformar.setLocationRelativeTo(null);
	}	

}
