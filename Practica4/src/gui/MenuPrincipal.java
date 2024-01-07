package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import operaciones.Procesos;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MenuPrincipal extends JFrame implements ActionListener{
	//Declaraci�n de atributos
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JButton btnEmpleados;
	private JButton btnContratos;
	private JButton btnInfo;
	private JButton btnMostrarCuadrante;
	
	//Intancias a otras clases
	Procesos misProcesos; //Instanciamos a la clase Procesos

	//Definici�n de constructores
	public MenuPrincipal() {		
		misProcesos = new Procesos(); //Creo una instancia a la clase Procesos
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setTitle("GUILLERMO SYSTEMS"); //Colocamos el t�tulo a nuestra ventana
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
		
		lblTitulo = new JLabel("GUILLERMO SYSTEMS");
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setOpaque(true); //Este modificador hace visible el color de fondo de la etiqueta
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(0, 0, 684, 80);
		contentPane.add(lblTitulo);
		
		btnEmpleados = new JButton("GESTI\u00D3N DE EMPLEADOS");
		btnEmpleados.setBackground(SystemColor.window);
		btnEmpleados.setFont(new Font("Arial", Font.BOLD, 16));
		btnEmpleados.setBounds(90, 90, 500, 70);
		btnEmpleados.addActionListener(this);
		contentPane.add(btnEmpleados);
		
		btnContratos = new JButton("GESTI\u00D3N DE CONTRATOS");
		btnContratos.setBackground(SystemColor.window);
		btnContratos.setFont(new Font("Arial", Font.BOLD, 16));
		btnContratos.setBounds(90, 175, 500, 70);
		btnContratos.addActionListener(this);
		contentPane.add(btnContratos);
		
		btnInfo = new JButton("INFORMACI\u00D3N");
		btnInfo.setBackground(SystemColor.window);
		btnInfo.setFont(new Font("Arial", Font.BOLD, 16));
		btnInfo.setBounds(90, 260, 500, 70);
		btnInfo.addActionListener(this);
		contentPane.add(btnInfo);
		
		btnMostrarCuadrante = new JButton("CUADRANTE");
		btnMostrarCuadrante.setBackground(SystemColor.window);
		btnMostrarCuadrante.setFont(new Font("Arial", Font.BOLD, 16));
		btnMostrarCuadrante.setBounds(90, 345, 500, 70);
		btnMostrarCuadrante.addActionListener(this);
		contentPane.add(btnMostrarCuadrante);
	}

	//Definici�n de m�todos
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEmpleados) {
			GestionEmpleados miVentanaGestionEmpleados = new GestionEmpleados();
			miVentanaGestionEmpleados.asignarProcesos(misProcesos);
			miVentanaGestionEmpleados.setVisible(true);
			
		}else if(e.getSource() == btnContratos) {
			GestionContratos miVentanaGestionContratos = new GestionContratos();
			miVentanaGestionContratos.asignarProcesos(misProcesos);
			miVentanaGestionContratos.setVisible(true);
			
		}else if(e.getSource() == btnInfo) {
			InfoEmpresa miVentanaInfoEmpresa = new InfoEmpresa();
			miVentanaInfoEmpresa.asignarProcesos(misProcesos);
			miVentanaInfoEmpresa.mostrarInfoEnArea();
			miVentanaInfoEmpresa.setVisible(true);
			
		}else if(e.getSource() == btnMostrarCuadrante) {
			if(misProcesos.comprobarTrabajadores()) {
				GestionCuadrante miVentanaGestionCuadrante = new GestionCuadrante();
				miVentanaGestionCuadrante.asignarProcesos(misProcesos);
				miVentanaGestionCuadrante.setVisible(true);
			}
		}
	}
}
