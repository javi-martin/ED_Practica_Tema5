package es.studium.MVC;

import java.awt.Choice;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo 
{	
	public Connection conectar(String baseDatos, String usuario, String contraseña)
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/"+baseDatos+"?autoReconnect=true&useSSL=false";
		String user = usuario;
		String password = contraseña;
		Connection con = null;
		try {
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexión con la BD empresa
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Conectado a la base de datos");				
			}
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:La dirección no es válida o el usuario y clave");
			ex.printStackTrace();				
		}
		
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-" + cnfe.getMessage());				
		}
		return con;
	}
	
	public void desconectar(Connection con)
	{
		try
		{
			con.close();
			System.out.println("Desconectado de la base de datos");	
		}
		catch(Exception e) {}
	}
	
	public int insertar(Connection con, String tabla, String nombre) 
	{	
		int respuesta = 0;
		
		try 
		{
			// Creamos un STATEMENT para una consulta SQL INSERT.
			Statement sta = con.createStatement();
			String cadenaSQL = "INSERT INTO " + tabla + " (nombreEmpleado) "
					+ "VALUES ('" + nombre + "')";
			System.out.println(cadenaSQL);
			sta.executeUpdate(cadenaSQL);
			sta.close();
		} 
		catch (Exception ex) 
		{
			System.out.println("ERROR:al hacer un Insert");
			ex.printStackTrace();
			respuesta = 1;
		}
		return respuesta;
	}
	
	public int borrar(Connection con,String tabla, String idCampo, int id)
	{	
		int respuesta = 0;
		
		String sql = "DELETE FROM "+tabla+" WHERE "+idCampo+" = " + id;
		System.out.println(sql);
		try 
		{
			// Creamos un STATEMENT para una consulta SQL INSERT.
			Statement sta = con.createStatement();
			sta.executeUpdate(sql);
			sta.close();
		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR:al hacer un Delete");
			ex.printStackTrace();
			respuesta = 1;
		}
		
		return respuesta;
		
	}
	
	public Choice rellenarChoice(Choice nombre) 
	{
		nombre.add("Seleccionar uno...");
		// Conectar a la base de datos
		Connection con = conectar("empresa","root","Studium2019;");
		// Sacar los datos de la tabla productos
		// Rellenar el Choice
		String sqlSelect = "SELECT * FROM empleados";
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				nombre.add(rs.getInt("idEmpleado")+
						"-"+rs.getString("nombreEmpleado"));						
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR:al consultar");
			ex.printStackTrace();			
		}
		// Cerrar la conexión
		desconectar(con);
		
		return nombre;
	}	
	
	public void mostrarDatos(Connection con, int idEmpleado, TextField id, TextField nombre)
	{
		String sql = "SELECT * FROM empleados WHERE idEmpleado = "+idEmpleado;
		try 
		{
			
			// Creamos un STATEMENT para una consulta SQL.
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next())
			{
				String i = rs.getString("idEmpleado");
				id.setText(i);
				String n = rs.getString("nombreEmpleado");
				nombre.setText(n);				
			}
			sta.close();
		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR:al hacer el SELECT");
			ex.printStackTrace();
		}
	}
	
	public int modificar(Connection con,String nombre, int id) 
	{	
		int respuesta = 0;
		
		// Ejecutar el UPDATE
		String sql ="UPDATE empleados SET nombreEmpleado = '"+nombre+"' WHERE idEmpleado="+id;
		try 
		{
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();				
		}
		catch (SQLException ex) 
		{						
			ex.printStackTrace();
			System.out.println("Error en Modificar producto");
			respuesta = 1;
		}
		return respuesta;
	}
	
	public String rellenarLabel(String etiqueta) 
	{
		 return etiqueta;
	}	
}
