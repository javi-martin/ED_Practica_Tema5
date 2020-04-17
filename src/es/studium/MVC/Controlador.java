package es.studium.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;


public class Controlador implements WindowListener, ActionListener, ItemListener
{
	Modelo modelo = null;	
	Vista vista = null;
	
	public Controlador(Modelo modelo, Vista vista) 
	{	
		this.modelo = modelo;		
		this.vista = vista;
		
		// Añadimos el listener a cada opción de submenú del menú Artículos
		
		vista.nuevo.addActionListener(this);		
		vista.eliminar.addActionListener(this);		
		vista.consultar.addActionListener(this);
		vista.modificar.addActionListener(this);
		
		vista.btnNuevoEmpleado.addActionListener(this);
		vista.btnCancelarNuevoEmpleado.addActionListener(this);
		
		vista.btnEliminarEmpleado.addActionListener(this);
		vista.btnCancelarEliminarEmpleado.addActionListener(this);
		
		vista.btnConsultarEmpleado.addActionListener(this);
		vista.btnSalirConsultarEmpleado.addActionListener(this);		
		
		vista.btnModificarEmpleado.addActionListener(this);
		vista.btnCancelarModificarEmpleado.addActionListener(this);
		
		vista.btnSalir.addActionListener(this);
		
		vista.choEmpleadoModificar.addItemListener(this);
		
		// Añadimos el listener a las ventanas
		
		vista.addWindowListener(this);
		
		// Para poder cerrar el Diálogo, añadimos el listener a los cuadro de diálogo
		
		vista.dialogoNuevo.addWindowListener(this);
		vista.dialogoEliminar.addWindowListener(this);
		vista.dialogoConsultar.addWindowListener(this);
		vista.dialogoModificar.addWindowListener(this);
		vista.dialogoInformar.addWindowListener(this);
	
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		Object a;
		
		a = ae.getSource();
		
		if (a.equals(vista.nuevo))
		{
			//añade la etiqueta la cuadro de diálogo y la hace visible
			
			vista.dialogoNuevo.add(vista.lblNombreEmpleado);
			vista.dialogoNuevo.add(vista.txtNombreEmpleado);
			vista.dialogoNuevo.add(vista.btnNuevoEmpleado);
			vista.dialogoNuevo.add(vista.btnCancelarNuevoEmpleado);
			vista.dialogoNuevo.setVisible(true);		
		}
		else if (a.equals(vista.btnCancelarNuevoEmpleado)) 
		{
			vista.dialogoNuevo.setVisible(false);
		}
		else if (a.equals(vista.btnNuevoEmpleado)) 
		{
			// Conectar BD
			Connection con = modelo.conectar("empresa","root","Studium2019;");
			
			// Hacer el INSERT
			int respuesta = modelo.insertar(con, "empleados", vista.txtNombreEmpleado.getText());
			
			// Mostramos resultado
			if(respuesta == 0)
			{
				System.out.println("ALTA de empleado correcta");
				vista.dialogoInformar.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("ALTA de empleado correcta"));
				vista.dialogoInformar.add(vista.btnSalir);
				vista.dialogoInformar.setVisible(true);				
			}
			else
			{
				System.out.println("Error en ALTA de empleado");
				vista.dialogoInformar.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("Error en ALTA de empleado"));
				vista.dialogoInformar.add(vista.btnSalir);
				vista.dialogoInformar.setVisible(true);	
			}
			
			vista.txtNombreEmpleado.selectAll();
			vista.txtNombreEmpleado.setText("");
			
			// Desconectar de la base
			modelo.desconectar(con);
		}
		else if (a.equals(vista.eliminar)) 
		{
			vista.dialogoEliminar.add(vista.lblEliminarEmpleado);
			vista.dialogoEliminar.add(vista.choEmpleado);
			modelo.rellenarChoice(vista.choEmpleado);
			vista.dialogoEliminar.add(vista.btnEliminarEmpleado);
			vista.dialogoEliminar.add(vista.btnCancelarEliminarEmpleado);
			vista.dialogoEliminar.setVisible(true);
		}
		else if (a.equals(vista.btnCancelarEliminarEmpleado)) 
		{
			vista.dialogoEliminar.setVisible(false);
		}
		else if (a.equals(vista.btnEliminarEmpleado)) 
		{
			// Conectar a BD
			Connection con = modelo.conectar("empresa","root","Studium2019;"); 
			
			// Borrar
			String[] Empleado=vista.choEmpleado.getSelectedItem().split("-");
			int respuesta = modelo.borrar(con, "empleados","idEmpleado",Integer.parseInt(Empleado[0]));
			
			// Desconectar de la base
			modelo.desconectar(con);
			
			// Mostramos resultado
			if(respuesta == 0)
			{
				System.out.println("BAJA de empleado correcta");
				vista.dialogoInformar.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("BAJA de empleado correcta"));
				vista.dialogoInformar.add(vista.btnSalir);
				vista.dialogoInformar.setVisible(true);				
			}
			else
			{
				System.out.println("Error en BAJA de empleado");
				vista.dialogoInformar.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("Error en BAJA de empleado"));
				vista.dialogoInformar.add(vista.btnSalir);
				vista.dialogoInformar.setVisible(true);	
			}
			vista.choEmpleado.removeAll();
			modelo.rellenarChoice(vista.choEmpleado);			
		}
		else if (a.equals(vista.modificar)) 
		{
			vista.dialogoModificar.add(vista.lblModificarEmpleado);
			vista.dialogoModificar.add(vista.choEmpleadoModificar);
			modelo.rellenarChoice(vista.choEmpleadoModificar);			
			vista.dialogoModificar.add(vista.lblNombreEmpleadoModificar);
			vista.dialogoModificar.add(vista.txtNombreEmpleado);
			vista.dialogoModificar.add(vista.btnModificarEmpleado);
			vista.dialogoModificar.add(vista.btnCancelarModificarEmpleado);
			vista.dialogoModificar.setVisible(true);
		}
		else if (a.equals(vista.btnCancelarModificarEmpleado)) 
		{
			vista.dialogoModificar.setVisible(false);
		}		
		else if (a.equals(vista.btnModificarEmpleado)) 
		{
			// Conectar a BD
			Connection con = modelo.conectar("empresa","root","Studium2019;"); 
			
			// Borrar
			String[] Empleado=vista.choEmpleadoModificar.getSelectedItem().split("-");
			
			int respuesta = modelo.modificar(con,vista.txtNombreEmpleado.getText(),Integer.parseInt(Empleado[0]));
			
			// Desconectar de la base
			modelo.desconectar(con);
			
			// Mostramos resultado
			if(respuesta == 0)
			{
				System.out.println("MODIFICACIÓN de empleado correcta");
				vista.dialogoInformar.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("MODIFICACIÓN empleado correcta"));
				vista.dialogoInformar.add(vista.btnSalir);
				vista.dialogoInformar.setVisible(true);				
			}
			else
			{
				System.out.println("Error en MODIFICACIÓN de empleado");
				vista.dialogoInformar.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("Error MODIFICACIÓN empleado"));
				vista.dialogoInformar.add(vista.btnSalir);
				vista.dialogoInformar.setVisible(true);	
			}
			vista.txtNombreEmpleado.selectAll();
			vista.txtNombreEmpleado.setText("");
			vista.choEmpleadoModificar.removeAll();
			modelo.rellenarChoice(vista.choEmpleadoModificar);			
						
		}		
		else if(a.equals(vista.consultar)) 
		{
			vista.dialogoConsultar.add(vista.panel1);
			vista.panel1.add(vista.lblIdEmpleado);
			vista.panel1.add(vista.txtIdEmpleado);
			vista.dialogoConsultar.add(vista.panel2);
			vista.panel2.add(vista.btnConsultarEmpleado);
			vista.dialogoConsultar.add(vista.panel3);
			vista.panel3.add(vista.txtIdEmpleado2);
			vista.txtIdEmpleado2.setEnabled(false);
			vista.panel3.add(vista.txtNombreEmpleado2);
			vista.txtNombreEmpleado2.setEnabled(false);
			vista.dialogoConsultar.add(vista.btnSalirConsultarEmpleado);
			vista.dialogoConsultar.setVisible(true);
		}
		else if (a.equals(vista.btnSalirConsultarEmpleado)) 
		{
			vista.dialogoConsultar.setVisible(false);
		}
		else if (a.equals(vista.btnConsultarEmpleado)) 
		{
			// Conectar a BD
			Connection con = modelo.conectar("empresa","root","Studium2019;"); 
			
			modelo.mostrarDatos(con, Integer.parseInt(vista.txtIdEmpleado.getText()), vista.txtIdEmpleado2, vista.txtNombreEmpleado2);
			
			// Desconectar de la base
			modelo.desconectar(con);
		}
		else 
		{
			vista.dialogoInformar.setVisible(false);
		}
		
	}
	
	public void itemStateChanged(ItemEvent arg0) 
	{
		String[] Empleado=vista.choEmpleadoModificar.getSelectedItem().split("-");
		vista.txtNombreEmpleado.setText(Empleado[1]);
	}
	
	public void windowActivated(WindowEvent arg0) {}	
	public void windowClosed(WindowEvent arg0) {}		
	public void windowClosing(WindowEvent we) {
	
		if (vista.dialogoNuevo.isActive())
		{		
			vista.dialogoNuevo.setVisible(false);		
		} 
		else if (vista.dialogoEliminar.isActive())
		{		
			vista.dialogoEliminar.setVisible(false);		
		}
		else if (vista.dialogoConsultar.isActive())
		{		
			vista.dialogoConsultar.setVisible(false);		
		} 
		else if (vista.dialogoModificar.isActive())
		{		
			vista.dialogoModificar.setVisible(false);		
		}
		else if (vista.dialogoInformar.isActive())
		{		
			vista.dialogoInformar.setVisible(false);		
		} 
		else
		{		
			System.exit(0);		
		}
	
	}	
	public void windowDeactivated(WindowEvent arg0) {}	
	public void windowDeiconified(WindowEvent arg0) {}		
	public void windowIconified(WindowEvent arg0) {	}
	public void windowOpened(WindowEvent arg0) {}
}
