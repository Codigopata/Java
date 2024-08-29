package gui;	// Encargado: Sergio Pena

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import arreglos.*;
import clases.*;

public class DlgAlmacenVentana extends JDialog implements ActionListener, ItemListener {
    private static final long serialVersionUID = 1L;
    private ArregloProductos ap;

    private JPanel panelActualizarStock;
    private JComboBox<Integer> cboCodigo;
    private JTextField txtProducto;
    private JTextField txtPrecio;
    private JTextField txtStockActual;
    private JTextField txtStockMinimo;
    private JTextField txtStockMaximo;
    private JTextField txtCantidadNueva;
    private JButton btnIngresarCantidad;
    private JLabel lblCboProducto;
    private JLabel lblProducto;
    private JLabel lblPrecio;
    private JLabel lblStockActual;
    private JLabel lblStockMinimo;
    private JLabel lblStockMaximo;
    private JLabel lblCantidadNueva;
    private JPanel panelTitulo;
    private JLabel lblTitulo;
    private JButton btnRegresar;
    private JPanel panelBotones;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	try {
    		UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
    	} catch (Throwable e) {
    		e.printStackTrace();
    	}
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    DlgAlmacenVentana ventana = new DlgAlmacenVentana();
                    ventana.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the dialog.
     */
    public DlgAlmacenVentana() {
        super((Frame) null, "Almacen", true);
        setTitle("Almacén");
        setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlmacenVentana.class.getResource("/recursos/WorldphoneLogo.png")));
        this.ap = new ArregloProductos();

        setBackground(new Color(255, 255, 255));
        setBounds(100, 100, 420, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panelActualizarStock = new JPanel();
        panelActualizarStock.setBackground(UIManager.getColor("Button.background"));
        panelActualizarStock.setLayout(null);
        getContentPane().add(panelActualizarStock);

        lblCboProducto = new JLabel("C\u00F3digo");
        lblCboProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblCboProducto.setBounds(15, 60, 130, 25);
        panelActualizarStock.add(lblCboProducto);

        lblProducto = new JLabel("Producto");
        lblProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblProducto.setBounds(15, 120, 100, 25);
        panelActualizarStock.add(lblProducto);

        lblPrecio = new JLabel("Precio \u0024");
        lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblPrecio.setBounds(15, 180, 58, 25);
        panelActualizarStock.add(lblPrecio);

        lblStockActual = new JLabel("Stock Actual");
        lblStockActual.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblStockActual.setBounds(220, 180, 86, 25);
        panelActualizarStock.add(lblStockActual);

        lblStockMinimo = new JLabel("Stock M\u00EDnimo");
        lblStockMinimo.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblStockMinimo.setBounds(15, 240, 86, 25);
        panelActualizarStock.add(lblStockMinimo);

        lblStockMaximo = new JLabel("Stock M\u00E1ximo");
        lblStockMaximo.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblStockMaximo.setBounds(220, 240, 86, 25);
        panelActualizarStock.add(lblStockMaximo);

        lblCantidadNueva = new JLabel("Adicionar Stock");
        lblCantidadNueva.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblCantidadNueva.setBounds(220, 60, 110, 25);
        panelActualizarStock.add(lblCantidadNueva);

        cboCodigo = new JComboBox<Integer>();
        cboCodigo.setFont(new Font("Dialog", Font.PLAIN, 14));
        cboCodigo.setBackground(new Color(255, 255, 255));
        cboCodigo.setBounds(15, 85, 180, 25);
        cboCodigo.addItemListener(this);
        panelActualizarStock.add(cboCodigo);

        txtProducto = new JTextField();
        txtProducto.setFont(new Font("Dialog", Font.PLAIN, 14));
        txtProducto.setEditable(false);
        txtProducto.setBounds(15, 145, 385, 25);
        panelActualizarStock.add(txtProducto);

        txtPrecio = new JTextField();
        txtPrecio.setFont(new Font("Dialog", Font.PLAIN, 14));
        txtPrecio.setEditable(false);
        txtPrecio.setBounds(15, 205, 180, 25);
        txtPrecio.setHorizontalAlignment(JTextField.RIGHT);
        panelActualizarStock.add(txtPrecio);

        txtStockActual = new JTextField();
        txtStockActual.setFont(new Font("Dialog", Font.PLAIN, 14));
        txtStockActual.setEditable(false);
        txtStockActual.setBounds(220, 205, 180, 25);
        txtStockActual.setHorizontalAlignment(JTextField.RIGHT);
        panelActualizarStock.add(txtStockActual);

        txtStockMinimo = new JTextField();
        txtStockMinimo.setFont(new Font("Dialog", Font.PLAIN, 14));
        txtStockMinimo.setEditable(false);
        txtStockMinimo.setBounds(15, 265, 180, 25);
        txtStockMinimo.setHorizontalAlignment(JTextField.RIGHT);
        panelActualizarStock.add(txtStockMinimo);

        txtStockMaximo = new JTextField();
        txtStockMaximo.setFont(new Font("Dialog", Font.PLAIN, 14));
        txtStockMaximo.setEditable(false);
        txtStockMaximo.setBounds(220, 265, 180, 25);
        txtStockMaximo.setHorizontalAlignment(JTextField.RIGHT);
        panelActualizarStock.add(txtStockMaximo);

        txtCantidadNueva = new JTextField();
        txtCantidadNueva.setFont(new Font("Dialog", Font.PLAIN, 14));
        txtCantidadNueva.setBounds(220, 85, 180, 25);
        txtCantidadNueva.setHorizontalAlignment(JTextField.RIGHT);
        panelActualizarStock.add(txtCantidadNueva);

        panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(30, 144, 255));
        panelTitulo.setBounds(0, 0, 414, 50);
        panelActualizarStock.add(panelTitulo);
        panelTitulo.setLayout(new BorderLayout(0, 0));

        lblTitulo = new JLabel("Gesti\u00F3n de Almac\u00E9n");
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Roboto", Font.BOLD, 25));
        
        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBackground(new Color(30, 144, 255));
        panelBotones.setBounds(0, 308, 414, 65);
        panelActualizarStock.add(panelBotones);
        
        btnRegresar = new JButton(" ");
        btnRegresar.setBounds(343, 12, 60, 45);
        panelBotones.add(btnRegresar);
        btnRegresar.addActionListener(this);
        btnRegresar.setIcon(new ImageIcon(DlgAlmacenVentana.class.getResource("/recursos/regresar.png")));
        
                btnIngresarCantidad = new JButton("Agregar");
                btnIngresarCantidad.setBounds(12, 10, 130, 45);
                panelBotones.add(btnIngresarCantidad);
                btnIngresarCantidad.setIcon(new ImageIcon(DlgAlmacenVentana.class.getResource("/recursos/agregar.png")));
                btnIngresarCantidad.setFont(new Font("Dialog", Font.BOLD, 16));
                btnIngresarCantidad.addActionListener(this);
        

    
        PlainDocument doc = (PlainDocument) txtCantidadNueva.getDocument();
        doc.setDocumentFilter(new NumberFilter());

        // Seleccionar opción por defecto y cargar datos
        listarCboProducto();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIngresarCantidad) {
            procesarIngresoStock();
        }
        if (e.getSource() == btnRegresar) {
        	actionPerformedBtnRegresar();
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cboCodigo) {
            actualizarDatosProducto();
        }
    }

    private void procesarIngresoStock() {
        try {
            int codigoProducto = (int) cboCodigo.getSelectedItem();
            String cantidadTexto = txtCantidadNueva.getText().trim();

            if (cantidadTexto.isEmpty()) {
                JOptionPane.showMessageDialog(panelActualizarStock,
                        "No se ingreso ning\u00FAn valor.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int cantidad = Integer.parseInt(cantidadTexto);

            if (cantidad < 0) {
                JOptionPane.showMessageDialog(panelActualizarStock,
                        "Por favor, ingrese una cantidad mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cantidad == 0) {
                JOptionPane.showMessageDialog(panelActualizarStock,
                        "La cantidad ingresada es 0. El stock actual no cambiar\u00E1.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Producto producto = ap.buscar(codigoProducto);
            if (producto != null) {
                int stockActual = producto.getStockActual();
                int stockMaximo = producto.getStockMaximo();
                int stockMinimo = producto.getStockMinimo();

                if (stockActual < stockMinimo && cantidad < (stockMinimo - stockActual)) {
                    JOptionPane.showMessageDialog(panelActualizarStock,
                            "La cantidad ingresada no es suficiente para alcanzar el stock m\u00EDnimo. Ingrese al menos " + (stockMinimo - stockActual) + " unidades.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else if (stockActual + cantidad > stockMaximo) {
                    int exceso = (stockActual + cantidad) - stockMaximo;
                    JOptionPane.showMessageDialog(panelActualizarStock,
                            "No se pudo ingresar el stock porque se ha superado el stock m\u00E1ximo por " + exceso + " unidades.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    producto.setStockActual(stockActual + cantidad);
                    txtStockActual.setText(String.valueOf(producto.getStockActual()));
                    JOptionPane.showMessageDialog(panelActualizarStock,
                            "Stock ingresado correctamente.\nSe han a\u00F1adido " + cantidad + " unidades.",
                            "Confirmaci\u00F3n", JOptionPane.INFORMATION_MESSAGE);

                    // Actualizar productos.txt
                    ap.ActualizarArchivo();

                    // Limpiar textfield de cantidad
                    txtCantidadNueva.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(panelActualizarStock,
                        "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panelActualizarStock,
                    "Por favor ingrese una cantidad num\u00E9rica v\u00E1lida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void actualizarDatosProducto() {
        int codigoProducto = (int) cboCodigo.getSelectedItem();
        Producto producto = ap.buscar(codigoProducto);
            txtProducto.setText(producto.getModelo());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
            txtStockActual.setText(String.valueOf(producto.getStockActual()));
            txtStockMinimo.setText(String.valueOf(producto.getStockMinimo()));
            txtStockMaximo.setText(String.valueOf(producto.getStockMaximo()));
    }
    
	void listarCboProducto() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < ap.tamanio(); i++) {
			cboCodigo.addItem(ap.obtener(i).getCodProducto());
		}
	}

    // Clase para filtrar valores numericos
    class NumberFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string == null) {
                return;
            }
            if (isNumeric(string)) {
                super.insertString(fb, offset, string, attr);
            } else {
                JOptionPane.showMessageDialog(panelActualizarStock,
                        "Por favor, aseg\u00FArese de ingresar cantidades v\u00E1lidas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text == null) {
                return;
            }
            if (isNumeric(text)) {
                super.replace(fb, offset, length, text, attrs);
            } else {
                JOptionPane.showMessageDialog(panelActualizarStock,
                        "Por favor, aseg\u00FArese de ingresar cantidades v\u00E1lidas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }

        private boolean isNumeric(String text) {
            for (char c : text.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
    }
	protected void actionPerformedBtnRegresar() {
		dispose();
	}
}
