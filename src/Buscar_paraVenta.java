import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Buscar_paraVenta extends JFrame implements ActionListener{
	
	String nombre,puesto,user,pass,pass2;
	int id;

	ImageIcon entrar = new ImageIcon("users.png");
	ImageIcon salir = new ImageIcon("power.png");

	
    JButton JBentrar=new JButton("Entrar",entrar);
	JButton JBsalir=new JButton("Salir",salir);
	
	JLabel lblusuario = new JLabel("Id de Empleado:  ");
	JLabel lblpass = new JLabel("Contraseña:    :  ");
	
	JPasswordField txtcontraseña = new JPasswordField();
	JTextField txtid = new JTextField();
    ResultSet resultado;

	public Buscar_paraVenta(){

	super("Capturar empleado para venta");
	this.getContentPane().setBackground(Color.lightGray);	
	this.setBounds(300,190,400,240);
       
	    lblusuario.setBounds(30, 30, 200, 20);
	    lblpass.setBounds(30, 70, 200, 20);
     	txtid.setBounds(200, 30, 150, 20); //id de empleado
    	
     	txtcontraseña.setBounds(200, 70, 150, 20);
     	txtcontraseña.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		txtid.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		 JBsalir.setBounds(200,120,170,59);
	     JBentrar.setBounds(20,120,170,59);
    	
	setLayout(null);


	
	this.add(JBentrar);
    this.add(JBsalir);
    this.add(lblusuario);
    this.add(lblpass);
    this.add(txtcontraseña);
    this.add(txtid);


	JBentrar.addActionListener(this);
	JBsalir.addActionListener(this);
	
	
	this.setVisible(true);
	}

	
	
	public int EntrarVenta(){
		int respuesta=0;
		ConexionBD con=new ConexionBD(); 
		
		
		 Statement st =con.cone();
 		 String consultaSQL ="SELECT *FROM empleado WHERE usuario_login='"+txtid.getText()+"' AND contra=('"+txtcontraseña.getText()+"')";
 		try {
			resultado= st.executeQuery(consultaSQL);
			while(resultado.next()){
 		 		respuesta=1;
 		 		String usuario = txtid.getText();
 		 		Vta.enviarInfo(usuario);
 		 	}
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null, "Error conexion","Error", JOptionPane.INFORMATION_MESSAGE);
   	       
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				st.close();
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "Error de desconexion","Error", JOptionPane.INFORMATION_MESSAGE);
       	       
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return respuesta;
	}
	
	
	
	
	public void actionPerformed(ActionEvent evt) {
		 Object press=evt.getSource();

		 if(press == JBentrar){
		     	if(EntrarVenta()==1){
		     			JOptionPane.showMessageDialog(null, "Bienvenido","Empleado", JOptionPane.INFORMATION_MESSAGE);
			     		Inicio ini = new Inicio();
			     		Login x = new Login(); 	
				    	x.setVisible(false);	
			     		x.opcionDeLogueo=2;
	    				this.dispose();
		     			ini.cmdadm.setEnabled(false);
	    				ini.cmdemple.setEnabled(false);
	    				ini.cmdinst.setEnabled(false);
		     	}else
		     		JOptionPane.showMessageDialog(null, "Error","Error", JOptionPane.INFORMATION_MESSAGE);
		        

	     if(press == JBsalir){
	     	System.exit(0);
	     }

	}
	  
	}
}
