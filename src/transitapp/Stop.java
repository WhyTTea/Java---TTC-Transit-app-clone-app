package transitapp;

import transitapp.transit_system.Vehicle;

import java.util.ArrayList;

public class Stop {
	private String stopName;
	private String stopType;
	private ArrayList transitVehicle;

	public Stop(String name, String type) {
		this.stopName = name;
		this.stopType = type;
	}
	
	public String getName() {
		return this.stopName;
	}
	
	public void setName(String name) {
		this.stopName = name;		
	}
	public String getType() {
		return this.stopType;
	}
	
	public void setType(String type) {
		this.stopType = type;		
	}
	
	public ArrayList getTransitVehicle() {
		return this.transitVehicle;		
	}
	
	public void setTransitVehicle(Vehicle vehicle) {
		this.transitVehicle.add(vehicle.getId());
	}
}
