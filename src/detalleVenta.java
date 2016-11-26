import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class detalleVenta extends JFrame implements ActionListener
{
	ResultSet resultado;
	
	ImageIcon imalog = new ImageIcon("decorativo.png");
	ImageIcon agregar = new ImageIcon("add.png");
	ImageIcon regresar = new ImageIcon("closed-sign.png");
	ImageIcon eliminar = new ImageIcon("trash.png");
	ImageIcon modificar = new ImageIcon("documents.png");
	ImageIcon limpiar = new ImageIcon("flickr.png");
	ImageIcon ver = new ImageIcon("zoom-in.png");
    JButton cmdmosEmp = new JButton("Empleado",ver);
    JButton cmdregresar = new JButton("Regresar",regresar);
 
    JButton cmdlim = new JButton("Limpiar",limpiar);
    JButton cmdmosCliente = new JButton("Cliente",ver);
    JTextField txtbuscarEmpleado = new JTextField();
    JTextField txtbuscarCliente = new JTextField();
	
    ImageIcon logov = new ImageIcon("logovolteado.png");
    
    String [][] datos ={};
    String [] vector = {"idCliente", "idEmpleado", "fecha", "total_venta", "id_venta"};
    DefaultTableModel obj= new DefaultTableModel(datos,vector);
    
    private JTable  table = new JTable(obj);
    
    
    
    TableColumn columna1 = table.getColumn("idCliente");
    TableColumn columna2 = table.getColumn("idEmpleado");
    TableColumn columna3 = table.getColumn("fecha");
    TableColumn columna4 = table.getColumn("total_venta");
    TableColumn columna5 = table.getColumn("id_venta");
    
    public detalleVenta(){
    	super("Detalle Ventas");
    	this.getContentPane().setBackground(Color.lightGray);
    	setPreferredSize(new java.awt.Dimension(800,480));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new java.awt.Color(221,221,221));
		
    	
    	this.setBounds(0,0,749,480);
    	cmdmosEmp.setBounds(20,237,170,59);
    	cmdregresar.setBounds(20,371,170,59);
    	
    	columna1.setPreferredWidth(100);
		columna2.setPreferredWidth(90);
		columna3.setPreferredWidth(130);
		columna4.setPreferredWidth(70);
		columna5.setPreferredWidth(50);

    	cmdmosCliente.setBounds(20,136,170,59);
    	cmdlim.setBounds(20,307,170,59);
    	txtbuscarEmpleado.setBounds(20,206,170,20);
    	txtbuscarCliente.setBounds(20,105,170,20);
		txtbuscarEmpleado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    	
    	getContentPane().setLayout(null);
    	getContentPane().add(cmdmosEmp);
    	getContentPane().add(cmdregresar);
    	getContentPane().add(cmdlim);
    	getContentPane().add(cmdmosCliente);

    	getContentPane().add(txtbuscarEmpleado);
    	getContentPane().add(txtbuscarCliente);
    	
    	JPanel panel = new JPanel();
        panel.setBounds(200, 98, 467, 332);
        getContentPane().add(panel);
        
        
         panel.add(table);
         
         JLabel lblIdEmpleado = new JLabel("ID Empleado");
         lblIdEmpleado.setBounds(318, 77, 77, 14);
         getContentPane().add(lblIdEmpleado);
         
         JLabel lblIdCliente = new JLabel("ID Cliente");
         lblIdCliente.setBounds(218, 77, 77, 14);
         getContentPane().add(lblIdCliente);
         
         JLabel lblFechaVenta = new JLabel("Fecha Venta");
         lblFechaVenta.setBounds(417, 77, 85, 14);
         getContentPane().add(lblFechaVenta);
         
         JLabel lblTotalVenta = new JLabel("Total Venta");
         lblTotalVenta.setBounds(530, 77, 70, 14);
         getContentPane().add(lblTotalVenta);
         
         JLabel lblIdVenta = new JLabel("ID Venta");
         lblIdVenta.setBounds(612, 77, 70, 14);
         getContentPane().add(lblIdVenta);
    //     barra.setBounds(150,200,500,300);
 	//	 barra.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	
 	//	this.add(barra);
    	cmdmosEmp.addActionListener(this);
    	cmdregresar.addActionListener(this);
    	cmdlim.addActionListener(this);
    	cmdmosCliente.addActionListener(this);

    	this.setVisible(true);
    //	cmdmosEmp.setVisible(true);
    //	cmdregresar.setVisible(true);
    	//cmdlim.setVisible(false);
    	//cmdmosCliente.setVisible(false);
    	//txtbuscarEmpleado.setVisible(false);
    	//scrollmos.setVisible(false);
    	}
    
    
    public void buscarCliente()
    
    {
    	String idCliente= null, idEmpleado = null, fecha = null, totalVenta=null, idVenta=null;
    	ConexionBD con=new ConexionBD(); 
		try {
			int cp=0;
			 Statement st =con.cone();
	  		 String consultaSQL ="SELECT *FROM venta WHERE id_cliente='"+txtbuscarCliente.getText()+"';";
	  		 resultado= st.executeQuery(consultaSQL);
	  		 	while(resultado.next()){
				 idCliente = resultado.getString("id_cliente");
				 idEmpleado = resultado.getString("id_empleado");
				 fecha = resultado.getString("fecha");
				 totalVenta = resultado.getString("total_venta");
				 idVenta = resultado.getString("id_venta");
				// JOptionPane.showMessageDialog(null,"Se encontro la busqueda..!!");  
				 
				 String []modelo= {idVenta,fecha,totalVenta,idCliente,idEmpleado};
				 obj.addRow(modelo);
	 
			}
				
	  		 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
    
    
    public void buscarEmpleado()
    
    {
    	String idCliente= null, idEmpleado = null, fecha = null, totalVenta=null, idVenta=null;
    	ConexionBD con=new ConexionBD(); 
		try {
			int cp=0;
			 Statement st =con.cone();
	  		 String consultaSQL ="SELECT *FROM venta WHERE id_empleado='"+txtbuscarEmpleado.getText()+"';";
	  		 resultado= st.executeQuery(consultaSQL);
	  		 	while(resultado.next()){
				 idCliente = resultado.getString("id_cliente");
				 idEmpleado = resultado.getString("id_empleado");
				 fecha = resultado.getString("fecha");
				 totalVenta = resultado.getString("total_venta");
				 idVenta = resultado.getString("id_venta");
				// JOptionPane.showMessageDialog(null,"Se encontro la busqueda..!!");  
				 
				 String []modelo= {idCliente,idEmpleado,fecha,totalVenta,idVenta};
				 obj.addRow(modelo);
	 
			}
	  		 	

				
	  		 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }

	  public void limpiar(){
		txtbuscarEmpleado.setText("");
		txtbuscarCliente.setText("");
    	
		 for (int i = 0; i < table.getRowCount(); i++) {
	           obj.removeRow(i);
	           i-=1;
	       }

		
    }

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object press = evt.getSource();
		if(press == cmdmosCliente){
				buscarCliente();
		}
			else if (press == cmdmosEmp)
			{
				buscarEmpleado();
			}
			else if(press == cmdlim)
			{
				limpiar();
			}
			else if(press == cmdregresar)
			{
				Vta nvaVenta = new Vta();
			}
	}


	}

			
