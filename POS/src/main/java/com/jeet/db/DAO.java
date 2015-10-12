package com.jeet.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.jeet.api.Bill;
import com.jeet.api.Item;
import com.jeet.api.ItemBill;
import com.jeet.api.ItemOffer;
import com.jeet.api.ItemSupplier;
import com.jeet.api.Offer;
import com.jeet.api.Supplier;
import com.jeet.api.Type;
import com.jeet.api.Unit;

public class DAO {

	private static DAO instance;
	private SessionFactory factory;

	private DAO() {
		System.out.println("DAO.DAO() ready to create");
		Configuration conf = new Configuration();
		System.out.println("DAO.DAO() created config----------------");
		conf.configure("hibernate.cfg.xml");
		System.out.println("DAO.DAO() config created");
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				conf.getProperties()).buildServiceRegistry(); 
		System.out.println("DAO.DAO() reg");
		factory = conf.buildSessionFactory(registry);
		System.out.println("Creating factory");
	}

	public static synchronized DAO instance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}
	
	public void addItem(Item item){
		Session session = factory.openSession();
		System.out.println("DAO.addItem()");
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		System.out.println("DAO.addItem() ITEM ADDED");
	}
	
	public void addItem(ItemSupplier itemSupplier){
		Session session = factory.openSession();
		System.out.println("DAO.addItem() itemSupplier");
		session.beginTransaction();
		session.save(itemSupplier);
		session.getTransaction().commit();
		session.close();
		System.out.println("DAO.addItem() ITEM ADDED");
	}
	
	public void addType(Type type){
		Session session = factory.openSession();
		System.out.println("DAO.addItem()");
		session.beginTransaction();
		session.save(type);
		session.getTransaction().commit();
		System.out.println("DAO.addItem() ITEM ADDED");
	}
	public void addUnit(Unit unit){
		Session session = factory.openSession();
		System.out.println("DAO.addItem()");
		session.beginTransaction();
		session.save(unit);
		session.getTransaction().commit();
		System.out.println("DAO.addItem() ITEM ADDED");
	}
	public void addSupplier(Supplier supplier){
		Session session = factory.openSession();
		System.out.println("DAO.addItem()");
		session.beginTransaction();
		session.save(supplier);
		session.getTransaction().commit();
		System.out.println("DAO.addItem() ITEM ADDED");
	}
	
	public void addOffer(Offer offer){
		Session session = factory.openSession();
		System.out.println("DAO.addItem()");
		session.beginTransaction();
		session.save(offer);
		session.getTransaction().commit();
		System.out.println("DAO.addItem() ITEM ADDED");
	}
	public void addItemOffer(ItemOffer itemOffer) {
		Session session = factory.openSession();
		System.out.println("DAO.addItem()");
		session.beginTransaction();
		session.save(itemOffer);
		session.getTransaction().commit();
		System.out.println("DAO.addItem() ITEM ADDED");
	}
	
	public void addBill(Bill bill) {
		Session session = factory.openSession();
		System.out.println("DAO.addItem()");
		session.beginTransaction();
		session.save(bill);
		session.getTransaction().commit();
		System.out.println("DAO.addItem() ITEM ADDED");
	}

	public void addItemBill(ItemBill itemBill) {
		Session session = factory.openSession();
		System.out.println("DAO.addItem()");
		session.beginTransaction();
		session.save(itemBill);
		session.getTransaction().commit();
		System.out.println("DAO.addItem() ITEM ADDED");
		
	}
	
	public Item getItem(int itemId){
		System.out.println("DAO.getItem() itemId :"+itemId);
		Session session = factory.openSession();
		String hql = "from Item where barcode = :iId";
		Query query = session.createQuery(hql);
		query.setParameter("iId", itemId);
		List<Item> list = query.list();
		session.close();
		Item result = list.get(0);
		System.out.println("DAO.getItems() "+list.size()+" Item found.");
		System.out.println("item:- "+result);
		return result;
	}
	
	public Item getItem(int billNum, int itemId){
		System.out.println("DAO.getItem() itemId :"+itemId);
		Session session = factory.openSession();
		String hql = "from ItemBill where BILL_NUMBER = :billNum AND barcode = :bcode";
		Query query = session.createQuery(hql);
		query.setParameter("billNum", billNum);
		query.setParameter("bcode", itemId);
		List<ItemBill> list = query.list();
		session.close();
		System.out.println("DAO.getItems() "+list.size()+" Item found.");
		Item result = list.get(0).getItem();
		return result;
	}
	
	public Item getItemsFromBill(int billNum){
		System.out.println("DAO.getItem() billNum :"+billNum);
		Session session = factory.openSession();
		String hql = "from ItemBill where BILL_NUMBER = :billNum ";
		Query query = session.createQuery(hql);
		query.setParameter("billNum", billNum);
		List<ItemBill> list = query.list();
		session.close();
		System.out.println("DAO.getItems() "+list.size()+" Item found.");
		return list.get(0).getItem();
	}
	
	public List<Item> getItems(){
		Session session = factory.openSession();
		String hql = "from Item";
		Query query = session.createQuery(hql);
		List<Item> list = query.list();
		session.close();
		System.out.println("DAO.getItems() "+list.size()+" Item found.");
		return null;
	}
	
	public Item getSupplier(int supplierId){
		System.out.println("DAO.getItem() supplierId :"+supplierId);
		Session session = factory.openSession();
		String hql = "from Supplier where supplierId = :iId";
		Query query = session.createQuery(hql);
		query.setParameter("iId", supplierId);
		List<Item> list = query.list();
		session.close();
		System.out.println("DAO.getItems() "+list.size()+" Item found.");
		return list.get(0);
	}
	
	public Item getOffer(int offerId){
		System.out.println("DAO.getItem() OfferId :"+offerId);
		Session session = factory.openSession();
		String hql = "from Supplier where OfferId = :iId";
		Query query = session.createQuery(hql);
		query.setParameter("iId", offerId);
		List<Item> list = query.list();
		session.close();
		System.out.println("DAO.getItems() "+list.size()+" Item found.");
		return list.get(0);
	}
	
	public Item getBill(int billId){
		System.out.println("DAO.getItem() OfferId :"+billId);
		Session session = factory.openSession();
		String hql = "from Supplier where BILL_NUMBER = :iId";
		Query query = session.createQuery(hql);
		query.setParameter("iId", billId);
		List<Item> list = query.list();
		session.close();
		System.out.println("DAO.getItems() "+list.size()+" Item found.");
		return list.get(0);
	}


	
	/*public Screen getScreen(Movie movie){
		Session session = factory.openSession();
		String hql = "from Screen where movie_movieId = :mId";
		Query query = session.createQuery(hql);
		query.setParameter("mId", movie.getMovieId());
		List<Screen> list = query.list();
		session.close();
		return list.get(0);
	}
	
	public Movie getMovie(String movieName){
		System.out.println("DAO.getMovie()");
		Session session = factory.openSession();
		String hql = "from Movie where name = :mName";
		Query query = session.createQuery(hql);
		query.setParameter("mName", movieName);
		List<Movie> list = query.list();
		return list.get(0);
	}
	
	public List<Movie> getAllMovies(){
		Session session = factory.openSession();
		String hql = "from Movie";
		Query q = session.createQuery(hql);
		List<Movie> movies = q.list();
		return movies;
	}
	
	public Ticket getTicket(String screenId, String seatId){
		Session session = factory.openSession();
		String hql = "from Ticket where screen_screenId=:screenId and seat_seatNum=:seatId";
		Query query = session.createQuery(hql);
		query.setParameter("screenId", screenId);
		query.setParameter("seatId", seatId);
		List<Ticket> list = query.list();
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
		
	}
	
	public Ticket bookTicket(Ticket ticket){
		Session session = factory.openSession();
		System.out.println("DAO.bookTicket()");
		session.beginTransaction();
		session.save(ticket);
		session.getTransaction().commit();
		return ticket;
	}
	
	public void cancelTicket(int ticketId){
		System.out.println(ticketId);
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		Ticket tic = (Ticket)session.load(Ticket.class, ticketId);
		session.delete(tic);
		trx.commit();
		session.close();
	}*/

}
