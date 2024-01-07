package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import operaciones.Empleado;
import operaciones.Empresa;
import operaciones.Procesos;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class InfoEmpresa extends JFrame {
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JLabel lblTituloII;
	private JLabel lblTitulo;
	private JScrollPane scrollPane;
	private JTextArea txtDatosEmpresa;
	private JTable tablaEmpleados;
	private DefaultTableModel model;
	
	//Instancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos

	//Definici�n de constructores
	public InfoEmpresa() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Comentamos esta opci�n para que el programa no finalice al cerrar esta ventana
		setBounds(100, 100, 700, 500);
		setTitle("INFORMACI�N GUILLERMO SYSTEMS"); //Colocamos el t�tulo a nuestra ventana
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
		
		lblTituloII = new JLabel("INFORMACI\u00D3N EMPRESARIAL");
		lblTituloII.setBounds(489, 61, 177, 20);
		lblTituloII.setForeground(Color.WHITE);
		lblTituloII.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblTituloII);
		
		lblTitulo = new JLabel("GUILLERMO SYSTEMS");
		lblTitulo.setBounds(0, 0, 684, 80);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setBackground(Color.DARK_GRAY);
		contentPane.add(lblTitulo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 660, 250);
		contentPane.add(scrollPane);
		
		tablaEmpleados = new JTable();
		model = new DefaultTableModel();
		tablaEmpleados.setModel(model);
		
		model.addColumn("DNI");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Direcci�n");
		model.addColumn("Email");
		model.addColumn("Tel�fono");
		model.addColumn("F.Nacimiento");
		model.addColumn("N� Contratos");
		
		scrollPane.setViewportView(tablaEmpleados);
		
		txtDatosEmpresa = new JTextArea();
		txtDatosEmpresa.setBounds(10, 92, 660, 90);
		contentPane.add(txtDatosEmpresa);
	}

	public void asignarProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}

	public void mostrarInfoEnArea() {
		txtDatosEmpresa.setText(misProcesos.imprimirEmpresa());
		
		if(misProcesos.getEmpresa().getListaEmpleados().isEmpty()) {
			scrollPane.setVisible(false);
		}else {
			scrollPane.setVisible(true);
			rellenarTabla();
		}
	}
	
	private void rellenarTabla() {
		//ArrayList<Empleado> listaEmpleados = misProcesos.getEmpresa().getListaEmpleados();
		for(Empleado e: misProcesos.getEmpresa().getListaEmpleados()) {
			Object [] filas = new Object[8];
			filas[0] = e.getDni();
			filas[1] = e.getNombre();
			filas[2] = e.getApellidos();
			filas[3] = e.getDireccion();
			filas[4] = e.getEmail();
			filas[5] = e.getTelefono();
			filas[6] = e.getfNacimiento();
			filas[7] = e.getContratos().size();
			
			model.addRow(filas);
		}
	}
}
