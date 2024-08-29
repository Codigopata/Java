package gui;

import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DlgVisitaPagina extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JLabel lblAutores;
	private JLabel lblLaghaso;
	protected JLabel lblUnSoftwarePersonalizado;
	protected JLabel lblAsesoramientoPromocionesY;
	protected JLabel lblWwwcodecoffeecompe;
	protected JButton btnEnlace;

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
			DlgVisitaPagina dialog = new DlgVisitaPagina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVisitaPagina() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgVisitaPagina.class.getResource("/recursos/WorldphoneLogo.png")));
		setTitle("Visita nuesta página web");
		setBounds(100, 100, 400, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblLaghaso = new JLabel("Coffee Code Solutions");
		lblLaghaso.setBounds(5, 28, 374, 23);
		lblLaghaso.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaghaso.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPanel.add(lblLaghaso);
		
		lblAutores = new JLabel("Visita nuestra p\u00E1gina web, donde te ofreceremos ");
		lblAutores.setBounds(0, 63, 394, 23);
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPanel.add(lblAutores);
		
		btnCerrar = new JButton(" ");
		btnCerrar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCerrar.setIcon(new ImageIcon(DlgVisitaPagina.class.getResource("/recursos/regresar.png")));
		btnCerrar.setBounds(new Rectangle(319, 197, 60, 45));
		btnCerrar.addActionListener(this);
		
		lblUnSoftwarePersonalizado = new JLabel("un software personalizado a la medida, ");
		lblUnSoftwarePersonalizado.setBounds(0, 95, 394, 15);
		lblUnSoftwarePersonalizado.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnSoftwarePersonalizado.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPanel.add(lblUnSoftwarePersonalizado);
		
		lblAsesoramientoPromocionesY = new JLabel("asesoramiento, promociones y m\u00E1s...");
		lblAsesoramientoPromocionesY.setBounds(0, 123, 394, 15);
		lblAsesoramientoPromocionesY.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsesoramientoPromocionesY.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPanel.add(lblAsesoramientoPromocionesY);
		
		lblWwwcodecoffeecompe = new JLabel("www.coffeecodesolutions.github.io/worldphone");
		lblWwwcodecoffeecompe.setBounds(0, 151, 394, 14);
		lblWwwcodecoffeecompe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWwwcodecoffeecompe.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPanel.add(lblWwwcodecoffeecompe);
		
		btnEnlace = new JButton("Ir al sitio");
		btnEnlace.setIcon(new ImageIcon(DlgVisitaPagina.class.getResource("/recursos/web.png")));
		btnEnlace.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnEnlace.setBounds(139, 196, 124, 45);
		btnEnlace.addActionListener(this);
		contentPanel.add(btnEnlace);
		contentPanel.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnlace) {
			actionPerformedBtnEnlace(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedBtnEnlace(ActionEvent e) {
		abrirEnlace("https://coffeecodesolutions.github.io/laghaso322/");
	}
	
	private void abrirEnlace(String url) {
	    try {
	        Desktop.getDesktop().browse(new java.net.URI(url));
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
}