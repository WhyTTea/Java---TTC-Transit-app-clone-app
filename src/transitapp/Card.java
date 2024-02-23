package transitapp;

import java.text.SimpleDateFormat;

public class Card {
	private int id;
	private User owner;
	private double balance;
	private double moneySpent;
	private int numberOfTransactions;
	private boolean isValid;
	
	Card(int id, User owner) {
		this.id = id;
		this.owner = owner;
		this.balance = 19.0;
		this.moneySpent = 0.0;
		this.numberOfTransactions = 0;
		this.isValid = true;
	}
	
    // Getter/Setter Functions
	
	int getId() {
		return this.id;
	}
	
	User getOwner() {
		return this.owner;
	}
	
	double getBalance() {
		return this.balance;
	}
	
	boolean getValid() {
		return this.isValid;
	}
	
	void setValid(boolean value) {
		this.isValid = value;
	}
	
	// Instance Functions

	
    /**
     * Adds the money to the balance of the user if
     * the accepted value passed
     *
     * @param value of the money, should be 10/20/50
     * @return returns true iff accepted money value passed
     */
	boolean addMoney(double value) {
		if (value == 10.0 || value == 20.0 || value == 50.0) {
			this.balance += value;
			
	        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
	        String current_time_str = time_formatter.format(System.currentTimeMillis());
	        System.out.println(current_time_str + " AddedMoney " + value + " " + this.id);
	        
			return true;
		} else {
			return false;
		}
	}
	
	
    /**
     * Calculates average money spent per transaction
     * using formula: moneySpent/numberOfTransactions
     *
     * @return returns the average value
     */
	double calculateAvrgSpend() {
		if (this.numberOfTransactions == 0) {
			return 0.0;
		}
		return this.moneySpent/this.numberOfTransactions;
	}
	
    /**
     * Calculates and completes subway transaction and 
     * removes the money off the balance
     */
	void completeSubwayTransaction(int numberOfStations) {
		double price = Fares.getSharedInstance().countSubwayPrice(numberOfStations);
		balance -= price;
		moneySpent += price;
		numberOfTransactions += 1;
		this.balance -= price;

        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " CompleteTransaction Subway " + price + " " + this.id);
	}

    /**
     * Completes subway maximum transaction and removes
     * the money off the balance
     */
	void completeMaxSubwayTransaction() {
		double price = Fares.getSharedInstance().getMaxSubwayFare();
		balance -= price;
		moneySpent += price;
		numberOfTransactions += 1;
		this.balance -= price;

        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " CompleteTransaction Subway " + price + " " + this.id);
	}

    /**
     * Calculates and completes bus transaction and removes
     * the money off the balance
     */
	void completeBusTransaction() {
		double price = Fares.getSharedInstance().getBusFare();
		balance -= price;
		moneySpent += price;
		numberOfTransactions += 1;
		this.balance -= price;
		
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " CompleteTransaction Bus " + price + " " + this.id);
	}

    /**
     * Completes bus maximum transaction and removes
     * the money off the balance
     */
	void completeMaxBusTransaction() {
		double price = Fares.getSharedInstance().getMaxBusFare();
		balance -= price;
		moneySpent += price;
		numberOfTransactions += 1;
		this.balance -= price;

        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " CompleteTransaction Bus " + price + " " + this.id);
	}

    /**
     * Suspends the card by setting isValid to false
     */
	void suspendTheCard() {
		this.isValid = false;

        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " SuspendCard " + this.id);
	}
}
