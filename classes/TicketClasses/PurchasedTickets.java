package classes.TicketClasses;

import java.util.ArrayList;

public class PurchasedTickets {
    private String cID;
    private String eID;
    private String tID;
    private double tPrice;

    public PurchasedTickets(String cID, String eID, String tID, double tPrice) {
        super();
        this.cID = cID;
        this.eID = eID;
        this.tID = tID;
        this.tPrice = tPrice;

    }

    public String getCID() {
        return cID;
    }

    public String getEID() {
        return eID;
    }

    public String getTID() {
        return tID;
    }

    public double getTPrice() {
        return tPrice;
    }

    // Serch for a Ticket
    public static int searchPurchasedTickets(String ID, String ticID, ArrayList<PurchasedTickets> purchasedTickets) {
        for (int i = 0; i < purchasedTickets.size(); i++) {
            if ((ticID.equals(purchasedTickets.get(i).getTID()) && ID.equals(purchasedTickets.get(i).getCID()))
                    || (ticID.equals(purchasedTickets.get(i).getTID()) && ID.startsWith("1"))) {
                return i;
            }
        }
        return -1;
    }

    public static void deletePurchasedTickets(int checkTic, ArrayList<PurchasedTickets> purchasedTickets) {
        if (checkTic != -1) {
            purchasedTickets.remove(checkTic);
            System.out.println("The game removed successfully.");
        }

        else {
            System.out.println("there is no such a Ticket!");
        }
    }

    @Override
    public String toString() {
        return ("\nCustomer ID: " + getCID() + "\nEvent ID: " + getEID() + "\rRservation ID: " + getTID()
                + "\nTotal cost: "
                + getTPrice() + "\n");
    }

}