package transitapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import transitapp.transit_system.Transit_System;

public class Cardholder{
	ArrayList<Trip> trips;
	ArrayList<Card> cards;
	String email;
	boolean on_the_ride;
	Trip curr_trip;
	String FirstName;
	String LastName;
	/**
	 * One of the constructors for our Cardholder class object.
	 * @param FirstName string consisting of the first name
	 * @param LastName string consisting of the last name
	 * @param email string consisting of the email of the customer using this card
	 * @param card Card object displaying which card this user wants to use
	 */
	public Cardholder(String FirstName, String LastName, String email, Card card) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.email = email;
		this.cards.add(card);
		this.on_the_ride = false;
	}
	/**
	 * One of the constructors for our Cardholder class object. This one will be used if oyu simply create profile in the
	 * transit system with no card attached to it yet.
	 * @param FirstName string consisting of the first name
	 * @param LastName string consisting of the last name
	 * @param email string consisting of the email of the customer using this card
	 */
	public Cardholder(String FirstName, String LastName, String email) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.email = email;
		this.on_the_ride = false;
	}
//	public Cardholder(String FirstName, String LastName, String email, Card card, Trip tripID) {
//		this.FirstName = FirstName;
//		this.LastName = LastName;
//		this.email = email;
//		this.cards.add(card);
//		this.trips.add(tripID);
//		this.on_the_ride = false;
//		this.curr_ride = null;
//	}
	
	/**
	 * Getter for the name of the cardholder.
	 * @return string with the full name of the given cardholder.
	 */
	public String getName() {
		return this.FirstName + " " + this.LastName;
	}
	/**
	 * Setter for the first name
	 * @param FN string representing the first name of the cardholder.
	 */
	public void setFirstName(String FN) {
		this.FirstName = FN;
	}
	/**
	 * Setter for the last name
	 * @param LN string representing the first name of the cardholder.
	 */
	public void setLastName(String LN) {
		this.LastName = LN;
	}
	/**
	 * Add a new card to the list of cards this customer have used so far.
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}
	/**
	 * Remove a particular card from the list of all cards assigned under this cardholder's name. 
	 */
	public void removeCard() {
		int size = this.cards.size();
		this.cards.remove(size-1);
	}
	/**
	 * Getter for the card. 
	 * @return the most recently used card by the cardholder. 
	 */
	public Card getCard() {
		int size = this.cards.size();
		return this.cards.get(size-1);
	}
	
	/**
	 * Function to enter a station/stop.
	 * @param curr_stop Stop object for the current stop we are at (entering right now)
	 * @param today Date time of the day when we enter the stop/station
	 * @param ts Transit_System which transit system we are in
	 * @return String message indicating if you can enter or not the given station
	 */
	public String Enter(Stop curr_stop, Date today, Transit_System ts) {
		
		Card curr_card = this.getCard();
		 
		if (curr_stop.getType() == "Bus") {
			
			if (curr_card.getBalance()>0) {
				if (Trip.newTrip(curr_stop) == "new") {
					String uniquetrip_id = UUID.randomUUID().toString();
					Trip curr_trip = new Trip(uniquetrip_id, curr_stop);
					curr_trip.setStartTime(today);
					trips.add(curr_trip);
					curr_card.completeBusTransaction();
					
				}
				else {
					curr_trip.addBegStop(curr_stop);
				}
			}
			else {
				return ("You need to add funds before entering " + curr_stop + curr_stop.getType() + " station. Your current card balance is: " + curr_card.getBalance());
			}
		}
		if (curr_stop.getType() == "Subway") {
			if (curr_card.getBalance()< Fares.getSharedInstance().getSubwayFare()) {
				return ("Your card balance is too low to afford subway station transfer, please add more money to your account. Your current card balance is: " + curr_card.getBalance());
			}
			else {
				if (Trip.newTrip(curr_stop) == "new") {
					String uniquetrip_id = UUID.randomUUID().toString();
					Trip curr_trip = new Trip(uniquetrip_id, curr_stop);
					curr_trip.setStartTime(today);
					trips.add(curr_trip);
					curr_card.completeBusTransaction();
				}
				else {
					curr_trip.addStop(curr_stop);
				}
			}
		}
			
		this.on_the_ride = true;
		
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " enter " + this.email + " " + curr_stop.getName());
        
		return ("You have successfully entered "+ curr_stop + ". Your current card balance is: " + curr_card.getBalance());
	}
	
	/**
	 * 
	 * @param curr_stop Stop object for the current stop we are at (to exit right now)
	 * @param today Date time of the day when we exit the stop/station
	 * @param ts Transit_System which transit system we are in
	 * @return String message indicating your exit from the station
	 */
	public String Exit(Stop curr_stop, Date today, Transit_System ts) {
		Card curr_card = this.getCard();
		
		if ((curr_stop.getType() == "Bus") && (curr_trip.checkValidExit() == true)) {
			curr_trip.setEndTime(today);
			curr_trip.addStop(curr_stop);
			return ("Thank you for using our bus! Your current card balance is: " + curr_card.getBalance());
		}
		else if((curr_stop.getType() == "Bus") && (curr_trip.checkValidExit() == false)) {
			curr_card.completeBusTransaction();
			return ("It seems you forgot to tap in, we have charged your card for a cost of one entry");
		}
		else if ((curr_stop.getType() == "Subway") && (curr_trip.checkValidExit() == true)) {
			curr_trip.setEndTime(today);
			curr_trip.addStop(curr_stop);
			int numberSubwaySt = curr_trip.numOfStops();
			if (numberSubwaySt > 0) {curr_card.completeSubwayTransaction(numberSubwaySt);}
			if (numberSubwaySt == -2) {curr_card.completeBusTransaction();}
			
	        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
	        String current_time_str = time_formatter.format(System.currentTimeMillis());
	        System.out.println(current_time_str + " exit " + this.email + " " + curr_stop.getName());
	        
			return ("Thank you for using our subway!"+ curr_stop + ". Your current card balance is: " + curr_card.getBalance());
		}
		else {
			curr_card.completeMaxSubwayTransaction(); 
			return ("Seems like you forgot to tap in at the entry. Your card has been charged a daily maximum limit.");
		}
	}
}
