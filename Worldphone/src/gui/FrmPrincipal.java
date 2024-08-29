package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Toolkit;

public class FrmPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMant;
	private JMenu mnVentas;
	private JMenu mnReportes;
	private JMenu mnAyuda;
	private JMenuItem mntmClientes;
	private JMenuItem mntmSalir;
	private JMenuItem mntmProductos;
	private JMenuItem mntmVender;
	private JMenuItem mntmAcercaTienda;
	private JMenuItem mntmVisitaPagina;
	private JPanel contentPanel;
	private JLabel lblFondo;
	private JMenuItem mntmReportar;
	private JMenu mnAlmacen;
	private JMenuItem mntmAlmacenar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	    	
	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/recursos/WorldphoneLogo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	// Bloquea el cierre del programa al presionar la 'X'
		setTitle("WorldPhone - Comunica al mundo entero");
		setBounds(100, 100, 1100, 750);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu(" Archivo  ");
		mnArchivo.setForeground(new Color(0, 0, 0));
		mnArchivo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mnArchivo.setPreferredSize(new Dimension(mnArchivo.getPreferredSize().width, 25));
		mnArchivo.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/salida.png")));
		mntmSalir.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmSalir.setHorizontalAlignment(SwingConstants.CENTER);
		mntmSalir.setPreferredSize(new Dimension(mntmSalir.getPreferredSize().width, 45));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMant = new JMenu(" Mantenimiento ");
		mnMant.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mnMant.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnMant);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/clientes.png")));
		mntmClientes.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmClientes.setPreferredSize(new Dimension(mntmClientes.getPreferredSize().width, 45));
		mntmClientes.addActionListener(this);
		mnMant.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/productos.png")));
		mntmProductos.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmProductos.setPreferredSize(new Dimension(mntmProductos.getPreferredSize().width, 45));
		mntmProductos.addActionListener(this);
		mnMant.add(mntmProductos);
		
		mnVentas = new JMenu(" Ventas ");
		mnVentas.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mnVentas.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/ventas.png")));
		mntmVender.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmVender.setPreferredSize(new Dimension(mntmVender.getPreferredSize().width, 45));
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mnAlmacen = new JMenu(" Almacén ");
		mnAlmacen.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mnAlmacen.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnAlmacen);
		
		mntmAlmacenar = new JMenuItem("Almacenar");
		mntmAlmacenar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/almacen.png")));
		mntmAlmacenar.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmAlmacenar.setPreferredSize(new Dimension(mntmAlmacenar.getPreferredSize().width, 45));
		mntmAlmacenar.addActionListener(this);
		mnAlmacen.add(mntmAlmacenar);
		
		mnReportes = new JMenu(" Reportes ");
		mnReportes.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mnReportes.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnReportes);
		
		mntmReportar = new JMenuItem("Reportar");
		mntmReportar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/reportes.png")));
		mntmReportar.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmReportar.setPreferredSize(new Dimension(mntmReportar.getPreferredSize().width, 45));
		mntmReportar.addActionListener(this);
		mnReportes.add(mntmReportar);
		
		mnAyuda = new JMenu(" Ayuda ");
		mnAyuda.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mnAyuda.setForeground(new Color(0, 0, 0));
		mnAyuda.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnAyuda);
		
		mntmAcercaTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaTienda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/acerca.png")));
		mntmAcercaTienda.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmAcercaTienda.setPreferredSize(new Dimension(mntmAcercaTienda.getPreferredSize().width, 45));
		mntmAcercaTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaTienda);
		
		mntmVisitaPagina = new JMenuItem("Visita nuestra Web");
		mntmVisitaPagina.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/pagina.png")));
		mntmVisitaPagina.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmVisitaPagina.setPreferredSize(new Dimension(mntmVisitaPagina.getPreferredSize().width, 45));
		mntmVisitaPagina.addActionListener(this);
		mnAyuda.add(mntmVisitaPagina);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(252, 252, 252));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "Fondo");
		contentPanel.setLayout(null);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/Fondo.gif")));
		lblFondo.setBounds(0, 0, 1094, 699);
		contentPanel.add(lblFondo);
		
		addWindowListener(new WindowAdapter() {		// Cerrar toda la aplicacion desde el DefaultClose
            public void windowClosing(WindowEvent e) {
                goExit();
            }
        });
		setLocationRelativeTo(null);	// Centra en pantalla la ventana principal
	}
	
	//	Metodos publicos tipo Action que invocan los metodos de todos los Menus 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) actionPerformedMntmSalir(e);
	    if (e.getSource() == mntmClientes) actionPerformedMntmClientes(e);
		if (e.getSource() == mntmProductos) actionPerformedMntmProductos(e);
		if (e.getSource() == mntmVender) actionPerformedMntmVender(e);
		if (e.getSource() == mntmAlmacenar)actionPerformedMntmAlmacenar(e);
		if (e.getSource() == mntmReportar) actionPerformedMntmReportar(e);
		if (e.getSource() == mntmAcercaTienda) actionPerformedMntmAcercaTienda(e);
		if (e.getSource() == mntmVisitaPagina) actionPerformedMntmVisitaPagina(e);
	}
	
	//	Metodos que ejecutan cada Menu
	protected void actionPerformedMntmSalir(ActionEvent e) {	// Cerrar toda la aplicacion
		goExit();
	}
	protected void actionPerformedMntmClientes(ActionEvent e) {	// Abrir Menu Clientes
		DlgMantClientes mc = new DlgMantClientes();
		setMenu(mc);
	}
	protected void actionPerformedMntmProductos(ActionEvent e) {	// Abrir Menu Productos
		DlgMantProductos mp = new DlgMantProductos();
		setMenu(mp);
	}
	protected void actionPerformedMntmVender(ActionEvent e) {	// Abrir Menu Vender
		DlgVentVender mv = new DlgVentVender();
		setMenu(mv);
	}
	protected void actionPerformedMntmAlmacenar(ActionEvent e) {	// Abrir Menu Almacenar
		DlgAlmacenVentana ma = new DlgAlmacenVentana();
		setMenu(ma);
	}
	protected void actionPerformedMntmReportar(ActionEvent e) {	// Abrir Menu Reportar
		DlgReportes mr = new DlgReportes();
		setMenu(mr);
	}
	protected void actionPerformedMntmAcercaTienda(ActionEvent e) {	// Abrir Menu Acerca de tienda
		DlgAcercaSoftware at = new DlgAcercaSoftware();
		setMenu(at);
	}
	protected void actionPerformedMntmVisitaPagina(ActionEvent e) {	// Abrir Menu Visitar pagina
		DlgVisitaPagina vp = new DlgVisitaPagina();
		setMenu(vp);
	}
	
	void setMenu(JDialog i) {	//	Metodo setMenu que establece setter a cada Menu
		i.setModal(true);
		i.setLocationRelativeTo(this);
		i.setVisible(true);
	}
	
	private void goExit() {	//	Metodo goExit : pregunta si saldras o no del programa : usado en 2 metodos
		Object[] options = { "Si", "No" };
		int cExit = JOptionPane.showOptionDialog(
		        this,
		        "\u00BFEstá seguro(a) que desea salir de la aplicación\u003F",
		        "Salir",
		        JOptionPane.YES_NO_OPTION,
		        JOptionPane.QUESTION_MESSAGE,
		        null,
	            options, 
	            options[0]
		 );
		    if (cExit == JOptionPane.YES_OPTION) {
		        System.exit(0);
		    }
	}
}
