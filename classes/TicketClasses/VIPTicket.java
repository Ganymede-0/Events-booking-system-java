package classes.TicketClasses;

import java.util.ArrayList;
import java.util.Scanner;

import classes.EventClasses.*;

// VIPTicket class (subclass of Ticket)
public class VIPTicket extends Ticket {

    static Scanner input = new Scanner(System.in);

    // Additional Variables
    private double vipTicketPrice;
    private String vipTicketId;

    // Constructor
    public VIPTicket(String ticketId, int numOfTickets, double vipTicketPrice) {
        super(ticketId, numOfTickets);
        this.vipTicketPrice = vipTicketPrice;
    }

    // Getters and Setters specific to VIPTicket
    public double getVIPTicketPrice() {
        return vipTicketPrice;
    }

    public void setVIPTicketPrice(double vipTicketPrice) {
        this.vipTicketPrice = vipTicketPrice;
    }

    public String getVIPTicketId() {
        return vipTicketId;
    }

    public void setVIPTicketId(String vipTicketId) {
        this.vipTicketId = vipTicketId;
    }

    // Method to calculate the total cost of VIP tickets
    public static double calculateTotalCost(int numOfPeople, double price) {
        return numOfPeople * price;
    }

    public static String setTicketId() {
        Integer tempTicketId = random.nextInt(10000);
        Integer.toString(tempTicketId);

        String ticketID = "1" + tempTicketId;
        return ticketID;
    }

    public static void displayBill(String id, int numOfPeople, double price) {
        System.out.println("\n***** Bill Info *****");
        System.out.println("Reservation' ID: " + id);
        System.out.println("Number of Tickets: " + numOfPeople);
        System.out.println("Price per Ticket: " + price);
        System.out.println("Total Cost: " + calculateTotalCost(numOfPeople, price));
    }

    // Create Museum VIP Ticket
    public static void createMuseumVIPTicket(String cutId, String eventId, ArrayList<MuseumArea> museums,
            ArrayList<VIPTicket> VIPTickets, ArrayList<PurchasedTickets> purchasedTickets) {

        int capacity = 0;
        double price = 0.0;
        // Get the capacity and price of the event
        for (int i = 0; i < museums.size(); i++) {
            if (eventId.equals(museums.get(i).getEventID())) {
                capacity = museums.get(i).getCapacity();
                price = (museums.get(i).getEventPrice()) + ((museums.get(i).getEventPrice()) * 0.15);
            }
        }

        String ticketId = VIPTicket.setTicketId();

        System.out.println("Enter number of ticket: ");
        int numOfTickets = input.nextInt();

        if (numOfTickets <= capacity) {
            for (int i = 0; i < museums.size(); i++) {
                if (eventId.equals(museums.get(i).getEventID())) {
                    museums.get(i).setCapacity(((museums.get(i).getCapacity()) - numOfTickets));
                }
            }

            VIPTicket.displayBill(ticketId, numOfTickets, price);
            VIPTickets.add(new VIPTicket(ticketId, numOfTickets, price));
            purchasedTickets.add(new PurchasedTickets(cutId, eventId, ticketId, price));

        }

        else {
            System.out.println("Sorry, there is no enough ticket or the event is fully booked!");
        }
    }

    // Create Game VIP Ticket
    public static void createGameVIPTicket(String cutId, String eventId, ArrayList<GamesArea> games,
            ArrayList<VIPTicket> VIPTickets, ArrayList<PurchasedTickets> purchasedTickets) {

        int capacity = 0;
        double price = 0.0;
        // Get the capacity and price of the event
        for (int i = 0; i < games.size(); i++) {
            if (eventId.equals(games.get(i).getEventID())) {
                capacity = games.get(i).getCapacity();
                price = (games.get(i).getEventPrice()) + ((games.get(i).getEventPrice()) * 0.15);
            }
        }

        String ticketId = VIPTicket.setTicketId();

        System.out.println("Enter number of Tickets: ");
        int numOfTickets = input.nextInt();

        if (numOfTickets < capacity) {
            for (int i = 0; i < games.size(); i++) {
                if (eventId.equals(games.get(i).getEventID())) {
                    games.get(i).setCapacity(((games.get(i).getCapacity()) - numOfTickets));
                }
            }

            VIPTicket.displayBill(ticketId, numOfTickets, price);
            VIPTickets.add(new VIPTicket(ticketId, numOfTickets, price));
            purchasedTickets.add(new PurchasedTickets(cutId, eventId, ticketId, price));

        }

        else {
            System.out.println("Sorry, there is no enough ticket or the event is fully booked!");
        }
    }

}