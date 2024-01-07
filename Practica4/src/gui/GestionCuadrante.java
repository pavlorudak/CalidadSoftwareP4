package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import operaciones.Contrato;
import operaciones.Contrato24;
import operaciones.Contrato32;
import operaciones.Contrato40;
import operaciones.ContratoVacaciones;
import operaciones.Empleado;
import operaciones.Procesos;
import operaciones.Turno;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GestionCuadrante extends JFrame implements ActionListener{
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JLabel lblTituloII;
	private JLabel lblTitulo;
	private JLabel lblCabecera;
	private JTextField txtSemana;
	private JButton btnImprimirCuadrante;
	private JTable table;
	
	private JTable tablaCuadrante;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JLabel lblTituloSemana;
	
	//Instancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos
	
	//Definici�n de constructores
	public GestionCuadrante() {		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Comentamos esta opci�n para que el programa no finalice al cerrar esta ventana
		setBounds(100, 100, 700, 500);
		setTitle("IMPRESI�N DE CUADRANTE"); //Colocamos el t�tulo a nuestra ventana
		setLocationRelativeTo(null); //Este modificador nos coloca la ventana en el centro de la pantalla
		setResizable(false); //Este modificador hace que no se pueda cambiar el tama�o de la ventana
		iniciarComponentes(); //Iniciamos los componentes gr�ficos de la ventana
	}
	
	//Definici�n de m�todos
	public void iniciarComponentes() {
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTituloII = new JLabel("IMPRESI�N DE CUADRANTE");
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
		
		lblCabecera = new JLabel("Introduza la semana para la que quiere realizar el cuadrante:");
		lblCabecera.setForeground(Color.BLACK);
		lblCabecera.setFont(new Font("Arial", Font.BOLD, 12));
		lblCabecera.setBounds(70, 120, 370, 20);
		contentPane.add(lblCabecera);
		
		txtSemana = new JTextField();
		txtSemana.setColumns(10);
		txtSemana.setBounds(450, 120, 40, 20);
		contentPane.add(txtSemana);
			
		btnImprimirCuadrante = new JButton("IMPRIMIR CUADRANTE");
		btnImprimirCuadrante.setFont(new Font("Arial", Font.BOLD, 14));
		btnImprimirCuadrante.setBackground(SystemColor.window);
		btnImprimirCuadrante.setBounds(200, 170, 240, 30);
		btnImprimirCuadrante.addActionListener(this);
		contentPane.add(btnImprimirCuadrante);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 660, 90);
		scrollPane.setVisible(false);
		contentPane.add(scrollPane);
		
		tablaCuadrante = new JTable();
		model = new DefaultTableModel();
		tablaCuadrante.setModel(model);
		
		model.addColumn("TURNO");
		model.addColumn("LUNES");
		model.addColumn("MARTES");
		model.addColumn("MI�RCOLES");
		model.addColumn("JUEVES");
		model.addColumn("VIERNES");
		model.addColumn("S�BADO");
		model.addColumn("DOMINGO");
		
		scrollPane.setViewportView(tablaCuadrante);
		
		lblTituloSemana = new JLabel("");
		lblTituloSemana.setForeground(Color.BLACK);
		lblTituloSemana.setFont(new Font("Arial", Font.BOLD, 14));
		lblTituloSemana.setBounds(30, 220, 500, 20);
		contentPane.add(lblTituloSemana);
	}
		
	public void asignarProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(validarCampos()) {
			if(misProcesos.comprobarContratos(Integer.parseInt(txtSemana.getText()))) {
				rellenarTabla(Integer.parseInt(txtSemana.getText()));
				lblTituloSemana.setText(rellenarTituloSemana());
				scrollPane.setVisible(true);
				limpiarCampos();
			}
		}
	}
	
	private void rellenarTabla(int semana) {
		int i, j, k, posicion;
		Object [] fila1 = new Object [8];
		Object [] fila2 = new Object [8];
		Object [] fila3 = new Object [8];
		
		fila1 [0] = "MA�ANA";
		fila2 [0] = "TARDE";
		fila3 [0] = "NOCHE";
		
		
		for(Empleado e: misProcesos.getEmpresa().getListaEmpleados()) {
			i = 1;
			j = 1;
			k = 1;
			posicion = 1;
			
			for(Contrato c: e.getContratos()) {
				if(c.getSemana() == semana) {
					for(Turno t: c.getTurnos()) {
						if(t.equals(Turno.MAÑANA) && i<8) {
							fila1 [posicion] = e.getNombre();
							i++;
						}
						posicion++;
					}
					posicion = 1;
					for(Turno t: c.getTurnos()) {
						if(t.equals(Turno.TARDE) && j<8) {
							fila2 [posicion] = e.getNombre();
							j++;
						}
						posicion ++;
					}
					posicion = 1;
					for(Turno t: c.getTurnos()) {
						if(t.equals(Turno.NOCHE) && k<8) {
							fila3 [posicion] = e.getNombre();
							k++;
						}
						posicion ++;
					}
				}
			}
		}
		
		model.addRow(fila1);
		model.addRow(fila2);
		model.addRow(fila3);
	}
	
	private boolean validarCampos() {
		try {
			if(txtSemana.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos deben estar rellenos", "Error" , JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error de ingreso de texto", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return true;
	}
	
	private void limpiarCampos() {
		txtSemana.setText("");
	}
	
	private String rellenarTituloSemana() {
		return "CUADRANTE SEMANA " + txtSemana.getText();
	}
}