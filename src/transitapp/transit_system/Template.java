package transitapp.transit_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import transitapp.Stop;

/**
 * Template of a Transit System
 */
public class Template {

    private Transit_System template;
    private ArrayList<Stop> stops;
    private ArrayList<Route> routes;
    private ArrayList<Vehicle> vehicles;

    public Template(){
        stops = createStops();
        routes = createRoutes();
        vehicles = createVehicles();
        this.template = Transit_System.createTransitSystem(vehicles, stops, routes);
    }

    // Functions

    /**
     * Create 25 Bus stops and 5 Subway Stations for the
     * Transit System template
     */
    private ArrayList<Stop> createStops() {
        ArrayList<Stop> template = new ArrayList<Stop>();

        // 5 Bus stops for 5 different routes
        template.add(new Stop("Toronto", "Bus"));
        template.add(new Stop("Rome", "Bus"));
        template.add(new Stop("Beijing", "Bus"));
        template.add(new Stop("Amsterdam", "Bus"));
        template.add(new Stop("London", "Bus"));
        template.add(new Stop("Paris", "Bus"));
        template.add(new Stop("Berlin", "Bus"));
        template.add(new Stop("Brussels", "Bus"));
        template.add(new Stop("Cairo", "Bus"));
        template.add(new Stop("Athens", "Bus"));
        template.add(new Stop("Jerusalem", "Bus"));
        template.add(new Stop("Tokyo", "Bus"));
        template.add(new Stop("Kuala Lumpur", "Bus"));
        template.add(new Stop("Monaco", "Bus"));
        template.add(new Stop("Manila", "Bus"));
        template.add(new Stop("Oslo", "Bus"));
        template.add(new Stop("Madrid", "Bus"));
        template.add(new Stop("Lisbon", "Bus"));
        template.add(new Stop("Cape Town", "Bus"));
        template.add(new Stop("Singapore", "Bus"));
        template.add(new Stop("Seoul", "Bus"));
        template.add(new Stop("Bangkok", "Bus"));
        template.add(new Stop("Abu Dhabi", "Bus"));
        template.add(new Stop("Kyiv", "Subway"));
        template.add(new Stop("Moscow", "Subway"));
        template.add(new Stop("Astana", "Subway"));
        template.add(new Stop("New York", "Subway"));
        template.add(new Stop("New Delhi", "Subway"));
        
//        for (int i = 0; i < 5; i++){
//            for (int j = 0; j < 5; j++){
//                template.add(new Stop("Stop " + (i + 1) + (j + 1), "Bus"));
//            }
//        }
//
//        // 5 Subway stations
//        for (int i = 0; i < 5; i++){
//            template.add(new Stop("Station " + (i + 1), "Subway"));
//        }

        return template;
    }

    /**
     * Create 5 Bus routes and 1 Subway route for the
     * Transit System template
     */
    private ArrayList<Route> createRoutes() {
        ArrayList<Route> template = new ArrayList<Route>();

        // Create Bus routes
//        for (int i = 0; i < 5; i++){
//            LinkedHashMap<Stop, Double> path = new LinkedHashMap<Stop, Double>();
//
//            for (int j = 0; j < 5; j++){
//                double time_to_next = 10 * (new Random()).nextDouble() + 5;
//                path.put(this.stops.get((i*5) + j), time_to_next);
//            }
//
//            template.add(new Route("Bus", i + 1, path));
//        }
            LinkedHashMap<Stop, Double> path = new LinkedHashMap<Stop, Double>();

            for (int j = 0; j < 4; j++){
                double time_to_next = 10 * (new Random()).nextDouble() + 5;
                path.put(this.stops.get(j), time_to_next);
            }
            path.put(this.stops.get(23), 0.00);
            template.add(new Route("Bus", 1, path));
            
            LinkedHashMap<Stop, Double> path2 = new LinkedHashMap<Stop, Double>();

            for (int l = 4; l < 7; l++){
                double time_to_next = 10 * (new Random()).nextDouble() + 5;
                path2.put(this.stops.get(l), time_to_next);
            }
            path2.put(this.stops.get(24), 0.00);
            for (int l = 7; l < 9; l++){
                double time_to_next = 10 * (new Random()).nextDouble() + 5;
                path2.put(this.stops.get(l), time_to_next);
           
            }
            template.add(new Route("Bus", 2, path2));
            
            LinkedHashMap<Stop, Double> path3 = new LinkedHashMap<Stop, Double>();
            
            double time_to_next = 10 * (new Random()).nextDouble() + 5;
            path3.put(this.stops.get(9), time_to_next);
            
            path3.put(this.stops.get(25), 0.00);
            
            for (int j = 10; j < 14; j++){
                double time_to_next2 = 10 * (new Random()).nextDouble() + 5;
                path3.put(this.stops.get(j), time_to_next2);
            }
           
            template.add(new Route("Bus", 3, path3));
            
            LinkedHashMap<Stop, Double> path4 = new LinkedHashMap<Stop, Double>();

            for (int j = 14; j < 16; j++){
                double time_to_next3 = 10 * (new Random()).nextDouble() + 5;
                path4.put(this.stops.get(j), time_to_next3);
            }
            path4.put(this.stops.get(26), 0.00);
            for (int j = 16; j < 18; j++){
                double time_to_next4 = 10 * (new Random()).nextDouble() + 5;
                path4.put(this.stops.get(j), time_to_next4);
            }
            template.add(new Route("Bus", 4, path4));
            
            LinkedHashMap<Stop, Double> path5 = new LinkedHashMap<Stop, Double>();

            for (int j = 18; j < 21; j++){
                double time_to_next5 = 10 * (new Random()).nextDouble() + 5;
                path5.put(this.stops.get(j), time_to_next5);
            }
            path5.put(this.stops.get(27), 0.00);
            for (int j = 21; j < 23; j++){
                double time_to_next6 = 10 * (new Random()).nextDouble() + 5;
                path5.put(this.stops.get(j), time_to_next6);
            }
            template.add(new Route("Bus", 5, path5));
        

        // Create a Subway route
        LinkedHashMap<Stop, Double> s_path = new LinkedHashMap<Stop, Double>();
        for (int i = 23; i < 28; i++){
            double time_to_next_s = 10 * (new Random()).nextDouble() + 5;
            s_path.put(this.stops.get(i), time_to_next_s);
        }
        template.add(new Route("Subway", 1, s_path));

        return template;
    }

    /**
     * Create 5 Buses and 1 Subway train for the
     * Transit System template
     */
    private ArrayList<Vehicle> createVehicles() {
        ArrayList<Vehicle> template = new ArrayList<Vehicle>();

        // Create 5 buses
        for (int i = 0; i < 5; i++){
            template.add(new Bus(i + 1, this.routes.get(i)));
        }

        // Create 1 subway train
        template.add(new Train(1, this.routes.get(routes.size() - 1)));

        return template;
    }

}
