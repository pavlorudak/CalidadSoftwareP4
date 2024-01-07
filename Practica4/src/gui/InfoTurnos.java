package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;


public class InfoTurnos extends JFrame implements ActionListener{
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JLabel lblTituloII;
	private JLabel lblTitulo;
	private JLabel lblEmpleado;
	private JLabel lblNombreEmpleado;
	private JLabel lblNumeroContrato;
	private JTextField txtNumContrato;
	private JTable tablaTurnos;
	private DefaultTableModel model;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	
	private JButton btnConCom;
	
	private int sodfij = 0;
	int prueba = 0;
	
	//Instancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos
	Empleado miEmpleado;
	Contrato miContrato;

	//Definici�n de constructores
	public InfoTurnos() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Comentamos esta opci�n para que el programa no finalice al cerrar esta ventana
		setBounds(100, 100, 700, 500);
		setTitle("INFORMACI�N DE TURNOS"); //Colocamos el t�tulo a nuestra ventana
		setLocationRelativeTo(null); //Este modificador nos coloca la ventana en el centro de la pantalla
		setResizable(false); //Este modificador hace que no se pueda cambiar el tama�o de la ventana
		//iniciarComponentes();
	}
	
	//Definici�n de getters
	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	//Definici�n de m�todos
	public void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTituloII = new JLabel("IMPRESI�N DE TURNOS");
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
		
		lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setForeground(Color.BLACK);
		lblEmpleado.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmpleado.setBounds(70, 100, 70, 20);
		contentPane.add(lblEmpleado);
		
		lblNombreEmpleado = new JLabel("");
		lblNombreEmpleado.setForeground(Color.BLACK);
		lblNombreEmpleado.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombreEmpleado.setBounds(150, 100, 400, 20);
		lblNombreEmpleado.setText(miEmpleado.getNombre() + " " + miEmpleado.getApellidos());
		contentPane.add(lblNombreEmpleado);
		
		lblNumeroContrato = new JLabel("Seleccione el n\u00FAmero de contrato:");
		lblNumeroContrato.setForeground(Color.BLACK);
		lblNumeroContrato.setFont(new Font("Arial", Font.BOLD, 12));
		lblNumeroContrato.setBounds(70, 150, 210, 20);
		contentPane.add(lblNumeroContrato);
		
		txtNumContrato = new JTextField();
		txtNumContrato.setBounds(285, 150, 50, 20);
		contentPane.add(txtNumContrato);
		txtNumContrato.setColumns(10);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultar.setBackground(SystemColor.window);
		btnConsultar.setBounds(450, 144, 150, 30);
		btnConsultar.addActionListener(this);
		contentPane.add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 660, 200);
		contentPane.add(scrollPane);
		
		tablaTurnos = new JTable();
		model = new DefaultTableModel();
		tablaTurnos.setModel(model);
		
		model.addColumn("N�MERO");
		model.addColumn("TIPO");
		model.addColumn("LUNES");
		model.addColumn("MARTES");
		model.addColumn("MI�RCOLES");
		model.addColumn("JUEVES");
		model.addColumn("VIERNES");
		model.addColumn("S�BADO");
		model.addColumn("DOMINGO");
		
		scrollPane.setViewportView(tablaTurnos);
		
		btnConCom = new JButton("CONSULTA COMPLETA");
		btnConCom.setFont(new Font("Arial", Font.BOLD, 14));
		btnConCom.setBackground(Color.WHITE);
		btnConCom.setBounds(70, 200, 530, 30);
		btnConCom.addActionListener(this);
		contentPane.add(btnConCom);
	}
	
	public void asignarProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}
	
	public void asignarEmpleado(Empleado empleadoTemp) {
		this.miEmpleado = empleadoTemp;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConsultar) {
			try {
				if(txtNumContrato.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe insertar un valor", "ERROR" , JOptionPane.ERROR_MESSAGE);
				}else {
					if(Integer.parseInt(txtNumContrato.getText()) > miEmpleado.getContratos().size() || Integer.parseInt(txtNumContrato.getText()) < 1) {
						JOptionPane.showMessageDialog(null, "El n�mero insertado no es v�lido", "Error" , JOptionPane.ERROR_MESSAGE);
					}else {
						rellenarTablaUnitaria(miEmpleado);
					}
				}
			}catch(NumberFormatException d) {
				JOptionPane.showMessageDialog(null, "Error de ingreso de texto", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == btnConCom) {
			rellenarTabla(miEmpleado);
		}
	}
	
	private void rellenarTabla(Empleado empleado) {
		
		try {
			
			//Declaraci�n de variables locales
			int i = 1;
			
			for(Contrato c: empleado.getContratos()) {
				Object [] filas = new Object[9];
				filas[0] = i;
				filas[1] = c.getTipoContrato();
				filas[2] = c.getTurnos().get(0).name();
				filas[3] = c.getTurnos().get(1).name();
				filas[4] = c.getTurnos().get(2).name();
				filas[5] = c.getTurnos().get(3).name();
				filas[6] = c.getTurnos().get(4).name();
				filas[7] = c.getTurnos().get(5).name();
				filas[8] = c.getTurnos().get(6).name();
				
				model.addRow(filas);
				i++;
			}
			
		}catch(IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al insertar los valores en la tabla", "Error" , JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void rellenarTablaUnitaria(Empleado empleado) {
		
		try {

			Object [] filas = new Object[9];
			filas[0] = txtNumContrato.getText();
			filas[1] = empleado.getContratos().get(Integer.parseInt(txtNumContrato.getText())-1).getTipoContrato();
			filas[2] = empleado.getContratos().get(Integer.parseInt(txtNumContrato.getText())-1).getTurnos().get(0).name();
			filas[3] = empleado.getContratos().get(Integer.parseInt(txtNumContrato.getText())-1).getTurnos().get(1).name();
			filas[4] = empleado.getContratos().get(Integer.parseInt(txtNumContrato.getText())-1).getTurnos().get(2).name();
			filas[5] = empleado.getContratos().get(Integer.parseInt(txtNumContrato.getText())-1).getTurnos().get(3).name();
			filas[6] = empleado.getContratos().get(Integer.parseInt(txtNumContrato.getText())-1).getTurnos().get(4).name();
			filas[7] = empleado.getContratos().get(Integer.parseInt(txtNumContrato.getText())-1).getTurnos().get(5).name();
			filas[8] = empleado.getContratos().get(Integer.parseInt(txtNumContrato.getText())-1).getTurnos().get(6).name();
				
			model.addRow(filas);

		}catch(IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al insertar los valores en la tabla", "ERROR" , JOptionPane.ERROR_MESSAGE);
		}
	}
}