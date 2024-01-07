package gui;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AltaEmpleados extends JFrame implements ActionListener {
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private static JTextField txtDni;
	private JTextField txtFechaNac;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JLabel lblFechaDeNacimiento;
	private JButton btnRegistrarEmpleado;
	private JLabel lblTituloII;
	private JLabel lblTitulo;
	
	//Instancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos

	//Definici�n de constructores
	public AltaEmpleados() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Comentamos esta opci�n para que el programa no finalice al cerrar esta ventana
		setBounds(100, 100, 700, 500);
		setTitle("ALTA DE EMPLEADOS"); //Colocamos el t�tulo a nuestra ventana
		setLocationRelativeTo(null); //Este modificador nos coloca la ventana en el centro de la pantalla
		setResizable(false); //Este modificador hace que no se pueda cambiar el tama�o de la ventana
		iniciarComponentes();
	}
	
	//Definici�n de getters y setters
	public static void setTxtDni(String dni) {
		txtDni.setText(dni);
	}

	//Definici�n de m�todos
	public void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTituloII = new JLabel("ALTA DE EMPLEADOS");
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
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(20, 100, 70, 20);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(100, 100, 120, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 12));
		lblApellidos.setBounds(253, 100, 70, 20);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(333, 100, 250, 20);
		contentPane.add(txtApellidos);
		
		lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Arial", Font.BOLD, 12));
		lblDireccion.setBounds(20, 200, 70, 20);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(100, 200, 300, 20);
		contentPane.add(txtDireccion);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(253, 250, 70, 20);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(333, 250, 250, 20);
		contentPane.add(txtEmail);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		lblTelefono.setBounds(20, 250, 70, 20);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(100, 250, 100, 20);
		contentPane.add(txtTelefono);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Arial", Font.BOLD, 12));
		lblDni.setBounds(20, 150, 70, 20);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(100, 150, 100, 20);
		contentPane.add(txtDni);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 12));
		lblFechaDeNacimiento.setBounds(253, 150, 130, 20);
		contentPane.add(lblFechaDeNacimiento);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setColumns(10);
		txtFechaNac.setBounds(403, 150, 100, 20);
		contentPane.add(txtFechaNac);
		
		btnRegistrarEmpleado = new JButton("REGISTRAR EMPLEADO");
		btnRegistrarEmpleado.setFont(new Font("Arial", Font.BOLD, 14));
		btnRegistrarEmpleado.setBackground(SystemColor.window);
		btnRegistrarEmpleado.setBounds(235, 300, 240, 30);
		btnRegistrarEmpleado.addActionListener(this);
		contentPane.add(btnRegistrarEmpleado);
	}

	//Definici�n de m�todos
	public void asignarProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(validarCampos()== true) {
			if(misProcesos.comprobarCadenaDni(txtDni.getText()) && misProcesos.comprobarCadenaFecha(txtFechaNac.getText()) && misProcesos.comprobarCadenaTlf(txtTelefono.getText())) {
				registroEmpleado();
			}
		}
	}

	private void registroEmpleado() {
		try {
			Empleado empleado = new Empleado(txtDni.getText());
			empleado.setNombre(txtNombre.getText());
			empleado.setApellidos(txtApellidos.getText());
			empleado.setfNacimiento(txtFechaNac.getText());
			empleado.setDireccion(txtDireccion.getText());
			empleado.setTelefono(Integer.parseInt(txtTelefono.getText()));
			empleado.setEmail(txtEmail.getText());
			
			if(misProcesos.comprobarDni(txtDni.getText())) {
				misProcesos.registrarEmpleado(empleado);
				JOptionPane.showMessageDialog(null, "Empleado registrado con �xito", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
				limpiarCampos(); //Limpiamos todos los campos del formulario
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error de ingreso de texto", "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error", "ERROR" , JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean validarCampos() {
		if(txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtDni.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtFechaNac.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar rellenos", "ERROR" , JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}
	
	private void limpiarCampos() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtFechaNac.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
	}
}
