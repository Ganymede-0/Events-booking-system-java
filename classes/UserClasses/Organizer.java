package classes.UserClasses;

public class Organizer extends User {

    // public static ArrayList<Customer> customers;

    public Organizer() {
        super();
    }

    public Organizer(String newUsername, String newPassword, String newID) {
        super(newUsername, newPassword, newID);
    }

    // method to display the menu for Admin
    public static void displayAdminOptions() {
        System.out.println(
                "+-----------------------------------+\n"
                        + "|     Welcome to the admin panel    |\n"
                        + "| 0. Exit.                          |\n"
                        + "| 1. Create Event.                  |\n"
                        + "| 2. Search Event.                  |\n"
                        + "| 3. Update Event.                  |\n"
                        + "| 4. Delete Event.                  |\n"
                        + "| 5. View All Events.               |\n"
                        + "| 6. Delete Reservation.            |\n"
                        + "| 7. View All Reservation.          |\n"
                        + "| 8. View All Customers.            |\n"
                        + "+-----------------------------------+");
    } // end of displayAdminOptions method

}
