package com.jeet.pos;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class POSConsole {
	public static void main(String[] args) {

		System.out.println("LibraryConsole.main()");
		Client client = Client.create(new DefaultClientConfig());
		WebResource service = client
				.resource("http://localhost:8080/pos-1/rest/");
		
		
		//addType(service);
		addItems(service, 501);
		//addItems(service, 6);
		//addItems(service, 8);
		getItems(service, "501");
		//addBill(service);
		service.delete();
		client.destroy();
	}

	private static void addType(WebResource service) {

		Unit unit = new Unit();
		unit.setName("KG");
		unit.setUnitId(1);

		Type type = new Type();
		type.setName("Toy");
		type.setTypeId(123);
		type.setUnit(unit);
		
		ClientResponse response = service.path("type")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, type);
		if (response.getStatus() == 200) {
			System.out.println("Account is added successfully!");
		} else {
			System.out.println("Sorry, failed to upload the book!");
		}

	}
	private static Item getItems(WebResource service, String itemId) {
		ClientResponse response = null;
		Item result = null;
		response = service.path("item").path(itemId).type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		System.out.println("POSConsole.getItems()"+response.getStatus());
		if (response.getStatus() == 200 ) {
			System.out.println("Tyring to fetch it back...");
			result = response.getEntity(Item.class);
			System.out.println("Found the book with ISBN: " + result.barCode
					+ "[" + result.itemName + "] by " + result.description+"  size:"+result.getSupplierSet().size());
			
		} else {
			System.out.println("Sorry, failed to upload the item!");
		}
		response.close();
		return result;
	}

	private static void addItems(WebResource service, int barcode) {
		System.out.println("POSConsole.addItems()");
		ClientResponse response = null;
		ItemSupplier is = addItem(barcode);

		response = service.path("itemsupplier")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, is);
		if (response.getStatus() == 200) {
			System.out.println("Account is added successfully!");
		} else {
			System.out.println("Sorry, failed to upload the book!");
		}
		response.close();
	}
	
	private static void addBill(WebResource service){
		System.out.println("POSConsole.addBill()");
		Bill bill = new Bill();
		bill.setBillDate(new Date());
		bill.setBillNumber(12333);
		bill.setTotalBill(2000);
		

		//addBillItem(service, bill, "3333");
		addBillItem(service, bill, "5555");
		//addBillItem(service, bill, "4444");
		
		/*ItemBill iBill1 = new ItemBill();
		iBill1.setItem(getItems(service, "3333"));
		iBill1.setBill(bill);
		
		ItemBill iBill2 = new ItemBill();
		iBill2.setItem(getItems(service, "4444")); 
		iBill2.setBill(bill);*/
		
		//ib.add(iBill);
	/*	ib.add(iBill1);
		ib.add(iBill2);
		*/
		
		
	}
	
	private static void addBillItem(WebResource service, Bill bill, String itemId){

		ItemBill iBill = new ItemBill();
		Item item1 = getItems(service, itemId);
		iBill.setItem(item1);
		iBill.setBill(bill);
		
		
		/*ClientResponse response = null;

		response = service.path("itembill")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, iBill);
		System.out.println("POSConsole.addBill() res: " +response);
		if (response.getStatus() == 200) {
			System.out.println("Account is added successfully!");
		} else {
			System.out.println("Sorry, failed to upload the book!");
		}*/
	}

	private static ItemSupplier addItem(int barcode) {
		Supplier supplier = new Supplier();
		supplier.setQuantity(10);
		supplier.setSupplierId(1234);
		supplier.setSupplierName("KDGG");

		Type type = new Type();
		type.setTypeId(123);

		Item item = new Item();
		item.setBarCode(barcode);
		item.setDescription("Toy");
		item.setItemName("Toy Train");
		item.setPurchasePrice(500);
		item.setSellingPrice(750);
		item.setType(type);
		ItemSupplier iSupplier = new ItemSupplier();
		iSupplier.setItem(item);
		iSupplier.setQuantity(10);
		iSupplier.setSupplier(supplier);
		iSupplier.setSupplyDate(new Date());

		return iSupplier;
	}

}
