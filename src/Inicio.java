import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Inicio extends JFrame implements ActionListener{
	ImageIcon imalog = new ImageIcon("Logoo.png");
	
	
	ImageIcon instrumento = new ImageIcon("instrumentoo.png");
	ImageIcon administrador = new ImageIcon("admini.png");
	ImageIcon empleado = new ImageIcon("emplea.png");
	ImageIcon cliente = new ImageIcon("usuarioo.png");
	ImageIcon venta = new ImageIcon("ventass.png");
	ImageIcon salir = new ImageIcon("salirr.png");
	
	
	JButton cmdinst = new JButton("Instrumentos",instrumento);
	JButton cmdadm = new JButton("Administrador",administrador);
	JButton cmdemple = new JButton("Empleados",empleado);
	JButton cmdcliente = new JButton("Clientes",cliente);
	JButton cmdvent = new JButton("Venta",venta);
	JButton cmdsal = new JButton("Salir",salir);
	
	JLabel lblogo = new JLabel(imalog);
	
	public Inicio(){
		super("Instrumentos");
		this.getContentPane().setBackground(Color.lightGray);
		setPreferredSize(new java.awt.Dimension(640,480));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new java.awt.Color(221,221,221));
		pack();
		
		this.setBounds(0,0,550,550);
		cmdadm.setBounds(40,200,200,79);
		cmdcliente.setBounds(300,200,200,79);
		cmdemple.setBounds(40,300,200,79);
		cmdinst.setBounds(300,300,200,79);
		cmdvent.setBounds(40,400,200,79);
		cmdsal.setBounds(300,400,200,79);
		
		lblogo.setBounds(65,0,500,200);
		
		setLayout(null);
		this.add(cmdinst);
		this.add(cmdvent);
		this.add(cmdsal);
		this.add(lblogo);
		this.add(cmdadm);
		this.add(cmdcliente);
		this.add(cmdemple);
		
		
		cmdinst.addActionListener(this);
		cmdvent.addActionListener(this);
		cmdsal.addActionListener(this);
		cmdadm.addActionListener(this);
		cmdcliente.addActionListener(this);
		cmdemple.addActionListener(this);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		lblogo.setVisible(true);
		this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent evt){
		Object press = evt.getSource();
		if(press == cmdadm){
		    Admin nuevo = new Admin();
			nuevo.capturar();
			this.dispose();
			}
		if(press == cmdcliente){
		    Clte nuevo = new Clte();
			nuevo.capturar();
			this.dispose();
			}
		if(press == cmdemple){
		    Emple nuevo = new Emple();
			nuevo.capturar();
			this.dispose();
			}
		if(press == cmdinst){
			Stock ins = new Stock();
			this.dispose();
			}
			
			if(press == cmdvent){
				
				Login x = new Login(); 	
		    	x.setVisible(false);
		    	if(x.opcionDeLogueo ==1)	
		    	{
		    		Buscar_paraVenta venta= new Buscar_paraVenta();
		    	}
				else
				{
					
					Vta nvaVenta = new Vta();
					
					this.dispose();
				}
				
				
				this.dispose();
				
				}
				
				if(press == cmdsal){

					int seleccion = JOptionPane.showOptionDialog( null,"Seleccione una opcion",
					  "Selecciona la opcion",JOptionPane.YES_NO_CANCEL_OPTION,
					   JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
					  new Object[] { "Login Administrador", "Salir" },"opcion 1");
					 
					 if(seleccion + 1 == 1)
					 {
						 Login x = new Login();
						 this.dispose();

					 }
					 else if (seleccion + 1 == 2)
					 {
						 int i=JOptionPane.showConfirmDialog(null,"¿Seguro que deseas salir?");
					   		if(i==(JOptionPane.YES_OPTION)){
					          this.setVisible(false);
					          System.exit(0);		
					   		}
					   		else
					   			this.setVisible(true);
							}
					 }

					
		}
		
		public static void main(String[] args){
			Inicio ini = new Inicio();
			}
}