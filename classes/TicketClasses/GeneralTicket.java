package classes.TicketClasses;

import java.util.ArrayList;
import java.util.Scanner;

import classes.EventClasses.*;

// GeneralTicket class (subclass of Ticket)
public class GeneralTicket extends Ticket {

    static Scanner input = new Scanner(System.in);

    // Additional Variables
    private double generalTicketPrice;

    // Constructor
    public GeneralTicket(String ticketId, int numOfTickets, double generalTicketPrice) {
        super(ticketId, numOfTickets);
        this.generalTicketPrice = generalTicketPrice;
    }

    // Getters and setters specific to GeneralTicket
    public double getGeneralTicketPrice() {
        return generalTicketPrice;
    }

    public void setGeneralTicketPrice(double generalTicketPrice) {
        this.generalTicketPrice = generalTicketPrice;
    }

    // Method to calculate the total cost of general tickets
    public static double calculateTotalCost(int numOfPeople, double price) {
        return numOfPeople * price;
    }

    public static void displayBill(String id, int numOfPeople, double price) {
        System.out.println("\n***** Bill Info *****");
        System.out.println("Reservation' ID: " + id);
        System.out.println("Number of Tickets: " + numOfPeople);
        System.out.println("Price per Tickes: " + price);
        System.out.println("Total Cost: " + calculateTotalCost(numOfPeople, price));
    }

    public static String setTicketId() {
        Integer tempTicketId = random.nextInt(10000);
        Integer.toString(tempTicketId);

        String ticketID = "2" + tempTicketId;
        return ticketID;
    }

    public static void createMuseumGenTicket(String cutId, String eventId, ArrayList<MuseumArea> museums,
            ArrayList<GeneralTicket> generalTickets, ArrayList<PurchasedTickets> purchasedTickets) {

        int capacity = 0;
        double price = 0.0;
        // Get the capacity and price of the event
        for (int i = 0; i < museums.size(); i++) {
            if (eventId.equals(museums.get(i).getEventID())) {
                capacity = museums.get(i).getCapacity();
                price = museums.get(i).getEventPrice();
            }
        }

        String ticketId = GeneralTicket.setTicketId();

        System.out.println("Enter number of tickets: ");
        int numOfTickets = input.nextInt();

        if (numOfTickets <= capacity) {
            for (int i = 0; i < museums.size(); i++) {
                if (eventId.equals(museums.get(i).getEventID())) {
                    museums.get(i).setCapacity(((museums.get(i).getCapacity()) - numOfTickets));
                }
            }

            GeneralTicket.displayBill(ticketId, numOfTickets, price);
            generalTickets.add(new GeneralTicket(ticketId, numOfTickets, price));
            purchasedTickets.add(new PurchasedTickets(cutId, eventId, ticketId, price));

        }

        else {
            System.out.println("Sorry, there is no enough ticket or the event is fully booked!");
        }
    }

    public static void createGameGenTicket(String cutId, String eventId, ArrayList<GamesArea> games,
            ArrayList<GeneralTicket> generalTickets, ArrayList<PurchasedTickets> purchasedTickets) {

        int capacity = 0;
        double price = 0.0;
        // Get the capacity and price of the event
        for (int i = 0; i < games.size(); i++) {
            if (eventId.equals(games.get(i).getEventID())) {
                capacity = games.get(i).getCapacity();
                price = games.get(i).getEventPrice();
            }
        }

        String ticketId = GeneralTicket.setTicketId();

        System.out.println("Enter number of tickets: ");
        int numOfTickets = input.nextInt();

        if (numOfTickets <= capacity) {
            for (int i = 0; i < games.size(); i++) {
                if (eventId.equals(games.get(i).getEventID())) {
                    games.get(i).setCapacity(((games.get(i).getCapacity()) - numOfTickets));
                }
            }

            GeneralTicket.displayBill(ticketId, numOfTickets, price);
            generalTickets.add(new GeneralTicket(ticketId, numOfTickets, price));
            purchasedTickets.add(new PurchasedTickets(cutId, eventId, ticketId, price));

        }

        else {
            System.out.println("Sorry, there is no enough ticket or the event is fully booked!");
        }
    }

    @Override
    public String toString() {
        return ("Ticket ID: " + getTicketId() + " general Ticket Price: " + getGeneralTicketPrice()
                + " Number of Tickets: " + getNumOfTickets());
    }
}