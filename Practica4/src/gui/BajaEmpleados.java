package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import operaciones.Empleado;
import operaciones.Procesos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaEmpleados extends JFrame implements ActionListener {
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JLabel lblTituloII;
	private JLabel lblTitulo;
	private JTextField txtDni;
	private JLabel lblMensaje;
	private JButton btnEliminarEmpleado;
	
	//Instancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos

	//Definici�n de constructores
	public BajaEmpleados() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Comentamos esta opci�n para que el programa no finalice al cerrar esta ventana
		setBounds(100, 100, 700, 300);
		setTitle("BAJA DE EMPLEADOS"); //Colocamos el t�tulo a nuestra ventana
		setLocationRelativeTo(null); //Este modificador nos coloca la ventana en el centro de la pantalla
		setResizable(false); //Este modificador hace que no se pueda cambiar el tama�o de la ventana
		iniciarComponentes();
	}

	//Definici�n de m�todos
	public void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTituloII = new JLabel("BAJA DE EMPLEADOS");
		lblTituloII.setForeground(Color.WHITE);
		lblTituloII.setFont(new Font("Arial", Font.BOLD, 12));
		lblTituloII.setBounds(523, 60, 161, 20);
		contentPane.add(lblTituloII);
		
		lblTitulo = new JLabel("GUILLERMO SYSTEMS");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setBounds(0, 0, 684, 80);
		contentPane.add(lblTitulo);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(430, 120, 100, 20);
		contentPane.add(txtDni);
		
		lblMensaje = new JLabel("Introduzca el DNI del empleado que desea eliminar:");
		lblMensaje.setForeground(Color.BLACK);
		lblMensaje.setFont(new Font("Arial", Font.BOLD, 12));
		lblMensaje.setBounds(70, 120, 350, 20);
		contentPane.add(lblMensaje);
		
		btnEliminarEmpleado = new JButton("ELIMINAR EMPLEADO");
		btnEliminarEmpleado.setFont(new Font("Arial", Font.BOLD, 14));
		btnEliminarEmpleado.setBackground(SystemColor.window);
		btnEliminarEmpleado.setBounds(200, 180, 240, 30);
		btnEliminarEmpleado.addActionListener(this);
		contentPane.add(btnEliminarEmpleado);
	}
	
	public void asignarProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}

	public void actionPerformed(ActionEvent e) {
		//Declaraci�n de variables locales
		Empleado empleadoTemp = misProcesos.buscarEmpleado(txtDni.getText());
		
		if(empleadoTemp != null && validarCampos() && misProcesos.comprobarCadenaDni(txtDni.getText())) {
			bajaEmpleado(empleadoTemp);
			limpiarCampos();
		}else {
			limpiarCampos();
		}
	}

	private boolean validarCampos() {
		if(txtDni.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar rellenos", "ERROR" , JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}

	private void bajaEmpleado(Empleado empleado) {
		misProcesos.eliminarEmpleado(empleado);
	}

	private void limpiarCampos() {
		txtDni.setText("");
	}
}
