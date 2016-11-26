import java.io.*;//manipular archivos
import java.text.DecimalFormat;
import java.sql.*; 
import javax.swing.JOptionPane;  
import javax.swing.*;//graficos
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.awt.*;//eventos
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
	public class Emple extends JFrame implements ActionListener, MouseListener, KeyListener 
	{
		      
		//Statement  st=null;     
		//Connection con=null;  
		 ResultSet resultado;
		 static String CP,RFC,usuario_login,contra,nombre,domicilio;
		//Etiquetas
		JLabel lblnombre= new JLabel("Nombre:");
		JLabel lblcalle = new JLabel("Domicilio:");
		JLabel lblcp = new JLabel("Codigo postal");
		JLabel lblrfc = new JLabel("RFC:");
		JLabel lblnombre_user = new JLabel("Nombre de usuario: ");
		JLabel lblcontra = new JLabel("Contraseña:");
		
		
		JTextField txtnombre = new JTextField();
		JTextField txtcalle = new JTextField();
		JTextField txtcp = new JTextField();
		JTextField txtrfc = new JTextField();
		JTextField txtnombre_user = new JTextField();
		JPasswordField txtcontra = new JPasswordField();
		JTextField txtbuscar = new JTextField("  Busca por ID Aqu\u00ED");	
		JTextField txteliminar = new JTextField("  Elimina por ID Aqu\u00ED");	

		ImageIcon agregar = new ImageIcon("add-user.png");
		ImageIcon mostrar = new ImageIcon("open-sign.png");
		ImageIcon regresar = new ImageIcon("left.png");
		ImageIcon buscar = new ImageIcon("search.png");
		ImageIcon eliminar = new ImageIcon("delete-user.png");
		ImageIcon borrartodo = new ImageIcon("trash.png");
		ImageIcon limpiar = new ImageIcon("flickr.png");
	
		
		
		JButton cmdagregar = new JButton("Agregar",agregar);
		JButton cmdmostrar = new JButton("Mostrar",mostrar);
		JButton cmdregresar = new JButton("Regresar",regresar);
		JButton cmdbuscar = new JButton("Buscar",buscar);
		JButton cmdeliminar = new JButton("Eliminar",eliminar);
		JButton cmdModificar = new JButton("Modificar",borrartodo);
		JButton cmdlimpiar = new JButton("Limpiar",limpiar);
		JButton cmdconfirmar = new JButton("Confirmar");
	    ImageIcon icono = new ImageIcon("emplea.png"); //icono de usuario
	    JLabel imagen = new JLabel("",icono,SwingConstants.RIGHT);
	    
	    
	    
	    ImageIcon logo = new ImageIcon("logochico.png"); // logo chico
	    JLabel imagen_logo = new JLabel("",logo,SwingConstants.RIGHT);
	   
	    
	    
	    String [][] datos ={};
        String [] vector = {"nombre", "domicilio", "cp", "RFC", "usuario login", "contra"};
        DefaultTableModel obj= new DefaultTableModel(datos,vector);
        
        private JTable  table = new JTable(obj);
        TableColumn columna1 = table.getColumn("nombre");
        TableColumn columna2 = table.getColumn("domicilio");
        TableColumn columna3 = table.getColumn("cp");
        TableColumn columna4 = table.getColumn("RFC");
        TableColumn columna5 = table.getColumn("usuario login");
        TableColumn columna6 = table.getColumn("contra");
        private final JLabel lblNombre = new JLabel("Nombre");
        private final JLabel lblDomcilio = new JLabel("Domcilio");
        private final JLabel lblCp = new JLabel("CP");
        private final JLabel lblRfc = new JLabel("RFC");
        private final JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
        private final JLabel lblContrasea = new JLabel("Contrase\u00F1a");
	    public Emple() {
	        //posiciones etiquetas
	    	
	        	super("Empleado");
	        	this.getContentPane().setBackground(Color.lightGray);
	        	this.setBounds(0,0,1201,540);
	        	//table.setAutoResizeMode(JTable.AUTO_RESIZE_ON);
	    		imagen.setBounds(-90,60,200,80);
	    		imagen_logo.setBounds(-170,0,515,179);
	    		//para redimensionar las columnas
	    		columna1.setPreferredWidth(200);
	    		columna2.setPreferredWidth(200);
	    		columna3.setPreferredWidth(50);
	    		columna4.setPreferredWidth(150);
	    		columna5.setPreferredWidth(150);
	    		columna6.setPreferredWidth(150);
	    		
	    		
	    		// x,y, ancho, alto
	        	lblnombre.setBounds(20,151,180,19);
	        	lblcalle.setBounds(20,190,180,19);
	        	lblcp.setBounds(20,230,180,19);
	        	lblrfc.setBounds(20,273,180,19);
	        	lblnombre_user.setBounds(20,330,180,19);
	        	lblcontra.setBounds(20,380,180,19);
	        	txtnombre.setBounds(20,170,180,19);
	        	txtcalle.setBounds(20,210,180,19);
	        	txtcp.setBounds(20,254,180,19);
	        	txtrfc.setBounds(20,303,180,19);
	        	txtnombre_user.setBounds(20,350,180,19);
	        	txtcontra.setBounds(20,410,180,19);
	        	txtbuscar.setBounds(370,11,220,59);
	        	txteliminar.setBounds(370,81,220,59);
	        	////////*********************//////////////////
	        	txtcontra.addKeyListener(new KeyAdapter() {
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			  Object tecla = new Object();
	        		        tecla = evento.getSource(); 
	        		        char c = evento.getKeyChar();
	        		        if((tecla == txtcontra) )
	        		        {if (txtcontra.getText().length() == 15){
	   	        			 getToolkit().beep();
			        		 evento.consume(); 
		        		 }
	        		        }
	        		}
	        		
	        	});
	        	
	        	txtcalle.addKeyListener(new KeyAdapter() {
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			  Object tecla = new Object();
	        		        tecla = evento.getSource(); 
	        		        char c = evento.getKeyChar();
	        		        if((tecla == txtcalle) )
	        		        {
	        		        	if(!((c>=48 && c<=57) ||(c>=65 && c<=90) || (c>=97 && c<=122) || (c>=160 && c<=165) || (c==130) || (c==144) || (c>=160) || (c>=65 && c<=90) || (c>=181) || (c==214) || (c==224) || (c==233) || (c==32)))
	        		     		     {
	        				        	getToolkit().beep();
	        							evento.consume();
	        				        }
	        		        	 else if (txtcalle.getText().length() == 45)	{ 
	        		        		 getToolkit().beep();
	        		        		 	evento.consume();
	        		        	 }
	        		        }
	        		}
	        		
	        	});
	        	
	        	txtcp.addKeyListener(new KeyAdapter() {
	        		
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			Object tecla = new Object();
        		        tecla = evento.getSource(); 
        		        char c = evento.getKeyChar();
        		        if((tecla == txtcp))
        		        {if (txtcp.getText().length() == 5)	{ 
        		        		 getToolkit().beep();
        		        		 	evento.consume();
        		        	 }	 
        		        }
	        		}
	        	});
	        	
	        	txtrfc.addKeyListener(new KeyAdapter() {
	        		
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			Object tecla = new Object();
        		        tecla = evento.getSource(); 
        		        char c = evento.getKeyChar();
        		        if((tecla == txtrfc))
        		        {
        		        	if(!((c>=65 && c<=90) || (c>=48 && c<=57)))
        	    	    		     {
        				        	getToolkit().beep();
        							evento.consume();
        				        }
        		        	 else if (txtrfc.getText().length() == 13)	{ 
        		        		 getToolkit().beep();
        		        		 	evento.consume();
        		        	 }	 
        		        }
	        		}
	        	});
	        	
	        	txtnombre_user.addKeyListener(new KeyAdapter() {
	        		
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			Object tecla = new Object();
        		        tecla = evento.getSource(); 
        		        char c = evento.getKeyChar();
        		        if((tecla == txtnombre_user))
        		        {
        		        	if ((txtnombre_user.getText().length() == 15) ){	 
        		        		 getToolkit().beep();
        		        		 evento.consume();
        		        	}} }
	        		
	        	});
	        	
	        	txtbuscar.addKeyListener(new KeyAdapter() {
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			  Object tecla = new Object();
	        		        tecla = evento.getSource(); 
	        		        char c = evento.getKeyChar();
	        		        if((tecla == txtbuscar) )
	        		        {if (txtbuscar.getText().length() == 15){
	   	        			 getToolkit().beep();
			        		 evento.consume(); 
		        		 }
	        		        }
	        		}
	        		
	        	});
	        	
	        	txteliminar.addKeyListener(new KeyAdapter() {
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			  Object tecla = new Object();
	        		        tecla = evento.getSource(); 
	        		        char c = evento.getKeyChar();
	        		        if((tecla == txteliminar) )
	        		        {if(txteliminar.getText().length() == 15)
	   	        		 {
	   	        			 getToolkit().beep();
	   		        		 evento.consume();
	   	        	 }	
	        		        }
	        		}
	        		
	        	});
	        	
	        	
	        	txtbuscar.setForeground(Color.GRAY);
	        	txteliminar.setForeground(Color.GRAY);
	        	
	        	cmdagregar.setBounds(210,410,150,59);
	        	cmdregresar.setBounds(967,410,170,59);
	        	cmdmostrar.setBounds(384,410,179,59);
	        	cmdModificar.setBounds(573,410,191,59);
	        	cmdlimpiar.setBounds(777,410,180,59);
	        	cmdconfirmar.setBounds(650,383,110,23);
	        	cmdbuscar.setBounds(630,11,150,59);
	        	cmdeliminar.setBounds(630,81,150,59);
	        	
	        
	        	
	        	//agregar al formulario
	        	getContentPane().setLayout(null);
	        	
	        	
	        	//Agregar los objetos
	        	
	        	getContentPane().add(lblnombre);
	        	getContentPane().add(lblcalle);
	        	getContentPane().add(lblcp);
	        	getContentPane().add(lblnombre_user);
	        	getContentPane().add(lblcontra);
	        	getContentPane().add(lblrfc);
	        	
	        	//agrega la imagen
	        	getContentPane().add(imagen);
	        	getContentPane().add(imagen_logo);
	        	getContentPane().add(txtnombre);
	        	getContentPane().add(txtcalle);
	        	getContentPane().add(txtcp);
	        	getContentPane().add(txtnombre_user);
	        	getContentPane().add(txtrfc);
	        	getContentPane().add(txtcontra);
	        	getContentPane().add(txtbuscar);
	            getContentPane().add(txteliminar);
	        
	        	getContentPane().add(cmdagregar);
	        	getContentPane().add(cmdregresar);
	        	getContentPane().add(cmdmostrar);
	            getContentPane().add(cmdbuscar);
	            getContentPane().add(cmdeliminar);
	            getContentPane().add(cmdlimpiar);
	            getContentPane().add(cmdModificar);
	            getContentPane().add(cmdconfirmar);
	            
	            JPanel panel = new JPanel();
	            panel.setBounds(210, 178, 943, 199);
	            getContentPane().add(panel);
	            
	         //   JTable tabla = null;
	            panel.add(table);
	            
	            JScrollPane scrollPane = new JScrollPane();
	            panel.add(scrollPane);
	            lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblNombre.setBounds(277, 156, 61, 14);
	            
	            getContentPane().add(lblNombre);
	            lblDomcilio.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblDomcilio.setBounds(443, 156, 61, 14);
	            
	            getContentPane().add(lblDomcilio);
	            lblCp.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblCp.setBounds(640, 156, 61, 14);
	            
	            getContentPane().add(lblCp);
	            lblRfc.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblRfc.setBounds(735, 156, 61, 14);
	            
	            getContentPane().add(lblRfc);
	            lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblNombreUsuario.setBounds(852, 156, 118, 14);
	            
	            getContentPane().add(lblNombreUsuario);
	            lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblContrasea.setBounds(1040, 156, 118, 14);
	            
	            getContentPane().add(lblContrasea);

	            txtbuscar.addKeyListener(this);
	            txtcp.addKeyListener(this);
	            txteliminar.addKeyListener(this);
	            txtnombre.addKeyListener(this);
	            txtnombre_user.addKeyListener(this);
	         
	            
	            
                txtbuscar.addMouseListener((MouseListener) this);
                txteliminar.addMouseListener((MouseListener) this);
                cmdagregar.addActionListener(this);
	            cmdbuscar.addActionListener(this);
	            cmdeliminar.addActionListener(this);
	            cmdmostrar.addActionListener(this);
	            cmdregresar.addActionListener(this);
	            cmdlimpiar.addActionListener(this);
	            cmdModificar.addActionListener(this);
	            cmdconfirmar.addActionListener(this);
	           
	            this.setVisible(true);
	
	            
	    
	        	//hacerlo visible
	        	this.setVisible(true);
	        	
	        }
	   
	     
 
	    
	    public void limpiar(){
	    
	    	       for (int i = 0; i < table.getRowCount(); i++) {
	    	           obj.removeRow(i);
	    	           i-=1;
	    	       }
	    	   
	    	
			txtnombre.setText("");
			txtcalle.setText("");
			txtcp.setText("");
			txtrfc.setText("");
		
			txtbuscar.setForeground(Color.GRAY);
			
			txtbuscar.setText("  Busca por ID Aquí");
			
			txteliminar.setForeground(Color.GRAY);
			
			txteliminar.setText("  Elimina por ID Aquí");	
			
			txtnombre_user.setText("");
			txtcontra.setText("");
			//txpMostrar.setText("");
			
			
	    }
	    
	    public void capturar()
	    {
	    	
	    	if(txtnombre.getText().isEmpty()||txtcalle.getText().isEmpty()   ||txtcp.getText().isEmpty() ||txtrfc.getText().isEmpty() ||txtnombre_user.getText().isEmpty() ||txtcontra.getText().isEmpty())
	        {
	          JOptionPane.showMessageDialog(null,"No se pueden dejar campos vacios..!!");      
	        
	        }
	        
	      else
	        {
	    	  ConexionBD con=new ConexionBD(); 
				try {
					 Statement st =con.cone();
			  		 String consultaSQL ="INSERT INTO empleado (nombre,domicilio,cp,rfc,usuario_login,contra) VALUES('"+txtnombre.getText()+"' , '"+txtcalle.getText()+"' , '"+txtcp.getText()+"' , '"+txtrfc.getText()+"' , '"+txtnombre_user.getText()+"' , '"+txtcontra.getText()+"')";
			  		 st.executeUpdate(consultaSQL);
			  		 st.close();
			  		 JOptionPane.showMessageDialog(null,"El registro se inserto de manera correcta..!!");   
			  		 	
				} catch (SQLException e) {
					 JOptionPane.showMessageDialog(null,"Hubo un error en la insercion..!!");   
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	
	  
	    }
	    }
	    
	  
	    
	    public void mostrar(){
	       int cp=0;
	    	limpiar();
       
	  		  ConexionBD con=new ConexionBD(); 
				try {
					 Statement st =con.cone();
			  		 String consultaSQL ="SELECT *FROM empleado";
			  		 resultado= st.executeQuery(consultaSQL);
			  		 	while(resultado.next()){
						String nombre = resultado.getString("nombre");
						String domicilio = resultado.getString("domicilio");
						cp= resultado.getInt("cp");
						String CP = Integer.toString(cp);
						String RFC = resultado.getString("rfc");
						String usuario_login = resultado.getString("usuario_login");
						String contra= resultado.getString("contra");
						String []modelo= {nombre,domicilio,CP,RFC,usuario_login,contra};
						obj.addRow(modelo);
					
						
					}
			  		 	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }

	        
	         
	    
        public void buscar()
	    
	    {
        	 for (int i = 0; i < table.getRowCount(); i++) {
  	           obj.removeRow(i);
  	           i-=1;
  	       }
        	ConexionBD con=new ConexionBD(); 
			try {
				int cp=0;
				 Statement st =con.cone();
		  		 String consultaSQL ="SELECT *FROM empleado WHERE usuario_login='"+txtbuscar.getText()+"';";
		  		 resultado= st.executeQuery(consultaSQL);
		  		 	while(resultado.next()){
					String nombre = resultado.getString("nombre");
					String domicilio = resultado.getString("domicilio");
					cp= resultado.getInt("cp");
					String CP = Integer.toString(cp);
					String RFC = resultado.getString("rfc");
					String usuario_login = resultado.getString("usuario_login");
					String contra= resultado.getString("contra");
					String []modelo= {nombre,domicilio,CP,RFC,usuario_login,contra};
					obj.addRow(modelo);
					 JOptionPane.showMessageDialog(null,"Se encontro la busqueda..!!");   
					
				}
		  		 	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
       
     
		 public void eliminar()
		   {
			 ConexionBD con=new ConexionBD(); 
				try {
					 Statement st =con.cone();
					 
			  		 String consultaSQL ="DELETE FROM empleado WHERE usuario_login='"+txteliminar.getText()+"';";
			  		 st.executeUpdate(consultaSQL);
			  		 st.close();
			  		 JOptionPane.showMessageDialog(null,"El registro se elimino de manera correcta..!!");   
			  		 	
				} catch (SQLException e) {
					 JOptionPane.showMessageDialog(null,"Hubo un error en la eliminacion..!!");   
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	
			
		   }
		//hacer menu para que el cliente elija el campo
 public void modificar()
		 
		 {
			 String idModificar = JOptionPane.showInputDialog("Ingresa el id del empleado a modificar: ");
			 if(idModificar != null)
			 {
				cmdbuscar.setEnabled(false);
				cmdeliminar.setEnabled(false);
 				cmdagregar.setEnabled(false);
 				cmdmostrar.setEnabled(false);
				cmdregresar.setEnabled(false);
				txtnombre_user.setEditable(false);
		  		 	 
			 }
			 ConexionBD con=new ConexionBD(); 
				try {
					int cp=0;
					 Statement st =con.cone();
					 Statement st2 =con.cone();
			  		 String consultaSQL ="SELECT *FROM empleado WHERE usuario_login='"+idModificar+"';";
			  		 resultado= st.executeQuery(consultaSQL);
			  		 	while(resultado.next()){
			  		 		nombre = resultado.getString("nombre");
							domicilio = resultado.getString("domicilio");
							cp= resultado.getInt("cp");
							CP = Integer.toString(cp);
							RFC = resultado.getString("rfc");
							usuario_login = resultado.getString("usuario_login");
							contra= resultado.getString("contra");
								txtnombre_user.setText(usuario_login);
								txtnombre.setText(nombre);
								txtcalle.setText(domicilio);
								txtcp.setText(CP);
								txtrfc.setText(RFC);
								txtcontra.setText(contra);
						//	confirmar (marca,tipo,costo,nombre);
							
					}
			  		 	
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		 }
		 public void confirmar()
		    {
			    cmdbuscar.setEnabled(true);
				cmdeliminar.setEnabled(true);
				cmdagregar.setEnabled(true);
				cmdmostrar.setEnabled(true);
				cmdregresar.setEnabled(true);
				txtnombre_user.setEditable(true);
		    	  ConexionBD con=new ConexionBD(); 
					try {
						 Statement st =con.cone();
						 String consultaSQL=  "UPDATE empleado SET nombre='"+txtnombre.getText()+"' WHERE nombre='"+nombre+"';";
						 String consultaSQL2= "UPDATE empleado SET domicilio='"+txtcalle.getText()+"' WHERE domicilio='"+domicilio+"';";
						 String consultaSQL3= "UPDATE empleado SET cp='"+txtcp.getText()+"' WHERE cp='"+CP+"';";
						 String consultaSQL4= "UPDATE empleado SET rfc='"+txtrfc.getText()+"' WHERE rfc='"+RFC+"';";
						 String consultaSQL5= "UPDATE empleado SET contra='"+txtcontra.getText()+"' WHERE contra='"+contra+"';";
							
						 st.execute(consultaSQL);
						 st.execute(consultaSQL2);
						 st.execute(consultaSQL3);
						 st.execute(consultaSQL4);
						 st.execute(consultaSQL5);
						 st.close();
				  		 JOptionPane.showMessageDialog(null,"El registro se actualizo de manera correcta..!!");   
				  		 	
					} catch (SQLException e) {
						 JOptionPane.showMessageDialog(null,"Hubo un error en la modificacion..!!");   
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		    }
		 
	    
	
	
	    
	    
	    
	    
	    
	    
	    
	    public void actionPerformed(ActionEvent evt)
	    {
	    	Object presionado= evt.getSource();
	    	
	    	
	    	if(presionado==cmdagregar)
	    	{
	    		capturar();
	    		limpiar();
	    	}
	    	
	    		if(presionado==cmdmostrar)
	    		{
	    		mostrar();	
	    		}
	    		else
	    	    if(presionado==cmdlimpiar)
	    		{
	    			limpiar();
	    		}
	    	    if(presionado==cmdbuscar)
	    	   {
	    	    //	limpiar();
	    		buscar();
	    		
	    	   }
	    	    if(presionado==cmdeliminar)
		    	   {
	    	    	int i=JOptionPane.showConfirmDialog(null,"¿Seguro que deseas eliminar?");
			   		if(i==(JOptionPane.YES_OPTION)){ 
	    	    	eliminar();  		
				   			limpiar();
			   		}
				   		
				   		
		    	   }
	    	    if(presionado==cmdModificar)
		    	   {
		    		modificar();
		    	   }
	    	      if(presionado==cmdconfirmar){
	    	    	int i=JOptionPane.showConfirmDialog(null,"¿Seguro que deseas modificar?");
			   		if(i==(JOptionPane.YES_OPTION)){ 
	    	    	confirmar();
			   		}
		    	   }
	    	    if(presionado==cmdregresar)
		    	   {
		    		this.setVisible(false);
		    		Inicio reg= new Inicio();
		    	   }
	    	    
	 
	    }




		public void mouseClicked(MouseEvent e) {
			
			Object clik = e.getSource();
			
			if(clik == txtbuscar )
			{
			  txtbuscar.setText("");	
			  txtbuscar.setForeground(Color.BLACK);
				
			}
			
			if(clik == txteliminar )
			{
			  txteliminar.setText("");	
			  txteliminar.setForeground(Color.BLACK);
				
			}
			
			
		}




		public void mouseEntered(MouseEvent ev) {
		
			
		}




		public void mouseExited(MouseEvent eve) {
			
			
		}




		public void mousePressed(MouseEvent even) {
		
			
		}




		public void mouseReleased(MouseEvent event) {
			
			
		}




		



		public void keyReleased(KeyEvent y) {
						
		}




		public void keyTyped(KeyEvent evento) {
			
	      Object tecla = new Object();
			
	        tecla = evento.getSource();
	        char c = evento.getKeyChar();
	        
	       
	        if(tecla==txtcp)
	        {
	    				  if(!Character.isDigit(c))
	    				  {
	    					 getToolkit().beep();
	    					  evento.consume();}
	    				  
	        }
	        else if(tecla == txtnombre){
	        	if(!((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=160 && c<=165) || (c==130) || (c==144) || (c>=160) || (c>=65 && c<=90) || (c>=181) || (c==214) || (c==224) || (c==233) || (c==32)))
    		        {
		        	getToolkit().beep();
					evento.consume();
		        }  
	        }
	        else if((tecla == txtnombre_user)||(tecla == txtbuscar)||(tecla == txteliminar))
	        {
	        	if(!((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=48 && c<=57)))
 	    		   {
		        	getToolkit().beep();
					evento.consume();
		        }
	        }
	        
	        
	       
	    		
                }




		public void keyPressed(KeyEvent a) {

			
		}
	}