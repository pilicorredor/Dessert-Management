package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Client;
import model.InfoEnterprise;

public class DialogBill extends JDialog{
	private JLabel txtNameEnterprise, lblLogo, nameClient, costTotal;
	private JPanel contacts;
	private TableBill tableOrder;
	private JPanel auxPanel;
	private JButton accept;
	
	public DialogBill(InfoEnterprise infoEnt, Client client, int total, ArrayList<ArrayList<Object>> orderClient, ActionListener listener) {
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setSize(500, 600);
		initComponents(infoEnt, client, total, orderClient, listener);
	}
	
	public void initComponents(InfoEnterprise infoEnt, Client client, int total, ArrayList<ArrayList<Object>> orderClient, ActionListener listener) {
		auxPanel = new JPanel();
		auxPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		lblLogo = new JLabel();
		lblLogo.setSize(new Dimension (350, 250));
		lblLogo.setIcon(this.setImageSize(infoEnt.getLogo(), lblLogo));
		auxPanel.add(lblLogo, gbc1);
		nameClient = new JLabel("Nombre del Cliente: " + client.getName());
		gbc1.gridy = 1;
		auxPanel.add(nameClient, gbc1);
		
		add(auxPanel, BorderLayout.NORTH);
		
		tableOrder = new TableBill(orderClient);
		add(tableOrder, BorderLayout.CENTER);
		
		auxPanel = new JPanel();
		auxPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		costTotal = new JLabel("Total: " + total);
		auxPanel.add(costTotal, gbc);
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		txtNameEnterprise = new JLabel(infoEnt.getName() + "          ");
		auxPanel.add(txtNameEnterprise, gbc);
		contacts = this.getContactsList(infoEnt.getContacts());
		gbc.gridx = 1;
		auxPanel.add(contacts, gbc);
		accept = new JButton("Aceptar");
		accept.setActionCommand("AcceptBill");
		accept.addActionListener(listener);
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		auxPanel.add(accept, gbc);
		add(auxPanel, BorderLayout.SOUTH);
	}
	
	private JPanel getContactsList(long[] contactsList) {
		contacts = new JPanel();
		contacts.setLayout(new BoxLayout(contacts, BoxLayout.Y_AXIS));
		contacts.add(new JLabel("Contactenos: "));
		for (int i = 0; i < contactsList.length; i++) {
			contacts.add(new JLabel("" + contactsList[i]));
		}
		return contacts;
	}
	
	public ImageIcon setImageSize(String url, JLabel label) {
		ImageIcon icon = new ImageIcon(url);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		return newImc;
	}
	
	public void closeBill() {
		this.dispose();
	}
	
}
