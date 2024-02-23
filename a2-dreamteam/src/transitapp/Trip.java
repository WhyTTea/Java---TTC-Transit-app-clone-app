package transitapp;

import transitapp.transit_system.Route;
import transitapp.transit_system.Transit_System;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Trip {
	private String tripID;
	private static ArrayList<Stop> path;
	private static ArrayList<Stop> begpath;
	private long startTime;
	private long endTime;
	private int timeLeft;
	private int duration;
	
	Trip(String tripID, Stop stop) {
		this.tripID = tripID;
		this.begpath.add(stop);
	}
	
	public static String newTrip(Stop stop) {
		if(begpath.isEmpty()) {return "new";
		}else if ((path).get(path.size()-1).equals(stop)) {
			return "same";
		}return "new";
	}
	
	public String getTripID() {
		return this.tripID;
	}
	
	public ArrayList<Stop> getEndPath() {
		return this.path;
	}
	public ArrayList<Stop> getBegPath() {
		return this.begpath;
	}
	
	public void addStop(Stop stop) {
		this.path.add(stop);
	}
	public void addBegStop(Stop stop) {
		this.begpath.add(stop);
	}
	
	public void setStartTime(Date time) {
		this.startTime=time.getTime();
		/*
		 Calendar calendar = Calendar.getInstance();
         calendar.setTime(time);
		
		int hours =calendar.get(Calendar.HOUR);
		int minutes =calendar.get(Calendar.MINUTE);
		Interval interval = new Interval(start, end);
		Period period = interval.toPeriod(); 
		*/
	}
	
	public void setEndTime(Date time) {
		/*
		Scanner scan = new Scanner(System.in);
		this.endTime = scan.nextInt();
		*/
		this.endTime=time.getTime();
	}
	
 /***
  * 
  * @param time
  * @return
  */
	
	public String getTime(long time) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date(time);
		String printTime = formatter.format(date);
		return printTime;
	}
	
	public int getDuration(long start, long end) {
		long millseconds= end - start;
		int minutes = (int) ((millseconds / 1000) / 60);
		//long minutes = end - start;
		return minutes;
	}
	
	
	// return the free minutes left during a 2h bus trip or 3h subway trip
	public int getTimer(Stop stop) {
		if (stop.getType() == "Bus") {
			this.duration= 120; 
		}else if (stop.getType() == "Subway") {
			this.duration = 180;		
		}
		this.timeLeft = this.duration - getDuration(this.startTime, this.endTime);
		return this.timeLeft;
	}

	public boolean checkValidExit() {
		if (this.getEndPath().size()-1 != this.getBegPath().size()) {
			return false;
		} return true;
	}
	
	public int numOfStops() {
		Stop exit = (Stop)this.getEndPath().get(path.size()-1);
		Stop entry =(Stop)this.getBegPath().get(begpath.size()-1);

		ArrayList<Route> routes = Transit_System.getTransitSystem().getRoutes();
		
		if (exit.getType() == "Subway" && entry.getType() == "Bus") {
			for (Route r: routes) {
				if (r.includes(exit) && r.includes(entry)) {
					return 0;
				}
			}
		}
		if (exit.getType() == "Bus" && entry.getType() == "Subway") {
			for (Route r1: routes) {
				if (r1.includes(exit) && r1.includes(entry)) {
					return -2;
					}
			}
		}
		
		for (Route r2 : routes){
			int count = r2.countStops(entry, exit);
			if (count != -1) return count;
		}

		return -1;
	}
}
