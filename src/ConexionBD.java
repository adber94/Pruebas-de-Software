

import java.sql.*; 
import javax.swing.JOptionPane;  
public class ConexionBD {     
	String host_Server="localhost";     
	String user_Server="postgres";     
	String pass_Server="EX109261";           
	String db_Server="tiendaDeInstrumentos";       
	Statement  st=null;     
	Connection con=null;  
	 ResultSet resultado;
	public ConexionBD()     
	{            
		
	}           
	public Statement cone()     
	{         
		try         
		{               
			/* Driver */  
			int cp=0;
			String driver = "org.postgresql.Driver";               
			//System.out.println( "=> Cargando el Driver:" );               
			Class.forName( driver );               
			System.out.println("OK");               
			/* Definiendo Base de Datos */               
			String url  = "jdbc:postgresql://"+host_Server+":5432/"+db_Server ;               
			String user = user_Server;               
			String pass = pass_Server;              
			/* Conectando */               
			//System.out.println( "=> conectando:" );               
			con = DriverManager.getConnection(url,user,pass);               
			//System.out.println("OK");               
			/* Mostrando Resultados */               
			st= con.createStatement();
			
			//resultado = st.executeQuery("SELECT VERSION()");
		     
			}catch( Exception x )         
		{              JOptionPane.showMessageDialog(null,x.toString());              
       
		}
		return st;     
		} 

}

