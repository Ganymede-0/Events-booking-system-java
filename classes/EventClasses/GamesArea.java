package classes.EventClasses;

import java.util.*;

public class GamesArea extends Event {
    static Scanner input = new Scanner(System.in);

    private String gameName;

    // Constructer
    public GamesArea(String gameName, String eventId, double eventPrice, String eventLocation, int capacity) {
        super();
        this.gameName = gameName;
        setEventID(eventId);
        setEventPrice(eventPrice);
        setEventLocation(eventLocation);
        setCapacity(capacity);
    }// end constructer

    // Setter
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    // Getter
    public String getGameName() {
        return gameName;
    }

    // METHODES
    public static int searchGame(String gameId, ArrayList<GamesArea> games) {
        for (int i = 0; i < games.size(); i++) {
            if (gameId.equals(games.get(i).getEventID())) {
                return i;
            }
        }
        return -1;
    }

    // create new Game Area
    public static void createGame(ArrayList<GamesArea> games) {
        System.out.println("Name of the game: ");
        String gameName = input.nextLine();

        System.out.println("ID of the game: ");
        String gameID = input.next();
        int exist = GamesArea.searchGame(gameID, games);
        while (exist != -1) {
            System.out.println("This ID alrady exists!\nEnter another ID: ");
            gameID = input.next();
            exist = GamesArea.searchGame(gameID, games);
        }

        System.out.println("price of the game: ");
        double price = input.nextDouble();

        System.out.println("location of the game: ");
        String location = input.next();

        System.out.println("capacity of the game: ");
        int capacity = input.nextInt();

        games.add(new GamesArea(gameName, gameID, price, location, capacity));
        System.out.println("The game added successfully");
    }

    // update Game Area
    public static void updateGame(ArrayList<GamesArea> games) {
        System.out.println("Enter the id of the game: ");
        String gameId = input.next();
        int index = searchGame(gameId, games);
        if (index != -1) {
            System.out.println("enter new name: ");
            String editedName = input.next();

            System.out.println("enter new price: ");
            double editedPrice = input.nextDouble();

            System.out.println("enter new location: ");
            String editedLocation = input.next();

            System.out.println("enter new capacity: ");
            int editedLcapacity = input.nextInt();

            games.set(index, new GamesArea(editedName, gameId, editedPrice, editedLocation, editedLcapacity));

            System.out.println("The game updated successfully.");
        }

        else {
            System.out.println("not found!");
        }
    }

    // delete Game Area
    public static void deleteGame(ArrayList<GamesArea> games) {
        System.out.println("Enter the id of the games: ");
        String gameId = input.next();
        int index = searchGame(gameId, games);
        if (index != -1) {
            games.remove(index);
            System.out.println("The game removed successfully.");
        }

        else {
            System.out.println("not found!");
        }
    }

    @Override
    public String toString() {
        return ("\nGame Area' Name: " + getGameName() + "\nGame Area' ID: " + getEventID() + "\nGame Area' Price: "
                + getEventPrice() + "\nGame Area' Location: "
                + getEventLocation() + "\nGame Area' Capacity: " + getCapacity() + "\n");
    }

}
