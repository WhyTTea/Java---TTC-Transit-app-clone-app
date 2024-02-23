package transitapp;

public class Fares {
	
	private static Fares sharedInstance = new Fares(2.0, 0.5, 6.0);
	
	static Fares getSharedInstance() {
		return sharedInstance;
	}
	
	private double BUS_FARE;
	private double SUBWAY_FARE;
	private double MAX_FARE;
	
	Fares(double BUS_FARE, double SUBWAY_FARE, double MAX_FARE) {
		this.BUS_FARE = BUS_FARE;
		this.SUBWAY_FARE = SUBWAY_FARE;
		this.MAX_FARE = MAX_FARE;
	}

    // Getter/Setter Functions
	
	double getBusFare() {
		return this.BUS_FARE;
	}

	void setBusFare(double value) {
		this.BUS_FARE = value;
	}
	
	double getSubwayFare() {
		return this.SUBWAY_FARE;
	}

	void setSubwayFare(double value) {
		this.SUBWAY_FARE = value;
	}

	// Instance Functions
	
	/**
     * Calculates and returns the price of the subway
     * trip for the given number of stations.
     *
     * @param number of stations in the trip
     * @return price of the subway trip
     */
	double countSubwayPrice(int numberOfStations) {
		double value = SUBWAY_FARE*numberOfStations;
		if (value > MAX_FARE) {
			return MAX_FARE;
		}
		return SUBWAY_FARE;
	}
}
