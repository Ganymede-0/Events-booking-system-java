package classes.EventClasses;

import java.util.ArrayList;
import java.util.Scanner;

public class MuseumArea extends Event {
	static Scanner input = new Scanner(System.in);

	private String musName;

	// Constructer
	public MuseumArea(String musName, String eventId, double eventPrice, String eventLocation, int capacity) {
		super();
		this.musName = musName;
		setEventID(eventId);
		setEventPrice(eventPrice);
		setEventLocation(eventLocation);
		setCapacity(capacity);
	}// end constructer

	// Setter
	public void setMuseumName(String musName) {
		this.musName = musName;
	}

	// Getter
	public String getMuseumName() {
		return musName;
	}

	// METHODES
	public static int searchMuseum(String museumId, ArrayList<MuseumArea> museums) {
		for (int i = 0; i < museums.size(); i++) {
			if (museumId.equals(museums.get(i).getEventID())) {
				return i;
			}
		}
		return -1;
	}

	// Create Museum
	public static void createMuseum(ArrayList<MuseumArea> museums) {
		System.out.println("Name of the museum: ");
		String musName = input.nextLine();

		System.out.println("ID of the museum: ");
		String musID = input.next();

		int exist = MuseumArea.searchMuseum(musID, museums);
		while (exist != -1) {
			System.out.println("This ID alrady exists!\nEnter another ID: ");
			musID = input.next();
			exist = MuseumArea.searchMuseum(musID, museums);
		}

		System.out.println("price of the museum: ");
		double price = input.nextDouble();

		System.out.println("location of the museum: ");
		String location = input.next();

		System.out.println("capacity of the museum: ");
		int capacity = input.nextInt();

		museums.add(new MuseumArea(musName, musID, price, location, capacity));
		System.out.println("The museum added successfully");
	}

	public static void updateMuseum(ArrayList<MuseumArea> museums) {
		System.out.println("Enter the id of the museums: ");
		String museumId = input.next();
		int index = searchMuseum(museumId, museums);
		if (index != -1) {
			System.out.println("enter new name: ");
			String editedName = input.next();

			System.out.println("enter new price: ");
			double editedPrice = input.nextDouble();

			System.out.println("enter new location: ");
			String editedLocation = input.next();

			System.out.println("enter new capacity: ");
			int editedLcapacity = input.nextInt();

			museums.set(index, new MuseumArea(editedName, museumId, editedPrice, editedLocation, editedLcapacity));

			System.out.println("The museum updated successfully.");
		}

		else {
			System.out.println("not found!");
		}
	}

	public static void deleteMuseum(ArrayList<MuseumArea> museums) {
		System.out.println("Enter the id of the museums: ");
		String museumId = input.next();
		int index = searchMuseum(museumId, museums);
		if (index != -1) {
			museums.remove(index);
			System.out.println("The museum removed successfully.");
		}

		else {
			System.out.println("not found!");
		}
	}

	// (String musName, String eventId, double eventPrice, String eventLocation, int
	// capacity)

	@Override
	public String toString() {
		return ("\nMuseum' Name: " + getMuseumName() + "\nMuseum' ID: " + getEventID() + "\nMuseum' Price: "
				+ getEventPrice() + "\nMuseum' Location: "
				+ getEventLocation() + "\nMuseum' Capacity: " + getCapacity() + "\n");
	}

}// End Museum class