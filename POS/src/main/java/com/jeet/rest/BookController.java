package com.jeet.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jeet.api.Bill;
import com.jeet.api.Item;
import com.jeet.api.ItemBill;
import com.jeet.api.ItemOffer;
import com.jeet.api.ItemSupplier;
import com.jeet.api.Offer;
import com.jeet.api.Supplier;
import com.jeet.api.Type;
import com.jeet.api.Unit;
import com.jeet.db.DAO;

@Path("/")
public class BookController {
	
	
	@POST
	@Path("/item")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addItem(Item item){
		DAO.instance().addItem(item);
		return Response.ok().build();
	}
	
	@POST
	@Path("/itemsupplier")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addItem(ItemSupplier itemSupplier){
		DAO.instance().addItem(itemSupplier);
		return Response.ok().build();
	}
	
	@POST
	@Path("/type")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addType(Type type){
		DAO.instance().addType(type);
		return Response.ok().build();
	}
	
	@POST
	@Path("/unit")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addUnit(Unit unit){
		DAO.instance().addUnit(unit);
		return Response.ok().build();
	}
	
	@POST
	@Path("/supplier")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addSupplier(Supplier supplier){
		DAO.instance().addSupplier(supplier); 
		return Response.ok().build();
	}
	
	@POST
	@Path("/offer")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addOffer(Offer offer){
		DAO.instance().addOffer(offer); 
		return Response.ok().build();
	}
	
	@POST
	@Path("/itemoffer")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addItemOfferr(ItemOffer itemOffer){
		DAO.instance().addItemOffer(itemOffer); 
		return Response.ok().build();
	}
	
	@POST
	@Path("/bill")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addBill(Bill bill){
		System.out.println("BookController.addBill()-------------");
		DAO.instance().addBill(bill); 
		return Response.ok().build();
	}
	
	@POST
	@Path("/itembill")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addItemBill(ItemBill itemBill){
		DAO.instance().addItemBill(itemBill); 
		return Response.ok().build();
	}
	
	@GET
	@Path("/item/{itemId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Item getItem(@PathParam(value="itemId") int itemId){
	   Item item = DAO.instance().getItem(itemId);
	   return item; 
	}
	
	@GET
	@Path("/item")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Item> getItems(){
	   List<Item> items = DAO.instance().getItems();
	   return items; 
	}
	
	/*@GET
	@Path("/bill/{billNum}/item/{itemId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Item getItemsFromBill(@PathParam(value="billNum") int billNum, @PathParam(value="itemId") int itemId){
	   Item item = DAO.instance().getItem(billNum, itemId);
	   return item; 
	}
	
	@GET
	@Path("/bill/{billNum}/item")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Item getItemFromBill(@PathParam(value="billNum") int billNum){
	   Item item = DAO.instance().getItemsFromBill(billNum);
	   return item; 
	}
	*/
	
	/*

	@PUT
	@Path("/book/{movieName}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getMovieTicket(
			@PathParam(value = "movieName") String movieName) {
		Ticket ticket = new BookingHandlerImpl().bookTicket(movieName);
		if (ticket != null) {
			return Response.ok().entity(ticket).build();
		} else {
			return Response.status(404).build();
		}
	}

//localhost:8080/mbook-1/rest/book/movies
	@GET
	@Path("/book/movies")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Movie> getAllMovies(){
		List<Movie> movies = new BookingHandlerImpl().getAllMovies();
		GenericEntity<List<Movie>> entity = new GenericEntity<List<Movie>>(movies){};
		//return Response.ok(entity).build(); 
		return movies;
	}
	
	@DELETE
	@Path("/book/{ticketId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response cancelTicket(@PathParam(value = "ticketId") int ticketId) {
		new BookingHandlerImpl().deleteTicket(ticketId);
		return Response.ok().build();
	}
*/}
