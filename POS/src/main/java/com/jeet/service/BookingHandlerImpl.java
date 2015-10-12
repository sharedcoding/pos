package com.jeet.service;

import com.jeet.api.BookHandler;

public class BookingHandlerImpl implements BookHandler {/*

	public Ticket bookTicket(String movieName) throws InvalidMovieException,
			BookingException {
		Ticket ticket = null;
		Movie movie = DAO.instance().getMovie(movieName);
		Screen screen = DAO.instance().getScreen(movie);
		System.out.println("BookingHandlerImpl.bookTicket()"+screen);
		List<Seat> seats = screen.getSeat();
		for( Seat seat : seats){
			Ticket tic = DAO.instance().getTicket(screen.getScreenId(), seat.getSeatNum());
			if(  tic == null){
				Ticket newTic = new Ticket();
				newTic.setScreen(screen);
				newTic.setPrice(200);
				newTic.setSeat(seat);
				DAO.instance().bookTicket(newTic);
				return newTic;
			}
		}
		return ticket;
	}

	public Ticket getTicket(int ticketId) throws InvalidTicketException,
			BookingException {
		return null;
	}

	public void deleteTicket(int ticketId) throws InvalidTicketException,
			BookingException {
		DAO.instance().cancelTicket(ticketId);
	}

	public Ticket updateTicket(Ticket ticket, Movie newMovie)
			throws InvalidTicketException, InvalidMovieException,
			BookingException {
		return null;
	}
	
	public List<Movie> getAllMovies(){
		return DAO.instance().getAllMovies();
	}

*/}
