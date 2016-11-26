import javax.swing.*;

//import conexion.nvaPrueba;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login extends JFrame implements ActionListener{
	static int opcionDeLogueo;
	String nombre,puesto,user,pass,pass2;
	int id;
	int band=0;
	ResultSet resultado;
	ImageIcon entrar = new ImageIcon("users.png");
	ImageIcon salir = new ImageIcon("power.png");

	Checkbox chkEmpleado = new Checkbox("Empleado",false);
    Checkbox chkAdministrador = new Checkbox("Administrador",false);
	
    JButton JBentrar=new JButton("Entrar",entrar);
	JButton JBsalir=new JButton("Salir",salir);
	//---------------------------------------------------
	JButton JBaceptar=new JButton("Aceptar");
	JButton JBcancel=new JButton("Cancelar");

    //---------------------------------------------------
	JLabel lblusuario = new JLabel("Nombre de Usuario: ");
	JLabel lblcontraseña = new JLabel("Contraseña:  ");

	JTextField txtusuario = new JTextField("");
	JPasswordField txtcontraseña = new JPasswordField("");

	public Login(){

	super("Login");
	   this.getContentPane().setBackground(Color.lightGray);
		this.setBounds(300,190,400,240);
		
		
		JBaceptar.setBounds(80,410,100,25);
		JBcancel.setBounds(300,410,100,25);

		txtusuario.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent evento) {
    			  Object tecla = new Object();
    		        tecla = evento.getSource(); 
    		        char c = evento.getKeyChar();
    		        if((tecla == txtusuario) )
    		        {if (txtusuario.getText().length() == 15)	{ 
   	        		 getToolkit().beep();
	        		 	evento.consume();
	        	 }  
    		        else//comprobacion id user//
    		        	if(!((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=48 && c<=57)))
    	    		        
    		        {
    		        	
    		        	getToolkit().beep();
    					evento.consume();
    		        }
    		        }
    		}
    		
    	});
		
		txtcontraseña.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent evento) {
    			  Object tecla = new Object();
    		        tecla = evento.getSource(); 
    		        char c = evento.getKeyChar();
    		        if((tecla == txtcontraseña) )
    		        {if (txtcontraseña.getText().length() == 15)	{ 
   	        		 getToolkit().beep();
	        		 	evento.consume();
	        	 }  
    		        }
    		}
    		
    	});
    	

        JBsalir.setBounds(200,120,170,59);
    	JBentrar.setBounds(20,120,170,59);
	    lblusuario.setBounds(30, 30, 200, 20);
	    lblcontraseña.setBounds(30, 80, 200, 20);
	    txtusuario.setBounds(200, 30, 150, 20);
    	txtcontraseña.setBounds(200, 80, 150, 20);
    	chkEmpleado.setBounds(30, 10, 100, 20);
    	chkAdministrador.setBounds(200, 10, 100, 20);
    	txtusuario.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		txtcontraseña.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    	
	setLayout(null);

	this.add(JBaceptar);
	this.add(JBcancel);
	
	this.add(JBentrar);
    this.add(JBsalir);
    this.add(lblusuario);
    this.add(lblcontraseña);
    this.add(txtusuario);
    this.add(txtcontraseña);
    this.add(chkEmpleado);
    this.add(chkAdministrador);

	
	JBentrar.addActionListener(this);
	JBsalir.addActionListener(this);
	
	JBaceptar.addActionListener(this);
	JBcancel.addActionListener(this);
	
	

	this.setVisible(true);
	
	JBaceptar.setVisible(false);
	JBcancel.setVisible(false);
	}
	
	public void LimpiarPass()
	{
		txtcontraseña.setText("");
		txtusuario.setText("");
	}
	
	
	public int  Entrar(){
		int respuesta=0;
		boolean login=true;
		if(chkAdministrador.getState()== true && chkEmpleado.getState()== true )
	     {
			
			
	     JOptionPane.showMessageDialog(null, "Error, solo se puede seleccionar una sola opcion..!!");
	     login=false;
	     }
		if(chkAdministrador.getState()== true && login==true )
	      {
			
			opcionDeLogueo = 1;
			ConexionBD con=new ConexionBD(); 
			
				int cp=0;
				 Statement st =con.cone();
		  		 String consultaSQL ="SELECT *FROM administrador WHERE usuario_login='"+txtusuario.getText()+"' AND contra=('"+txtcontraseña.getText()+"')";
		  		try {
					resultado= st.executeQuery(consultaSQL);
					while(resultado.next()){
		  		 		respuesta=1;
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
		else
			if(chkEmpleado.getState()== true)
		    {
				opcionDeLogueo = 2;
				ConexionBD con=new ConexionBD(); 
				
				
					 Statement st =con.cone();
			  		 String consultaSQL ="SELECT *FROM empleado WHERE usuario_login='"+txtusuario.getText()+"' AND contra=('"+txtcontraseña.getText()+"')";
			  		try {
						resultado= st.executeQuery(consultaSQL);
						while(resultado.next()){
			  		 		respuesta=1;
			  		 		String usuario = txtusuario.getText();
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
		  		 
		    }
		return respuesta;

		
	}		

	public void actionPerformed(ActionEvent evt){
	     Object press=evt.getSource();

	     if(press == JBentrar){
	     	if(Entrar()==1){
	     		if(opcionDeLogueo==1){
	     		JOptionPane.showMessageDialog(null, "Bienvenido","Administrador", JOptionPane.INFORMATION_MESSAGE);
	     		Inicio ini = new Inicio();
				this.dispose();
	     		}
	     		else if (opcionDeLogueo==2)
	     		{
	     			JOptionPane.showMessageDialog(null, "Bienvenido","Empleado", JOptionPane.INFORMATION_MESSAGE);
		     		Inicio ini = new Inicio();
    				this.dispose();
	     			ini.cmdadm.setEnabled(false);
    				ini.cmdemple.setEnabled(false);
    				ini.cmdinst.setEnabled(false);
	     		}
	     	
	     	}else
	     		JOptionPane.showMessageDialog(null, "Error","Error", JOptionPane.INFORMATION_MESSAGE);
	        
	     }
	 /*    if(press== chkAdministrador)
				{
					chkEmpleado.setState(false);
				}

		if (press== chkEmpleado)
			
						chkAdministrador.setState(false);*/

	     if(press == JBsalir){
	     	System.exit(0);
	     }
	     
	     if(press == JBcancel){
	     	Login log = new Login();
	     	this.dispose();
	     }
	     
	     if(press == JBaceptar){
	    
	     	Inicio ini = new Inicio();
    		this.dispose();
	     }
	}
	
	
	  
	public static void main(String[] args) {
        Login x=new Login();
        x.setVisible(true);
        
        
	}
}