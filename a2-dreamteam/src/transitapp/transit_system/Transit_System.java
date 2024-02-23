package transitapp.transit_system;

import transitapp.Stop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Transit_System class
 * Keeps the data about:
 *      1) All vehicles in the city
 *      2) All stops/stations in the city
 *      3) List of all possible routes
 *      4) List of allowed vehicle types in the certain city
 */

public class Transit_System {

    private ArrayList<Vehicle> vehicles;
    private ArrayList<Stop> stops;
    private ArrayList<Route> routes;

    // Single instance of a Transit_System
    private static Transit_System system;

    private Transit_System(ArrayList<Vehicle> vehicles, ArrayList<Stop> stops, ArrayList<Route> routes){
        this.vehicles = vehicles;
        this.stops = stops;
        this.routes = routes;
    }

    // Getting the instance of a Transit_System
    public static Transit_System getTransitSystem(){
        return system;
    }

    public static Transit_System createTransitSystem(ArrayList<Vehicle> v, ArrayList<Stop> s, ArrayList<Route> r){
        if (system == null) system = new Transit_System(v, s, r);

        return system;
    }

    // Getter Methods

    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public ArrayList<Stop> getStops() {
        return this.stops;
    }

    public ArrayList<Route> getRoutes() {
        return this.routes;
    }

    // Add or Remove Vehicle

    public boolean addVehicle(Vehicle vehicle){
        if (this.vehicles.contains(vehicle)) return false;

        this.vehicles.add(vehicle);
        
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " addVehicle " + vehicle.getId() + " " + vehicle.getRoute().getId());
        
        return true;
    }

    public boolean removeVehicle(Vehicle vehicle){
        if (this.vehicles.contains(vehicle)){
            this.vehicles.remove(vehicle);
            
            SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
            String current_time_str = time_formatter.format(System.currentTimeMillis());
            System.out.println(current_time_str + " removeVehicle " + vehicle.getId() + " " + vehicle.getRoute().getId());
            
            return true;
        }

        return false;
    }

    // Add or Remove Stop

    public boolean addStop(Stop stop){
        if (this.stops.contains(stop)) return false;

        this.stops.add(stop);
        
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " addStop " + stop.getName());
        
        return true;
    }

    public boolean removeStop(Stop stop){
        if (this.stops.contains(stop)){
            this.stops.remove(stop);
            
            SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
            String current_time_str = time_formatter.format(System.currentTimeMillis());
            System.out.println(current_time_str + " removeStop " + stop.getName());
            
            return true;
        }

        return false;
    }

    // Add or Remove Route

    public boolean addRoute(Route route){
        if (this.routes.contains(route)) return false;

        this.routes.add(route);
        
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " addRoute " + route.getId());
        
        return true;
    }

    public boolean removeRoute(Route route){
        if (this.routes.contains(route)){
            this.routes.remove(route);
            
            SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
            String current_time_str = time_formatter.format(System.currentTimeMillis());
            System.out.println(current_time_str + " removeRoute " + route.getId());
            
            return true;
        }

        return false;
    }

}
