package classes.TicketClasses;

import java.util.*;

// Ticket class (superclass)
public class Ticket {
    static Random random=new Random();
    // Variables
    private String ticketId;
    private int numOfTickets;

    // Constructor
    public Ticket() {

    }
    
    public Ticket(String ticketId, int numOfTickets) {
        this.ticketId = ticketId;
        this.numOfTickets = numOfTickets;
    }

    // Method to search for a ticket by ticket Id
    public boolean searchTicket(String targetTicketId) {
        return this.ticketId == targetTicketId;
    }

    // Method to search for tickets avalability
    public static boolean searchTicket(String targetTicketId, ArrayList<Ticket> purchasedTickets) {
        boolean ticketAvalabile = false;
        for (Ticket ticket : purchasedTickets) {
            if (ticket.getTicketId().equals(targetTicketId)) {
                ticketAvalabile = true;
            }
        }

        return ticketAvalabile;

    }

    // Method to update the number of tickets
    public void updateTicket(int newNumOfTickets) {
        this.numOfTickets = newNumOfTickets;
    }

    // Method to delete the ticket (set it as invalid)
    public void deleteTicket(String targetTicketId, ArrayList<Ticket> purchasedTickets) {

    }

    // Getter for ticketId
    public String getTicketId() {
        return ticketId;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }
         
    public static String setTicketId() {
        Integer tempTicketId = random.nextInt(10000);
        Integer.toString(tempTicketId); 
        return tempTicketId.toString();

    }
}