package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Dessert;

public class TableBill extends JPanel {
	private JTable table;
	private String[] titleColumn;
	private Object[][] dataDesserts;
	
	public TableBill(ArrayList<ArrayList<Object>> orderClient) {
		table = new JTable();
		table.setRowHeight(30);
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		initComponents(orderClient);
	}
	
	public void initComponents(ArrayList<ArrayList<Object>> orderClient) {
		this.setTitleColumn();
		this.dataDesserts = this.setDataDesserts(orderClient);
		table.setDefaultRenderer(Object.class, new ImageTable());
		DefaultTableModel tm = new DefaultTableModel(setDataDesserts(orderClient), titleColumn);
		table.setModel(tm);
		table.setPreferredScrollableViewportSize(new Dimension(100, 30));
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private String[] setTitleColumn() {
		return titleColumn = new String [] {"Número de Productos", "Nombre del Producto", "Precio Unitario"};
	}
	
	private Object[][] setDataDesserts(ArrayList<ArrayList<Object>> orderClient){
		ArrayList<Dessert> auxList = new ArrayList<Dessert>();
		ArrayList<Integer> auxListQuantity = new ArrayList<>();
		for (int i = 0; i < orderClient.get(0).size(); i++) {
			auxList.add(i, (Dessert) orderClient.get(0).get(i));
			auxListQuantity.add(i, (Integer) orderClient.get(1).get(i));
		}
		
		Object[][] auxDataDesserts = new Object[auxList.size()][3];
		for (int i = 0; i < auxList.size(); i++) {
			auxDataDesserts[i][0] = auxListQuantity.get(i);
			auxDataDesserts[i][1] = auxList.get(i).getName();
			auxDataDesserts[i][2] = auxList.get(i).getPrice();
		}
		return auxDataDesserts;
	}
}
