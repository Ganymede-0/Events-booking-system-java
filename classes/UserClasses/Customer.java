package classes.UserClasses;

public class Customer extends User {

    public Customer() {
        super();
    }

    public Customer(String newUsername, String newPassword, String newID) {
        super(newUsername, newPassword, newID);
    }

    @Override
    public String toString() {
        return ("\nCustomer' Name: " + getUsername() + "\nCustomer' ID: " + getID() + "\n\n");
    }

    public static void displayCustomerOptions() {
        System.out.println(
                "+----------------------------+\n"
                        + "|     What you want to do    |\n"
                        + "| 0. Exit.                   |\n"
                        + "| 1. Purchase Ticket.        |\n"
                        + "| 2. Cancel Ticket.          |\n"
                        + "+----------------------------+");
    }

}
