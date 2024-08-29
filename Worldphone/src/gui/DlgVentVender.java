package gui;	// Encargado: Anthony Espinoza

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.*;
import clases.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ItemEvent;
import javax.swing.UIManager;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class DlgVentVender extends JDialog implements ActionListener, ItemListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblProducto;
	private JComboBox<Integer> cboProducto;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JLabel lblStock;
	private JTextField txtStock;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnVender;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JButton btnBoleta;
	private JTextField txtNombreProducto;
	private JLabel lblCliente;
	private JComboBox<Integer> cboCliente;
	private JTextField txtNombreCliente;
	private JLabel lblFecha;
	private JComboBox<Integer> cboVenta;
	private JButton btnOtraVenta;
	
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
			DlgVentVender dialog = new DlgVentVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVentVender() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgVentVender.class.getResource("/recursos/WorldphoneLogo.png")));
		setTitle("Ventas");
		setBounds(100, 100, 640, 588);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 260, 605, 220);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Consolas", Font.PLAIN, 15));
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(30, 144, 255));
		panelTitulo.setBounds(0, 0, 630, 50);
		contentPanel.add(panelTitulo);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		lblRegistroDeVentas = new JLabel("Registro de Ventas");
		lblRegistroDeVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeVentas.setForeground(Color.WHITE);
		lblRegistroDeVentas.setFont(new Font("Roboto", Font.BOLD, 25));
		panelTitulo.add(lblRegistroDeVentas, BorderLayout.CENTER);
		
		panelDatos = new JPanel();
		panelDatos.setLayout(null);
		panelDatos.setBorder(new TitledBorder(new LineBorder(new Color(140, 144, 148)), "Datos de la venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatos.setBackground(new Color(255, 255, 255));
		panelDatos.setBounds(10, 65, 610, 180);
		contentPanel.add(panelDatos);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(20, 20, 70, 25);
		panelDatos.add(lblCliente);
		lblCliente.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		cboCliente = new JComboBox<Integer>();
		cboCliente.setBounds(90, 20, 120, 25);
		panelDatos.add(cboCliente);
		cboCliente.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(230, 20, 360, 25);
		panelDatos.add(txtNombreCliente);
		txtNombreCliente.setEditable(false);
		txtNombreCliente.setColumns(10);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setBounds(230, 60, 360, 25);
		panelDatos.add(txtNombreProducto);
		txtNombreProducto.setEditable(false);
		txtNombreProducto.setColumns(10);
		
		cboProducto = new JComboBox<Integer>();
		cboProducto.setBounds(90, 60, 120, 25);
		panelDatos.add(cboProducto);
		cboProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(20, 60, 70, 25);
		panelDatos.add(lblProducto);
		lblProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		lblPrecio = new JLabel("Precio \u0024");
		lblPrecio.setBounds(20, 100, 70, 25);
		panelDatos.add(lblPrecio);
		lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(90, 100, 120, 25);
		panelDatos.add(txtPrecio);
		txtPrecio.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtPrecio.addKeyListener(this);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(230, 100, 50, 25);
		panelDatos.add(lblStock);
		lblStock.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtStock = new JTextField();
		txtStock.setBounds(280, 100, 120, 25);
		panelDatos.add(txtStock);
		txtStock.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtStock.setEnabled(false);
		txtStock.setEditable(false);
		txtStock.setColumns(10);
		
		lblFecha = new JLabel(".");
		lblFecha.setBounds(430, 140, 80, 25);
		panelDatos.add(lblFecha);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		cboVenta = new JComboBox<Integer>();
		cboVenta.setBounds(280, 140, 120, 25);
		panelDatos.add(cboVenta);
		cboVenta.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboVenta.setEnabled(false);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(89, 140, 120, 25);
		panelDatos.add(txtCantidad);
		txtCantidad.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtCantidad.addKeyListener(this);
		txtCantidad.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(20, 140, 70, 25);
		panelDatos.add(lblCantidad);
		lblCantidad.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		btnOtraVenta = new JButton(" ");
		btnOtraVenta.setHorizontalAlignment(SwingConstants.TRAILING);
		btnOtraVenta.setIcon(new ImageIcon(DlgVentVender.class.getResource("/recursos/bucle.png")));
		btnOtraVenta.setBounds(525, 110, 65, 45);
		panelDatos.add(btnOtraVenta);
		btnOtraVenta.setFont(new Font("Dialog", Font.PLAIN, 5));
		btnOtraVenta.setEnabled(false);
		
		lblVenta = new JLabel("Venta");
		lblVenta.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblVenta.setBounds(230, 140, 50, 25);
		panelDatos.add(lblVenta);
		
		lblTitleFecha = new JLabel("Fecha :");
		lblTitleFecha.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTitleFecha.setBounds(440, 100, 55, 25);
		panelDatos.add(lblTitleFecha);
		
		panelBotones = new JPanel();
		panelBotones.setLayout(null);
		panelBotones.setBackground(new Color(30, 144, 255));
		panelBotones.setBounds(0, 492, 630, 65);
		contentPanel.add(panelBotones);
		
		btnBoleta = new JButton("Boleta");
		btnBoleta.setIcon(new ImageIcon(DlgVentVender.class.getResource("/recursos/impresora.png")));
		btnBoleta.setBounds(12, 10, 130, 45);
		panelBotones.add(btnBoleta);
		btnBoleta.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBoleta.addActionListener(this);
		btnBoleta.setEnabled(false);
		
		btnVender = new JButton("Vender");
		btnVender.setIcon(new ImageIcon(DlgVentVender.class.getResource("/recursos/vender.png")));
		btnVender.setBounds(150, 10, 130, 45);
		panelBotones.add(btnVender);
		btnVender.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnRegresar = new JButton(" ");
		btnRegresar.setIcon(new ImageIcon(DlgVentVender.class.getResource("/recursos/regresar.png")));
		btnRegresar.addActionListener(this);
		btnRegresar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnRegresar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnRegresar.setBounds(558, 10, 60, 45);
		panelBotones.add(btnRegresar);
		btnVender.addActionListener(this);
		btnOtraVenta.addActionListener(this);
		
		cboVenta.addItem(av.codigoCorrelativo());
		cboProducto.addItemListener(this);
		cboCliente.addItemListener(this);
		
		
		listarCboProducto();
		listarCboClientes();
		mostrarFechaActual();
		
	}
	//DECLARACI�N GLOBAL
			ArregloProductos ap = new ArregloProductos();
			ArregloClientes ac = new ArregloClientes();
			ArregloVentas av = new ArregloVentas();
			private JPanel panelTitulo;
			private JLabel lblRegistroDeVentas;
			private JPanel panelDatos;
			private JLabel lblVenta;
			private JLabel lblTitleFecha;
			private JPanel panelBotones;
			private JButton btnRegresar;
			
		
	private void mostrarFechaActual() {
	     LocalDate currentDate = LocalDate.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		 String formattedDate = currentDate.format(formatter);
		 lblFecha.setText(formattedDate);
	}		
			
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCliente) {
			itemStateChangedCboCliente(e);
		}
		if (e.getSource() == cboProducto) {
			itemStateChangedCboProducto(e);
		}
	}
	protected void itemStateChangedCboProducto(ItemEvent e) {
		try {
			int codProducto = leerProducto();
			Producto buscado = ap.buscar(codProducto);
			txtNombreProducto.setText(buscado.getModelo());
			txtPrecio.setText("" + buscado.getPrecio());
			txtStock.setText("" + buscado.getStockActual());
		} catch (Exception error) {
			
		}
	}
	protected void itemStateChangedCboCliente(ItemEvent e) {
		try {
			int codCliente = leerCliente();
			Cliente buscado = ac.buscar(codCliente);
			txtNombreCliente.setText(buscado.getNombres() + " " + buscado.getApellidos());
		} catch (Exception error) {
			
		}
	}
		void listarCboProducto() {
			cboProducto.removeAllItems();
			for (int i = 0; i < ap.tamanio(); i++) {
				cboProducto.addItem(ap.obtener(i).getCodProducto());
			}
		}
		void listarCboClientes() {
			cboCliente.removeAllItems();
			for (int i = 0; i < ac.tamanio(); i++) {
				cboCliente.addItem(ac.obtener(i).getCodCliente());
			}
		}
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOtraVenta) {
			actionPerformedBtnOtraVenta(e);
		}
		if (e.getSource() == btnBoleta) {
			actionPerformedBtnImprimir(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnRegresar) {
			actionPerformedBtnRegresar(e);
		}
	}
	protected void actionPerformedBtnOtraVenta(ActionEvent e) {
		txtCantidad.setText("");
		txtCantidad.requestFocus();
		limpiar();
		habilitar(true,false,false);
	}
	protected void actionPerformedBtnVender(ActionEvent e) {
		limpiar();
	    if(ac.tamanio() > 0 && ap.tamanio() > 0) {
	    	try {
		    	int cantidad = leerCantidad();
		    	if(cantidad > 0) {
		    		int codProducto = leerProducto();
			    	Producto buscadoP = ap.buscar(codProducto);
			    	int stock = buscadoP.getStockActual();
			    	
			    	if(cantidad <= stock) {

				    	int codVentas = leerVenta();
				        int codCliente = leerCliente();
				       
				        Cliente buscadoC = ac.buscar(codCliente);
				        
				        
				        String fecha = leerFecha();
				        String nombreC = buscadoC.getNombres() + " " + buscadoC.getApellidos();
				        String nombreP = buscadoP.getModelo();
				        double precio = buscadoP.getPrecio();
				        double importeSubTotal = Ventas.calcularImporteSubTotal(precio, cantidad);
				        double importeIGV = Ventas.calcularImporteIGV(precio);
				        double importePagar = Ventas.calcularImportePagar(importeSubTotal, importeIGV);

				        String boleta = String.format(
				            "C\u00F3digo del cliente : %d\n" +
				            "Nombre del cliente : %s\n" +
				            "C\u00F3digo del producto : %d\n" +
				            "Nombre del producto : %s\n" +
				            "Unidades compradas : %d\n" +
				            "Precio unitario : %.2f\n" +
				            "Importe Subtotal : %.2f\n" +
				            "Importe del IGV : %.2f\n" +
				            "Importe a pagar : %.2f",
				            codCliente, nombreC, codProducto, nombreP , cantidad, precio, importeSubTotal, importeIGV, importePagar
				        );

				        // Mostrar la boleta y preguntar si quiere proceder con la compra
				        int proceder = JOptionPane.showConfirmDialog(this, boleta + "\n\n\u00BFDesea proceder con la compra\u003F", "Confirmar", JOptionPane.YES_NO_OPTION);

				        if (proceder == JOptionPane.YES_OPTION) {
				        	
				        	ap.actualizarStock(codProducto, cantidad);
				        	txtStock.setText("" + buscadoP.getStockActual());
				        	
				        	imprimir("");
				        	imprimir("C\u00F3digo del cliente  : " + codCliente);
							imprimir("Nombre del cliente  : " + nombreC);
							imprimir("C\u00F3digo del producto : " + codProducto);
							imprimir("Nombre del producto : " + nombreP);
							imprimir("Unidades compradas  : " + cantidad);
							imprimir("Precio unitario     : $ " + precio);
							imprimir("Importe Subtotal    : $ " + importeSubTotal);
							imprimir("Importe del IGV     : $ " + importeIGV);
							imprimir("Importe a pagar     : $ " + importePagar);
							habilitar(true , true , true);
							
							buscadoP.setCantidadVendida(buscadoP.getCantidadVendida() + cantidad);
							buscadoP.setImporteAcumulado(buscadoP.getImporteAcumulado() + importePagar);
							ap.ActualizarArchivo();
							
							Ventas nuevo = new Ventas(codVentas,codCliente,codProducto, nombreP ,nombreC, fecha,cantidad,precio,importeSubTotal,importeIGV,importePagar);
							av.adicionar(nuevo);
							cboVenta.removeAllItems();
							cboVenta.addItem(av.codigoCorrelativo());
				        } else {
				            error("Venta cancelada", txtCantidad);
				        }
			    	}else {
			    		error("Stock no disponible para las cantidades solicitadas" , txtCantidad);
			    	}
		    	}else {
		    		error("La cantidad debe ser mayor a 0",txtCantidad);
		    	}
		    	
			} catch (Exception error) {
				error("Ingrese la cantidad de unidades a comprar", txtCantidad);
			}
	    }else {
	    	mensaje("No hay cliente(s) o producto(s)");
	    }
	}
	
	protected void actionPerformedBtnImprimir(ActionEvent e) {
		  try {
		        boolean printed = txtS.print();
		        if (printed) {
		            JOptionPane.showMessageDialog(this, "Impresi\u00F3n exitosa", "Informaci\u00F3n", JOptionPane.INFORMATION_MESSAGE);
		            habilitar(false , false ,true);
		            txtCantidad.setText("");
		            txtCantidad.requestFocus();
		        } else {
		            JOptionPane.showMessageDialog(this, "La impresi\u00F3n no se complet\u00F3 correctamente", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    } catch (PrinterException e1) {
		        JOptionPane.showMessageDialog(this, "Error al imprimir: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        e1.printStackTrace();
		    }
	}
	
	void habilitar(boolean vender, boolean imprimir , boolean otraVenta) {
		btnVender.setEnabled(vender);
		btnBoleta.setEnabled(imprimir);
		btnOtraVenta.setEnabled(otraVenta);
	}
	//Metodos de lectura y obtencion de datos
		String leerFecha() {
			return lblFecha.getText();
		}
		int leerVenta() {
			return Integer.parseInt(cboVenta.getSelectedItem().toString());
		}
		int leerProducto() {
			return Integer.parseInt(cboProducto.getSelectedItem().toString());
		}
		int leerCliente() {
			return Integer.parseInt(cboCliente.getSelectedItem().toString());
		}
		int leerCantidad() {
			return Integer.parseInt(txtCantidad.getText().trim());
		}
		void limpiar(){
			txtS.setText("");
		}
		void imprimir(String s) {
			txtS.append(" " + s + "\n");
		}
		
		
		
		//Mensajes JOption - Error
		void mensaje(String s) {
			JOptionPane.showMessageDialog(this, s);
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
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCantidad) {
			restarTexto(e);
		}
	}
	public void  restarTexto(KeyEvent e) {
		char c = e.getKeyChar();
		if(c < '0' || c > '9') e.consume();
	}
	protected void actionPerformedBtnRegresar(ActionEvent e) {
		dispose();
	}
}
