package classes.UserClasses;

public class User {
    private String username;
    private String password;
    private String ID;

    public User() {
        // Default constructor
    }

    public User(String newUsername, String newPassword, String newID) {
        username = newUsername;
        password = newPassword;
        ID = newID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    // method to display the menu
    public static void displayOptions() {
        System.out.println(
                "+---------------------------+\n"
                        + "|     Wellcome to Events    |\n"
                        + "| 0. Exit.                  |\n"
                        + "| 1. Login As Administrator.|\n"
                        + "| 2. Login As Customer.     |\n"
                        + "+---------------------------+");
    } // end of displayOptions method

}
