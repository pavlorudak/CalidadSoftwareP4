package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import operaciones.Contrato;
import operaciones.Contrato24;
import operaciones.Contrato32;
import operaciones.Contrato40;
import operaciones.ContratoVacaciones;
import operaciones.Empleado;
import operaciones.Procesos;

public class GestionContratos extends JFrame implements ActionListener{
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JLabel lblTituloII;
	private JLabel lblTitulo;
	private ButtonGroup grupoRadio;
	private JLabel lblIntroduzcaElDni;
	private JTextField txtDni;
	private JComboBox<String> comboBox;
	private JRadioButton rdbTipo1;
	private JRadioButton rdbTipo2;
	private JLabel lblFechaDeInicio;
	private JTextField txtFechaInicio;
	private JLabel lblFechaDeFin;
	private JTextField txtFechaFin;
	private JButton btnAsignarContrato;
	private JTextField txtSemana;
	private JLabel lblSemana;
	
	//Instancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos

	//Definici�n de constructores
	public GestionContratos() {		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Comentamos esta opci�n para que el programa no finalice al cerrar esta ventana
		setBounds(100, 100, 700, 500);
		setTitle("GESTI�N DE CONTRATOS"); //Colocamos el t�tulo a nuestra ventana
		setLocationRelativeTo(null); //Este modificador nos coloca la ventana en el centro de la pantalla
		setResizable(false); //Este modificador hace que no se pueda cambiar el tama�o de la ventana
		iniciarComponentes(); //Iniciamos los componentes gr�ficos de la ventana
	}
	
	//Definici�n de m�todos
	public void iniciarComponentes() {
		grupoRadio = new ButtonGroup();
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTituloII = new JLabel("GESTI�N DE CONTRATOS");
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
		
		lblIntroduzcaElDni = new JLabel("Introduzca el DNI del empleado al que desea asignar un contrato:");
		lblIntroduzcaElDni.setForeground(Color.BLACK);
		lblIntroduzcaElDni.setFont(new Font("Arial", Font.BOLD, 12));
		lblIntroduzcaElDni.setBounds(70, 120, 400, 20);
		contentPane.add(lblIntroduzcaElDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(480, 120, 100, 20);
		contentPane.add(txtDni);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(70, 189, 200, 22);
		comboBox.setFont(new Font("Arial", Font.BOLD, 12));
		rellenarComboBox();
		comboBox.addActionListener(this);
		contentPane.add(comboBox);
		
		rdbTipo1 = new JRadioButton("Tipo 1", true); //Selecci�n por defecto
		rdbTipo1.setBounds(330, 177, 80, 20);
		contentPane.add(rdbTipo1);
		
		rdbTipo2 = new JRadioButton("Tipo 2");
		rdbTipo2.setBounds(330, 207, 80, 20);
		contentPane.add(rdbTipo2);
		
		grupoRadio.add(rdbTipo1);
		grupoRadio.add(rdbTipo2);
		rdbTipo1.setVisible(false);
		rdbTipo2.setVisible(false);
		
		lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setFont(new Font("Arial", Font.BOLD, 12));
		lblFechaDeInicio.setBounds(70, 265, 130, 20);
		contentPane.add(lblFechaDeInicio);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(185, 265, 100, 20);
		contentPane.add(txtFechaInicio);
			
		lblFechaDeFin = new JLabel("Fecha de fin:");
		lblFechaDeFin.setFont(new Font("Arial", Font.BOLD, 12));
		lblFechaDeFin.setBounds(70, 310, 130, 20);
		contentPane.add(lblFechaDeFin);
			
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(185, 310, 100, 20);
		contentPane.add(txtFechaFin);
			
		btnAsignarContrato = new JButton("ASIGNAR CONTRATO");
		btnAsignarContrato.setFont(new Font("Arial", Font.BOLD, 14));
		btnAsignarContrato.setBackground(SystemColor.window);
		btnAsignarContrato.setBounds(200, 360, 240, 30);
		btnAsignarContrato.addActionListener(this);
		contentPane.add(btnAsignarContrato);
		
		lblSemana = new JLabel("Semana: ");
		lblSemana.setFont(new Font("Arial", Font.BOLD, 12));
		lblSemana.setBounds(319, 310, 70, 20);
		contentPane.add(lblSemana);
		
		txtSemana = new JTextField();
		txtSemana.setColumns(10);
		txtSemana.setBounds(400, 310, 40, 20);
		contentPane.add(txtSemana);
	}
		
	public void asignarProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comboBox) {
			mostrarRadio();
		}else if(e.getSource() == btnAsignarContrato){
			if(validarCampos() == true) {
				if(misProcesos.comprobarCadenaDni(txtDni.getText()) && misProcesos.comprobarCadenaFecha(txtFechaFin.getText()) && misProcesos.comprobarCadenaFecha(txtFechaInicio.getText())){
					creacionContrato();
				}
			}
		}
	}
	
	private void rellenarComboBox() {
		comboBox.addItem("Seleccione un contrato");
		comboBox.addItem("Contrato 40h");
		comboBox.addItem("Contrato 32h");
		comboBox.addItem("Contrato 24h");
		comboBox.addItem("Contrato vacaciones");
		comboBox.setSelectedIndex(0);
	}
	
	private void mostrarRadio() {
		if(comboBox.getSelectedIndex() == 1 || comboBox.getSelectedIndex() == 2) {
			rdbTipo1.setVisible(true);
			rdbTipo2.setVisible(true);
		}else {
			rdbTipo1.setVisible(false);
			rdbTipo2.setVisible(false);
		}
	}
	
	private boolean validarCampos() {
		if(txtDni.getText().isEmpty() || txtFechaInicio.getText().isEmpty() || txtFechaFin.getText().isEmpty() || comboBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar rellenos", "ERROR" , JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}
	
	private void limpiarCampos() {
		txtDni.setText("");
		comboBox.setSelectedIndex(0);
		txtFechaInicio.setText("");
		txtFechaFin.setText("");
		txtSemana.setText("");
		rdbTipo1.setVisible(false);
		rdbTipo2.setVisible(false);
	}
	
	private void creacionContrato() {
		try {
			Empleado empleado = misProcesos.buscarEmpleado(txtDni.getText());
			Contrato contrato = null;
			if(misProcesos.comprobarDisponibilidadContrato(empleado, Integer.parseInt(txtSemana.getText()))){
				if(comboBox.getSelectedIndex() == 1) {
					if(rdbTipo1.isSelected()) {
						contrato = new Contrato40(txtFechaInicio.getText(), txtFechaFin.getText(), 1, Integer.parseInt(txtSemana.getText()));
						
						misProcesos.asignacionContrato(empleado, contrato);
						JOptionPane.showMessageDialog(null, "Contrato creado con �xito", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos(); //Limpiamos todos los campos del formulario
						
					}else {
						contrato = new Contrato40(txtFechaInicio.getText(), txtFechaFin.getText(), 2, Integer.parseInt(txtSemana.getText()));
						
						misProcesos.asignacionContrato(empleado, contrato);
						JOptionPane.showMessageDialog(null, "Contrato creado con �xito", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos(); //Limpiamos todos los campos del formulario
						
					}
				}else if(comboBox.getSelectedIndex() == 2) {
					if(rdbTipo1.isSelected()) {
						contrato = new Contrato32(txtFechaInicio.getText(), txtFechaFin.getText(), 1, Integer.parseInt(txtSemana.getText()));
						
						misProcesos.asignacionContrato(empleado, contrato);
						JOptionPane.showMessageDialog(null, "Contrato creado con �xito", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos(); //Limpiamos todos los campos del formulario
						
					}else {
						contrato = new Contrato32(txtFechaInicio.getText(), txtFechaFin.getText(), 2, Integer.parseInt(txtSemana.getText()));
						
						misProcesos.asignacionContrato(empleado, contrato);
						JOptionPane.showMessageDialog(null, "Contrato creado con �xito", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos(); //Limpiamos todos los campos del formulario
						
					}
				}else if(comboBox.getSelectedIndex() == 3) {
					contrato = new Contrato24(txtFechaInicio.getText(), txtFechaFin.getText(), Integer.parseInt(txtSemana.getText()));
					
					misProcesos.asignacionContrato(empleado, contrato);
					JOptionPane.showMessageDialog(null, "Contrato creado con �xito", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
					limpiarCampos(); //Limpiamos todos los campos del formulario
					
				}else if(comboBox.getSelectedIndex() == 4) {
					if(misProcesos.cogerVacaciones(empleado)) {
						contrato = new ContratoVacaciones(txtFechaInicio.getText(), txtFechaFin.getText(), Integer.parseInt(txtSemana.getText()));
						
						misProcesos.asignacionContrato(empleado, contrato);
						JOptionPane.showMessageDialog(null, "Contrato creado con �xito", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos(); //Limpiamos todos los campos del formulario
					}else {
						limpiarCampos();
					}
				}
			}else {
				txtSemana.setText("");
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error de ingreso de texto", "Error", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error", "Error" , JOptionPane.ERROR_MESSAGE);
		}
	}
}
