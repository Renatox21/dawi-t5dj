package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FmrManteUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FmrManteUsuario frame = new FmrManteUsuario();
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
	public FmrManteUsuario() {
		setTitle("Mantenimiento de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo :");
		lblNewLabel_1.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre :");
		lblNewLabel_1_1.setBounds(10, 42, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido :");
		lblNewLabel_1_2.setBounds(10, 78, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Usuario :");
		lblNewLabel_1_3.setBounds(10, 114, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Clave :");
		lblNewLabel_1_4.setBounds(10, 149, 46, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Fecha :");
		lblNewLabel_1_4_1.setBounds(10, 178, 46, 14);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Tipo:");
		lblNewLabel_1_4_2.setBounds(10, 212, 46, 14);
		contentPane.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Estado :");
		lblNewLabel_1_4_3.setBounds(10, 247, 46, 14);
		contentPane.add(lblNewLabel_1_4_3);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 39, 174, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(66, 78, 174, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(66, 111, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(66, 146, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(66, 175, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(66, 209, 86, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(66, 244, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnNewButton.setBounds(319, 71, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				actualizar();				
			}
		});
		btnNewButton_1.setBounds(319, 107, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				eliminar();				
			}
		});
		btnNewButton_2.setBounds(319, 143, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Consultar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				consultar();				
			}
		});
		btnNewButton_3.setBounds(319, 178, 89, 23);
		contentPane.add(btnNewButton_3);
	}
	
	void registrar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = new Usuario();
		
		u.setNombre(txtNombre.getText());
		u.setApellido(txtApellido.getText());
		u.setUsuario(txtUsuario.getText());
		u.setClave(txtClave.getText());
		u.setFnacim(txtFecha.getText());
		u.setTipo(Integer.parseInt(txtTipo.getText()));
		u.setEstado(Integer.parseInt(txtEstado.getText()));
		
		em.getTransaction().begin();
		em.persist(u);		
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
	}
	
	void consultar() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = em.find(Usuario.class, Integer.parseInt(txtCodigo.getText()));
		
		if(u != null) {
			
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
			txtUsuario.setText(u.getUsuario());
			txtClave.setText(u.getClave());
			txtFecha.setText(u.getFnacim());
			txtTipo.setText(u.getTipo()+"");
			txtEstado.setText(u.getEstado()+"");
			
			
		}else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
		}
		
		em.close();
		fabrica.close();
		
	}
	
	void actualizar() {
		
		
		
	}
	void eliminar() {}
	
}
