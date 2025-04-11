import classes.EventClasses.*;
import classes.TicketClasses.*;
import classes.UserClasses.*;
import java.util.*;

public class Events {
    public static ArrayList<Organizer> organizers = new ArrayList<Organizer>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static ArrayList<Event> events = new ArrayList<Event>();
    public static ArrayList<MuseumArea> museums = new ArrayList<MuseumArea>();
    public static ArrayList<GamesArea> games = new ArrayList<GamesArea>();

    public static ArrayList<PurchasedTickets> purchasedTickets = new ArrayList<PurchasedTickets>();
    public static ArrayList<GeneralTicket> generalTickets = new ArrayList<GeneralTicket>();
    public static ArrayList<VIPTicket> VIPTickets = new ArrayList<VIPTicket>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ArrayList of Organizers
        organizers.add(new Organizer("Ola Khalid", "OlKh@123", "1110005637"));
        organizers.add(new Organizer("Amal Salem", "AmSa@123", "1110006991"));
        organizers.add(new Organizer("Saud Mohamed", "SaMo@123", "1110004275"));
        organizers.add(new Organizer("Ahmed Ali", "AhAl@123", "1110005622"));

        // ArrayList of Customers
        customers.add(new Customer("Mohamed Ahmed", "MoAh@123", "2220005975"));
        customers.add(new Customer("Hassan Abdelmageed", "HaAb@123", "2220007651"));
        customers.add(new Customer("Rula Mohamed", "RuMo@123", "2220002397"));
        customers.add(new Customer("Reem Talal", "ReTa@123", "2220001348"));
        customers.add(new Customer("Sara Rami", "SaRa@123", "2220009876"));

        // ArrayList of Museum Area
        museums.add(new MuseumArea("Museum of the Future", "19526", 140.00, "Dubai", 1000));
        museums.add(new MuseumArea("National Museum of Saudi Arabia", "12003", 10.0, "Riyadh", 100));
        museums.add(new MuseumArea("Museum Al Wahyu", "18221", 20.0, "Makkah", 80));

        // ArrayList of Games Event
        games.add(new GamesArea("XTIME", "21573", 40.0, "AlKhobar", 70));
        games.add(new GamesArea("Pixels", "21900", 20.0, "Dammam", 50));
        games.add(new GamesArea("HighEnd", "24739", 45.0, "Riyadh", 100));

        // Variable declareation
        int userChoise;
        int adminChoise;
        int customerChoise;
        int eventChoise;

        do {
            User.displayOptions();
            System.out.println("Enter your choise:");
            userChoise = input.nextInt();

            switch (userChoise) {
                case 0: {
                    break;
                }

                case 1: {
                    System.out.println("Eter your ID and Password.");
                    String ID = input.next();
                    String password = input.next();
                    if (adminLogin(ID, password, organizers)) {
                        do {
                            Organizer.displayAdminOptions();
                            adminChoise = input.nextInt();

                            switch (adminChoise) {

                                case 1: {
                                    // Create Event.
                                    Event.displayEvents();
                                    eventChoise = input.nextInt();

                                    if (eventChoise == 1) { // Create museum.
                                        MuseumArea.createMuseum(museums);

                                    }

                                    else if (eventChoise == 2) { // Create game
                                        GamesArea.createGame(games);
                                    }

                                    else {
                                        System.out.println("wrong choise");
                                    }
                                    break;
                                }

                                case 2: {
                                    // Serch event.
                                    Event.displayEvents();
                                    eventChoise = input.nextInt();

                                    if (eventChoise == 1) { // Serch museum.
                                        System.out.println("Enter the id of the museum: ");
                                        String museumId = input.next();
                                        int index = MuseumArea.searchMuseum(museumId, museums);
                                        if (index != -1) {
                                            System.out.println("the data for this museum are : "
                                                    + museums.get(index).toString());
                                        }

                                        else {
                                            System.out.println("not found!");
                                        }
                                    }

                                    else if (eventChoise == 2) { // Serch game.
                                        System.out.println("Enter the id of the game: ");
                                        String gameId = input.next();
                                        int index = GamesArea.searchGame(gameId, games);
                                        if (index != -1) {
                                            System.out.println("the data for this game are : "
                                                    + games.get(index).toString());
                                        }

                                        else {
                                            System.out.println("not found!");
                                        }
                                    }

                                    else {
                                        System.out.println("wrong choise");
                                    }

                                    break;
                                }

                                case 3: {
                                    // Update Event.
                                    Event.displayEvents();
                                    eventChoise = input.nextInt();

                                    if (eventChoise == 1) { // Update museums.
                                        MuseumArea.updateMuseum(museums);
                                    }

                                    else if (eventChoise == 2) { // Update game.
                                        GamesArea.updateGame(games);
                                    }

                                    else {
                                        System.out.println("wrong choise");
                                    }

                                    break;
                                }

                                case 4: {
                                    // Delete Event.
                                    Event.displayEvents();
                                    eventChoise = input.nextInt();

                                    if (eventChoise == 1) { // Delete museums.
                                        MuseumArea.deleteMuseum(museums);
                                    }

                                    else if (eventChoise == 2) { // Delete game.
                                        GamesArea.deleteGame(games);
                                    }

                                    else {
                                        System.out.println("wrong choise");
                                    }

                                    break;
                                }

                                case 5: {
                                    // Show all envents.
                                    System.out.println("*************** All museums: ***************");
                                    System.out.println(Arrays.toString(museums.toArray()));

                                    System.out.println("\n\n*************** All games: ***************");
                                    System.out.println(Arrays.toString(games.toArray()));

                                    break;
                                }

                                case 6: {
                                    // Delete Reservation.
                                    if (!purchasedTickets.isEmpty()) {
                                        System.out.println("Enter the ID of the Reservation: ");
                                        String ticId = input.next();
                                        int bookedTic = PurchasedTickets.searchPurchasedTickets(ID, ticId,
                                                purchasedTickets);
                                        PurchasedTickets.deletePurchasedTickets(bookedTic, purchasedTickets);

                                    }

                                    else {
                                        System.out.println("No reservations yet.");
                                    }

                                    break;
                                }

                                case 7: {
                                    // Show all reservations.
                                    if (!purchasedTickets.isEmpty()) {
                                        System.out.println("All reservations: ");
                                        System.out.println(Arrays.toString(purchasedTickets.toArray()));

                                    }

                                    else {
                                        System.out.println("No reservations yet.");
                                    }

                                    break;
                                }

                                case 8: {
                                    // Show all Customers.
                                    System.out.println("View All Customers: \n");
                                    System.out.println(Arrays.toString(customers.toArray()));
                                    break;
                                }

                                default: {
                                    System.out.println("Invalid Option");
                                }
                            }
                        }

                        while (adminChoise != 0);
                    }

                    else {
                        System.out.println("Invalid ID or Password");
                    }

                    break;
                } // end of case 1

                case 2: {
                    System.out.println("Eter your ID and Password.");
                    String ID = input.next();
                    String password = input.next();
                    if (CustomerLogin(ID, password, customers)) {

                        do {
                            Event.displayEvents();
                            eventChoise = input.nextInt();

                            switch (eventChoise) {
                                case 0: {
                                    break;
                                }

                                case 1: {
                                    System.out.println("********** Museum Area **********");
                                    Customer.displayCustomerOptions();
                                    customerChoise = input.nextInt();
                                    if (customerChoise == 0) {
                                        break;
                                    }

                                    else if (customerChoise == 1) {
                                        System.out.println("View All museums: \n");
                                        System.out.println(Arrays.toString(museums.toArray()));
                                        System.out.println("Enter the ID of the museum: ");
                                        String eventId = input.next();

                                        System.out.println(
                                                "Enter type of the ticket you want to buy: \n1. VIP\n2. Standerd");
                                        int ticketType = input.nextInt();

                                        if (ticketType == 1) {
                                            VIPTicket.createMuseumVIPTicket(ID, eventId, museums, VIPTickets,
                                                    purchasedTickets);
                                        }

                                        else if (ticketType == 2) {
                                            GeneralTicket.createMuseumGenTicket(ID, eventId, museums, generalTickets,
                                                    purchasedTickets);

                                        }

                                        else {
                                            System.out.println("Invalid choise");
                                        }

                                    }

                                    else if (customerChoise == 2) { // Delete Museum Ticket
                                        System.out.println("Enter the ID of the Reservation: ");
                                        String ticID = input.next();
                                        int checkTic = PurchasedTickets.searchPurchasedTickets(ID, ticID,
                                                purchasedTickets);
                                        PurchasedTickets.deletePurchasedTickets(checkTic, purchasedTickets);

                                    }

                                    else {
                                        System.out.println("Invalid Option!");
                                    }

                                    break;
                                }

                                case 2: {
                                    System.out.println("********** Games Area **********");
                                    Customer.displayCustomerOptions();
                                    customerChoise = input.nextInt();
                                    if (customerChoise == 0) {
                                        break;
                                    }

                                    else if (customerChoise == 1) {
                                        System.out.println("View All Games: \n");
                                        System.out.println(Arrays.toString(games.toArray()));
                                        System.out.println("Enter the ID of the Game: ");
                                        String eventId = input.next();

                                        System.out.println(
                                                "Enter type of the ticket you want to buy: \n1. VIP\n2. Standerd");
                                        int ticketType = input.nextInt();

                                        if (ticketType == 1) {
                                            VIPTicket.createGameVIPTicket(ID, eventId, games, VIPTickets,
                                                    purchasedTickets);
                                        }

                                        else if (ticketType == 2) {
                                            GeneralTicket.createGameGenTicket(ID, eventId, games, generalTickets,
                                                    purchasedTickets);

                                        }

                                        else {
                                            System.out.println("Invalid choise");
                                        }
                                    }

                                    else if (customerChoise == 2) { // Delete Game Ticket
                                        System.out.println("Enter the ID of the Reservation: ");
                                        String ticID = input.next();
                                        int checkTic = PurchasedTickets.searchPurchasedTickets(ID, ticID,
                                                purchasedTickets);
                                        PurchasedTickets.deletePurchasedTickets(checkTic, purchasedTickets);

                                    }

                                    else {
                                        System.out.println("Invalid Option!");
                                    }

                                    break;
                                }

                                default: {
                                    System.out.println("Invalid Option");
                                }
                            }

                        }

                        while (eventChoise != 0);

                    }

                    else {
                        System.out.println("Invalid ID or Password");
                    }
                    break;
                }

                default: {
                    System.out.println("Invalid Choice");
                    break;
                }

            } // end of switch

        }

        while (userChoise != 0);

        input.close();

    } // end of main

    // *********** All methods declaration ***********

    // method for admin login
    public static boolean adminLogin(String ID, String password, ArrayList<Organizer> organizers) {
        boolean isAdmin = false;
        for (Organizer org : organizers) {
            if (org.getID().equals(ID) && org.getPassword().equals(password)) {
                isAdmin = true;
                break;
            }

        }

        return isAdmin;

    }

    // method for customer login
    public static boolean CustomerLogin(String ID, String password, ArrayList<Customer> customers) {
        boolean isCustomer = false;
        for (Customer cust : customers) {
            if (cust.getID().equals(ID) && cust.getPassword().equals(password)) {
                isCustomer = true;
                break;

            }

        }

        return isCustomer;
    }// end of customerlogin method

} // end of Events class