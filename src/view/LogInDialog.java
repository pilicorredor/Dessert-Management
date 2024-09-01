package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LogInDialog extends JDialog {

	private JLabel txtGuia;
	private JTextField name;
	private JButton btnAccept, btnCancel;
	
	public LogInDialog(ActionListener listener) {
		this.setSize(400, 100);
		this.setTitle("Iniciar Sesión");
		this.initComponents(listener);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(2, 2));
		
		txtGuia = new JLabel("Nombre: ");
		add(txtGuia);
		
		name = new JTextField(20);
		add(name);
		
		btnAccept = new JButton("Aceptar");
		btnAccept.setActionCommand("accept");
		btnAccept.addActionListener(listener);
		add(btnAccept);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setActionCommand("cancel");
		btnCancel.addActionListener(listener);
		add(btnCancel);
	}
	
	public String getNameUser() {
		return name.getText();
	}
	
	public void close() {
		this.dispose();
	}
	
}
