package com.jeet.view.billing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.jeet.infra.Activity;
import com.jeet.infra.Fragment;
import com.jeet.model.BillingTableModel;
import com.jeet.model.bean.BillNumRowData;
import com.jeet.model.bean.DataRow;
import com.jeet.model.bean.ItemDataRow;
import com.jeet.model.contentprovider.ContentProvider;
import com.jeet.model.db.procedure.MyStoredProcedures;

public class BillingInfoPaneFragment extends Fragment {

	private BillNumberPanel billNumberPanel;
	private CustomerInfoPanel customerInfoPanel;
	private ItemTablePanel itemTablePanel;
	private BillingDetailPanel billingDetailPanel;
	private Activity activity;

	public void onCreate() {
		super.onCreate();
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(800, 575));
		init();
	}

	private void init() {
		billNumberPanel = new BillNumberPanel();
		this.add(billNumberPanel);
		customerInfoPanel = new CustomerInfoPanel();
		this.add(customerInfoPanel);
		itemTablePanel = new ItemTablePanel();
		this.add(itemTablePanel);
		billingDetailPanel = new BillingDetailPanel();
		this.add(billingDetailPanel);
	}
	
	public void onBind(Activity activity){
		this.activity = activity;
	}

	public void onDestroy() {
		super.onDestroy();
		billNumberPanel.removeAll();
		customerInfoPanel.removeAll();
		itemTablePanel.removeAll();
		billingDetailPanel.removeAll();
	}

	void save() {
		DefaultTableModel model = itemTablePanel.model;
		Vector<DataRow> rows = new Vector<DataRow>();
		for (int i = 0; i < model.getRowCount(); i++) {
			Object isSelectedToUpdate = model.getValueAt(i, 6);
			if (isSelectedToUpdate != null && ((Boolean) isSelectedToUpdate)) {
				ItemDataRow row = new ItemDataRow(model.getValueAt(i, 0)
						.toString(), model.getValueAt(i, 1).toString(),
						Integer.parseInt(model.getValueAt(i, 2).toString()),
						Integer.parseInt(model.getValueAt(i, 3).toString()));
				rows.add(row);
			}
		}
		if (!rows.isEmpty()) {
			ContentProvider.getContentResolver().executeUpdate(rows);
		}

	}

	void billNumUpdate() {
		/*MyStoredProcedures.dropAllProcedures();
		MyStoredProcedures.createAllProcedures();
		ContentProvider.getContentResolver().createDataBase();
		*/Vector<DataRow> v = new Vector<DataRow>();
		v.add(new BillNumRowData(0));
		ContentProvider.getContentResolver().executeUpdate(v);
		activity.getIntent().putExtra("TABLE_MODEL", itemTablePanel.model);
		activity.getIntent().putExtra("BILL_NUM", billNumberPanel.billNumTxt.getText());
		
	}

	private class BillNumberPanel extends JPanel {
		private JLabel billNumLbl;
		private JTextField billNumTxt;
		private JLabel dateHeadingLbl;
		private JLabel dateLbl;

		BillNumberPanel() {
			this.setLayout(new GridBagLayout());
			billNumLbl = new JLabel("Bill Number:");
			Vector<DataRow> rows = ContentProvider.getContentResolver().executeSelect(DataRow.BILL_NUMBER_ROW_TYPE, "");
			billNumTxt = new JTextField("JMC-"+ ((BillNumRowData)rows.elementAt(0)).getBillNum());
			billNumTxt.setEnabled(false);
			billNumTxt.setPreferredSize(new Dimension(80, 25));
			dateHeadingLbl = new JLabel("Date: ");
			DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String datee = dFormat.format(date);
			dateLbl = new JLabel(datee);
			JLabel dummy = new JLabel();
			dummy.setPreferredSize(new Dimension(500, 25));

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			this.add(billNumLbl, c);
			c.gridx = 1;
			this.add(billNumTxt);

			c.gridx = 2;
			this.add(dummy);

			c.gridx = 3;
			this.add(dateHeadingLbl, c);
			c.gridx = 4;
			this.add(dateLbl, c);

			setPreferredSize(new Dimension(800, 30));
			this.setBorder(BorderFactory.createRaisedBevelBorder());
		}
	}

	private class ItemTablePanel extends JPanel {
		private JScrollPane pane;
		private JButton addBtn;
		private JButton removeBtn;
		private BillingTableModel model;

		ItemTablePanel() {
			setLayout(new BorderLayout());
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			String[] colNames = new String[] { "Item Code", "Item Name", "MRP",
					"Discount(%)", "Quantity", "Final Price", "Update" };
			model = new BillingTableModel(colNames, 10);
			model.addTableModelListener(new TableModelListenerImpl());
			BillingTable table = new BillingTable(model);
			pane = new JScrollPane(table);
			pane.setPreferredSize(new Dimension(800, 280));
			this.add(pane, BorderLayout.PAGE_START);
			addBtn = new JButton("+");
			this.add(addBtn, BorderLayout.EAST);
			addBtn.setPreferredSize(new Dimension(400, 15));
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					model.incrementRow();
				}
			});

			removeBtn = new JButton("-");
			this.add(removeBtn, BorderLayout.WEST);
			removeBtn.setPreferredSize(new Dimension(400, 15));
			removeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					model.decrementRow();
				}
			});
			setPreferredSize(new Dimension(800, 300));
		}
	}

	private class CustomerInfoPanel extends JPanel {
		private JLabel nameLbl;
		private JTextField nameTxt;
		private JLabel phLbl;
		private JTextField phTxt;

		private JLabel addressLbl;
		private JTextField addresstxt;

		CustomerInfoPanel() {
			setBorder(BorderFactory.createLineBorder(Color.black));
			nameLbl = new JLabel("Name:        ");
			nameTxt = new JTextField();
			phLbl = new JLabel("Phone Number:");
			phTxt = new JTextField();
			addressLbl = new JLabel("Address:      ");
			addresstxt = new JTextField();
			nameLbl.setPreferredSize(new Dimension(100, 25));
			nameTxt.setPreferredSize(new Dimension(650, 25));
			phTxt.setPreferredSize(new Dimension(650, 25));
			phLbl.setPreferredSize(new Dimension(100, 25));
			addressLbl.setPreferredSize(new Dimension(100, 25));
			addresstxt.setPreferredSize(new Dimension(650, 30));
			this.add(nameLbl);
			this.add(nameTxt);
			this.add(phLbl);
			this.add(phTxt);
			this.add(addressLbl);
			this.add(addresstxt);
			this.setPreferredSize(new Dimension(800, 100));
		}
	}

	private class BillingDetailPanel extends JPanel {
		private JLabel totalItemsLbl;
		private JLabel totalItems;
		private JLabel billAmountLbl;
		private JLabel billAmount;
		private JLabel discountLbl;
		private JLabel discount;
		private JLabel totalBillLbl;
		private JLabel totalBill;

		BillingDetailPanel() {
			setBorder(BorderFactory.createEtchedBorder());
			totalItemsLbl = new JLabel("Number of Items:");
			totalItems = new JLabel("");
			billAmountLbl = new JLabel("Bill Amount:");
			billAmount = new JLabel("");
			discountLbl = new JLabel("Discounts:");
			discount = new JLabel("");
			totalBillLbl = new JLabel("Final Bill Amount:");
			totalBill = new JLabel("");

			totalItemsLbl.setPreferredSize(new Dimension(300, 25));
			this.add(totalItemsLbl);
			totalItems.setPreferredSize(new Dimension(300, 25));
			this.add(totalItems);

			billAmountLbl.setPreferredSize(new Dimension(300, 25));
			this.add(billAmountLbl);
			billAmount.setPreferredSize(new Dimension(300, 25));
			this.add(billAmount);

			discountLbl.setPreferredSize(new Dimension(300, 25));
			this.add(discountLbl);
			discount.setPreferredSize(new Dimension(300, 25));
			this.add(discount);

			totalBillLbl.setPreferredSize(new Dimension(300, 25));
			this.add(totalBillLbl);
			totalBill.setPreferredSize(new Dimension(300, 25));
			this.add(totalBill);

			this.setPreferredSize(new Dimension(800, 125));
		}

	}

	public class TableModelListenerImpl implements TableModelListener {

		public void tableChanged(TableModelEvent e) {
			if (e.getColumn() == 4 || e.getColumn() == 5) {

				int noOfItems = 0;
				int totalPrice = 0;
				int discounts = 0;
				int mrpVal = 0;
				for (int i = 0; i < itemTablePanel.model.getRowCount(); i++) {
					Object itemObj = itemTablePanel.model.getValueAt(i, 4);
					Object priceObj = itemTablePanel.model.getValueAt(i, 5);
					Object mrpObj = itemTablePanel.model.getValueAt(i, 2);

					if (itemObj != null && itemObj != "" && priceObj != null
							& priceObj != "") {
						int items = Integer.parseInt(itemObj.toString());
						noOfItems += items;

						int price = Integer.parseInt(priceObj.toString());
						totalPrice += price;

						int mrp = Integer.parseInt(mrpObj.toString());
						discounts += ((mrp * items) - price);

						mrpVal += (mrp * items);

						System.out.println(noOfItems + "   " + totalPrice);
						billingDetailPanel.billAmount.setText(mrpVal + "");
						billingDetailPanel.discount.setText(discounts + "");
						billingDetailPanel.totalBill.setText(totalPrice + "");
						billingDetailPanel.totalItems.setText(noOfItems + "");
					}
				}
			}
		}

	}

}

class B{
	
}