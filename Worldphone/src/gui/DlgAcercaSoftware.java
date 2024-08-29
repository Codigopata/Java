package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;

import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class DlgAcercaSoftware extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblVersion;
	private JLabel lblDesarrolladora;
	private JLabel lblAutores;
	private JLabel lblPatricia;
	private JLabel lblMarcos;
	private JLabel lblSergio;
	private JLabel lblLeonardo;
	private JLabel lblAnthony;
	private JButton btnRegresar;

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
			DlgAcercaSoftware dialog = new DlgAcercaSoftware();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAcercaSoftware() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAcercaSoftware.class.getResource("/recursos/WorldphoneLogo.png")));
		setModal(true);
		setResizable(false);
		setTitle("Acerca del Software");
		setBounds(100, 100, 400, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblVersion = new JLabel("WorldPhone v.1.0");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVersion.setBounds(0, 12, 394, 22);
		contentPanel.add(lblVersion);
		
		lblDesarrolladora = new JLabel("Coffe Code Solutions");
		lblDesarrolladora.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrolladora.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDesarrolladora.setBounds(0, 40, 394, 23);
		contentPanel.add(lblDesarrolladora);
		
		lblAutores = new JLabel("Autores :");
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutores.setBounds(0, 68, 394, 23);
		contentPanel.add(lblAutores);
		
		lblPatricia = new JLabel("      Patricia Cuba Pirco      ");
		lblPatricia.setIcon(new ImageIcon(DlgAcercaSoftware.class.getResource("/recursos/usuario.png")));
		lblPatricia.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatricia.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblPatricia.setBounds(0, 100, 384, 35);
		contentPanel.add(lblPatricia);
		
		lblMarcos = new JLabel("   Marcos Serme\u00F1o Cruz    ");
		lblMarcos.setIcon(new ImageIcon(DlgAcercaSoftware.class.getResource("/recursos/usuario.png")));
		lblMarcos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcos.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblMarcos.setBounds(0, 140, 384, 35);
		contentPanel.add(lblMarcos);
		
		lblSergio = new JLabel("    Sergio Pe\u00F1a Yumbato    ");
		lblSergio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSergio.setIcon(new ImageIcon(DlgAcercaSoftware.class.getResource("/recursos/usuario.png")));
		lblSergio.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblSergio.setBounds(0, 180, 384, 35);
		contentPanel.add(lblSergio);
		
		lblLeonardo = new JLabel("Leonardo Pereyra Pacheco ");
		lblLeonardo.setIcon(new ImageIcon(DlgAcercaSoftware.class.getResource("/recursos/usuario.png")));
		lblLeonardo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeonardo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblLeonardo.setBounds(0, 220, 384, 35);
		contentPanel.add(lblLeonardo);
		
		lblAnthony = new JLabel("  Anthony Espinoza P\u00E9rez  ");
		lblAnthony.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnthony.setIcon(new ImageIcon(DlgAcercaSoftware.class.getResource("/recursos/usuario.png")));
		lblAnthony.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblAnthony.setBounds(0, 260, 384, 35);
		contentPanel.add(lblAnthony);
		
		btnRegresar = new JButton(" ");
		btnRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegresar.setForeground(SystemColor.activeCaptionText);
		btnRegresar.addActionListener(this);
		btnRegresar.setIcon(new ImageIcon(DlgAcercaSoftware.class.getResource("/recursos/regresar.png")));
		btnRegresar.setMargin(new Insets(25, 25, 30, 30));
		btnRegresar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnRegresar.setFocusable(false);
		btnRegresar.setBounds(new Rectangle(0, 0, 100, 50));
		btnRegresar.setBounds(323, 317, 60, 45);
		contentPanel.add(btnRegresar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegresar) {
		actionPerformedBtnRegresar(e);
		}
	}
	protected void actionPerformedBtnRegresar(ActionEvent e) {
		dispose();
	}
}