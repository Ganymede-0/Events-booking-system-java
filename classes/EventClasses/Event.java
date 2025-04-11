package classes.EventClasses;

public class Event {

	private String eventName;
	private double eventPrice;
	private String eventID;
	private String eventLocation;
	private int capacity;

	// Constructer
	public Event() {

	}

	public Event(String eventName, String eventID, double eventPrice, String eventLocation, int capacity) {
		this.eventName = eventName;
		this.eventID = eventID;
		this.eventPrice = eventPrice;
		this.eventLocation = eventLocation;
		this.capacity = capacity;
	}

	// GETTER
	public String getEventName() {
		return eventName;
	}

	public String getEventID() {
		return eventID;
	}

	public double getEventPrice() {
		return eventPrice;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public int getCapacity() {
		return capacity;
	}

	// Setters
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public void setEventPrice(double eventPrice) {
		this.eventPrice = eventPrice;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// METHODS

	public static void displayEvents() {
		System.out.println(
				"+------------------------------------------+\n"
						+ "|     choose the type of event you want    |\n"
						+ "| 0. Exit.                                 |\n"
						+ "| 1. Museum Area.                          |\n"
						+ "| 2. Games Area.                           |\n"
						+ "+------------------------------------------+");
	}

}// end Event class
