package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends BackgroundPanel{
	private JTable table;
	private String[] titleColumn;
	private Object[][] dataDesserts;
	
	public TablePanel(Object[][] dataDessert) {
		table = new JTable();
		table.setRowHeight(100);
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		initComponents(dataDessert);
	}
	
	public void initComponents(Object[][] dataDessert) {
		this.setTitleColumn();
		this.dataDesserts = this.setDataDesserts(dataDessert);
		table.setDefaultRenderer(Object.class, new ImageTable());
		DefaultTableModel tm = new DefaultTableModel(setDataDesserts(dataDessert), titleColumn);
		table.setModel(tm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private String[] setTitleColumn() {
		return titleColumn = new String [] {"Nombre del Producto", "Imagen", "Precio", "Número de Productos Disponibles"};
	}
	
	private Object[][] setDataDesserts(Object[][] dataDessert){
		Object[][] auxDataDesserts = new Object[dataDessert.length][dataDessert[0].length];
		for (int i = 0; i < dataDessert.length; i++) {
			auxDataDesserts[i][0] = dataDessert[i][0];
			auxDataDesserts[i][1] = new JLabel(this.setImageSize(dataDessert, i));
			auxDataDesserts[i][2] = dataDessert[i][2];
			auxDataDesserts[i][3] = dataDessert[i][3];
		}
		return auxDataDesserts;
	}
	
	public ImageIcon setImageSize(Object[][] dataDessert, int i) {
		ImageIcon icon = new ImageIcon(dataDessert[i][1].toString());
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(table.getRowHeight(), table.getRowHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		return newImc;
	}
	
}
