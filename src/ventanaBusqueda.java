import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class ventanaBusqueda extends JFrame implements ActionListener{
	
    JTextField txtDato=new JTextField();
    JTextField txtDato2=new JTextField();
    JTextField txtDato3=new JTextField();
    JTextField txtDato4=new JTextField();
    JTextField txtDato5=new JTextField();
    JButton btnBoton1=new JButton("Modificar");
    JButton btnBoton2=new JButton("Regresar");
    private final JLabel lblNewLabel = new JLabel("Marca");
    private final JLabel lblTipo = new JLabel("Tipo");
    private final JLabel lblCosto = new JLabel("Costo");
    private final JLabel lblNombre = new JLabel("Nombre");
    private final JLabel lblIdProducto = new JLabel("id Producto");
    private final JLabel lblNewLabel_1 = new JLabel("Agrega datos al campo a modificar");

	public ventanaBusqueda()
	{
		super("Hola gente");
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		setTitle("Modificar");
		this.setBounds(0,0,309,294);
		
		txtDato.setBounds(111, 50, 137, 20);
		txtDato2.setBounds(111, 77, 137, 20);
		txtDato3.setBounds(111, 108, 137, 20);
		txtDato4.setBounds(111, 139, 137, 20);
		txtDato5.setBounds(109, 170, 139, 20);
		btnBoton1.setBounds(35, 217, 90, 30);
		btnBoton2.setBounds(158, 217, 90, 30);
		getContentPane().add(txtDato);
		getContentPane().add(txtDato2);
		getContentPane().add(txtDato3);
		getContentPane().add(txtDato4);
		getContentPane().add(txtDato5);
		
		getContentPane().add(btnBoton1);
		getContentPane().add(btnBoton2);
		
		getContentPane().setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 48, 70, 20);
		
		getContentPane().add(lblNewLabel);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 77, 70, 17);
		
		getContentPane().add(lblTipo);
		lblCosto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCosto.setBounds(10, 108, 70, 17);
		
		getContentPane().add(lblCosto);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 139, 70, 17);
		
		getContentPane().add(lblNombre);
		lblIdProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdProducto.setBounds(10, 173, 89, 14);
		
		getContentPane().add(lblIdProducto);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 11, 253, 26);
		
		getContentPane().add(lblNewLabel_1);
		btnBoton1.addActionListener(this);
		btnBoton2.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object presionar= evt.getSource();
		if(presionar.equals(btnBoton1))
		{	
		//	Area.append(txtDato.getText()+"\n");
		}
		else if(presionar.equals(btnBoton2))
		{
			this.setVisible(false);
    		Inicio reg= new Inicio();
		}

	}
	
	public static void main(String [] args)
	{
		ventanaBusqueda vent =new ventanaBusqueda();
	}
}


