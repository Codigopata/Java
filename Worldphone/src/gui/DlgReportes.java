package gui;	// Encargado: Marcos Sermeno

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.*;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;

public class DlgReportes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnImprimir;
	private JButton btnListar;
	private JTextArea txtS;
	private JComboBox<String> cboReporte;
	private JScrollPane scrollPane;

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
			DlgReportes dialog = new DlgReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReportes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgReportes.class.getResource("/recursos/WorldphoneLogo.png")));
		setResizable(false);
		setTitle("Reportes");
		setBounds(100, 100, 500, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboReporte = new JComboBox<String>();
		cboReporte.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboReporte.addActionListener(this);
		cboReporte.setModel(new DefaultComboBoxModel<String>(new String[] {"LISTADO GENERAL DE VENTAS", "LISTADO DE PRODUCTO POR DEBAJO DEL STOCK M\u013ANIMO", "LISTADO DE PRODUCTO POR UNIDADES VENDIDAS", "LISTADO DE PRODUCTO POR IMPORTE TOTAL"}));
		cboReporte.setBounds(10, 65, 475, 30);
		contentPanel.add(cboReporte);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 474, 316);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtS.setText("!Presione Listar para mostrar los reportes!");
		scrollPane.setViewportView(txtS);
		txtS.setEditable(false);
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(30, 144, 255));
		panelTitulo.setBounds(0, 0, 494, 50);
		contentPanel.add(panelTitulo);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("Generador de Reportes");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 25));
		panelTitulo.add(lblTitulo, BorderLayout.CENTER);
		
		panelBotones = new JPanel();
		panelBotones.setLayout(null);
		panelBotones.setBackground(new Color(30, 144, 255));
		panelBotones.setBounds(0, 438, 494, 65);
		contentPanel.add(panelBotones);
		
		btnRegresar = new JButton(" ");
		btnRegresar.setBounds(425, 10, 60, 45);
		panelBotones.add(btnRegresar);
		btnRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegresar.addActionListener(this);
		btnRegresar.setIcon(new ImageIcon(DlgReportes.class.getResource("/recursos/regresar.png")));
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(10, 10, 130, 45);
		panelBotones.add(btnImprimir);
		btnImprimir.setFont(new Font("Dialog", Font.BOLD, 16));
		btnImprimir.setIcon(new ImageIcon(DlgReportes.class.getResource("/recursos/impresora.png")));
		btnImprimir.setEnabled(false);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(150, 10, 130, 45);
		panelBotones.add(btnListar);
		btnListar.setIcon(new ImageIcon(DlgReportes.class.getResource("/recursos/listar.png")));
		btnListar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnListar.addActionListener(this);
		btnImprimir.addActionListener(this);
	}
	
	ArregloVentas av = new ArregloVentas();
	ArregloProductos ap = new ArregloProductos();
	private JButton btnRegresar;
	private JPanel panelTitulo;
	private JLabel lblTitulo;
	private JPanel panelBotones;

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(e);
		}
		if (e.getSource() == cboReporte) {
			actionPerformedCboReporte(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnRegresar) {
			actionPerformedBtnRegresar(e);
		}
	}
	protected void actionPerformedCboReporte(ActionEvent e) {
		int tipoReporte = leerReporte();
		btnImprimir.setEnabled(false);
		
		switch (tipoReporte) {
		case 0: {
			limpiar();
			break;
		}
		case 1:{
			limpiar();
			break;
		}
		case 2:{
			limpiar();
			break;
		}
		case 3:{
			limpiar();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoReporte);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		int tipoReporte = leerReporte();
		limpiar();
		btnImprimir.setEnabled(true);
		
		switch (tipoReporte) {
		case 0: {
			for(int i = 0 ; i < av.tamanio(); i++) {
				int codVentas = av.obtener(i).getCodVentas();
				int codCliente = av.obtener(i).getCodCliente();
				int codProducto = av.obtener(i).getCodProducto();
				String fecha = av.obtener(i).getFecha();
				double importeSubtotal = av.obtener(i).getImporteSubtotal();
				double importeIGV = av.obtener(i).getImporteIGV();
				double importeTotal = av.obtener(i).getImporteTotalPagar();
				
				imprimir(""); 
				imprimir("C\u00F3digo de venta\t : " + codVentas);
				imprimir("C\u00F3digo del cliente\t : " + codCliente);
				imprimir("C\u00F3digo del producto\t : " + codProducto);
				imprimir("Fecha\t\t\t : " + fecha);
				imprimir("Importe Subtotal\t : \u0024 " + importeSubtotal);
				imprimir("Importe IGV\t\t : \u0024 " + importeIGV);
				imprimir("Importe Total\t\t : \u0024 " + importeTotal);
				imprimir(""); 
				imprimir("------------------------------------------------------"); 
			}
			
			posicionar();
			
			break;
		}
		case 1:{
			
			boolean hayProductoConStockBajo = false;
			
			for(int i = 0 ; i < ap.tamanio() ; i++) {
				int codProducto = ap.obtener(i).getCodProducto();
				String modelo = ap.obtener(i).getModelo();
				int stockActual = ap.obtener(i).getStockActual();
				int stockMinimo = ap.obtener(i).getStockMinimo();
				
				if (stockActual < stockMinimo) {
					
					hayProductoConStockBajo = true; 
					
					imprimir(""); 
					imprimir("C\u00F3digo de producto\t : " + codProducto);
					imprimir("Nombre de producto\t : " + modelo);
					imprimir("Stock Actual\t\t : " + stockActual);
					imprimir("Stock M\u00EDnimo\t\t : " + stockMinimo);
					imprimir(modelo + " tiene stock por debajo del stock m\u00EDnimo");
					imprimir("");
					imprimir("------------------------------------------------------");
				} 
			}
			
			if (!hayProductoConStockBajo) {
			    imprimir("No hay ning\u00FAn producto que tenga stock menor al m\u00EDnimo");
			}
			
			posicionar();
			
			break;
		}
		case 2:{
			for(int i = 0 ; i < ap.tamanio() ; i++) {
				int codProducto = ap.obtener(i).getCodProducto();
				String modelo = ap.obtener(i).getModelo();
				int cUnidadesVendidas = ap.obtener(i).getCantidadVendida();
				
					imprimir(""); 
					imprimir("C\u00F3digo de producto\t\t : " + codProducto);
					imprimir("Nombre de producto\t\t : " + modelo);
					imprimir("Unidades vendidas del producto\t : " + cUnidadesVendidas);
					imprimir("");
					imprimir("------------------------------------------------------");
				
			}
			
			posicionar();
			
			break;
		}
		case 3:{
			
			for(int i = 0 ; i < ap.tamanio() ; i++) {
				int codProducto = ap.obtener(i).getCodProducto();
				String modelo = ap.obtener(i).getModelo();
				double cImporteTotalVendido = ap.obtener(i).getImporteAcumulado();
				
					imprimir(""); 
					imprimir("C\u00F3digo de producto\t : " + codProducto);
					imprimir("Nombre de producto\t : " + modelo);
					imprimir("Importe total vendido\t : \u0024 " + cImporteTotalVendido);
					imprimir("");
					imprimir("------------------------------------------------------");
				
			}
			
			posicionar();
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoReporte);
		}
		
	}
	int leerReporte() {
		return cboReporte.getSelectedIndex();
	}
	//POSICIONA AL PRINCIPIO DE LA LISTA
	void posicionar() {
		txtS.setCaretPosition(0);
	}
	void limpiar() {
		txtS.setText("");
	}
	void imprimir(String s) {
		txtS.append(" " + s + "\n");
	}
	
	//METODO IMPRIMIR  
	
	protected void actionPerformedBtnImprimir(ActionEvent e) { 
		try {
	        boolean printed = txtS.print();
	        if (printed) {
	            JOptionPane.showMessageDialog(this, "Impresi\u00F3n exitosa", "Informaci\u00F3n", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, "La impresi\u00F3n no se complet\u00F3 correctamente", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (PrinterException e1) {
	        JOptionPane.showMessageDialog(this, "Error al imprimir: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        e1.printStackTrace();
	    }
	}
	protected void actionPerformedBtnRegresar(ActionEvent e) {
		dispose();
	}
}
