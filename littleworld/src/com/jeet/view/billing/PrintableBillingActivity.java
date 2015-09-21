package com.jeet.view.billing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JEditorPane;
import javax.swing.table.TableModel;

import com.jeet.infra.Activity;

public class PrintableBillingActivity extends Activity {
	private Container container;
	private MyEditorPane pane;

	public PrintableBillingActivity() {
	}

	protected void onCreate() {
		super.onCreate();
System.out.println("PrintableBillingActivity.onCreate()");
		container = (Container) getIntent().getExtra(
				"com.jeet.view.CONTENTPANE");
		container.add(this);
		TableModel model = (TableModel) getIntent().getExtra("TABLE_MODEL");
		setPreferredSize(new Dimension(800, model.getRowCount() * 60));
		pane = new MyEditorPane(getHeader()
				+ getTableStructure(model) + addBillDetail(model));
		System.out.println("PrintableBillingActivity.onCreate()"+model.getRowCount() * 40);
		pane.setPreferredSize(new Dimension(550, model.getRowCount() * 40));
		
		
	}

	protected void onStart(){
		super.onStart();
		this.add(pane);
		container.revalidate();
		//pane.printPane();
		System.out.println("PrintableBillingActivity.onStart()");
	}
	protected void onDestroy() {
		super.onDestroy();
		container.remove(this);
	}

	private String getHeader() {
		String header = "<h2>" + getSpace(60) + " Little World<br>"
				+ getSpace(50) + " M/s Jai Maa Enterprises <br>" + getSpace(45)
				+ "Inside Delhi Gate, Ferozepur City</h2>" + "<h3>"
				+ getSpace(1) + " Invoice Num: " + getBillNum() + getSpace(80)
				+ "Date: " + getDate() + "</h3>";
		return header;
	}

	private String getBillNum() {
		return getIntent().getExtra("BILL_NUM").toString();
	}

	private String getDate() {
		DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String datee = dFormat.format(date);
		return datee;
	}

	private String getTableStructure(TableModel model) {
		String data = "<table style=width:350px> ";
		data += addTableHeader(model);
		data += addTableRows(model);
		data += "</table>";
		return data;
	}
	

	private String addTableHeader(TableModel model) {
		String header = " <th>Index</th> ";
		for (int i = 0; i < model.getColumnCount() - 1; i++) {
			if (i == 4) {
				header += "<th> Discount(Rs)</th> ";
			}
			header += " <th>" + model.getColumnName(i) + "</th>";
		}
		return header;
	}

	private String addTableRows(TableModel model) {
		String rows = "";
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0) == null) {
				break;
			}
			rows += " <tr>" + "<td align=center width=\"20\">" + (i + 1) + "</td>"
					+ getCellData(i, 0, model, 60) + getCellData(i, 1, model,150)
					+ getCellData(i, 2, model, 30) + getCellData(i, 3, model,30)
					+ getCellData(i, 4, model, 30) + getCellData(i, 5, model, 80)
					+ " </tr>";
		}
		return rows;
	}
	

	private String getCellData(int i, int j, TableModel model, int width) {
		String data = " <td align=center  width=\""+width+"\">" + model.getValueAt(i, j) + "</td>";
		if (j == 3) {
			data += "<td align=center width=\""+width+"\" >" + getDiscountRs(i, model) + "</td>";
		}
		return data;
	}

	private String getDiscountRs(int row, TableModel model) {
		int disc = Integer.parseInt(model.getValueAt(row, 2).toString())
				* Integer.parseInt(model.getValueAt(row, 3).toString())
				* Integer.parseInt(model.getValueAt(row, 4).toString()) / 100;
		String dis = disc + "";
		return dis;
	}

	private String addBillDetail(TableModel model) {
		String billAmount = "";
		int noOfItems = 0;
		int totalPrice = 0;
		int discounts = 0;
		int mrpVal = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			Object itemObj = model.getValueAt(i, 4);
			Object priceObj = model.getValueAt(i, 5);
			Object mrpObj = model.getValueAt(i, 2);

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
			}
		}
		billAmount += " <h2><br>" + getSpace(70) + "Number of Items : "
				+ noOfItems + "<br>" + getSpace(70) + "You have Saved  : "
				+ discounts + "<br>" + getSpace(70) + "GRAND TOTAL     : "
				+ totalPrice + "</h2>";
		return billAmount;
	}

	private String getSpace(int size) {
		String space = "";
		for (int i = 0; i < size; i++) {
			space += "&nbsp;";
		}
		return space;
	}

	private class MyEditorPane extends JEditorPane implements Printable {
		MyEditorPane(String text) {
			super("text/html", text);
			putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
			setFont(new Font(getFont().getFontName(), 0, 8));
		}

		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
				throws PrinterException {
			System.out.println("PrintableBillingActivity.print()" + pageIndex);
			if (pageIndex > 0) {
				return NO_SUCH_PAGE;
			}
			Graphics2D g2d = (Graphics2D) graphics;
			g2d.translate(pageFormat.getImageableX(),
					pageFormat.getImageableY());
			this.printAll(graphics);
			return PAGE_EXISTS;
		}

		private void printPane() {
			PrinterJob printerJob = PrinterJob.getPrinterJob();
			printerJob.setPrintable(MyEditorPane.this);
			try {
				printerJob.print();
				System.out
						.println("PrintableBillingActivity.printMe() SEND TO PRINT");
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}

}
