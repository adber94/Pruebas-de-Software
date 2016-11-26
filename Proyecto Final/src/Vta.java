import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
public class Vta extends JFrame implements ActionListener, KeyListener

{
	private static String user, idProd,idCliente,idEmpleado,fecha,idVenta,totalVta;
	static float tot ;
	float costoCovertido;
	ResultSet resultado, resultado3, resul;
	String gen,nom,gene,mostrar,most,nombre;
	int opc,cont,y,can;
	double costo,sum,cos,sum2;
	ImageIcon ok = new ImageIcon("success.png");
	ImageIcon imalog = new ImageIcon("musica.jpg");
	
	ImageIcon agregar = new ImageIcon("add-to-cart.png");
	ImageIcon cancelar = new ImageIcon("x.png");
	ImageIcon total = new ImageIcon("money-bills.png");
	ImageIcon regresar = new ImageIcon("flickr.png");
    
    JButton cmdcar = new JButton("AGREGAR CARRITO",agregar);
    JButton cmddetallesventa = new JButton("DETALLE VENTAS",cancelar);
    JButton cmdtot = new JButton("TOTAL",total);
    JButton cmdret = new JButton("REGRESAR",regresar);
    JButton cmdverActuales = new JButton("ver Actuales");
    JLabel lbnom = new JLabel("NickName de Cliente");
    JLabel lbgen = new JLabel("ID del producto");
    JLabel lblidempleado = new JLabel("ID de Empleado");
    
    JTextArea Area=new JTextArea();
    
    String [][] datos ={};
    String [] vector = {"id Producto", "nombre", "costo"};
    DefaultTableModel obj= new DefaultTableModel(datos,vector);
    
    String [][] info ={};
    String [] vec = {"Nombre", "id Producto", "id Cliente", "id Empleado", "fecha", "total", "id Venta"};
    DefaultTableModel obj2= new DefaultTableModel(info,vec);
    String fechaAct;
    
    JTextField txtidEmple = new JTextField(user);

    private JTextField txtFechayHora;
    private final JTextField txtidVta = new JTextField();
    private JTextField txtidProducto;
    private JTextField txtidCliente;
    private final JLabel lblResumenVta = new JLabel("Resumen de la venta");
    
    private JTable  table = new JTable(obj);
    private JTable  tabla = new JTable(obj2);
    
    TableColumn columna1 = table.getColumn("id Producto");
    TableColumn columna2 = table.getColumn("nombre");
    TableColumn columna3 = table.getColumn("costo");
    
    TableColumn column0 = tabla.getColumn("Nombre");
    TableColumn column1 = tabla.getColumn("id Producto");
    TableColumn column2 = tabla.getColumn("id Cliente");
    TableColumn column3 = tabla.getColumn("id Empleado");
    TableColumn column4 = tabla.getColumn("fecha");
    TableColumn column5 = tabla.getColumn("total");
    TableColumn column6 = tabla.getColumn("id Venta");
    private final JLabel lblIdCliente = new JLabel("id Cliente");
    
    Calendar date = new GregorianCalendar();
    
    public Vta() {
    	super("VENTA");
  
    	this.getContentPane().setBackground(Color.lightGray);
    	this.setBounds(0,0,1014,478);
    	
    	
    	int año = date.get(Calendar.YEAR);
        int mes = date.get(Calendar.MONTH);
        int dia = date.get(Calendar.DAY_OF_MONTH);
        int hora = date.get(Calendar.HOUR_OF_DAY);
        int minuto = date.get(Calendar.MINUTE);
        int segundo = date.get(Calendar.SECOND);
    	
    	columna1.setPreferredWidth(150);
		columna2.setPreferredWidth(100);
		columna3.setPreferredWidth(100);
		
		column0.setPreferredWidth(100);
		column1.setPreferredWidth(60);
		column2.setPreferredWidth(100);
		column3.setPreferredWidth(70);
		column4.setPreferredWidth(100);
		column5.setPreferredWidth(70);
		column6.setPreferredWidth(30);
    	
    	//this.setBounds(0,0,651,561);
    	lbgen.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	Area.setBounds(734, 277, 248, 78);
    	getContentPane().add(Area);
    	
    	lbgen.setBounds(30,105,100,27);
    	lbnom.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	lbnom.setBounds(146,132,139,20);
    	lblidempleado.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	lblidempleado.setBounds(146,163,100,20);
    	txtidEmple.setBounds(282,164,133,20);
    	
    	cmdcar.setBounds(30,366,255,59);
    	cmdverActuales.setBounds(30,164,106,36);
    	cmddetallesventa.setBounds(684,366,216,59);
    	
    	cmdtot.setBounds(295,366,170,59);
    	cmdret.setBounds(492,366,170,59);
        txtidEmple.setEditable(false);
    	txtidEmple.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    	
    	getContentPane().setLayout(null);
    	getContentPane().add(cmdcar);
    	getContentPane().add(cmdverActuales);
    	getContentPane().add(cmdtot);
    	getContentPane().add(cmddetallesventa);
    	getContentPane().add(cmdret);
    	getContentPane().add(lbnom);
    	getContentPane().add(lblidempleado);
    	getContentPane().add(lbgen);
    	getContentPane().add(txtidEmple);
    	
    	JPanel panel2 = new JPanel();
        panel2.setBounds(30, 234, 366, 112);
        getContentPane().add(panel2);
        
        JPanel panel3 = new JPanel();
        panel3.setBounds(428, 135, 554, 126);
        getContentPane().add(panel3);
        
        JScrollPane scrollPane2 = new JScrollPane();
        panel2.add(scrollPane2);
        
        JScrollPane scrollPane3 = new JScrollPane();
        panel3.add(scrollPane3);
        ///////////////////////////////////////////////////////
        
        
        panel3.add(tabla);
        panel2.add(table);
     /*   nvaPrueba con=new nvaPrueba(); 
		try {
			 Statement st =con.cone();
	  		 String consultaSQL ="SELECT *FROM venta";
	  		    resultado= st.executeQuery(consultaSQL);
	  		 	while(resultado.next()){
	  		 		fecha = resultado.getString("fecha");
			}
	  		 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 */
        String hr = ":"+hora+":"+minuto+":"+segundo;
        fechaAct = " "+dia + "/" + (mes+1) + "/" + año;
    	
    	txtFechayHora = new JTextField("Fecha: "+fechaAct+"       Hora Actual "+hr);
    	
    	/*System.out.println("Fecha Actual: "
                + dia + "/" + (mes+1) + "/" + año);*/
/*System.out.printf("Hora Actual: %02d:%02d:%02d %n",
                                   hora, minuto, segundo);*/
    	
    	
    	txtFechayHora.setForeground(Color.BLACK);
    	txtFechayHora.setColumns(10);
    	txtFechayHora.setBackground(new Color(211, 211, 211));
    	txtFechayHora.setBounds(671, 64, 260, 27);
    	txtFechayHora.setEditable(false);
    	getContentPane().add(txtFechayHora);
    	txtidVta.setHorizontalAlignment(SwingConstants.CENTER);
    	txtidVta.setForeground(new Color(0, 0, 0));
    	txtidVta.setColumns(10);
    	txtidVta.setBackground(new Color(211, 211, 211));
    	txtidVta.setBounds(115, 26, 100, 27);
    	
    	getContentPane().add(txtidVta);
    	//txtidVta.setEditable(false);
    	txtidProducto = new JTextField();
    	txtidProducto.setBounds(30, 136, 106, 20);
    	getContentPane().add(txtidProducto);
    	txtidProducto.setColumns(10);
    	
    	txtidCliente = new JTextField();
    	txtidCliente.setBounds(282, 133, 133, 20);
    	getContentPane().add(txtidCliente);
    	txtidCliente.setColumns(10);
    	
    	JLabel lblfechayhora = new JLabel("Fecha y Hora Actual");
    	lblfechayhora.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	lblfechayhora.setBounds(671, 26, 144, 27);
    	getContentPane().add(lblfechayhora);
    	
    	JLabel lblIdDeVenta = new JLabel("ID de Venta");
    	lblIdDeVenta.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	lblIdDeVenta.setBounds(20, 17, 82, 42);
    	getContentPane().add(lblIdDeVenta);
    	lblResumenVta.setFont(new Font("Times New Roman", Font.BOLD, 17));
    	lblResumenVta.setBounds(428, 79, 152, 31);
    	
    	getContentPane().add(lblResumenVta);
    	
    	JLabel lblCodigo = new JLabel("Codigo");
    	lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
    	lblCodigo.setVerticalAlignment(SwingConstants.TOP);
    	lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	lblCodigo.setBounds(314, 213, 100, 17);
    	getContentPane().add(lblCodigo);
    	
    	JLabel lblNombreProducto = new JLabel("Nombre Producto");
    	lblNombreProducto.setVerticalAlignment(SwingConstants.TOP);
    	lblNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNombreProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	lblNombreProducto.setBounds(33, 213, 142, 17);
    	getContentPane().add(lblNombreProducto);
    	
    	JLabel lblNewLabel = new JLabel("idProducto");
    	lblNewLabel.setBounds(549, 112, 82, 14);
    	getContentPane().add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("Id Venta");
    	lblNewLabel_1.setBounds(942, 112, 46, 14);
    	getContentPane().add(lblNewLabel_1);
    	
    	JLabel lblFechaVenta = new JLabel("Fecha Venta");
    	lblFechaVenta.setBounds(789, 112, 81, 14);
    	getContentPane().add(lblFechaVenta);
    	lblIdCliente.setBounds(641, 112, 60, 14);
    	
    	getContentPane().add(lblIdCliente);
    	
    	JLabel lblIdEmpleado = new JLabel("id Empleado");
    	lblIdEmpleado.setBounds(711, 112, 82, 14);
    	getContentPane().add(lblIdEmpleado);
    	
    	JLabel lblSubTotalVenta = new JLabel("Subtotal");
    	lblSubTotalVenta.setBounds(871, 112, 60, 14);
    	getContentPane().add(lblSubTotalVenta);
    	
    	JLabel lblCosto = new JLabel("Costo");
    	lblCosto.setVerticalAlignment(SwingConstants.TOP);
    	lblCosto.setHorizontalAlignment(SwingConstants.CENTER);
    	lblCosto.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	lblCosto.setBounds(173, 213, 100, 17);
    	getContentPane().add(lblCosto);
    	
    	JLabel lblNombre = new JLabel("Nombre");
    	lblNombre.setBounds(472, 112, 51, 14);
    	getContentPane().add(lblNombre);
    	
    	txtidEmple.addKeyListener(this);
    	
    	cmdcar.addActionListener(this);
    	cmdverActuales.addActionListener(this);
    	cmddetallesventa.addActionListener(this);
    	cmdret.addActionListener(this);
    	cmdtot.addActionListener(this);
    	this.setVisible(true);
    }
    
    public void limpiar(){
	    
	       for (int i = 0; i < table.getRowCount(); i++) {
	           obj.removeRow(i);
	           i-=1;
	       }
    }
    

    public String agregarCarrito()
    {
    	String costo = null;
    	
    	ConexionBD con=new ConexionBD(); 
		try {
			 Statement st =con.cone();
			 String idProd = txtidProducto.getText();
			 String consultaBuscar ="SELECT *FROM stock WHERE id_producto='"+idProd+"';";
			 resultado= st.executeQuery(consultaBuscar);
	  		 	while(resultado.next()){
				costo = resultado.getString("costo");
				 JOptionPane.showMessageDialog(null,"Producto Agregado..!!");   
				 txtidCliente.setEditable(false);
				 
				 
			} 
		//	 String consultaSQL ="INSERT INTO venta (id_producto,id_cliente,id_empleado, id_venta) VALUES('"+txtidProducto.getText()+"' , '"+txtidCliente.getText()+"' , '"+txtidEmple.getText()+"' , '"+txtidVta.getText()+"')";st.executeUpdate(consultaSQL);
	  	//	 st.close();
	  		// JOptionPane.showMessageDialog(null,"El registro se inserto de manera correcta..!!");   
	  		 	
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null,"Hubo un error en la insercion..!!");   
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return costo;
    }
    
    
    public void insertarVenta (float total)
    {
    	float totalVenta = 0;
    	ConexionBD con=new ConexionBD(); 
		try {
			 Statement st =con.cone();
			// String consultaSQL ="INSERT INTO venta (id_cliente,id_empleado, id_venta,id_producto) VALUES('"+txtidCliente.getText()+"' , '"+txtidEmple.getText()+"' , '"+txtidVta.getText()+"' , '"+txtidProducto.getText()+"')";
			 String consultaSQL ="INSERT INTO venta (id_cliente, id_empleado, total_venta, id_venta, fecha) VALUES('"+txtidCliente.getText()+"' , '"+txtidEmple.getText()+"' , '"+total+"' , '"+txtidVta.getText()+"' , '"+"now()"+"')";
			 st.executeUpdate(consultaSQL);
	  		
	  		 JOptionPane.showMessageDialog(null,"Se cerro la venta..!!"); 
	  		 
	  		try {
	  			 
				 String consultaBuscar ="SELECT *FROM venta WHERE id_venta='"+txtidVta.getText()+"';";
				 resultado= st.executeQuery(consultaBuscar);
		  		 	while(resultado.next()){
		  		 	idCliente = resultado.getString("id_cliente");
		  		 	idEmpleado= resultado.getString("id_empleado");
		  		 	totalVenta = total;
					idVenta = resultado.getString("id_venta");
					fecha = resultado.getString("fecha");
				}
	  		 
	  		 Area.append("Gracias por tu compra: "+idCliente+"\nTe Atendio: "+idEmpleado+"\nTotal de la Venta: "+totalVenta+"\nId de la Venta: "+idVenta);
	  		txtidCliente.setEditable(true);
	  		} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null,"Error..!!");   
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  		 st.close();
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null,"Hubo un error en la insercion..!!");   
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
   
   /* public void eliminar(String id)
	   {
		 nvaPrueba con=new nvaPrueba(); 
			try {
				 Statement st =con.cone();
				 
		  		 String consultaSQL ="DELETE FROM stock WHERE id_producto='"+id+"';";
		  		 st.executeUpdate(consultaSQL);
		  		 st.close(); 	
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null,"Hubo un error en la eliminacion..!!");   
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	
		
	   }*/
    
    public String [] verActuales(){
	       //double costo=0;
	       int id_prod;
	       String nombre = null, ID = null,costo = null;
	    	limpiar();
    
	  		  ConexionBD con=new ConexionBD(); 
				try {
					 Statement st =con.cone();
			  		 String consultaSQL ="SELECT *FROM stock";
			  		 resultado= st.executeQuery(consultaSQL);
			  		 	while(resultado.next()){
						//String marca = resultado.getString("marca");
					//	String tipo = resultado.getString("tipo");
						costo = resultado.getString("costo");
					//	String COSTO = Double.toString(costo);
						nombre = resultado.getString("nombre");
						id_prod= resultado.getInt("id_producto");
						ID= Integer.toString(id_prod);
						String []modelo= {nombre, costo,  ID};
						obj.addRow(modelo);
						
						
					}
			  		 	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] modelo = {nombre, costo,  ID};
				return modelo;
	    }
    
    public void actionPerformed(ActionEvent evt){
    	Object press = evt.getSource();
    	
    	
		if(press == cmdret){
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
			}else if(press == cmdverActuales)
			{
				verActuales();
			}
			else if (press == cmdcar) {
				if(txtidVta.getText().isEmpty()||txtidProducto.getText().isEmpty()   ||txtidCliente.getText().isEmpty())
		        {
		    		JOptionPane.showMessageDialog(null,"Dejaste algun campo requerido vacio..!!");   
		        }
				else{
			//	agregarCarrito();
				String nombre = null;
				String resultado =agregarCarrito();
				float resCovertido = Float.parseFloat(resultado);
			    tot = tot + resCovertido;
			    
			    ConexionBD con=new ConexionBD(); 
				try {
					int cp=0;
					 Statement st =con.cone();

			  		 String consultaSQL ="SELECT *FROM stock WHERE id_producto='"+txtidProducto.getText()+"';";
			  		 resul= st.executeQuery(consultaSQL);
			  		 	while(resul.next()){
							nombre = resul.getString("nombre");	
					}
			  		 	
			  		 	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    
				//String resu[]=	verActuales();
				//String nombre = resu[0];
			    String []modelo= { nombre, txtidProducto.getText(), txtidCliente.getText(), txtidEmple.getText(), fechaAct, Float.toString(tot),txtidVta.getText() };
				obj2.addRow(modelo);
			  //  System.out.println(tot);
				}
				
				txtidProducto.setText("");
			}
			else if (press == cmdtot)
			{
				insertarVenta(tot);
				cmdcar.setEnabled(false);
			}
			else if (press == cmddetallesventa)
			{
				detalleVenta detalle = new detalleVenta();
				this.setVisible(false);
			}
    }

    
	public void keyReleased(KeyEvent y) {
		
	}




	public void keyTyped(KeyEvent evento) {
		
      Object tecla = new Object();
		
        tecla = evento.getSource();
      
        
       
        if(tecla==txtidEmple)
        {
      	    char c = evento.getKeyChar();
    				   
    				  if(!Character.isDigit(c))
    				  {
    					 getToolkit().beep();
    					  evento.consume();}
        }
        
    
       
    		
            }




	public void keyPressed(KeyEvent a) {

		
	}

	public static void enviarInfo(String usuario) {
		user = usuario;
	}	
}