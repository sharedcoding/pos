package com.jeet.model;

import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.jeet.model.bean.DataRow;
import com.jeet.model.bean.ItemDataRow;
import com.jeet.model.contentprovider.ContentProvider;

public class BillingTableModel extends DefaultTableModel {

	public BillingTableModel(Object[] colnames, int rowCount) {
		super(colnames, rowCount);
		this.rowCount = rowCount;
		this.addTableModelListener(new TableModelListenerImpl());
	}

	private int rowCount = 1;

	public void incrementRow() {
		setRowCount(++rowCount);
		fireTableDataChanged();
	}

	public void decrementRow() {
		if (rowCount > 0) {
			setRowCount(--rowCount);
			fireTableDataChanged();
		}
	};

	public Class getColumnClass(int colIndex) {
		if (colIndex == 6)
			return Boolean.class;
		return super.getColumnClass(colIndex);
	}

	public void setValueAt(Object obj, int row, int col) {
		if (col == 2 || col == 3 || col == 4 || col == 5) {
			try {
				Integer.valueOf(obj + "");
			} catch (Exception e) {
				super.setValueAt(0, row, col);
				return;
			}
		}
		super.setValueAt(obj, row, col);
	}

	class TableModelListenerImpl implements TableModelListener {

		public void tableChanged(TableModelEvent e) {
			switch (e.getColumn()) {
			case 0:
				String id = getValueAt(e.getFirstRow(), 0).toString();
				Vector<DataRow> dataRowVec = ContentProvider
						.getContentResolver().executeSelect(
								DataRow.ITEM_ROW_TYPE, "where itemId='" + id+"'");
				if (dataRowVec != null && dataRowVec.size() > 0) {
					ItemDataRow dataRow = (ItemDataRow) dataRowVec.elementAt(0);
					setValueAt(dataRow.getItemName(), e.getFirstRow(), 1);
					setValueAt(dataRow.getPrice(), e.getFirstRow(), 2);
					setValueAt(dataRow.getDiscount(), e.getFirstRow(), 3);
					setValueAt(1, e.getFirstRow(), 4);
					setValueAt(
							getFinalPrice(dataRow.getPrice(),
									dataRow.getDiscount(), 1), e.getFirstRow(),
							5);
					setValueAt(false, e.getFirstRow(), 6);
				} else {
					setValueAt("", e.getFirstRow(), 1);
					setValueAt("", e.getFirstRow(), 2);
					setValueAt("", e.getFirstRow(), 3);
					setValueAt("", e.getFirstRow(), 4);
					setValueAt("", e.getFirstRow(), 5);
					setValueAt(true, e.getFirstRow(), 6);
				}
				break;
			case 2:
			case 3:
			case 4:
				Object priceObj = getValueAt(e.getFirstRow(), 2);
				Object disObj = getValueAt(e.getFirstRow(), 3);
				Object quantityObj = getValueAt(e.getFirstRow(), 4);
				if (priceObj != null && priceObj != "" && disObj != null
						&& disObj != "" && quantityObj != null
						&& quantityObj != "") {
					int priceVal = Integer.parseInt("" + priceObj);
					int disVal = Integer.parseInt("" + disObj);
					int quantityVal = Integer.parseInt("" + quantityObj);
					setValueAt(getFinalPrice(priceVal, disVal, quantityVal),
							e.getFirstRow(), 5);
				}
				break;
			}
		}

		private int getFinalPrice(int mrp, int dis, int quantity) {
			return (mrp - (mrp * dis / 100)) * quantity;
		}

	}
}
