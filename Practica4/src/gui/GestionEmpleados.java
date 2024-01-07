package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import operaciones.Procesos;

public class GestionEmpleados extends JFrame implements ActionListener{
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JButton btnAltaEmpleado;
	private JButton btnBajaEmpleado;
	private JButton btnConsulta;
	private JLabel lblTituloII;
	
	//Instancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos

	//Definici�n de constructores
	public GestionEmpleados() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Comentamos esta opci�n para que el programa no finalice al cerrar esta ventana
		setBounds(100, 100, 700, 500);
		setTitle("GESTI�N DE EMPLEADOS"); //Colocamos el t�tulo a nuestra ventana
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
		
		lblTituloII = new JLabel("GESTI\u00D3N DE EMPLEADOS");
		lblTituloII.setForeground(Color.WHITE);
		lblTituloII.setFont(new Font("Arial", Font.BOLD, 12));
		lblTituloII.setBounds(523, 60, 161, 20);
		contentPane.add(lblTituloII);
		
		lblTitulo = new JLabel("GUILLERMO SYSTEMS");
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setOpaque(true); //Este modificador hace visible el color de fondo de la etiqueta
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(0, 0, 684, 80);
		contentPane.add(lblTitulo);
		
		btnAltaEmpleado = new JButton("ALTA EMPLEADO");
		btnAltaEmpleado.setBackground(SystemColor.window);
		btnAltaEmpleado.setFont(new Font("Arial", Font.BOLD, 16));
		btnAltaEmpleado.setBounds(90, 100, 500, 70);
		btnAltaEmpleado.addActionListener(this);
		contentPane.add(btnAltaEmpleado);
		
		btnBajaEmpleado = new JButton("BAJA EMPLEADO");
		btnBajaEmpleado.setBackground(SystemColor.window);
		btnBajaEmpleado.setFont(new Font("Arial", Font.BOLD, 16));
		btnBajaEmpleado.setBounds(90, 200, 500, 70);
		btnBajaEmpleado.addActionListener(this);
		contentPane.add(btnBajaEmpleado);
		
		btnConsulta = new JButton("CONSULTAR EMPLEADO");
		btnConsulta.setBackground(SystemColor.window);
		btnConsulta.setFont(new Font("Arial", Font.BOLD, 16));
		btnConsulta.setBounds(90, 300, 500, 70);
		btnConsulta.addActionListener(this);
		contentPane.add(btnConsulta);
	}

	//Definici�n de m�todos
	public void asignarProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAltaEmpleado) {
			AltaEmpleados miVentanaAltaEmpleados = new AltaEmpleados();
			miVentanaAltaEmpleados.asignarProcesos(misProcesos);
			miVentanaAltaEmpleados.setVisible(true);
			
		}else if(e.getSource() == btnBajaEmpleado) {
			BajaEmpleados miVentanaBajaEmpleados = new BajaEmpleados();
			miVentanaBajaEmpleados.asignarProcesos(misProcesos);
			miVentanaBajaEmpleados.setVisible(true);
			
		}else if(e.getSource() == btnConsulta) {
			InfoEmpleados miVentanaInfoEmpleados = new InfoEmpleados();
			miVentanaInfoEmpleados.asignarProcesos(misProcesos);
			miVentanaInfoEmpleados.setVisible(true);
		}
		
	}
}
