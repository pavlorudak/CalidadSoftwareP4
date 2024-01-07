package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import operaciones.Contrato;
import operaciones.Empleado;
import operaciones.Procesos;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class InfoEmpleados extends JFrame implements ActionListener{
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JLabel lblTituloII;
	private JLabel lblTitulo;
	private JLabel lblMensaje;
	private JTextField txtDni;
	private JButton btnConsultarEmpleado;
	private JScrollPane scrollPane;
	private JTextArea txtDatosEmpleado;
	private JTable table;
	private JTable tablaContratos;
	private DefaultTableModel model;
	private JButton btnConsultarTurnos;
	
	//Instancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos
	Empleado miEmpleado;

	//Definici�n de constructores
	public InfoEmpleados() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Comentamos esta opci�n para que el programa no finalice al cerrar esta ventana
		setBounds(100, 100, 700, 500);
		setTitle("INFORMACI�N"); //Colocamos el t�tulo a nuestra ventana
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
		
		lblTituloII = new JLabel("INFORMACI�N DEL EMPLEADO");
		lblTituloII.setForeground(Color.WHITE);
		lblTituloII.setFont(new Font("Arial", Font.BOLD, 12));
		lblTituloII.setBounds(480, 60, 200, 20);
		contentPane.add(lblTituloII);
		
		lblTitulo = new JLabel("GUILLERMO SYSTEMS");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setBounds(0, 0, 684, 80);
		contentPane.add(lblTitulo);
		
		lblMensaje = new JLabel("Introduzca el DNI del empleado que desea consultar:");
		lblMensaje.setForeground(Color.BLACK);
		lblMensaje.setFont(new Font("Arial", Font.BOLD, 12));
		lblMensaje.setBounds(70, 100, 350, 20);
		contentPane.add(lblMensaje);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(430, 100, 100, 20);
		contentPane.add(txtDni);
		
		btnConsultarEmpleado = new JButton("CONSULTAR EMPLEADO");
		btnConsultarEmpleado.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultarEmpleado.setBackground(SystemColor.window);
		btnConsultarEmpleado.setBounds(70, 150, 240, 30);
		btnConsultarEmpleado.addActionListener(this);
		contentPane.add(btnConsultarEmpleado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 349, 660, 100);
		scrollPane.setVisible(false);
		contentPane.add(scrollPane);
		
		tablaContratos = new JTable();
		model = new DefaultTableModel();
		tablaContratos.setModel(model);
		
		model.addColumn("N� ");
		model.addColumn("Tipo de contrato");
		model.addColumn("Fecha inicio");
		model.addColumn("Fecha final");
		model.addColumn("D�as de trabajo");
		model.addColumn("D�as libres");
		
		scrollPane.setViewportView(tablaContratos);
		
		txtDatosEmpleado = new JTextArea();
		txtDatosEmpleado.setBounds(10, 190, 660, 148);
		txtDatosEmpleado.setVisible(false);
		contentPane.add(txtDatosEmpleado);
		
		btnConsultarTurnos = new JButton("CONSULTAR TURNOS");
		btnConsultarTurnos.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultarTurnos.setBackground(SystemColor.window);
		btnConsultarTurnos.setBounds(380, 150, 240, 30);
		btnConsultarTurnos.setVisible(false);
		btnConsultarTurnos.addActionListener(this);
		contentPane.add(btnConsultarTurnos);
	}
	
	public void asignarProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}

	public void actionPerformed(ActionEvent e) {
		if(misProcesos.comprobarCadenaDni(txtDni.getText())) {
			//Declaraci�n de variables locales
			Empleado empleadoTemp = misProcesos.buscarEmpleado(txtDni.getText());
			
			if(e.getSource() == btnConsultarEmpleado) {
				if(empleadoTemp != null) {
					txtDatosEmpleado.setVisible(true);
					mostrarInfoEnArea(empleadoTemp);
					miEmpleado = empleadoTemp;
					//limpiarCampos();
				}else {
					limpiarCampos();
				}
			}else if(e.getSource() == btnConsultarTurnos) {
				InfoTurnos miVentanaInfoTurnos = new InfoTurnos();
				miVentanaInfoTurnos.asignarProcesos(misProcesos);
				miVentanaInfoTurnos.asignarEmpleado(miEmpleado);
				miVentanaInfoTurnos.iniciarComponentes(); //Inicio los componentes de la clase InfoTurnos desde aqu� para que me aparezca el nombre del empleado al iniciar la ventana
				miVentanaInfoTurnos.setVisible(true);
			}
		}		
	}
	
	public void mostrarInfoEnArea(Empleado empleado) {
		txtDatosEmpleado.setText(misProcesos.imprimirEmpleado(empleado));
		
		if(empleado.getContratos().isEmpty()) {
			scrollPane.setVisible(false);
		}else {
			btnConsultarTurnos.setVisible(true);
			scrollPane.setVisible(true);
			rellenarTabla(empleado);
		}
	}
	
	private void rellenarTabla(Empleado empleado) {
		//Declaraci�n de variables locales
		int i = 1;
		
		for(Contrato c: empleado.getContratos()) {
			Object [] filas = new Object[6];
			filas[0] = i;
			filas[1] = c.getTipoContrato();
			filas[2] = c.getFechaInicio();
			filas[3] = c.getFechaFin();
			filas[4] = c.getDiasTrabajo();
			filas[5] = c.getDiasDescanso();
			
			model.addRow(filas);
			i++;
		}
	}
	
	private void limpiarCampos() {
		txtDni.setText("");
	}
}
