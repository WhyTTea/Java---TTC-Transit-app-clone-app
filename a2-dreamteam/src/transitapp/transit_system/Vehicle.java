package transitapp.transit_system;

import transitapp.Stop;
import java.text.SimpleDateFormat;

/**
 * Vehicle class is the main class that defines
 * all types of the vehicles in the city
 */

public abstract class Vehicle {

    private int id;
    private Stop current_stop;
    private Route route;

    Vehicle(int id, Route route){
        this.id = id;
        this.route = route;
        this.current_stop = this.route.getStart();
    }

    // Getter Functions

    public int getId() {
        return this.id;
    }

    public Route getRoute() {
        return this.route;
    }

    public Stop getCurrent_stop() {
        return this.current_stop;
    }

    // Setter Functions

    public void setRoute(Route route) {
        this.route = route;
    }

    /**
     * Set the current_stop to stop if the stop is in the route
     *
     * @param stop Desired stop
     * @return true if it is possible to change the stop
     *         false if desired stop is not in the route
     */
    public boolean setCurrent_stop(Stop stop) {
        if (this.route.includes(stop)){
            this.current_stop = stop;
            return true;
        }

        return false;
    }

    // Functions

    /**
     * Move vehicle to the next stop in the route
     *
     * @return true if it is possible to move to the next stop
     *         false if the vehicle reached its final stop
     */
    public boolean move(){
        this.current_stop = this.route.getNextStop(current_stop);
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " transportMove " + id + " " + this.getCurrent_stop().getName());
        return this.current_stop != null;
    }
}
