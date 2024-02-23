package transitapp.transit_system;

import transitapp.Stop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Route class contains information about the
 * specific route for Bus/Train
 */

public class Route {

    private int id;
    private String type;
    private Stop start;
    private Stop finish;
    private LinkedHashMap<Stop, Double> path;

    Route(String type, int id, LinkedHashMap<Stop, Double> path){
        this.type = type;
        this.id = id;
        this.path = path;
        this.start = getFirstStop();
        this.finish = getLastStop();
    }

    // Getter Functions
    public String getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public Stop getFinish() {
        return this.finish;
    }

    public Stop getStart() {
        return this.start;
    }

    public LinkedHashMap<Stop, Double> getPath() {
        return this.path;
    }

    // Functions
    /**
     * Return the first stop of the route
     */
    public Stop getFirstStop(){
        Map.Entry<Stop, Double> element = (Map.Entry) (this.path.entrySet().iterator()).next();
        return element.getKey();
    }

    /**
     * Return the first stop of the route
     */
    public Stop getLastStop(){
        Iterator iterator = this.path.entrySet().iterator();
        Map.Entry<Stop, Double> element = null;

        while (iterator.hasNext()){
            element = (Map.Entry) iterator.next();
        }

        return element.getKey();
    }

    /**
     * Check if stop is in the path
     */
    public boolean includes(Stop stop){
        for (Map.Entry<Stop, Double> element : this.path.entrySet()){
            if (element.getKey() == stop) return true;
        }

        return false;
    }

    /**
     * Count the number of stops between startStop and endStop
     * in this route (start and end stops are included)
     *
     * @return number of stops in between start and end points
     *         -1 if either point is not in the route
     */
    public int countStops(Stop startStop, Stop endStop){
        if (includes(startStop) && includes(endStop)){
            int stops = 0;
            boolean started = false;

            for (Map.Entry<Stop, Double> element : this.path.entrySet()){
                if (!started){
                    if (element.getKey() == startStop) started = true;
                }else {
                    stops++;
                    if (element.getKey() == endStop) return ++stops;
                }
            }
        }

        return -1;
    }

    /**
     * Return the stop that goes after the given stop
     *
     * @param stop Current stop
     * @return next possible stop
     *         null if the given stop is the final stop
     */
    public Stop getNextStop(Stop stop){
        Map.Entry<Stop, Double> prev = null;
        for (Map.Entry<Stop, Double> element : this.path.entrySet()){
            if (prev != null && prev.getKey() == stop){
                return element.getKey();
            } else {
                prev = element;
            }
        }

        return null;
    }

    /**
     * Return the stop that goes before the given stop
     *
     * @param stop Current stop
     * @return previous stop
     *         stop if the given stop is the start stop
     */
    public Stop getPrevStop(Stop stop){
        Map.Entry<Stop, Double> prev = null;
        for (Map.Entry<Stop, Double> element : this.path.entrySet()){
            if (prev == null) prev = element;

            if (element.getKey() == stop){
                return prev.getKey();
            } else {
                prev = element;
            }
        }

        return null;
    }

    /**
     * Count entire time needed to finish the route
     *
     * @return Time it takes to start and finish the route
     */
    public double countTime(){
        double time = 0.0;

        for (Map.Entry<Stop, Double> element : this.path.entrySet()){
            time += element.getValue();
        }

        return time;
    }

    @Override
    public String toString(){
        return "Type: " + getType() + ", ID: " + getId() + ", Start: " + getStart().getName() +
                ", Finish: " + getFinish().getName() + ", Overall time: " + countTime();
    }
}
