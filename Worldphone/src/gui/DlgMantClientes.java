package gui;	// Encargado: Patricia Cuba

import arreglos.*;
import clases.*;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class DlgMantClientes extends JDialog implements ItemListener , ActionListener, KeyListener , MouseListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JComboBox<Integer> cboCodigo;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnConsulta;
	private JButton btnEliminar;
	private JButton btnListado;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JTable tblClientes;
	private DefaultTableModel modeloTbl;
	private JScrollPane scrollPane;
	private JLabel lblEdad;
	private JTextField txtEdad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgMantClientes dialog = new DlgMantClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMantClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgMantClientes.class.getResource("/recursos/WorldphoneLogo.png")));
		setResizable(false);
		setTitle("Clientes");
		setBounds(100, 100, 900, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.setIcon(new ImageIcon(DlgMantClientes.class.getResource("/recursos/consultar.png")));
		btnConsulta.setFont(new Font("Dialog", Font.BOLD, 16));
		btnConsulta.setEnabled(false);
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(156, 223, 135, 45);
		contentPanel.add(btnConsulta);
		
		btnListado = new JButton("Listar");
		btnListado.setIcon(new ImageIcon(DlgMantClientes.class.getResource("/recursos/listar.png")));
		btnListado.setFont(new Font("Dialog", Font.BOLD, 16));
		btnListado.setEnabled(false);
		btnListado.addActionListener(this);
		btnListado.setBounds(10, 223, 135, 45);
		contentPanel.add(btnListado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 280, 872, 266);
		contentPanel.add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.addMouseListener(this);
		tblClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblClientes);
		
		
		modeloTbl = new NonEditableTableModel();
		modeloTbl.addColumn("C\u00D3DIGO");
		modeloTbl.addColumn("NOMBRES");
		modeloTbl.addColumn("APELLIDOS");
		modeloTbl.addColumn("DIRECCION");
		modeloTbl.addColumn("TEL\u00C9FONO");
		modeloTbl.addColumn("DNI");
		modeloTbl.addColumn("EDAD");
		
		tblClientes.setModel(modeloTbl);
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(30, 144, 255));
		panelTitulo.setBounds(0, 0, 894, 50);
		contentPanel.add(panelTitulo);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		lblRegistroDeClientes = new JLabel("Registro de Clientes");
		lblRegistroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeClientes.setForeground(Color.WHITE);
		lblRegistroDeClientes.setFont(new Font("Roboto", Font.BOLD, 25));
		panelTitulo.add(lblRegistroDeClientes, BorderLayout.CENTER);
		
		panelBotones = new JPanel();
		panelBotones.setLayout(null);
		panelBotones.setBackground(new Color(30, 144, 255));
		panelBotones.setBounds(0, 558, 894, 65);
		contentPanel.add(panelBotones);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(DlgMantClientes.class.getResource("/recursos/agregar.png")));
		btnAgregar.setBounds(10, 10, 135, 45);
		panelBotones.add(btnAgregar);
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(DlgMantClientes.class.getResource("/recursos/modificar.png")));
		btnModificar.setBounds(155, 10, 135, 45);
		panelBotones.add(btnModificar);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgMantClientes.class.getResource("/recursos/eliminar.png")));
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEliminar.setBounds(300, 10, 135, 45);
		panelBotones.add(btnEliminar);
		
		btnRegresar = new JButton(" ");
		btnRegresar.addActionListener(this);
		btnRegresar.setIcon(new ImageIcon(DlgMantClientes.class.getResource("/recursos/regresar.png")));
		btnRegresar.setBounds(820, 10, 60, 45);
		panelBotones.add(btnRegresar);
		btnRegresar.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		panelDatos = new JPanel();
		panelDatos.setLayout(null);
		panelDatos.setBorder(new TitledBorder(new LineBorder(new Color(140, 144, 148)), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatos.setBackground(Color.WHITE);
		panelDatos.setBounds(10, 62, 872, 150);
		contentPanel.add(panelDatos);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(DlgMantClientes.class.getResource("/recursos/cancelar.png")));
		btnCancelar.setBounds(725, 85, 130, 45);
		panelDatos.add(btnCancelar);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DlgMantClientes.class.getResource("/recursos/aceptar.png")));
		btnAceptar.setBounds(725, 30, 130, 45);
		panelDatos.add(btnAceptar);
		btnAceptar.setFont(new Font("Dialog", Font.BOLD, 16));
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(20, 20, 60, 25);
		panelDatos.add(lblCodigo);
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		cboCodigo = new JComboBox<Integer>();
		cboCodigo.setBounds(20, 45, 90, 25);
		panelDatos.add(cboCodigo);
		cboCodigo.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboCodigo.setToolTipText("");
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(140, 20, 80, 25);
		panelDatos.add(lblNombres);
		lblNombres.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtNombres = new JTextField();
		txtNombres.setBounds(140, 45, 250, 25);
		panelDatos.add(txtNombres);
		txtNombres.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtNombres.addKeyListener(this);
		txtNombres.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(420, 20, 80, 25);
		panelDatos.add(lblApellidos);
		lblApellidos.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(420, 45, 250, 25);
		panelDatos.add(txtApellidos);
		txtApellidos.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtApellidos.addKeyListener(this);
		txtApellidos.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(20, 80, 80, 25);
		panelDatos.add(lblEdad);
		lblEdad.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtEdad = new JTextField();
		txtEdad.setBounds(20, 105, 90, 25);
		panelDatos.add(txtEdad);
		txtEdad.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtEdad.addKeyListener(this);
		txtEdad.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(140, 80, 80, 25);
		panelDatos.add(lblDireccion);
		lblDireccion.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(140, 105, 250, 25);
		panelDatos.add(txtDireccion);
		txtDireccion.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDireccion.setColumns(10);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(420, 80, 80, 25);
		panelDatos.add(lblTelefono);
		lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(420, 105, 110, 25);
		panelDatos.add(txtTelefono);
		txtTelefono.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtTelefono.addKeyListener(this);
		txtTelefono.setColumns(10);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(560, 80, 80, 25);
		panelDatos.add(lblDni);
		lblDni.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtDni = new JTextField();
		txtDni.setBounds(560, 105, 110, 25);
		panelDatos.add(txtDni);
		txtDni.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDni.addKeyListener(this);
		txtDni.setColumns(10);
		cboCodigo.addItemListener(this);
		cboCodigo.addActionListener(this);
		btnAceptar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnModificar.addActionListener(this);
		btnAgregar.addActionListener(this);
		
		ajustarAnchoColumnas();
		deshabilitarTodo();
		if(ac.tamanio() < 1) {
			habilitar(false, false, false, false,false, false, false,  false, false, true, false, false,false,false);
		}
	}
	
	//DECLARACI�N GLOBAL
		ArregloClientes ac = new ArregloClientes();
		private JPanel panelTitulo;
		private JLabel lblRegistroDeClientes;
		private JPanel panelBotones;
		private JButton btnRegresar;
		private JPanel panelDatos;
		
		
		//Lista de codigos de cliente : Txt con los datos 
		
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == cboCodigo) {
				itemStateChangedCboCodigo(e);
			}
		}
		protected void itemStateChangedCboCodigo(ItemEvent e) {
			try {
				int codCliente = leerCodigo();
				Cliente buscado = ac.buscar(codCliente);
				txtNombres.setText(buscado.getNombres());
				txtApellidos.setText(buscado.getApellidos());
				txtDireccion.setText(buscado.getDireccion());
				txtTelefono.setText("" + buscado.getTelefono());
				txtDni.setText(buscado.getDni());
				txtEdad.setText("" + buscado.getEdad());
				tblClientes.setRowSelectionInterval(cboCodigo.getSelectedIndex(), cboCodigo.getSelectedIndex());
			} catch (Exception error) {
				
			}
		}
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnIngreso(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificacion(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminacion(e);
		}
		if (e.getSource() == btnRegresar) {
			actionPerformedBtnRegresar(e);
		}
		if (e.getSource() == btnListado) {
			actionPerformedBtnListado(e);
		}
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	private void actionPerformedBtnIngreso(ActionEvent e) {
		limpiar();
		txtDni.setEnabled(true);
		habilitar(false, true, true, true, true, true, true,  true, true, false, true, true,false,true);
		cboCodigo.addItem(ac.codigoCorrelativo());
		cboCodigo.setSelectedIndex(ac.tamanio());
		txtNombres.requestFocus();
	}
	
	protected void actionPerformedBtnModificacion(ActionEvent e) {
		if (!btnAgregar.isEnabled()) deshabilitarTodo();
		
		txtDni.setEnabled(false);
		
		inicializar(0);
		
		if(ac.tamanio() > 0) {
			habilitar(true, true, true, true,true, false, true,  true, true, true, false, false,false,true);
		}
		
		cboCodigo.requestFocus();
	}
	
	private void actionPerformedBtnConsulta(ActionEvent e) {
		if (!btnAgregar.isEnabled()) deshabilitarTodo();
		
		inicializar(0);
		if(ac.tamanio() > 0) {
			habilitar(true, false, false, false,false, false, false,  false, false, true, true, false,false,true);
		}
		cboCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnEliminacion(ActionEvent e) {
		try {
			int codCliente = leerCodigo();
			Cliente buscado = ac.buscar(codCliente);
				if (confirmar() == 0) {
					ac.eliminar(buscado);
					listar();
					mensaje("Cliente eliminado exitosamente", "Confirmaci\u00F3n");
					deshabilitarTodo();
				}
		} catch (Exception error) {
			error("Seleccione un c\u00F3digo de cliente", cboCodigo);
		}
	}
		int confirmar() {
			int valor = JOptionPane.showOptionDialog(this,
					"\u00BFEstas seguro que deseas eliminar los datos de este cliente\u003F\n  "
					+ ac.buscar(leerCodigo()).getNombres() + " " + ac.buscar(leerCodigo()).getApellidos(),
					"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No"}, null);
			return valor;
		}
	
	private void actionPerformedBtnListado(ActionEvent e) {
		if (!btnAgregar.isEnabled()) deshabilitarTodo();
		if(ac.tamanio() > 0) {
			listar();
		}else {
			mensaje("Actualmente no hay clientes registrados", "Aviso");
		}
	}
		
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int codCliente = leerCodigo();
			String nombres = Mod.txtAjustado(leerNombres());
				if (nombres.length() != 0) {
						String apellidos = Mod.txtAjustado(leerApellidos());
						if(apellidos.length() != 0) {
							String direccion = Mod.txtAjustado(leerDireccion());
							if(direccion.length() != 0) {
								try {
									int telefono = leerTelefono();
									String dni  = leerDni();
									try {
										if(Integer.parseInt(dni) > 0 && Integer.parseInt(dni) < 100000000) {
											try {
												int edad = leerEdad();
												if (!btnAgregar.isEnabled()) {
													if (!existeDni(dni)) {
														Cliente nuevo = new Cliente(codCliente, nombres, apellidos, direccion , telefono , dni, edad);
														ac.adicionar(nuevo);
														listar();
														mensaje("Nuevo cliente agregado exitosamente.", "Confirmaci\u00F3n");
														deshabilitarTodo();	
													} else {
														error("No puede ingresar un Dni ya registrado.", txtDni);
														int oDataDni = JOptionPane.showConfirmDialog(
														        this,
														        "\u00BFMostrar datos del dni encontrado\u003F",
														        "Resolver",
														        JOptionPane.YES_NO_OPTION,
														        JOptionPane.QUESTION_MESSAGE
														 );
															if (oDataDni == JOptionPane.YES_OPTION) {
																inicializar(dniEncontrado(dni));
														    }
													}
												} else if (!btnModificar.isEnabled()) {
														Cliente buscado = ac.buscar(codCliente);
														buscado.setNombres(nombres);
														buscado.setApellidos(apellidos);
														buscado.setDireccion(direccion);
														buscado.setTelefono(telefono);
														buscado.setEdad(edad);
														ac.ActualizarArchivo();
														listar();
														mensaje("Cliente modificado exitosamente.", "Confirmaci\u00F3n");
														deshabilitarTodo();
												}
											} catch (Exception error) {
												error("Ingrese una edad v\u00E1lida" , txtEdad);
											}
										}else {
											error("Ingrese un n\u00FAmero de DNI v\u00E1lido" , txtDni);
										}
									}catch(Exception error) {
										error("Ingrese un n\u00FAmero de DNI v\u00E1lido" , txtDni);
									}
								} catch (Exception error) {
									error("Ingrese un n\u00FAmero de tel\u00E9fono v\u00E1lido" , txtTelefono);
								}
							}else {
								error("Ingrese una direcci\u00F3n v\u00E1lida" , txtDireccion);	
							}
						}else {
							error("Ingrese el apellido del cliente" , txtApellidos);
						}
				}else {
					error("Ingrese el nombre del cliente", txtNombres);
				}
			} catch (Exception error) {
			error("Seleccione un c\u00F3digo de cliente", cboCodigo);
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}
		
	//Metodos de lectura y obtencion de datos
	
	int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
	String leerNombres() {
		return txtNombres.getText().trim().toUpperCase();
	}
	String leerApellidos() {
		return txtApellidos.getText().trim().toUpperCase();
	}
	String leerDireccion() {
		return txtDireccion.getText().trim().toUpperCase();
	}
	int leerTelefono() {
		return Integer.parseInt(txtTelefono.getText().trim());
	}
	String leerDni() {
		return txtDni.getText().trim().toUpperCase();
	}
	int leerEdad() {
		return Integer.parseInt(txtEdad.getText().trim());
	}
	
	//Inicializar valores por defecto del primer codigo del cliente
	
	void inicializar(int i) {
		if (ac.tamanio() > 0) {
            Cliente buscado = ac.obtener(i);
            cboCodigo.setSelectedItem(buscado.getCodCliente());
            txtNombres.setText(buscado.getNombres());
            txtApellidos.setText(buscado.getApellidos());
            txtDireccion.setText(buscado.getDireccion());
            txtTelefono.setText("" + buscado.getTelefono());
            txtDni.setText(buscado.getDni());
            txtEdad.setText("" + buscado.getEdad());
        } else {
            limpiar();
            mensaje("No hay clientes registrados.", "Aviso");
        }
	}
	
	//Desabilita , remueve la lista de cbo y limpia los campos de txt
	
	void deshabilitarTodo() {
		listarCboCodigo();
		habilitar(false, false, false,false, false, false, false, false, false, true, true, true,false,true);
		limpiar();
	}
		void listarCboCodigo() {
			cboCodigo.removeAllItems();
			for (int i = 0; i < ac.tamanio(); i++) {
				cboCodigo.addItem(ac.obtener(i).getCodCliente());
			}
		}
			void habilitar(boolean codigo,boolean nombre, boolean apellidos, boolean direccion, boolean telefono, boolean dni, boolean edad,
					boolean aceptar, boolean cancelar,boolean ingresar, boolean modificar, boolean consulta , boolean eliminar , boolean listado) {
				//txt
				cboCodigo.setEnabled(codigo);
				txtNombres.setEditable(nombre);
				txtApellidos.setEditable(apellidos);
				txtDireccion.setEditable(direccion);
				txtTelefono.setEditable(telefono);
				txtDni.setEditable(dni);
				txtEdad.setEditable(edad);
				
				//Botones 
				btnAceptar.setEnabled(aceptar);
				btnCancelar.setEnabled(cancelar);
				btnAgregar.setEnabled(ingresar);
				btnModificar.setEnabled(modificar);
				btnConsulta.setEnabled(consulta);
				btnEliminar.setEnabled(eliminar);
				btnListado.setEnabled(listado);
			}
				void limpiar() {
					cboCodigo.setSelectedIndex(-1);
					txtNombres.setText("");
					txtApellidos.setText("");
					txtDireccion.setText("");
					txtTelefono.setText("");
					txtDni.setText("");
					txtEdad.setText("");
				}
	
				//No dni duplicado
				
				boolean existeDni(String dni) {
					for (int i = 0; i < ac.tamanio(); i++) {
						if(ac.obtener(i).getDni().equals(dni))
							return true;	
						}
						return false;
				}
				int dniEncontrado(String dni) {
					for(int i = 0; i < ac.tamanio() ; i++) {
						if(ac.obtener(i).getDni().equals(dni))
							return i;
					}
					return -1;
				}
					
	//Lista de celdas  con los datos obtenidos
	
		void listar() {
			modeloTbl.setRowCount(0);
			for (int i = 0; i < ac.tamanio(); i++) {
				Object[] fila = {
						ac.obtener(i).getCodCliente(),
						ac.obtener(i).getNombres(),
						ac.obtener(i).getApellidos(),
						ac.obtener(i).getDireccion(),
						ac.obtener(i).getTelefono(),
						ac.obtener(i).getDni(),
						ac.obtener(i).getEdad(),	
				};
				modeloTbl.addRow(fila);
			}
		}			
		
		
		//Mensajes JOption - Error
		
		void mensaje(String s, String s2) {
			JOptionPane.showMessageDialog(this, s, s2, JOptionPane.INFORMATION_MESSAGE);
		}
		void error(String s, JComboBox<Integer> cbo) {
			JOptionPane.showMessageDialog(this, s,"Error", JOptionPane.ERROR_MESSAGE);
			cbo.requestFocus();
		}
		void error(String s, JTextField txt) {
			JOptionPane.showMessageDialog(this, s,"Error", JOptionPane.ERROR_MESSAGE);
			txt.selectAll();
			txt.requestFocus();
		}			
		
	//Celdas 		
			
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblClientes.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(18));  // apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(18));  // direccion
		tcm.getColumn(4).setPreferredWidth(anchoColumna(9));  // telefono
		tcm.getColumn(5).setPreferredWidth(anchoColumna(8));  // dni
		tcm.getColumn(6).setPreferredWidth(anchoColumna(5));  // edad
	}
		int anchoColumna(int porcentaje) {
			return porcentaje * scrollPane.getWidth() / 100;
		}
	//Clickear celdas para obtener informacion , Evento Click	
		

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == tblClientes) {
				mouseClickedTblClientes(e);
			}
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		protected void mouseClickedTblClientes(MouseEvent e) {
			if (tblClientes.getSelectedRow() != -1) { 
		        if (btnAgregar.isEnabled()) {
		            try {
		            	btnEliminar.setEnabled(true);
		                Cliente buscado = ac.obtener(tblClientes.getSelectedRow());
		                cboCodigo.setSelectedIndex(tblClientes.getSelectedRow());
		                txtNombres.setText(buscado.getNombres());
		                txtApellidos.setText(buscado.getApellidos());
		                txtDireccion.setText(buscado.getDireccion());
		                txtTelefono.setText("" + buscado.getTelefono());
		                txtDni.setText(buscado.getDni());
		                txtEdad.setText("" + buscado.getEdad());
		            } catch (Exception error) {
		                error.printStackTrace();
		            }
		        }
		    }
		}	
		
	//No permitir los numeros  , Evento key
		
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {		
		 if (e.getSource() == txtApellidos || e.getSource() == txtNombres) {
		        noNumero(e);
		    } else if (e.getSource() == txtDni) {
		        limitC(e, 8);
		        restarTexto(e);
		    }else if (e.getSource() == txtTelefono) {
				limitC(e, 9);
				restarTexto(e);
			}else if (e.getSource() == txtEdad) {
				limitC(e, 3);
				restarTexto(e);
			}
	}
	protected void limitC(KeyEvent e  , int lc) {
		 JTextField textField = (JTextField) e.getSource();
	        String text = textField.getText();
	        if (text.length() >= lc) {
	            e.consume(); 
	        }
	}
	public void noNumero(KeyEvent e) {
		char c = e.getKeyChar();
		if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) e.consume();
	}
	public void  restarTexto(KeyEvent e) {
		char c = e.getKeyChar();
		if((c < '0' || c > '9') && c != '.') e.consume();
	}
	class NonEditableTableModel extends DefaultTableModel {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
	protected void actionPerformedBtnRegresar(ActionEvent e) {
		dispose();
	}
}
