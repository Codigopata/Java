package gui;	// Encargado: Leonardo Pereyra

import arreglos.*;
import clases.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DlgMantProductos extends JDialog implements ActionListener, ItemListener, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelTitulo;
	private JPanel panelBotones;
	private JPanel panelDatos;
	private JLabel lblTitulo;
	private JLabel lblCodProducto;
	private JComboBox<Integer> cboCodProducto;
	private JLabel lblProducto;
	private JTextField txtProducto;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblStockAct;
	private JTextField txtStockActual;
	private JLabel lblStockMin;
	private JTextField txtStockMinimo;
	private JLabel lblStockMax;
	private JTextField txtStockMaximo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnConsultar;
	private JButton btnListar;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnRegresar;
	private JScrollPane scrollPane;
	private JTable tblProductos;
	private DefaultTableModel modelo;

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
			DlgMantProductos dialog = new DlgMantProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMantProductos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgMantProductos.class.getResource("/recursos/WorldphoneLogo.png")));
		setTitle("Productos");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 900, 650);
		getContentPane().setLayout(null);
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(30, 144, 255));
		panelTitulo.setBounds(0, 0, 890, 50);
		getContentPane().add(panelTitulo);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("Registro de Productos");
		panelTitulo.add(lblTitulo);
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 25));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(30, 144, 255));
		panelBotones.setBounds(0, 558, 890, 65);
		getContentPane().add(panelBotones);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(DlgMantProductos.class.getResource("/recursos/agregar.png")));
		btnAgregar.setBounds(10, 10, 135, 45);
		btnAgregar.addActionListener(this);
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(DlgMantProductos.class.getResource("/recursos/modificar.png")));
		btnModificar.setBounds(155, 10, 135, 45);
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setIcon(new ImageIcon(DlgMantProductos.class.getResource("/recursos/eliminar.png")));
		btnEliminar.setBounds(300, 10, 135, 45);
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 15));
		
		btnRegresar = new JButton(" ");
		btnRegresar.setIcon(new ImageIcon(DlgMantProductos.class.getResource("/recursos/regresar.png")));
		btnRegresar.setBounds(820, 10, 60, 45);
		btnRegresar.addActionListener(this);
		btnRegresar.setFont(new Font("Dialog", Font.PLAIN, 12));
		panelBotones.setLayout(null);
		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnRegresar);
		
		panelDatos = new JPanel();
		panelDatos.setBackground(new Color(255, 255, 255));
		panelDatos.setBorder(new TitledBorder(new LineBorder(new Color(140, 144, 148)), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatos.setBounds(10, 62, 872, 150);
		getContentPane().add(panelDatos);
		panelDatos.setLayout(null);
		
		lblCodProducto = new JLabel("C\u00F3digo");
		lblCodProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCodProducto.setBounds(20, 20, 60, 25);
		panelDatos.add(lblCodProducto);
		
		cboCodProducto = new JComboBox<Integer>();
		cboCodProducto.addItemListener(this);
		cboCodProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboCodProducto.setBounds(20, 45, 120, 25);
		panelDatos.add(cboCodProducto);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblProducto.setBounds(170, 20, 60, 25);
		panelDatos.add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtProducto.setBounds(170, 45, 360, 25);
		panelDatos.add(txtProducto);
		txtProducto.setColumns(10);
		
		lblStockAct = new JLabel("Stock actual");
		lblStockAct.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblStockAct.setBounds(170, 80, 106, 25);
		panelDatos.add(lblStockAct);
		
		txtStockActual = new JTextField();
		txtStockActual.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtStockActual.addKeyListener(this);
		txtStockActual.setBounds(170, 105, 100, 25);
		panelDatos.add(txtStockActual);
		txtStockActual.setColumns(10);
		
		lblPrecio = new JLabel("Precio \u0024");
		lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPrecio.setBounds(20, 80, 100, 25);
		panelDatos.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtPrecio.addKeyListener(this);
		txtPrecio.setBounds(20, 105, 120, 25);
		panelDatos.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblStockMin = new JLabel("Stock m\u00EDnimo");
		lblStockMin.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblStockMin.setBounds(300, 80, 100, 25);
		panelDatos.add(lblStockMin);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.addKeyListener(this);
		txtStockMinimo.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtStockMinimo.setBounds(300, 105, 100, 25);
		panelDatos.add(txtStockMinimo);
		txtStockMinimo.setColumns(10);
		
		lblStockMax = new JLabel("Stock m\u00E1ximo");
		lblStockMax.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblStockMax.setBounds(430, 80, 100, 25);
		panelDatos.add(lblStockMax);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.addKeyListener(this);
		txtStockMaximo.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtStockMaximo.setBounds(430, 105, 100, 25);
		panelDatos.add(txtStockMaximo);
		txtStockMaximo.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DlgMantProductos.class.getResource("/recursos/aceptar.png")));
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAceptar.setBounds(725, 30, 130, 45);
		panelDatos.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(DlgMantProductos.class.getResource("/recursos/cancelar.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCancelar.setBounds(725, 85, 130, 45);
		panelDatos.add(btnCancelar);
		
		btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon(DlgMantProductos.class.getResource("/recursos/listar.png")));
		btnListar.addActionListener(this);
		btnListar.setBounds(10, 223, 135, 45);
		getContentPane().add(btnListar);
		btnListar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnListar.setEnabled(true);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(DlgMantProductos.class.getResource("/recursos/consultar.png")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(155, 223, 135, 45);
		getContentPane().add(btnConsultar);
		btnConsultar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnConsultar.setEnabled(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 280, 872, 265);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFont(new Font("Dialog", Font.PLAIN, 14));
		tblProductos.addMouseListener(this);
		scrollPane.setViewportView(tblProductos);
		tblProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductos);
		modelo = new DefaultTableModel();
		tblProductos.setDefaultEditor(Object.class, null);
		modelo.addColumn("C\u00D3DIGO");
		modelo.addColumn("PRODUCTO");
		modelo.addColumn("PRECIO \u0024");
		modelo.addColumn("STOCK ACTUAL");
		modelo.addColumn("STOCK M\u013AN");
		modelo.addColumn("STOCK MAX");
		tblProductos.setModel(modelo);
		
		ajustarAnchoColumnas();
		deshabilitarTodo();
		if(ap.tamanio() < 1) {
			habilitar(false, false, false, false,false, false, false, false, true, false, false,false,false);
		}
	}
	
	//	DECLARACION GLOBAL
	
	ArregloProductos ap = new ArregloProductos();
	
	//	Ejecuta el metodo instanciado al JButton al darle Click
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnRegresar) {
			actionPerformedBtnRegresar(e);
		}
	}

	//	Lista de codigos de cliente : Txt con los datos 
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodProducto) {
			itemStateChangedCboCodProducto(e);
		}
	}
	protected void itemStateChangedCboCodProducto(ItemEvent e) {
		try {
			int codProducto = leerCodigo();
			Producto buscado = ap.buscar(codProducto);
			txtProducto.setText(buscado.getModelo());
			txtPrecio.setText("" + buscado.getPrecio());
			txtStockActual.setText("" + buscado.getStockActual());
			txtStockMinimo.setText("" + buscado.getStockMinimo());
			txtStockMaximo.setText("" + buscado.getStockMaximo());
			tblProductos.setRowSelectionInterval(cboCodProducto.getSelectedIndex(), cboCodProducto.getSelectedIndex());
		} catch (Exception error) {
			
		}
	}
	
	//	Boton que Acepta los datos ingresados: Del boton Agregar o Modificar
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int codProducto = leerCodigo();
			String modelo = Mod.txtAjustado(leerModelo());
			if (modelo.length() != 0) {
				try {
					double precio = leerPrecio();
						try {
							int stockActual = leerStockActual();
								try {
									int stockMinimo = leerStockMinimo();
										try {
											int stockMaximo = leerStockMaximo();
												try {
													if (!btnAgregar.isEnabled()) {
														Producto nuevo = new Producto(codProducto, modelo, precio, stockActual, stockMinimo, stockMaximo, 0,0.0);
														ap.adicionar(nuevo);
														listar();
														mensaje("Nuevo producto agregado exitosamente.","Confirmacion");
														deshabilitarTodo();
													} else if (!btnModificar.isEnabled()) {
														Producto buscado = ap.buscar(codProducto);
														buscado.setModelo(modelo);
														buscado.setPrecio(precio);
														buscado.setStockActual(stockActual);
														buscado.setStockMinimo(stockMinimo);
														buscado.setStockMaximo(stockMaximo);
														ap.ActualizarArchivo();
														listar();
														mensaje("Producto modificado exitosamente.","Confirmacion");
														deshabilitarTodo();
													}
												} catch (Exception e2) {
													// TODO: handle exception
												}
										} catch (Exception e2) {
											error("Ingrese un n\u00FAmero de stock m\u00E1ximo v\u00E1lido.", txtStockMaximo);
										}
								} catch (Exception error) {
									error("Ingrese un n\u00FAmero de stock m\u00EDnimo v\u00E1lido.", txtStockMinimo);
								}
						} catch (Exception error) {
							error("Ingrese un n\u00FAmero de stock actual v\u00E1lido.", txtStockActual);
						}	
				} catch (Exception e2) {
					error("Ingrese un precio de producto v\u00E1lido.", txtPrecio);
				}
			} else {
				error("Ingrese el nombre del producto.", txtProducto);
			}
		} catch (Exception error) {
			error("Seleccione un c\u00F3digo de producto.", cboCodProducto);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}
	
	//	Boton que permite Listar en las celdas todos los productos ingresados
	
	private void actionPerformedBtnListar(ActionEvent e) {
		if (!btnAgregar.isEnabled()) deshabilitarTodo();
		if(ap.tamanio() > 0) {
			listar();
		}else {
			mensaje("Actualmente no hay productos registrados","Aviso");
		}
	}
	
	//	Boton que permite Consultar los datos del codigo seleccionado 
	
	private void actionPerformedBtnConsultar(ActionEvent e) {
		if (!btnAgregar.isEnabled()) deshabilitarTodo();
		
		inicializar(0);
		if(ap.tamanio() > 0) {
			habilitar(true, false, false, false,false, false, false, false, true, true, false,false,true);
		}
		cboCodProducto.requestFocus();
	}
	
	//	Boton que permite Agregar un producto nuevo 
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		limpiar();
		habilitar(false, true, true, true, true, true, true, true, false, true, true,false,true);
		cboCodProducto.addItem(ap.codigoCorrelativo());
		cboCodProducto.setSelectedIndex(ap.tamanio());
		txtProducto.requestFocus();
	}
	
	//	Boton que permite Modificar un producto seleccionado
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (!btnAgregar.isEnabled()) deshabilitarTodo();
		habilitar(true, true, true, true,true, true, true,  true, true, false, false,false,true);
		cboCodProducto.requestFocus();
	}
	
	//	Boton que elimina un producto de la celda seleccionada
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int codProducto = leerCodigo();
			if (confirmar() == 0) {
				Producto buscado = ap.buscar(codProducto);
				ap.eliminar(buscado);
				listar();
				mensaje("Producto eliminado exitosamente.", "Confirmaci\u00F3n");
				deshabilitarTodo();
			}
		} catch (Exception error) {
			error("Seleccione un c\u00F3digo de producto.", cboCodProducto);
		}
	}
		
	//	Boton que retorna al Menu principal
	
	protected void actionPerformedBtnRegresar(ActionEvent e) {
		this.dispose();
	}
	
	//	METODOS COMPLEMENTARIOS
	//	Inicializar valores por defecto del primer codigo del cliente
	
	void inicializar(int i) {
		if (ap.tamanio() > 0) {
            Producto buscado = ap.obtener(i);
            cboCodProducto.setSelectedItem(buscado.getCodProducto());
            txtProducto.setText(buscado.getModelo());
            txtPrecio.setText(String.valueOf(buscado.getPrecio()));
            txtStockActual.setText("" + buscado.getStockActual());
            txtStockMinimo.setText("" + buscado.getStockMinimo());
            txtStockMaximo.setText("" + buscado.getStockMaximo());
        } else {
            limpiar();
            mensaje("No hay productos registrados.","Aviso");
        }
	}
	
	//	Desabilita , remueve la lista de cbo y limpia los campos de txt
	
	void deshabilitarTodo() {
		listarCboProducto();
		habilitar(false, false, false, false, false, false, false, false, true, true, true, false, true);
		limpiar();
	}
	void listarCboProducto() {
		cboCodProducto.removeAllItems();
		for (int i = 0; i < ap.tamanio(); i++) {
			cboCodProducto.addItem(ap.obtener(i).getCodProducto());
		}
	}
	void habilitar(boolean codigo,boolean modelo, boolean precio, boolean stockActual, boolean stockMinimo, boolean stockMaximo, 
			boolean aceptar, boolean cancelar,boolean ingresar, boolean modificar, boolean consulta , boolean eliminar , boolean listado) {
		//txt
		cboCodProducto.setEnabled(codigo);
		txtProducto.setEditable(modelo);
		txtPrecio.setEditable(precio);
		txtStockActual.setEditable(stockActual);
		txtStockMinimo.setEditable(stockMinimo);
		txtStockMaximo.setEditable(stockMaximo);
		
		txtProducto.setEnabled(modelo);
		txtPrecio.setEnabled(precio);
		txtStockActual.setEnabled(stockActual);
		txtStockMinimo.setEnabled(stockMinimo);
		txtStockMaximo.setEnabled(stockMaximo);
		
		//Botones 
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnAgregar.setEnabled(ingresar);
		btnModificar.setEnabled(modificar);
		btnConsultar.setEnabled(consulta);
		btnListar.setEnabled(listado);
	}
	void limpiar() {
		cboCodProducto.setSelectedIndex(-1);
		txtProducto.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMinimo.setText("");
		txtStockMaximo.setText("");
	}
	
	//	Celdas
	
	void ajustarAnchoColumnas() {
		TableColumnModel modeloColuma = tblProductos.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth()*1);  // codigo
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth()*4);  // modelo
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth()*1);  // precio
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth()*1);  // stockActual
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth()*1);  // stockMinimo
		modeloColuma.getColumn(5).setPreferredWidth(scrollPane.getWidth()*1);  // stockMaximo
	}
	
	//Lista las celdas  con los datos obtenidos
	
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ap.tamanio(); i++) {
			Object[] fila = {
					ap.obtener(i).getCodProducto(),
					ap.obtener(i).getModelo(),
					ap.obtener(i).getPrecio(),
					ap.obtener(i).getStockActual(),
					ap.obtener(i).getStockMinimo(),
					ap.obtener(i).getStockMaximo(),
			};
			modelo.addRow(fila);
		}
	}
	
	//	Mensaje JOption - Confirmacion
	
	int confirmar() {
		int valor = JOptionPane.showOptionDialog(this,
				"\u00BFEst\u00E1s seguro que deseas eliminar este producto\u003F "
				+ ap.buscar(leerCodigo()).getModelo() + "\n\u00A1Recuerda imprimir el reporte del producto antes de eliminarlo\u0021",
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No"}, null);
		return valor;
	}
	
	//	Metodos de lectura y obtencion de datos
	
	int leerCodigo() {
		return Integer.parseInt(cboCodProducto.getSelectedItem().toString());
	}
	String leerModelo() {
		return txtProducto.getText().trim().toUpperCase();
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int leerStockActual() {
		return Integer.parseInt(txtStockActual.getText().trim());
	}
	int leerStockMinimo() {
		return Integer.parseInt(txtStockMinimo.getText().trim());
	}
	int leerStockMaximo() {
		return Integer.parseInt(txtStockMaximo.getText().trim());
	}
	
	//	Mensajes JOption - Error
	
	void mensaje(String s, String s2) {
		JOptionPane.showMessageDialog(this, s, s2, JOptionPane.INFORMATION_MESSAGE);
	}
	void error(String s, JComboBox<Integer> cbo) {
		JOptionPane.showMessageDialog(this, s,"Error", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	void error(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s,"Error", JOptionPane.ERROR_MESSAGE);
		txt.setText("");
		txt.requestFocus();
	}
	
	//	Clickear celdas para obtener informacion , Evento Click
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblProductos) { mouseClickedTblCurso(e); }
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblCurso(MouseEvent e) {
		if (tblProductos.getSelectedRow() != -1) {
			if (btnAgregar.isEnabled()) {
				try {
					btnEliminar.setEnabled(true);
					Producto buscado = ap.obtener(tblProductos.getSelectedRow());
					cboCodProducto.setSelectedIndex(tblProductos.getSelectedRow());
					txtProducto.setText(buscado.getModelo());
					txtPrecio.setText("" + buscado.getPrecio());
					txtStockActual.setText("" + buscado.getStockActual());
					txtStockMinimo.setText("" + buscado.getStockMinimo());
					txtStockMaximo.setText("" + buscado.getStockMaximo());
				} catch (Exception error) {
					error.printStackTrace();
				}
			}
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtStockMaximo) {
			restarTexto2(e);
		}
		if (e.getSource() == txtStockMinimo) {
			restarTexto2(e);
		}
		if (e.getSource() == txtStockActual) {
			restarTexto2(e);
		}
		if (e.getSource() == txtPrecio) {
			restarTexto(e);
		}
	}
	public void  restarTexto2(KeyEvent e) {
		char c = e.getKeyChar();
		if((c < '0' || c > '9')) e.consume();
	}
	public void  restarTexto(KeyEvent e) {
		char c = e.getKeyChar();
		if((c < '0' || c > '9') && c != '.') e.consume();
	}
}
