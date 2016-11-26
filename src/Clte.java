import javax.swing.border.EmptyBorder;
import java.io.*;//manipular archivos
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.*;//graficos

import java.awt.*;//eventos
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
	public class Clte extends JFrame implements ActionListener, MouseListener, KeyListener 
	{
		 ResultSet resultado;
		 static String CP,RFC,nickname,nombre,domicilio;
			
		//Etiquetas
		JLabel lblnombre= new JLabel("Nombre:");
		JLabel lblcalle = new JLabel("Domicilio:");
		JLabel lblcp = new JLabel("Codigo postal");
		JLabel lblrfc = new JLabel("RFC:");
		JLabel lblnombre_user = new JLabel("Id de cliente: ");
		
		
		JTextField txtnombre = new JTextField();
		JTextField txtcalle = new JTextField();
		JTextField txtcp = new JTextField();
		JTextField txtrfc = new JTextField();
		JTextField txtnombre_user = new JTextField();
		
		JTextField txtbuscar = new JTextField("  Busca por nickname Aqu\u00ED");	
		JTextField txteliminar = new JTextField("  Elimina por nickname Aqu\u00ED");	

		ImageIcon agregar = new ImageIcon("add-user.png");
		ImageIcon mostrar = new ImageIcon("open-sign.png");
		ImageIcon regresar = new ImageIcon("left.png");
		ImageIcon buscar = new ImageIcon("search.png");
		ImageIcon eliminar = new ImageIcon("delete-user.png");
		ImageIcon borrartodo = new ImageIcon("trash.png");
		ImageIcon limpiar = new ImageIcon("flickr.png");
		//ImageIcon limpiar = new ImageIcon("add.png");
		
		
		JButton cmdagregar = new JButton("Agregar",agregar);
		JButton cmdmostrar = new JButton("Mostrar",mostrar);
		JButton cmdregresar = new JButton("Regresar",regresar);
		JButton cmdbuscar = new JButton("Buscar",buscar);
		JButton cmdeliminar = new JButton("Eliminar",eliminar);
		JButton cmdmodificar = new JButton("Modificar",borrartodo);
		JButton cmdlimpiar = new JButton("Limpiar",limpiar);
		JButton cmdconfirmar = new JButton("Confirmar");
	   
	    ImageIcon icono = new ImageIcon("usuarioo.png"); //lgo user
	    JLabel imagen = new JLabel("",icono,SwingConstants.RIGHT);
	    
	    
	    
	    ImageIcon logo = new ImageIcon("Logochico.png"); //logo adm
	    JLabel imagen_logo = new JLabel("",logo,SwingConstants.RIGHT);
	  //  private JTable table;
	    String [][] datos ={};
        String [] vector = {"nombre", "domicilio", "cp", "RFC", "usuario login"};
        DefaultTableModel obj= new DefaultTableModel(datos,vector);
        
        JTable  table = new JTable(obj);
        TableColumn columna1 = table.getColumn("nombre");
        TableColumn columna2 = table.getColumn("domicilio");
        TableColumn columna3 = table.getColumn("cp");
        TableColumn columna4 = table.getColumn("RFC");
        TableColumn columna5 = table.getColumn("usuario login");
        private final JLabel lblNombreCliente = new JLabel("Nombre Cliente");
        private final JLabel lblDomicilio = new JLabel("Domicilio");
        private final JLabel lblCp = new JLabel("CP");
        private final JLabel lblNickname = new JLabel("Nickname");
        private final JLabel lblRfc = new JLabel("RFC");
        
	   
	    public Clte() {
	        //posiciones etiquetas
	    	
	        	super("Cliente");
	        	this.getContentPane().setBackground(Color.lightGray);
	        	this.setBounds(0,0,1050,540);
	        	int y=120;
	        	
	    		imagen.setBounds(-90,60,200,80);
	    		imagen_logo.setBounds(-170,0,500,200);
	    		
	    		
	    		columna1.setPreferredWidth(200);
	    		columna2.setPreferredWidth(200);
	    		columna3.setPreferredWidth(50);
	    		columna4.setPreferredWidth(150);
	    		columna5.setPreferredWidth(150);
	    		
	    	    
	    		
	    		// x,y, ancho, alto
	    		lblnombre.setBounds(20,151,180,19);
	        	lblcalle.setBounds(20,190,180,19);
	        	lblcp.setBounds(20,230,180,19);
	        	lblrfc.setBounds(20,273,180,19);
	        	lblnombre_user.setBounds(20,330,180,19);
	        	
	        	txtnombre.setBounds(20,170,180,19);
	        	
	        	txtcalle.setBounds(20,210,180,19);
	        	txtcp.setBounds(20,254,180,19);
	        	
	        	txtrfc.setBounds(20,303,180,19);
	        	
	        	
	        	////////////////////***********************/////////////
	        	txtnombre.addKeyListener(new KeyAdapter() {
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			  Object tecla = new Object();
	        		        tecla = evento.getSource(); 
	        		        char c = evento.getKeyChar();
	        		        if((tecla == txtnombre) )
	        		        {if (txtnombre.getText().length() == 45)	{ 
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
        		        	if(!((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=48 && c<=57)))
        		 	    		 {
        				        	getToolkit().beep();
        							evento.consume();
        				        }else if (txtnombre_user.getText().length() == 15 )	{ 
        			        		 getToolkit().beep();
        			        		 evento.consume();
        			        	 }	
        			        }
	        		}
	        	});
	        	txtbuscar.addKeyListener(new KeyAdapter() {
	        		@Override
	        		public void keyTyped(KeyEvent evento) {
	        			  Object tecla = new Object();
	        		        tecla = evento.getSource(); 
	        		        char c = evento.getKeyChar();
	        		        if(!((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=48 && c<=57)))
	        	 	    		 {
    				        	getToolkit().beep();
    							evento.consume();
    				        }else if((tecla == txtbuscar) )
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
	        		        if(!((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=48 && c<=57)))
	        	 	    		 {
    				        	getToolkit().beep();
    							evento.consume();
    				        }else if((tecla == txteliminar) )
	        		        {if(txteliminar.getText().length() == 15)
	   	        		 {
	   	        			 getToolkit().beep();
	   		        		 evento.consume();
	   	        	 }	
	        		        }
	        		}
	        		
	        	});
	        	txtnombre_user.setBounds(20,350,180,19);
	        	
	        	
	        	txtbuscar.setBounds(370,30,220,59);
	        	txteliminar.setBounds(370,100,220,59);
	        	
	        	txtbuscar.setForeground(Color.GRAY);
	        	txteliminar.setForeground(Color.GRAY);
	        	
	        	cmdagregar.setBounds(20,431,150,59);
	        	cmdregresar.setBounds(763,431,170,59);
	        	cmdmostrar.setBounds(191,431,150,59);
	        	cmdmodificar.setBounds(370,431,180,59);
	        	cmdlimpiar.setBounds(576,431,150,59);
	        	cmdconfirmar.setBounds(441,407,110,23);
	        	cmdbuscar.setBounds(630,30,150,59);
	        	cmdeliminar.setBounds(630,100,150,59);
	        	
	        
	        	
	        	//agregar al formulario
	        	getContentPane().setLayout(null);
	        	
	        	
	        	//Agregar los objetos
	        	
	        	getContentPane().add(lblnombre);
	        	getContentPane().add(lblcalle);
	        	getContentPane().add(lblcp);
	        	getContentPane().add(lblnombre_user);
	        	getContentPane().add(lblrfc);
	        	
	        	//agrega la imagen
	        	getContentPane().add(imagen);
	        	getContentPane().add(imagen_logo);
	        	getContentPane().add(txtnombre);
	        	getContentPane().add(txtcalle);
	        	getContentPane().add(txtcp);
	        	getContentPane().add(txtnombre_user);
	        	getContentPane().add(txtrfc);
	        	
	        	getContentPane().add(txtbuscar);
	            getContentPane().add(txteliminar);
	        
	        	getContentPane().add(cmdagregar);
	        	getContentPane().add(cmdregresar);
	        	getContentPane().add(cmdmostrar);
	            getContentPane().add(cmdbuscar);
	            getContentPane().add(cmdeliminar);
	            getContentPane().add(cmdlimpiar);
	            getContentPane().add(cmdmodificar);
	            getContentPane().add(cmdconfirmar);
	            
	            JPanel panel = new JPanel();
	            panel.setBounds(210, 189, 791, 207);
	            getContentPane().add(panel);
	            panel.add(table);
	            
	            JScrollPane scrollPane = new JScrollPane();
	            panel.add(scrollPane);
	            lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblNombreCliente.setBounds(245, 172, 96, 14);
	            
	            getContentPane().add(lblNombreCliente);
	            lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblDomicilio.setBounds(477, 172, 96, 14);
	            
	            getContentPane().add(lblDomicilio);
	            lblCp.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblCp.setBounds(630, 172, 52, 14);
	            
	            getContentPane().add(lblCp);
	            lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblNickname.setBounds(882, 172, 96, 14);
	            
	            getContentPane().add(lblNickname);
	            lblRfc.setFont(new Font("Tahoma", Font.PLAIN, 13));
	            lblRfc.setBounds(737, 172, 96, 14);
	            
	            getContentPane().add(lblRfc);

	            txtbuscar.addKeyListener(this);
	            txtcp.addKeyListener(this);
	            txteliminar.addKeyListener(this);
	            txtnombre.addKeyListener(this);
	            
	            
                txtbuscar.addMouseListener((MouseListener) this);
                txteliminar.addMouseListener((MouseListener) this);
                cmdagregar.addActionListener(this);
	            cmdbuscar.addActionListener(this);
	            cmdeliminar.addActionListener(this);
	            cmdmostrar.addActionListener(this);
	            cmdregresar.addActionListener(this);
	            cmdlimpiar.addActionListener(this);
	            cmdmodificar.addActionListener(this);
	            cmdconfirmar.addActionListener(this);
	            
	
	          //  table.getTableHeader().setVisible(true);
	    
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
		
		txtbuscar.setText("  Busca por nickname Aquí");
		
		txteliminar.setForeground(Color.GRAY);
		
		txteliminar.setText("  Elimina por nickname Aquí");	
		
		txtnombre_user.setText("");
	
		//txpMostrar.setText("");
	    }
	    
	    public void capturar()
	    {
	    	if(txtnombre.getText().isEmpty()||txtcalle.getText().isEmpty()   ||txtcp.getText().isEmpty() ||txtrfc.getText().isEmpty() ||txtnombre_user.getText().isEmpty())
	        {
	          JOptionPane.showMessageDialog(null,"No se pueden dejar campos vacios..!!");      
	        
	        }
	        
	      else
	        {
	    	  ConexionBD con=new ConexionBD(); 
				try {
					 Statement st =con.cone();
			  		 String consultaSQL ="INSERT INTO cliente (nombre,domicilio,cp, rfc, nickname) VALUES('"+txtnombre.getText()+"' , '"+txtcalle.getText()+"' , '"+txtcp.getText()+"' , '"+txtrfc.getText()+"' , '"+txtnombre_user.getText()+"')";
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
			  		 String consultaSQL ="SELECT *FROM cliente";
			  		 resultado= st.executeQuery(consultaSQL);
			  		 	while(resultado.next()){
						String nombre = resultado.getString("nombre");
						String domicilio = resultado.getString("domicilio");
						cp= resultado.getInt("cp");
						String CP = Integer.toString(cp);
						String nickname = resultado.getString("nickname");
						String RFC = resultado.getString("rfc");
						String []modelo= {nombre,domicilio,CP,RFC, nickname};
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
				  		 String consultaSQL ="SELECT *FROM cliente WHERE nickname='"+txtbuscar.getText()+"';";
				  		 resultado= st.executeQuery(consultaSQL);
				  		 	while(resultado.next()){
							String nombre = resultado.getString("nombre");
							String domicilio = resultado.getString("domicilio");
							cp= resultado.getInt("cp");
							String CP = Integer.toString(cp);
							String nickname = resultado.getString("nickname");
							String RFC = resultado.getString("rfc");
							
							
							String []modelo= {nombre,domicilio,CP,RFC,nickname,};
							obj.addRow(modelo);
							 JOptionPane.showMessageDialog(null,"Se encontro la busqueda..!!");   
							
						}
				  		 	
					} catch (SQLException e) {
						
						JOptionPane.showMessageDialog(null,"Ese registro no existe.!!");  
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        }
	    
		public void eliminar()
		   {
			 ConexionBD con=new ConexionBD(); 
				try {
					 Statement st =con.cone();
					 
			  		 String consultaSQL ="DELETE FROM cliente WHERE nickname='"+txteliminar.getText()+"';";
			  		 st.executeUpdate(consultaSQL);
			  		 st.close();
			  		 JOptionPane.showMessageDialog(null,"El registro se elimino de manera correcta..!!");   
			  		 	
				} catch (SQLException e) {
					 JOptionPane.showMessageDialog(null,"Hubo un error en la eliminacion..!!");   
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	
			
		   }
		 
	    
		public void modificar()
		 
		 {
			 String idModificar = JOptionPane.showInputDialog("Ingresa el nickname del cliente a modificar: ");
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
					
			  		 String consultaSQL ="SELECT *FROM cliente WHERE nickname='"+idModificar+"';";
			  		 resultado= st.executeQuery(consultaSQL);
			  		 	while(resultado.next()){
			  		 		nombre = resultado.getString("nombre");
							domicilio = resultado.getString("domicilio");
							cp= resultado.getInt("cp");
							CP = Integer.toString(cp);
							RFC = resultado.getString("rfc");
							nickname = resultado.getString("nickname");
								
								txtnombre_user.setText(nickname);
								txtnombre.setText(nombre);
								txtcalle.setText(domicilio);
								txtcp.setText(CP);
								txtrfc.setText(RFC);
	
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
						 String consultaSQL=  "UPDATE cliente SET nombre='"+txtnombre.getText()+"' WHERE nombre='"+nombre+"';";
						 String consultaSQL2= "UPDATE cliente SET domicilio='"+txtcalle.getText()+"' WHERE domicilio='"+domicilio+"';";
						 String consultaSQL3= "UPDATE cliente SET cp='"+txtcp.getText()+"' WHERE cp='"+CP+"';";
						 String consultaSQL4= "UPDATE cliente SET rfc='"+txtrfc.getText()+"' WHERE rfc='"+RFC+"';";
							
						 st.execute(consultaSQL);
						 st.execute(consultaSQL2);
						 st.execute(consultaSQL3);
						 st.execute(consultaSQL4);
						
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
	    	  
	    		buscar();
	    		txtbuscar.setText("");
	    	   }
	    	    if(presionado==cmdeliminar)
		    	   {
				   			
	    	    	int i=JOptionPane.showConfirmDialog(null,"¿Seguro que deseas eliminar?");
			   		if(i==(JOptionPane.YES_OPTION)){ 
	    	    	eliminar();  		
				   			limpiar();
			   		}	
				   		
				   		
		    	   }
	    
	    	    if(presionado==cmdmodificar)
		    	   {
		    		modificar();
		    	   }
	    	      if(presionado==cmdconfirmar){
	    	    	int i=JOptionPane.showConfirmDialog(null,"¿Seguro que deseas modificar?");
			   		if(i==(JOptionPane.YES_OPTION)){ 
	    	    	confirmar();
	    	    	limpiar();
			   		}
		    	   }
	    	    if(presionado==cmdregresar)
	    	    {
	    	    	Login x = new Login(); 	
	    	    	x.setVisible(false);
	    	    	if(x.opcionDeLogueo ==2)	
	    	    	{	
		    		this.setVisible(false);
	    	    	Inicio ini = new Inicio();
    				ini.cmdadm.setEnabled(false);
    				ini.cmdemple.setEnabled(false);
    				ini.cmdinst.setEnabled(false);
		    	   }
	    	    	else{
		    		this.setVisible(false);
		    		Inicio reg= new Inicio();
	    	    	}
		    	   }
	    	    
	 
	    }


        public static void main (String[] args)
        {
        	Clte x= new Clte();
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
		        }}
	        
	    		
                }




		public void keyPressed(KeyEvent a) {

			
		}	
	}
