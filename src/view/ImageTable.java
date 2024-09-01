package view;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageTable extends DefaultTableCellRenderer{
	@Override
	public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
		if(o instanceof JLabel) {
			JLabel lbl = (JLabel)o;
			return lbl;
		}
		return super.getTableCellRendererComponent(jtable, o, bln1, bln1, i1, i1);
	}
}
