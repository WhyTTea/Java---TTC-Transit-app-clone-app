package transitapp;

import java.text.SimpleDateFormat;

public class Admin {
	boolean shift;
	double rev_amount;
	String FirstName;
	String LastName;
	
	public Admin(String FirstName, String LastName) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.shift = false;
		this.rev_amount = 0;
	}
	
	public void startShift() {
		this.shift = true;
		this.rev_amount = 0; 
        
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " startShift " + this.FirstName + " " + this.LastName);
	}
	public String endShift() {
		this.shift = false;
        
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println(current_time_str + " startShift " + this.FirstName + " " + this.LastName + " " + rev_amount);
        
		return ("Admin ( "+FirstName+LastName+"accumulated revenue of: "+rev_amount);
	}
	
	public void update(double trans) {
		this.rev_amount += trans;
	}
}
