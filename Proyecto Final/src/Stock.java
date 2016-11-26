import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.io.*;//manipular archivos
import java.text.DecimalFormat;
import javax.swing.*;//graficos
import java.awt.*;//eventos
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
	public class Stock extends JFrame implements ActionListener, MouseListener, KeyListener 
	{
		
		ResultSet resultado, resultado2;
		static String costo, marca, tipo, nombre,id_producto;
			
		//Etiquetas
		JLabel lblidProducto = new JLabel("id_producto:");
		JLabel lblmarca= new JLabel("Marca:");
		JLabel lbltipo = new JLabel("Tipo:");
		JLabel lblcosto = new JLabel("Costo: ");
		JLabel lblnombre= new JLabel("Nombre: ");
		
		JTextField txtidProducto = new JTextField();
		JTextField txtmarca = new JTextField();
		JTextField txtcosto = new JTextField();
		JTextField txtnombre = new JTextField();
		JTextField txttipo = new JTextField();
		
		JTextField txtbuscar = new JTextField("  Busca por ID Aqu\u00ED");	
		JTextField txteliminar = new JTextField("  Elimina por ID Aquí");	

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
		JButton cmdconfirmar = new JButton("Confirmar", null);
        
	   
	    ImageIcon icono = new ImageIcon("usuarioo.png"); //lgo user
	    
	    
	    
	    ImageIcon logo = new ImageIcon("Logochico.png"); //logo adm
	    JLabel imagen_logo = new JLabel("",logo,SwingConstants.RIGHT);
	    String [][] datos ={};
        String [] vector = {"marca", "tipo", "costo", "nombre", "id_producto"};
        DefaultTableModel obj= new DefaultTableModel(datos,vector);
        
        private JTable  table = new JTable(obj);
        TableColumn columna1 = table.getColumn("marca");
        TableColumn columna2 = table.getColumn("tipo");
        TableColumn columna3 = table.getColumn("costo");
        TableColumn columna4 = table.getColumn("nombre");
        TableColumn columna5 = table.getColumn("id_producto");
        private final JLabel lblNewLabel = new JLabel("Marca");
        private final JLabel lblNewLabel_1 = new JLabel("Tipo");
        private final JLabel lblNewLabel_2 = new JLabel("Costo");
        private final JLabel lblNewLabel_3 = new JLabel("Nombre");
        private final JLabel lblNewLabel_4 = new JLabel("id Producto");

	    public Stock() {
	        //posiciones etiquetas
	    	
	        	super("Instrumentos");
	        	this.getContentPane().setBackground(Color.lightGray);
	        	this.setBounds(0,0,850,510);//posicion X y Y, ancho y alto en pixeles ventana principal
	        	int y=120;
	    		imagen_logo.setBounds(539,0,234,78);
	    		lblidProducto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    		
	    		//para redimensionar las columnas
	    		columna1.setPreferredWidth(100);
	    		columna2.setPreferredWidth(130);
	    		columna3.setPreferredWidth(70);
	    		columna4.setPreferredWidth(110);
	    		columna5.setPreferredWidth(50);
	    		
	    		
	    		
	    		// x,y, ancho, alto
	    		lblidProducto.setBounds(10,70,106,19);
	    		lblmarca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    		lblmarca.setBounds(10,126,65,19);
	    		lblcosto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    		lblcosto.setBounds(10,156,78,19);
	        	lbltipo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	        	lbltipo.setBounds(10,186,71,19);
	        	lblnombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	        	lblnombre.setBounds(10, 100, 65, 14);
	        	//lbltipo.setBounds(150,170,180,19);
	        	
	        	txtidProducto.setBounds(112,69,180,19);
	        	txtnombre.setBounds(112,97,180,19);
	        	txtmarca.setBounds(112,126,180,19);
	        	txtcosto.setBounds(112,156,180,19);
	        	txttipo.setBounds(112,186,180,19);//sera ek choice
	        	
	        	
	        	txtbuscar.setBounds(10,226,220,29);
	        	txteliminar.setBounds(10,332,220,29);
	        	
	        	txtbuscar.setForeground(Color.GRAY);
	        	txteliminar.setForeground(Color.GRAY);
	        	
	        	cmdagregar.setBounds(302,317,150,59);
	        	cmdregresar.setBounds(633,382,170,59);
	        	cmdmostrar.setBounds(302,382,150,59);
	        	cmdmodificar.setBounds(462,317,161,59);
	        	cmdlimpiar.setBounds(462,382,161,59);
	        	cmdconfirmar.setBounds(680, 330, 106, 33);
	        	cmdbuscar.setBounds(10,262,150,59);
	        	cmdeliminar.setBounds(10,371,150,59);
	        	
	        
	        	
	        	//agregar al formulario
	        	getContentPane().setLayout(null);
	        	
	        	
	        	//Agregar los objetos
	        	
	        	getContentPane().add(lblidProducto);
	        	getContentPane().add(lblmarca);
	        	getContentPane().add(lblcosto);
	        	getContentPane().add(lbltipo);
	        	getContentPane().add(lblnombre);
	        	getContentPane().add(imagen_logo);
	        	getContentPane().add(txtidProducto);
	        	getContentPane().add(txtmarca);
	        	getContentPane().add(txtcosto);
	        	getContentPane().add(txtbuscar);
	        	getContentPane().add(txttipo);
	        	getContentPane().add(txtnombre);
	        	
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
	            panel.setBounds(305, 98, 481, 205);
	            getContentPane().add(panel);
	            
	             panel.add(table);
	             
	             JScrollPane scrollPane = new JScrollPane();
		            panel.add(scrollPane);
		            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		            lblNewLabel.setBounds(341, 77, 65, 14);
		            
		            getContentPane().add(lblNewLabel);
		            lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		            lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		            lblNewLabel_1.setBounds(443, 77, 46, 14);
		            
		            getContentPane().add(lblNewLabel_1);
		            lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		            lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		            lblNewLabel_2.setBounds(539, 77, 46, 14);
		            
		            getContentPane().add(lblNewLabel_2);
		            lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		            lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		            lblNewLabel_3.setBounds(609, 77, 65, 14);
		            
		            getContentPane().add(lblNewLabel_3);
		            lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		            lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		            lblNewLabel_4.setBounds(684, 77, 99, 14);
		            
		            getContentPane().add(lblNewLabel_4);
		            
		            
		           
	           // scrollPane.add(table);
	            

	            txtbuscar.addKeyListener(this);
	            txtcosto.addKeyListener(this);
	            txtidProducto.addKeyListener(this);
	            txttipo.addKeyListener(this);
	            
	            
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
	            this.setVisible(true);
	
	            
	    
	        	
	        	
	        }
	   
	     
	    
	    
	    public void limpiar(){
	    	txtidProducto.setText("");
	    	txtcosto.setText("");
	    	txtbuscar.setText("");
			txtmarca.setText("");
			txtnombre.setText("");
			 for (int i = 0; i < table.getRowCount(); i++) {
  	           obj.removeRow(i);
  	           i-=1;
  	       }
			
			txtbuscar.setForeground(Color.GRAY);
			
			txtbuscar.setText("  Busca por ID Aquí");
			
			txteliminar.setForeground(Color.GRAY);
			
			txteliminar.setText("  Elimina por ID Aquí");	
			
			txttipo.setText("");
			
			
			
			
	    }
	    
	    public void capturar()
	    {
	    	
	    	if(txtidProducto.getText().isEmpty()||txtmarca.getText().isEmpty()   ||txtcosto.getText().isEmpty() ||txttipo.getText().isEmpty())
	        {
	          JOptionPane.showMessageDialog(null,"No se pueden dejar campos vacios..!!");      
	        
	        }
	        
	      else
	        {
	    	  ConexionBD con=new ConexionBD(); 
				try {
					 Statement st =con.cone();
			  		 String consultaSQL ="INSERT INTO stock (marca,tipo,costo,nombre,id_producto) VALUES('"+txtmarca.getText()+"' , '"+txttipo.getText()+"' , '"+txtcosto.getText()+"' , '"+txtnombre.getText()+"' , '"+txtidProducto.getText()+"')";
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
				  		 String consultaSQL ="SELECT *FROM stock";
				  		 resultado= st.executeQuery(consultaSQL);
				  		 	while(resultado.next()){
							String marca = resultado.getString("marca");
							String tipo = resultado.getString("tipo");
						//	cp= resultado.getInt("cp");
							//String CP = Integer.toString(cp);
							String costo = resultado.getString("costo");
							String nombre = resultado.getString("nombre");
							String id_producto= resultado.getString("id_producto");
							String []modelo= {marca,tipo,costo,nombre,id_producto};
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

		  		 String consultaSQL ="SELECT *FROM stock WHERE id_producto='"+txtbuscar.getText()+"';";
		  		 resultado= st.executeQuery(consultaSQL);
		  		 	while(resultado.next()){
		  		 		String marca = resultado.getString("marca");
						String tipo = resultado.getString("tipo");
					//	cp= resultado.getInt("cp");
						//String CP = Integer.toString(cp);
						String costo = resultado.getString("costo");
						String nombre = resultado.getString("nombre");
						String id_producto= resultado.getString("id_producto");
						String []modelo= {marca,tipo,costo,nombre,id_producto};
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
					 
			  		 String consultaSQL ="DELETE FROM stock WHERE id_producto='"+txteliminar.getText()+"';";
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
			 String idModificar = JOptionPane.showInputDialog("Ingresa el id del producto a modificar: ");
			 if(idModificar != null)
			 {
				cmdbuscar.setEnabled(false);
				cmdeliminar.setEnabled(false);
 				cmdagregar.setEnabled(false);
 				cmdmostrar.setEnabled(false);
				cmdregresar.setEnabled(false);
				txtidProducto.setEditable(false);
		  		 	 
			 }
			 ConexionBD con=new ConexionBD(); 
				try {
					int cp=0;
					 Statement st =con.cone();
					 Statement st2 =con.cone();
			  		 String consultaSQL ="SELECT *FROM stock WHERE id_producto='"+idModificar+"';";
			  		 resultado= st.executeQuery(consultaSQL);
			  		 	while(resultado.next()){
			  		 		marca = resultado.getString("marca");
							 tipo = resultado.getString("tipo");
						//	cp= resultado.getInt("cp");
							//String CP = Integer.toString(cp);
							 costo = resultado.getString("costo");
							 nombre = resultado.getString("nombre");
							 id_producto= resultado.getString("id_producto");
							 txtidProducto.setText(id_producto);
								txtnombre.setText(nombre);
								txtmarca.setText(marca);
								txtcosto.setText(costo);
								txttipo.setText(tipo);
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
				txtidProducto.setEditable(true);
		    	  ConexionBD con=new ConexionBD(); 
					try {
						 Statement st =con.cone();
						// String consultaSQL ="UPDATE stock SET marca='"+txtmarca.getText()+"',tipo='"+txttipo.getText()+"',costo='"+txtcosto.getText()+"',nombre='"+txtnombre.getText()+"' WHERE marca='"+marca+"',tipo='"+tipo+"',costo='"+costo+"',nombre='"+nombre+"';";
						// String consultaSQL= "UPDATE stock SET nombre='"+txtnombre.getText()+"', marca='"+txtmarca.getText()+"' WHERE nombre='"+nombre+"', marca='"+marca+"';";
						 String consultaSQL= "UPDATE stock SET marca='"+txtmarca.getText()+"' WHERE marca='"+marca+"';";
						 String consultaSQL2= "UPDATE stock SET tipo='"+txttipo.getText()+"' WHERE tipo='"+tipo+"';";
						 String consultaSQL3= "UPDATE stock SET costo='"+txtcosto.getText()+"' WHERE costo='"+costo+"';";
						 String consultaSQL4= "UPDATE stock SET nombre='"+txtnombre.getText()+"' WHERE nombre='"+nombre+"';";
						
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
	    	
	    		if(presionado==cmdmostrar){
	    		mostrar();	
	    		}
	    		else
	    	    if(presionado==cmdlimpiar){
	    			limpiar();
	    		}
	    	    if(presionado==cmdbuscar){
	    		buscar();
	    	   }
	    	    if(presionado==cmdeliminar){
	    	    	int i=JOptionPane.showConfirmDialog(null,"¿Seguro que deseas eliminar?");
			   		if(i==(JOptionPane.YES_OPTION)){ 
	    	    	eliminar();  		
				   	limpiar();
			   		}
	    	    }
	    	    if(presionado==cmdmodificar){
		    		modificar();
		    	   }
	    	    if(presionado==cmdconfirmar){
	    	    	int i=JOptionPane.showConfirmDialog(null,"¿Seguro que deseas modificar?");
			   		if(i==(JOptionPane.YES_OPTION)){ 
	    	    	confirmar();
			   		}
		    	   }
	    	    if(presionado==cmdregresar){
		    		this.setVisible(false);
		    		Inicio reg= new Inicio();
		    	   }
	    	    
	 
	    }


        public static void main (String[] args)
        {
        	Stock x= new Stock();
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

	        
	        
	        
	       
	    		
                }




		public void keyPressed(KeyEvent a) {

			
		}	
	}
		
    	